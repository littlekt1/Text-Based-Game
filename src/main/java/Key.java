public class Key extends  Item{
    public Key(String itemName, boolean hasItem) {
        super(itemName, hasItem);
        this.setItemName("Key");
    }
    Key helicopterKey = new Key("Helicopter Key", false);
    Key frontDoorKey = new Key("Front Door Key", false);
    Key employeeKey = new Key("Employee Key", false);
    Key basementKey = new Key("Basement Key", false);
    Key executiveSuiteKey = new Key("Executive Suite Key", false);

}
