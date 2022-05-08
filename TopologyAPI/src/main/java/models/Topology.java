package models;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;

public class Topology {
    private String id;
    private JsonNode topologyJsonNode;
    private JsonNode componentJsonNode;
    private ArrayList<Component> components;

    public Topology(JsonNode topologyJsonNode) {
        this.topologyJsonNode = topologyJsonNode;
        this.components = new ArrayList<>();
        this.storeTopologyInMemory();
    }

    private void storeTopologyInMemory(){
        this.id = this.topologyJsonNode.findValue("id").asText();
        this.componentJsonNode = this.topologyJsonNode.findValue("components");
        for (int i = 0; i < componentJsonNode.size(); i++)
            this.components.add(new Component(componentJsonNode.get(i)));
    }

    @Override
    public String toString() {
        return topologyJsonNode.toPrettyString();
    }

    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

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

    public JsonNode getTopologyJsonNode() {
        return topologyJsonNode;
    }

    public void setTopologyJsonNode(JsonNode topologyJsonNode) {
        this.topologyJsonNode = topologyJsonNode;
    }
}
