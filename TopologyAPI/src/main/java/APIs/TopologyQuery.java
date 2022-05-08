package APIs;

import models.Topology;
import java.util.ArrayList;

public interface TopologyQuery {
    ArrayList<Topology> queryTopologies();
    boolean deleteTopology(String topologyID);
}
