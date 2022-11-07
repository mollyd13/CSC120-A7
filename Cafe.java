/* This is a stub for the Cafe class */
/* Cafe class, extends the Building class */
public class Cafe extends Building{

    /* attributes for a cafe */
    private int nCoffeeOunces;
    private int nSugarPackets;
    private int nCreams;
    private int nCups;

    /* full cafe constructor*/
    public Cafe(String name, String address, int nFloors) {
        super(name, address, nFloors);
        this.nCoffeeOunces = 500;
        this.nSugarPackets = 50;
        this.nCreams = 44;
        this.nCups = 100;
    }

    /* default constructor */
    public Cafe() {
        this("<Name Unknown>", "<Address Unknown>", 1);
    }

    /* overloaded cafe constructor*/
    public Cafe(String name) {
        this(); // Call default constructor
        this.name = name; // Override name
    }

    /* removes items from the inventory and restocks when necessary
     * @param size the num of ounces of coffee
     * @param sugars the amount of sugar packets in the coffee
     * @param creams the amount of creams in the coffee
    */
    public void sellCoffee(int size, int sugars, int creams){
        
        if (nCoffeeOunces <= size || nSugarPackets <= sugars || nCreams <= creams){
            restock(500, 50, 44, 100);
        }

        this.nCoffeeOunces -= size;
        this.nSugarPackets -= sugars;
        this.nCreams -= creams;
        this.nCups -= 1;
        System.out.println(size + " ounce coffee with " + sugars + " sugars and " + creams + " creams sold.");
    }

    /* adds more coffee, sugar packets, creams, and cups to the inventory 
     * @param coffeeOuncesRestock num of coffee ounces to be restocked
     * @param sugarPacketsRestock num of sugar packets to be restocked
     * @param creamsRestock num of creams to be restocked
     * @param cupsRestock num of cups to be restocked
    */
    private void restock(int coffeeOuncesRestock, int sugarPacketsRestock, int creamsRestock, int cupsRestock){
        this.nCoffeeOunces += coffeeOuncesRestock;
        this.nSugarPackets += sugarPacketsRestock;
        this.nCreams += creamsRestock;
        this.nCups += cupsRestock;
        System.out.println("Inventory restocked.");
        
    }

    /* prints the inventory */
    public void printInventory(){
        System.out.println("Inventory: ");
        System.out.println(nCoffeeOunces + " ounces of coffee");
        System.out.println(nSugarPackets + " sugar packets");
        System.out.println(nCreams + " creams");
        System.out.println(nCups + " cups");
    }

    /* prints the amount of a specific item in the inventory
     * @param item ingredient to be printed
     */
    public void printInventory(String item){
        if (item.equals("coffee")){
            System.out.println(nCoffeeOunces + " ounces of coffee");
        }
        else if (item.equals("sugar")){
            System.out.println(nSugarPackets + " sugar packets");
        }
        else if (item.equals("cream")){
            System.out.println(nCreams + " creams");
        }
        else if (item.equals("cups")){
            System.out.println(nCups + " cups");
        }
    }

    /* shows the methods */
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n):\n + sellCoffee() \n + restock() \n + printInventory()");
    }

    /* adjusts active floor
     * @param floorNum new active floor
     */
    public void goToFloor(int floorNum) {
        System.out.println("Other floors are only accessible to employees, please pick another method");
    }

    /* navigational methods */
    public void goUp() {
        System.out.println("Other floors are only accessible to employees, please pick another method");
    }

    public void goDown() {
        System.out.println("Other floors are only accessible to employees, please pick another method");
    }

    /* main method for testing */
    public static void main(String[] args) {
        Cafe myCafe = new Cafe();
        System.out.println(myCafe);
        myCafe.printInventory("sugar");
    }
    
}
