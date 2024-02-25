
public class Teacher {
    
    
    String teacherName;
    String teacherBranch;

    public Teacher(String teacherName, String teacherBranch) {
        
        this.teacherName = teacherName;
        this.teacherBranch = teacherBranch;
    }
    
    public void infoTeacher(){
        System.out.println("Adi: " + teacherName);
        System.out.println("Bransi: " + teacherBranch);
    }
    
}
