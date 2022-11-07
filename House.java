/* This is a stub for the House class */
/* imports arraylist */
import java.util.ArrayList;

/* House class, extends from Building object */
public class House extends Building{

  /* attributes for a house */
  private ArrayList<String> residents; // The <String> tells Java what kind of data we plan to store IN the ArrayList
  private boolean hasDiningRoom;
  private boolean hasElevator;

  /* full house constructor */
  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, nFloors);
    this.hasDiningRoom = hasDiningRoom;
    this.residents = new ArrayList<String>();
    this.hasElevator = hasElevator;
  }

  /* default constructor */
  public House() {
    this("<Name Unknown>", "<Address Unknown>", 1, true, false);
  }

  /* overloaded constructor */
  public House(String name) {
    this(); // Call default constructor
    this.name = name; // Override address
  }

  /* does the house have a dining room
   * @return whether or not there is a dining room
   */
  public boolean hasDiningRoom(){
    return hasDiningRoom;
  }

  /* does the house have an elevator
   * @return whether or not there is an elevator
   */
  public boolean hasElevator(){
    return hasElevator;
  }

  /* how many residents live in the house
   * @return num of residents
   */
  public int nResidents(){
    return residents.size();
  }

  /* moves in a new resident 
   * @param name person to be moved in
  */
  public void moveIn(String name){
    residents.add(name);
    System.out.println("Successfully moved in " + name);
  }

  /* moves out specified resident
   * @param name person to be moved out
   * @return name person who has been moved out
   */
  public String moveOut(String name){
    if (residents.contains(name)){
      residents.remove(name);
      System.out.println("Successfully moved out " + name);
    }
    else{
      System.err.println(name + " is not a resident");
    }
    return name;
  }

  /* is the person a resident 
   * @param person name of person in question
   * @return whether or not the person is a resident
   */
  public Boolean isResident(String person){
    if (residents.contains(person)){
      return true;
    }
    else {
      return false;
    }
  }

  /* changes active floor
   * @param floorNum new active floor
   */
  public void goToFloor(int floorNum) {
  
    if (floorNum-activeFloor>1){

      if (hasElevator){
        System.out.println("You are now on floor " + floorNum + " of " + this.name);
        this.activeFloor = floorNum;
      }
      else{
        System.out.println("Cannot go to floor " + floorNum + " because there is no elevator");
      }

    }
    else{

      if (this.activeFloor == -1) {
        throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
      }
      if (floorNum < 1 || floorNum > this.nFloors) {
        throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
      }
      this.activeFloor = floorNum;
      System.out.println("You are now on floor " + floorNum + " of " + this.name);

    }
  }

  /* prints methods */
  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n):\n + hasDiningRoom() \n + nResidents() \n + moveIn() \n + moveOut() \n + isResident()");
  }

  /* main method for testing */
  public static void main(String[] args) {
    House myHouse = new House("baldwin");
    System.out.println(myHouse);
    myHouse.showOptions();
    myHouse.enter();
  }

}
