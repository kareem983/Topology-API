package models;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.ArrayList;

public class Topology {
    private String id;
    private JsonNode topologyJsonNode;
    private JsonNode componentJsonNode;
    private ArrayList<Component> components;

    /**
     * The constructor role to initialize the class variables and data structure.
     *
     * @param topologyJsonNode The topology json node that has the object of topology from json file as a tree.
     */
    public Topology(JsonNode topologyJsonNode) {
        this.topologyJsonNode = topologyJsonNode;
        this.components = new ArrayList<>();
        this.storeTopologyInMemory();
    }

    /**
     * The description of the method to to parse the json object and store it in the model(class).
     */
    private void storeTopologyInMemory() {
        this.id = this.topologyJsonNode.findValue("id").asText();
        this.componentJsonNode = this.topologyJsonNode.findValue("components");
        for (int i = 0; i < componentJsonNode.size(); i++)
            this.components.add(new Component(componentJsonNode.get(i)));
    }

    /**
     * The description of the method to get the topology info as a tree.
     *
     * @return String that has the topology info.
     */
    @Override
    public String toString() {
        return topologyJsonNode.toPrettyString();
    }

    /**
     * @return ID variable.
     */
    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    /**
     * @return Component object.
     */
    public ArrayList<Component> getComponent() {
        return components;
    }

    public void setComponent(ArrayList<Component> components) {
        this.components = components;
    }

    public JsonNode getComponentJsonNode() {
        return componentJsonNode;
    }

    public void setComponentJsonNode(JsonNode componentJsonNode) {
        this.componentJsonNode = componentJsonNode;
    }

    /**
     * @return Json node of topology.
     */
    public JsonNode getTopologyJsonNode() {
        return topologyJsonNode;
    }

    public void setTopologyJsonNode(JsonNode topologyJsonNode) {
        this.topologyJsonNode = topologyJsonNode;
    }
}
