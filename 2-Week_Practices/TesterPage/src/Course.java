
public class Course {
    
    Teacher cuval;
    String kursTuru;
    

    public Course(String kursTuru) {
        
        this.kursTuru = kursTuru;
    }

    public void createClass(Teacher cuval){
        if(this.kursTuru.equals(cuval.teacherBranch)){
            System.out.println("Ogretmen atandi.");
            System.out.println("Sinif adi " + cuval.teacherBranch + " Sinifi");
        }
        else{
            System.out.println(" Ogretmen o sinifa atanamaz..");
        }
    }
    
}
