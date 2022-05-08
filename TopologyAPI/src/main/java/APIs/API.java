package APIs;

import models.Component;
import models.Topology;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class API implements JsonAPI, TopologyQuery, DeviceQuery{
    private String FILE_PATH;
    private ObjectMapper objectMapper;
    private static ArrayList<String>  pathsFiles = new ArrayList<>();
    public static ArrayList<Topology> topologies = new ArrayList<>();


    public API() {
        this.FILE_PATH = "src\\main\\resources\\";
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public Topology readJSON(String fileName) {
        this.FILE_PATH += fileName + ".json";
        if(this.checkFileExist()){
            System.out.println("You Can't Add the same Json File Twice");
            return null;
        }

        try {
            String topologyJsonString = new String(Files.readAllBytes(Paths.get(this.FILE_PATH)));
            JsonNode topologyJsonNode = this.objectMapper.readTree(topologyJsonString);
            Topology newTopology = new Topology(topologyJsonNode);
            pathsFiles.add(this.FILE_PATH);
            topologies.add(newTopology);
            return newTopology;

        } catch (Exception e) {
            System.out.println("Incorrect File Path");
            return null;
        }

    }

    private boolean checkFileExist(){
        return pathsFiles.contains(this.FILE_PATH);
    }

    @Override
    public boolean writeJSON(String topologyID) {
        return false;
    }

    @Override
    public ArrayList<Topology> queryTopologies() {
        return null;
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

}
