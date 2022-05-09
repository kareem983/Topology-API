package APIs;

import models.Component;
import models.IOMessages;
import models.Topology;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class API implements JsonAPI, TopologyQuery, DeviceQuery {
    private String FILE_PATH;
    private final ObjectMapper objectMapper;
    private static API instance;
    private final static ArrayList<String> filesIds = new ArrayList<>();
    public final static ArrayList<Topology> currentTopologies = new ArrayList<>();

    public API() {
        this.FILE_PATH = "src\\main\\resources\\";
        this.objectMapper = new ObjectMapper();
    }

    //Singleton Design Pattern
    public static API getInstance() {
        if (instance == null) return new API();
        return instance;
    }

    @Override
    public Topology readJSON(String fileName) {
        this.FILE_PATH += fileName + ".json";

        try {
            String topologyJsonString = new String(Files.readAllBytes(Paths.get(this.FILE_PATH)));
            JsonNode topologyJsonNode = this.objectMapper.readTree(topologyJsonString);
            Topology newTopology = new Topology(topologyJsonNode);
            if (this.checkFileExist(newTopology.getID())) {
                System.out.println(IOMessages.fileTwice);
                return null;
            }
            currentTopologies.add(newTopology);
            filesIds.add(newTopology.getID());
            return newTopology;

        } catch (Exception e) {
            System.out.println(IOMessages.incorrectFileName);
            return null;
        }

    }

    @Override
    public boolean writeJSON(String topologyID, String newJsonFileName) {
        JsonNode topology = getSelectedTopologyJsonNode(topologyID);

        try {
            if (topology != null) {
                this.objectMapper.writerWithDefaultPrettyPrinter().writeValue(
                        new File(this.FILE_PATH + newJsonFileName + ".json"), topology);
                return true;
            } else throw new Exception();

        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public ArrayList<Topology> queryTopologies() {
        return currentTopologies;
    }

    @Override
    public boolean deleteTopology(String topologyID) {
        Topology selectedTopology = getSelectedTopology(topologyID);
        if (selectedTopology != null) {
            currentTopologies.remove(selectedTopology);
            filesIds.remove(topologyID);
            return true;
        }
        return false;
    }

    @Override
    public ArrayList<Component> queryDevices(String topologyID) {
        Topology selectedTopology = getSelectedTopology(topologyID);

        if (selectedTopology != null) {
            if (selectedTopology.getComponent().size() == 0)
                System.out.println(IOMessages.deviceNotExist);

            return selectedTopology.getComponent();
        }

        System.out.println(IOMessages.topologyIDNotExist);
        return null;
    }

    @Override
    public ArrayList<Component> queryDevicesWithNetListNode(String topologyID, String netListNodeID) {
        ArrayList<Component> components = new ArrayList<>();
        Topology selectedTopology = getSelectedTopology(topologyID);

        if (selectedTopology != null) {
            for (Component component : selectedTopology.getComponent()) {
                if (component.getNetList().getNetListJsonNode().findValue(netListNodeID) != null)
                    components.add((component));
            }

            if (components.size() == 0)
                System.out.println(IOMessages.DeviceWithNetListNotExist);

            return components;
        }

        System.out.println(IOMessages.topologyIDNotExist);
        return null;
    }


    // Helpers
    private boolean checkFileExist(String topologyID) {
        return filesIds.contains(topologyID);
    }

    private JsonNode getSelectedTopologyJsonNode(String topologyID) {
        JsonNode topology = null;
        for (Topology top : currentTopologies) {
            if (top.getID().equals(topologyID)) {
                topology = top.getTopologyJsonNode();
                break;
            }
        }
        return topology;
    }

    private Topology getSelectedTopology(String topologyID) {
        Topology topology = null;
        for (Topology top : currentTopologies) {
            if (top.getID().equals(topologyID)) {
                topology = top;
                break;
            }
        }
        return topology;
    }

}
