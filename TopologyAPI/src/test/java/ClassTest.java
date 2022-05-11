import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Topology;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Paths;


@DisplayName("Automatic testing on Classes level")
public class ClassTest {
    private String FILE_PATH;
    private final ObjectMapper objectMapper;
    private Topology newTopology = null;

    public ClassTest() {
        this.FILE_PATH = "src\\main\\resources\\";
        this.objectMapper = new ObjectMapper();
    }

    @Test
    @DisplayName("[Test_1] Check the topology ID (top1) is equal to top1 [Topology Class]")
    public void topology1IDTest1() {
        try {
            String topologyJsonString = new String(Files.readAllBytes(Paths.get(this.FILE_PATH + "top1.json")));
            JsonNode topologyJsonNode = this.objectMapper.readTree(topologyJsonString);
            newTopology = new Topology(topologyJsonNode);
            Assertions.assertEquals(newTopology.getID(), "top1");
        } catch (Exception e) {
            Assertions.assertNull(newTopology);
        }
    }


    @Test
    @DisplayName("[Test_1] Check the Component1 ID for the (top1) is equal to res1 [Component Class]")
    public void topology1ComponentIDTest1() {
        try {
            String topologyJsonString = new String(Files.readAllBytes(Paths.get(this.FILE_PATH + "top1.json")));
            JsonNode topologyJsonNode = this.objectMapper.readTree(topologyJsonString);
            newTopology = new Topology(topologyJsonNode);
            Assertions.assertEquals(newTopology.getComponent().get(0).getId(), "res1");
        } catch (Exception e) {
            Assertions.assertNull(newTopology);
        }
    }

    @Test
    @DisplayName("[Test_2] Check the Component2 ID for the (top1) is equal to m1 [Component Class]")
    public void topology1ComponentIDTest2() {
        try {
            String topologyJsonString = new String(Files.readAllBytes(Paths.get(this.FILE_PATH + "top1.json")));
            JsonNode topologyJsonNode = this.objectMapper.readTree(topologyJsonString);
            newTopology = new Topology(topologyJsonNode);
            Assertions.assertEquals(newTopology.getComponent().get(1).getId(), "m1");
        } catch (Exception e) {
            Assertions.assertNull(newTopology);
        }
    }


    @Test
    @DisplayName("[Test_1] Check the Component1 Type for the (top1) is equal to resistor [Component Class]")
    public void topology1ComponentTypeTest1() {
        try {
            String topologyJsonString = new String(Files.readAllBytes(Paths.get(this.FILE_PATH + "top1.json")));
            JsonNode topologyJsonNode = this.objectMapper.readTree(topologyJsonString);
            newTopology = new Topology(topologyJsonNode);
            Assertions.assertEquals(newTopology.getComponent().get(0).getType(), "resistor");
        } catch (Exception e) {
            Assertions.assertNull(newTopology);
        }
    }

    @Test
    @DisplayName("[Test_2] Check the Component2 Type for the (top1) is equal to nmos [Component Class]")
    public void topology1ComponentTypeTest2() {
        try {
            String topologyJsonString = new String(Files.readAllBytes(Paths.get(this.FILE_PATH + "top1.json")));
            JsonNode topologyJsonNode = this.objectMapper.readTree(topologyJsonString);
            newTopology = new Topology(topologyJsonNode);
            Assertions.assertEquals(newTopology.getComponent().get(1).getType(), "nmos");
        } catch (Exception e) {
            Assertions.assertNull(newTopology);
        }
    }


    @Test
    @DisplayName("[Test_1] Check the topology ID (top2) is equal to top2 [Topology Class]")
    public void topology2IDTest1() {
        try {
            String topologyJsonString = new String(Files.readAllBytes(Paths.get(this.FILE_PATH + "top2.json")));
            JsonNode topologyJsonNode = this.objectMapper.readTree(topologyJsonString);
            newTopology = new Topology(topologyJsonNode);
            Assertions.assertEquals(newTopology.getID(), "top2");
        } catch (Exception e) {
            Assertions.assertNull(newTopology);
        }
    }

    @Test
    @DisplayName("[Test_1] Check the Component1 ID for the (top2) is equal to d1 [Component Class]")
    public void topology2ComponentIDTest1() {
        try {
            String topologyJsonString = new String(Files.readAllBytes(Paths.get(this.FILE_PATH + "top2.json")));
            JsonNode topologyJsonNode = this.objectMapper.readTree(topologyJsonString);
            newTopology = new Topology(topologyJsonNode);
            Assertions.assertEquals(newTopology.getComponent().get(0).getId(), "d1");
        } catch (Exception e) {
            Assertions.assertNull(newTopology);
        }
    }

    @Test
    @DisplayName("[Test_2] Check the Component2 ID for the (top2) is equal to d2 [Component Class]")
    public void topology2ComponentIDTest2() {
        try {
            String topologyJsonString = new String(Files.readAllBytes(Paths.get(this.FILE_PATH + "top2.json")));
            JsonNode topologyJsonNode = this.objectMapper.readTree(topologyJsonString);
            newTopology = new Topology(topologyJsonNode);
            Assertions.assertEquals(newTopology.getComponent().get(1).getId(), "d2");
        } catch (Exception e) {
            Assertions.assertNull(newTopology);
        }
    }


    @Test
    @DisplayName("[Test_1] Check the Component1 Type for the (top2) is equal to device1 [Component Class]")
    public void topology2ComponentTypeTest1() {
        try {
            String topologyJsonString = new String(Files.readAllBytes(Paths.get(this.FILE_PATH + "top2.json")));
            JsonNode topologyJsonNode = this.objectMapper.readTree(topologyJsonString);
            newTopology = new Topology(topologyJsonNode);
            Assertions.assertEquals(newTopology.getComponent().get(0).getType(), "device1");
        } catch (Exception e) {
            Assertions.assertNull(newTopology);
        }
    }

    @Test
    @DisplayName("[Test_2] Check the Component2 Type for the (top2) is equal to device2 [Component Class]")
    public void topology2ComponentTypeTest2() {
        try {
            String topologyJsonString = new String(Files.readAllBytes(Paths.get(this.FILE_PATH + "top2.json")));
            JsonNode topologyJsonNode = this.objectMapper.readTree(topologyJsonString);
            newTopology = new Topology(topologyJsonNode);
            Assertions.assertEquals(newTopology.getComponent().get(1).getType(), "device2");
        } catch (Exception e) {
            Assertions.assertNull(newTopology);
        }
    }

}
