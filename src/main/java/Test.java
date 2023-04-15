public class Test {

    public static final String RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        System.out.println("You pick up the papers from the desk. There are some frantic scribbles from presumably one of the nurses that detail the different exit routes from the hospital.");
        System.out.println(RED + "||FRONT DOOR:\n||a side note from the nurse states this is the most obvious, but getting there might be a challenge.");
        System.out.println("||PARKING GARAGE:\n||a side note from the nurse says there is an employee/emergency vehicle access gate that can be opened using an employee key.");
        System.out.println("||SEWER ACCESS:\n||a side note from the nurse lists this as only viable if you're extremely desperate you mignt be able to find access to the sewer system.");
        System.out.println("||EXECUTIVE EXIT ROUTE:\n||a side note from the nurse lists this as one of the ways the hospital owner gets to and from his office without taking the elevator or stairs. \n" + ANSI_RESET);
    }
}
