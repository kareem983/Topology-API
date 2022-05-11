package models;

import com.fasterxml.jackson.databind.JsonNode;

public class Component {
    private String id;
    private String type;
    private NetList netList;
    private JsonNode componentsJsonNode;
    private JsonNode netListJsonNode;

    /**
     * The constructor role to initialize the class variables and data structure.
     *
     * @param componentsJsonNode The component json node that has the object of component from json file as a tree.
     */
    public Component(JsonNode componentsJsonNode) {
        this.componentsJsonNode = componentsJsonNode;
        this.storeComponentInMemory();
    }

    /**
     * The description of the method to to parse the json object and store it in the model(class).
     */
    private void storeComponentInMemory() {
        this.id = this.componentsJsonNode.findValue("id").asText();
        this.type = this.componentsJsonNode.findValue("type").asText();
        this.netListJsonNode = this.componentsJsonNode.findValue("netlist");
        this.netList = new NetList(this.netListJsonNode);
    }

    /**
     * The description of the method to get the component info as a tree.
     *
     * @return String that has the component info.
     */
    @Override
    public String toString() {
        return componentsJsonNode.toPrettyString();
    }

    /**
     * @return Id variable.
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return Component type variable.
     */
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return Net list object.
     */
    public NetList getNetList() {
        return netList;
    }

    public void setNetList(NetList netList) {
        this.netList = netList;
    }
}
