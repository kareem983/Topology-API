package models;

import com.fasterxml.jackson.databind.JsonNode;

public class NetList {
    private JsonNode netList;

    public NetList(JsonNode netList) {
        this.netList = netList;
    }

    @Override
    public String toString() {
        return this.netList.toPrettyString();
    }

    public JsonNode getNetList() {
        return netList;
    }

    public void setNetList(JsonNode netList) {
        this.netList = netList;
    }
}
