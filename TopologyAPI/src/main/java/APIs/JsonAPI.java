package APIs;

import models.Topology;

public interface JsonAPI {
    Topology readJSON(String fileName);
    boolean writeJSON(String topologyID, String newJsonFileName);
}
