package models;

import com.fasterxml.jackson.databind.JsonNode;

public class NetList {
    private JsonNode netListJsonNode;

    /**
     * The constructor role to initialize the class variables and data structure.
     *
     * @param netListJsonNode The net list json node that has the object of net list from json file as a tree.
     */
    public NetList(JsonNode netListJsonNode) {
        this.netListJsonNode = netListJsonNode;
    }

    /**
     * The description of the method to to parse the json object and store it in the model(class).
     */
    @Override
    public String toString() {
        return this.netListJsonNode.toPrettyString();
    }

    /**
     * @return Json node of net list.
     */
    public JsonNode getNetListJsonNode() {
        return netListJsonNode;
    }

    public void setNetListJsonNode(JsonNode netListJsonNode) {
        this.netListJsonNode = netListJsonNode;
    }
}
