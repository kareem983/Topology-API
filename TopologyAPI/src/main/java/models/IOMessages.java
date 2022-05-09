package models;

public abstract class IOMessages {
    public final static String topologyAPI = "************ Topology API ************";
    public final static String invalidInput = "### Invalid Input ###";
    public final static String jsonFileName = "Enter the Json File Name: ";
    public final static String fileStoredInMemory = "File Stored in Memory Successfully.";
    public final static String fileStoredInJson = "File Stored in new JSON File Successfully.";
    public final static String idList = "Choose Id From below IDs ";
    public final static String topologyIDChoose = "Your Topology ID Choice: ";
    public final static String newJsonFileName = "Enter the Name of new Json File: ";
    public final static String topologyIDNotExist = "[Incorrect] the Topology ID doesn't Exist in the memory!!!";
    public final static String topologyNotExist = "There are not Topologies in Memory!!!";
    public final static String topologyDeleted = "Topology Deleted from memory Successfully.";
    public final static String netListID = "Enter The netListID: ";
    public final static String incorrectFileName = "Incorrect File Name!!!";
    public final static String fileTwice = "You Can't Add the Json file that has The Same Topology ID Twice!!!";
    public final static String deviceNotExist = "There are not any Device in this Topology!!!";
    public final static String DeviceWithNetListNotExist = "There are not any Device in this Topology that match the NetListID";


    public static void inputChoiceBox(){
        System.out.println("\n===========================================================================================");
        System.out.println("Enter 1 to Read a topology from a given JSON file and store it in the memory.");
        System.out.println("Enter 2 to Write a topology from memory to a JSON file.");
        System.out.println("Enter 3 to Query about which topologies are currently in the memory.");
        System.out.println("Enter 4 to Delete a given topology from memory.");
        System.out.println("Enter 5 to Query about which devices are in a given topology.");
        System.out.println("Enter 6 to Query about which devices are connected to a given netlist node in " +
                "a given topology.");
        System.out.println("Enter 0 to Exit.");
        System.out.println("===========================================================================================\n");
        System.out.print("Enter Your Choice: ");
    }

}
