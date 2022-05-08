import java.util.List;

public class Topology {
    private String id;
    private List<Component> components;

    public Topology(String id, List<Component> components) {
        this.id = id;
        this.components = components;
    }

    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }
}
