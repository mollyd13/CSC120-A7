/* This is a stub for the Library class */
/* import hashtable and set */
import java.util.Hashtable;
import java.util.Set;

/* Library class, extends from Building class */
public class Library extends Building{

  /* attribute for library */
  private Hashtable<String, Boolean> collection;

    /* full library constructor */
    public Library(String name, String address, int nFloors) {
      super(name, address, nFloors);
      this.collection = new Hashtable<String, Boolean>();
    }

    /* defualt constructor */
    public Library(){
      this("<Name Unknown>", "<Address Unknown>", 1);
    }

    /* adds a book to the collection
     * @param title title to be added
     */
    public void addTitle(String title){
      collection.put(title, true);
      System.out.println("Successfully added " + title + " to the collection");
    }

    /* removes a book from the collection
     * @param title title to be removed
     * @return title
     */
    public String removeTitle(String title){
      if (collection.containsKey(title)){
        collection.remove(title);
        System.out.println(title + " has been removed from the collection");
      }
      else{
        System.err.println(title + " is not in the collection so it cannot be removed");
      }
      return title;
    }

    /* changes the value of a title in the collection from true to false
     * @param title book to be checked out
     */
    public void checkOut(String title){
      if (collection.containsKey(title)){

        if (collection.get(title)){
          collection.replace(title, true, false);
          System.out.println("Successfully checked out " + title);
        }
        else {
          System.err.println(title + " has already been checked out");
        }
      }
      else {
        System.err.println(title + " is not in the collection");
      }

    }

    /* changes the value of a title in the collection from false to true 
     * @param title book to be returned
    */
    public void returnBook(String title){
      collection.replace(title, false, true);
    }

    /* is this book in the collection
     * @param title the book in question
     * @return whether or not a book is in the collection
     */
    public boolean containsTitle(String title){
      return collection.containsKey(title);
    }

    /* is this book available
     * @param title book in question
     * @return whether or not a book is available to be checked out
     */
    public boolean isAvailable(String title){
      return collection.get(title);
    }

    /* prints the books in the collection and their availability */
    public void printCollection(){
      Set<String> keys = collection.keySet();
      for(String key: keys){
        System.out.println("Availabilty of "+key+" is: "+collection.get(key));
      }
      if(collection.size() == 0){
        System.out.println("The collection is empty");
      }
    }

    /* prints the books in the collection based on their availability
     * @param availability available or unavailable
     */
    public void printCollection(String availability){
      Set<String> keys = collection.keySet();
      if (availability.equals("available")){
        for(String key: keys){
          if (collection.get(key) == true){
            System.out.println(key + " is available");
          }
        }
      }
      else{
        for(String key: keys){
          if (collection.get(key) == false){
            System.out.println(key + " is unavailable");
          }
        }
      }
      if(collection.size() == 0){
        System.out.println("The collection is empty");
      }
    }
  
    public void showOptions() {
      System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n):\n + addTitle() \n + removeTitle() \n + checkOut() \n + returnBook() \n + containsTitle() \n + isAvailable() \n + printCollection()");
    }
    
    /* main method for testing */
    public static void main(String[] args) {
      Library myLibrary = new Library();
      System.out.println(myLibrary);
      myLibrary.addTitle("lord of the rings");
      myLibrary.addTitle("harry potter");
      myLibrary.checkOut("lord of the rings");
      myLibrary.printCollection("unavailable");
      myLibrary.printCollection("available");
      myLibrary.printCollection();
    }
  
  }
