
# Java Video Game Store Management Project

## Overview
This project is a Java-based application designed to manage video game store related data and operations. The application contains multiple classes, each responsible for different aspects of the project, such as game details, store management, and database operations.

## Files

### 1. `Games.java`
Defines an abstract class `Games`, serving as a blueprint for various game entities. Key features include:
   - **Attributes**: `gameID` (unique and immutable), `title`, `publisher`, `releaseYear`, `rating`, and `basePrice`.
   - **Static Variables**: `id` to generate unique `gameID`s and `count` to track the number of game instances.
   - **Constructors**: 
      - Default constructor initializes a game object with default values.
      - Parameterized constructor allows customization of game attributes while auto-generating `gameID`.
   - **Abstract Design**: Enables individual stores to extend `Games` and customize attributes as needed.

### 2. `Store.java`
Manages store functionalities, such as adding and displaying items, handling transactions, and potentially managing inventory.

### 3. `Store_db.java`
Responsible for database operations related to the store, such as connecting to a database, retrieving data, and updating records related to inventory, sales, or customer information.

### 4. `Store_Use.java`
Serves as the main driver for integrating the game and store functionalities, utilizing `Store.java` and `Store_db.java` to enable a cohesive application experience.

## Requirements
- **Java Development Kit (JDK)**: Version 8 or higher
- **Database Setup**: Ensure the database is set up if `Store_db.java` interacts with one

## How to Run
1. **Compile** the Java files:
   ```bash
   javac Games.java Store.java Store_db.java Store_Use.java
   ```
2. **Run** the main application:
   ```bash
   java Store_Use
   ```

## Future Enhancements
- Adding a graphical user interface (GUI) for a more interactive experience
- Expanding game mechanics and store management features
- Implementing more complex database interactions

## Contributing
If you would like to contribute, please fork the repository, make your changes, and submit a pull request.

