import javafx.util.Pair;

public class Component {
    private String id;
    private String type;
    private Pair<String, ComponentData> data;
    private NetList netList;

    public Component(String id, String type, Pair<String, ComponentData> data, NetList netList) {
        this.id = id;
        this.type = type;
        this.data = data;
        this.netList = netList;
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

    public Pair<String, ComponentData> getData() {
        return data;
    }

    public void setData(Pair<String, ComponentData> data) {
        this.data = data;
    }

    public NetList getNetList() {
        return netList;
    }

    public void setNetList(NetList netList) {
        this.netList = netList;
    }
}
