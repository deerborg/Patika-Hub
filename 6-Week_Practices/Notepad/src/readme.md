# Note Taking Application

This simple Java application allows the user to take notes and save them to a file. It also displays the saved notes to the user.

## Usage

First, execute the `main` method of the `Main` class to start the application. Then, the user is prompted to take notes, and the user can enter as many notes as desired. The note-taking process can be ended by entering the letter "q". Afterwards, the saved notes are read from the file and displayed to the user.

## Methods

### `takeNote` Method

This method takes notes from the user and saves the entered notes to a file. Note-taking continues until the letter "q" is entered.

### `readNote` Method

This method reads the notes saved to the file and prints them to the screen.

#### Usage Example

```java
Notes notes = new Notes();
notes.takeNote();
notes.readNote();
