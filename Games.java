abstract public class Games {   // Games is abstract class so individual stores can efficiently add on it according to their needs
    final String gameID;       // gameID is only set by constructor automatically and cannot be changed
    String title, publisher;
    int releaseYear;
    static int id=100, count=0;     // both id and count are same for all objects (not a property of object but used by developer)
    float rating, basePrice;

    Games(){    // default constructor
        gameID= "G"+id;     // implicit typecasting (string+int=string)
        id++;               // id of next game will be incremented by 1
        releaseYear=0;
        title="";
        publisher="";
        rating= 0.0f;
        basePrice=5000;
        count++;            // count keeps a track of the number of objects (games)
    }
    Games(String title, int releaseYear, String publisher, float rating, float basePrice){  // parameterised constructor
        gameID= "G"+id;
        id++;
        this.title= title;      // this keyword is used to refer instance variable
        this.releaseYear= releaseYear;
        this.publisher= publisher;
        this.rating= rating;
        this.basePrice= basePrice;
        count++;
    }
    // abstract methods (need to be implemented by child class)
    abstract void display();
    abstract void sell();
    abstract void addStock();
    abstract void changeDiscount();
}