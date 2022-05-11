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

    /**
     * The Description of the method to get one instance from API class during the runtime.
     * the function apply Singleton Design Pattern.
     *
     * @return Unique API instance.
     */
    public static API getInstance() {
        if (instance == null) return new API();
        return instance;
    }

    /**
     * The Description of the method to read the topology from the json file and store it in the memory.
     *
     * @param fileName The json file name that the function read it.
     * @return New topology.
     */
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

    /**
     * The Description of the method to write the topology from the memory to the json file.
     *
     * @param topologyID      The topology id that the function write it in the json file.
     * @param newJsonFileName The new file name that the function save it.
     * @return Boolean value that the file stored or not (true/false).
     */
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

    /**
     * The Description of the method to query all the topologies from the memory.
     *
     * @return List of topologies that in the memory.
     */
    @Override
    public ArrayList<Topology> queryTopologies() {
        return currentTopologies;
    }

    /**
     * The Description of the method to delete the given topology from the memory.
     *
     * @param topologyID The topology id that the function delete it.
     * @return Boolean value that the topology is deleted from the memory or not (true/false)
     */
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

    /**
     * The Description of the method to query all the electronic devices in the given topology from the memory.
     *
     * @param topologyID The topology id that the function query about it.
     * @return List of electronic devices that in the given topology.
     */
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

    /**
     * The Description of the method to query all the electronic devices in the given topology and math
     * with et list id from the memory.
     *
     * @param topologyID    The topology id that the function query about it.
     * @param netListNodeID The net list id that the function use it to match with each device.
     * @return List of electronic devices that in the given topology and match the netListNodeID.
     */
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


    // Helpers Methods

    /**
     * The Description of the method to check that the given topology is exist in the memory or not.
     *
     * @param topologyID The given topology id that the function check for it.
     * @return Boolean value that The the file of the given topology exist in the memory or not (true/false).
     */
    private boolean checkFileExist(String topologyID) {
        return filesIds.contains(topologyID);
    }

    /**
     * The Description of the method to get the json node of the topology from the memory according for
     * the given topology id.
     *
     * @param topologyID the given topology id that the function search for it's topology.
     * @return Json node for the given topology id.
     */
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

    /**
     * The Description of the method to get the topology from the memory according for the given topology id.
     *
     * @param topologyID the given topology id that the function search for it's topology.
     * @return The topology for the given topology id.
     */
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
