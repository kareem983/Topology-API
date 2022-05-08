package APIs;

import models.Component;
import models.Topology;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class API implements JsonAPI, TopologyQuery, DeviceQuery {
    private String FILE_PATH;
    private ObjectMapper objectMapper;
    private static API instance;
    private static ArrayList<String> pathsFiles = new ArrayList<>();
    public static ArrayList<Topology> currentTopologies = new ArrayList<>();


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
        if (this.checkFileExist()) {
            System.out.println("You Can't Add the same Json File Twice!!!");
            return null;
        }

        try {
            String topologyJsonString = new String(Files.readAllBytes(Paths.get(this.FILE_PATH)));
            JsonNode topologyJsonNode = this.objectMapper.readTree(topologyJsonString);
            Topology newTopology = new Topology(topologyJsonNode);
            pathsFiles.add(this.FILE_PATH);
            currentTopologies.add(newTopology);
            return newTopology;

        } catch (Exception e) {
            System.out.println("Incorrect File Name!!!");
            return null;
        }

    }

    @Override
    public boolean writeJSON(String topologyID, String newJsonFileName) {
        JsonNode topology = getSelectedTopology(topologyID);

        try {
            if (topology != null) {
                this.objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(this.FILE_PATH +
                        newJsonFileName + ".json"), topology);
                return true;
            } else throw new Exception();

        } catch (Exception e) {
            System.out.println("[Incorrect] the Topology ID doesn't Exist in the memory!!!");
            return false;
        }
    }

    @Override
    public ArrayList<Topology> queryTopologies() {
        return currentTopologies;
    }

    @Override
    public boolean deleteTopology(String topologyID) {
        return false;
    }

    @Override
    public ArrayList<Component> queryDevices(String topologyID) {
        return null;
    }

    @Override
    public ArrayList<Component> queryDevicesWithNetListNode(String topologyID, String netListNodeID) {
        return null;
    }


    // Helpers
    private boolean checkFileExist() {
        return pathsFiles.contains(this.FILE_PATH);
    }

    private JsonNode getSelectedTopology(String topologyID) {
        JsonNode topology = null;
        for (Topology top : currentTopologies) {
            if (top.getID().equals(topologyID)) {
                topology = top.getTopologyJsonNode();
                break;
            }
        }
        return topology;
    }

}
