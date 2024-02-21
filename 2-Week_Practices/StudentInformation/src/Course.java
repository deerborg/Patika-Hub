/**
 * @author Furkan Aydemir, deerborg
 * @since 2024
 */
public class Course {
    Teacher courseTeacher;
    String CourseName;
    String CourseCode;
    String CourseClass;
    int note;

    public Course(String CourseName, String code, String CourseClass) {
        this.CourseName = CourseName;
        this.CourseCode = CourseCode;
        this.CourseClass = CourseClass;
        this.note = 0;
       
    }
    public void addTeacher(Teacher addTeacher) {
        if (this.CourseClass.equals(addTeacher.TeacherBranch)) {
            this.courseTeacher = addTeacher;
        } else {
            System.out.println(addTeacher.TeacherName + " Teacher not this course.");
        }
    }
    public void printTeacher() {
        if (courseTeacher != null) {
            System.out.println(this.CourseName + " course Teacher : " + courseTeacher.TeacherName);
        } else {
            System.out.println(this.CourseName + " not add a Teacher");
        }
    }
}
