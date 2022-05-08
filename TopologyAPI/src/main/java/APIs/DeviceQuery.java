package APIs;

import models.Component;
import java.util.ArrayList;

public interface DeviceQuery {
    ArrayList<Component> queryDevices(String topologyID);
    ArrayList<Component> queryDevicesWithNetListNode(String topologyID, String netListNodeID);
}
