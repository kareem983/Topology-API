import APIs.API;
import models.Component;
import models.IOMessages;
import models.Topology;
import java.util.ArrayList;
import java.util.Scanner;

public class MainTopology {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(IOMessages.topologyAPI);

        String choice;
        do {
            IOMessages.inputChoiceBox();
            choice = input.next();

            switch (choice.charAt(0)) {
                case '0':
                    break;
                case '1':
                    readJSON();
                    break;
                case '2':
                    writeJSON();
                    break;
                case '3':
                    queryTopologies();
                    break;
                case '4':
                    deleteTopology();
                    break;
                case '5':
                    queryDevices();
                    break;
                case '6':
                    queryDevicesWithNetListNode();
                    break;
                default:
                    System.out.println(IOMessages.invalidInput);
            }

        } while (!choice.equals("0"));

    }

    private static void readJSON() {
        System.out.print(IOMessages.jsonFileName);
        String fileName = input.next();
        API api = API.getInstance();
        if (api.readJSON(fileName) != null)
            System.out.println(IOMessages.fileStoredInMemory);
    }

    private static void writeJSON() {
        if (API.currentTopologies.size() != 0) {
            System.out.println(IOMessages.idList);
            displayCurrentTopologies();
            System.out.print(IOMessages.topologyIDChoose);
            String topologyID = input.next();
            System.out.print(IOMessages.newJsonFileName);
            String newJsonFileName = input.next();
            API api = API.getInstance();
            if (api.writeJSON(topologyID, newJsonFileName))
                System.out.println(IOMessages.fileStoredInJson);
            else
                System.out.println(IOMessages.topologyIDNotExist);

        } else System.out.println(IOMessages.topologyNotExist);
    }

    private static void queryTopologies() {
        API api = API.getInstance();
        ArrayList<Topology> currentTopologies = api.queryTopologies();
        if (currentTopologies.size() != 0) {
            for (Topology top : currentTopologies) {
                System.out.println("\n**** Topology ID: " + top.getID() + " ****");
                System.out.println(top.toString());
            }
        } else
            System.out.println(IOMessages.topologyNotExist);
    }

    private static void deleteTopology() {
        if (API.currentTopologies.size() != 0) {
            System.out.println(IOMessages.idList);
            displayCurrentTopologies();
            System.out.print(IOMessages.topologyIDChoose);
            String topologyID = input.next();
            API api = API.getInstance();
            if (api.deleteTopology(topologyID))
                System.out.println(IOMessages.topologyDeleted);
            else
                System.out.println(IOMessages.topologyIDNotExist);

        } else System.out.println(IOMessages.topologyNotExist);
    }

    private static void queryDevices() {
        if (API.currentTopologies.size() != 0) {
            System.out.println(IOMessages.idList);
            displayCurrentTopologies();
            System.out.print(IOMessages.topologyIDChoose);
            String topologyID = input.next();
            API api = API.getInstance();
            ArrayList<Component> components = api.queryDevices(topologyID);
            if (components != null) {
                for (Component component : components) {
                    System.out.println(component.toString());
                }
            }

        } else System.out.println(IOMessages.topologyNotExist);

    }

    private static void queryDevicesWithNetListNode() {
        if (API.currentTopologies.size() != 0) {
            System.out.println(IOMessages.idList);
            displayCurrentTopologies();
            System.out.print(IOMessages.topologyIDChoose);
            String topologyID = input.next();
            System.out.print(IOMessages.netListID);
            String netListID = input.next();
            API api = API.getInstance();
            ArrayList<Component> components = api.queryDevicesWithNetListNode(topologyID, netListID);
            if (components != null) {
                for (Component component : components) {
                    System.out.println(component.toString());
                }
            }

        } else System.out.println(IOMessages.topologyNotExist);
    }

    // Helpers
    private static void displayCurrentTopologies() {
        for (Topology top : API.currentTopologies)
            System.out.println(top.getID());
    }
}
