/**
 * @author Furkan Aydemir, deerborg
 * @since 2024
 */
public class Main {
    public static void main(String[] args) {
        Course mathsCourse = new Course("Maths", "Maths 10", "MTH");
        Course phsicCourse = new Course("Phisyc", "Phisyc 10", "PYH");
        Course chemical = new Course("Chemical", "Chemical 10", "CHE");

        Teacher addOne = new Teacher("Ulaş Hoca", "12345-1245-44", "Maths Teacher");
        Teacher addTwo = new Teacher("Ulaş Hoca2", "44124-44-15", "Physc Teacher");
        Teacher addThree = new Teacher("Ulaş Hoca3", "4124-55-123", "Chemic Teacher");
        

        mathsCourse.addTeacher(addOne);
        phsicCourse.addTeacher(addTwo);
        chemical.addTeacher(addThree);

        Student s1 = new Student("Semih Turan", 4, "42424242", mathsCourse, phsicCourse, chemical);
        s1.addBulkExamNote(80,60,70);
        s1.isPass();

        Student s2 = new Student("Batuhan Yürüdür", 4, "60606060", mathsCourse, phsicCourse, chemical);
        s2.addBulkExamNote(90,60,70);
        s2.isPass();

        Student s3 = new Student("Furkan Aydemir", 4, "55555555", mathsCourse, phsicCourse, chemical);
        s3.addBulkExamNote(100,100,100);
        s3.isPass();
        
        
    }
}
