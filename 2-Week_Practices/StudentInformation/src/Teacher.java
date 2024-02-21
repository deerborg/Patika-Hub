/**
 * @author Furkan Aydemir, deerborg
 * @since 2024
 */
public class Teacher {
    
    String TeacherName;
    String TeacherPhoneNumber;
    String TeacherBranch;

    public Teacher(String TeacherName, String TeacherPhoneNumber, String TeacherBranch) {
        this.TeacherName = TeacherName;
        this.TeacherPhoneNumber = TeacherPhoneNumber;
        this.TeacherBranch = TeacherBranch;
    }
    void printInformation(){
        System.out.println("Name: " + this.TeacherName);
        System.out.println("Brannch: " + this.TeacherBranch);
        System.out.println("Number: " + this.TeacherPhoneNumber);
    }

}
