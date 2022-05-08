package models;

import com.fasterxml.jackson.databind.JsonNode;

public class Component {
    private String id;
    private String type;
    private NetList netList;
    private JsonNode componentsJsonNode;
    private JsonNode netListJsonNode;

    public Component(JsonNode componentsJsonNode) {
        this.componentsJsonNode = componentsJsonNode;
        this.storeComponentInMemory();
    }

    private void storeComponentInMemory() {
        this.id = this.componentsJsonNode.findValue("id").asText();
        this.type = this.componentsJsonNode.findValue("type").asText();
        this.netListJsonNode = this.componentsJsonNode.findValue("netlist");
        this.netList = new NetList(this.netListJsonNode);
    }

    @Override
    public String toString() {
        return componentsJsonNode.toPrettyString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public NetList getNetList() {
        return netList;
    }

    public void setNetList(NetList netList) {
        this.netList = netList;
    }
}
