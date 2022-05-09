package models;

import com.fasterxml.jackson.databind.JsonNode;

public class NetList {
    private JsonNode netListJsonNode;

    public NetList(JsonNode netListJsonNode) {
        this.netListJsonNode = netListJsonNode;
    }

    @Override
    public String toString() {
        return this.netListJsonNode.toPrettyString();
    }

    public JsonNode getNetListJsonNode() {
        return netListJsonNode;
    }

    public void setNetListJsonNode(JsonNode netListJsonNode) {
        this.netListJsonNode = netListJsonNode;
    }
}
