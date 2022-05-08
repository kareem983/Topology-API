import java.util.Scanner;

public class MainTopology {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Topology API");

        String choice;
        do {
            userChoicesInput();
            choice = input.next();

            switch (choice.charAt(0)){
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
                    System.out.println("### Invalid Input ###");
            }

        }while (!choice.equals("0"));

    }


    private static void userChoicesInput() {
        System.out.println("===============================================");
        System.out.println("Read a topology from a given JSON file, Press 1");
        System.out.println("Write a given topology to a JSON file, Press 2");
        System.out.println("Query about which topologies are currently in the memory, Press 3");
        System.out.println("Delete a given topology from memory, Press 4");
        System.out.println("Query about which devices are in a given topology, Press 5");
        System.out.println("Query about which devices are connected to a given netlist node in " +
                "a given topology, Press 6");
        System.out.println("Exit from the Console, Press 0");
        System.out.println("===============================================");
        System.out.print("Enter Your Choice: ");
    }


    private static void readJSON() {
    }

    private static void writeJSON() {
    }

    private static void queryTopologies() {
    }

    private static void deleteTopology() {
    }

    private static void queryDevices() {
    }

    private static void queryDevicesWithNetListNode() {
    }

}
