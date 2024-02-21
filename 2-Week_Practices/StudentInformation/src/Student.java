
public class Student {
    String Studentname;
    String studentNo;
    int studenClass;
    Course maths;
    Course physical;
    Course chemical;
    double avarage;
    boolean isPass;
    String bracket;

    Student(String Studentname, int studenClass, String studentNo, Course maths,Course physical,Course chemical) {
        this.Studentname = Studentname;
        this.studenClass = studenClass;
        this.studentNo = studentNo;
        this.maths = maths;
        this.physical = physical;
        this.chemical = chemical;
        calculationAvarage();
        this.isPass = false;
    }
    public void addBulkExamNote(int maths, int physical, int chemical) {
        if (maths >= 0 && maths <= 100) {
            this.maths.note = maths;
        }
        if (physical >= 0 && physical <= 100) {
            this.physical.note = physical;
        }
        if (chemical >= 0 && chemical <= 100) {
            this.chemical.note = chemical;
        }
    }
    public void isPass() {
        if (this.maths.note == 0 || this.physical.note == 0 || this.chemical.note == 0) {
               bracket();
            System.out.println("Error");
               bracket();
        } else {
            this.isPass = isCheckPass();
            aNote();
            System.out.println("Your Avarage : " + this.avarage);
            if (this.isPass) {
                System.out.println("Congratulations ");
            } else {
                bracket();
                System.out.println("U dummy!");
                bracket();
            }
        }
    }
    public void calculationAvarage() {
        this.avarage = (this.physical.note + this.chemical.note + this.maths.note) / 3;
    }
    public boolean isCheckPass() {
        calculationAvarage();
        return this.avarage > 55;
    }
    public void aNote(){
        bracket();
        System.out.println("Student : " + this.Studentname);
        System.out.println("Math avarage : " + this.maths.note);
        System.out.println("Physical avarage : " + this.physical.note);
        System.out.println("Chemical avarage : " + this.chemical.note);
    }
    public void bracket(){
        System.out.println("---------------------------");
    }
}
