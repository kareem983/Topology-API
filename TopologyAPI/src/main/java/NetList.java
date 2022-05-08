import java.util.HashMap;

public class NetList {
    private HashMap<String, String> devices;

    public NetList(HashMap<String, String> devices) {
        this.devices = devices;
    }

    public HashMap<String, String> getDevices() {
        return devices;
    }

    public void setDevices(HashMap<String, String> devices) {
        this.devices = devices;
    }
}
