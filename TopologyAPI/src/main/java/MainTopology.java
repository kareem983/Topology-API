import APIs.API;
import models.Topology;

import java.util.Scanner;

public class MainTopology {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("************ Topology API ************");

        String choice;
        do {
            userChoicesInput();
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
                    System.out.println("### Invalid Input ###");
            }

        } while (!choice.equals("0"));

    }


    private static void userChoicesInput() {
        System.out.println("===============================================");
        System.out.println("Enter 1 to Read a topology from a given JSON file and store it in the memory.");
        System.out.println("Enter 2 to Write a given topology to a JSON file.");
        System.out.println("Enter 3 to Query about which topologies are currently in the memory.");
        System.out.println("Enter 4 to Delete a given topology from memory.");
        System.out.println("Enter 5 to Query about which devices are in a given topology.");
        System.out.println("Enter 6 to Query about which devices are connected to a given netlist node in " +
                "a given topology.");
        System.out.println("Enter 0 to Exit.");
        System.out.println("===============================================");
        System.out.print("Enter Your Choice: ");
    }


    private static void readJSON() {
        System.out.print("Enter the File Name: ");
        String fileName = input.next();
        API api = new API();
        Topology top = api.readJSON(fileName);
        if (top != null) {
            System.out.println("File Stored Successfully");
        }
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
