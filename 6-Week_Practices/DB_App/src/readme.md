# Employee Management Application

This Java application provides a basic interface to store employee data in a MySQL database, query this data, and export it to a text file.

## Installation

1. **Clone the Repository:** Clone this repository to your local machine using Git:

   ```bash
   git clone https://github.com/your_username/your_repo.git
   ```

2. **Database Configuration:**
    - Ensure MySQL is installed and running on your machine.
    - Create a database named `employees`.
    - Replace the `USERNAME` and `PASSWORD` constants in the `DB_Connect.java` file with your MySQL username and password.

3. **Import the Project:** Import the project into your preferred Java IDE (Eclipse, IntelliJ IDEA, etc.).

4. **Add MySQL Connector/J Library:**
    - Download MySQL Connector/J from the official website: [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/)
    - Add the Connector/J JAR file to your project's build path.

## Usage

### Methods of the DB_Connect Class:

#### `connectDB()`

- Description: Connects to the database.
- Usage:
  ```java
  DB_Connect dbConnect = new DB_Connect("SELECT * FROM employees");
  dbConnect.connectDB();
  ```

#### `printQuery()`

- Description: Prints the employee data from the database to the console.
- Usage:
  ```java
  dbConnect.printQuery();
  ```

#### `writeDB()`

- Description: Writes the employee data from the database to a text file named `employees_save.txt`.
- Usage:
  ```java
  dbConnect.writeDB();
  ```

#### `readDB()`

- Description: Reads the employee data from the `employees_save.txt` text file and prints it to the console.
- Usage:
  ```java
  dbConnect.readDB();
  ```

## Example

Here's an example of using the `DB_Connect` class:

```java
public class Main {
    public static void main(String[] args) {
        DB_Connect dbConnect = new DB_Connect("SELECT * FROM employees");
        dbConnect.connectDB();
        dbConnect.printQuery();
        dbConnect.writeDB();
        dbConnect.readDB();
    }
}
```

## Contributing

Contributions are welcome! If you have any suggestions, improvements, or feature requests, please open an issue or create a pull request.

## License

This project is licensed under the [MIT License](LICENSE).
