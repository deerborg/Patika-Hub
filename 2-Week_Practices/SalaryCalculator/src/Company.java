/**
 * @author Furkan Aydemir, deerborg
 * @since 2024
 */
public class Company {
    
     String workerName;
     double workerSalary;
     int workWeekHours;
     int dateOfYear;
     double newWorkerSalary;
     double tax;
     int bonus;

    public Company(String workerName, double workerSalary, int workWeekHours, int dateOfYear) {
        this.workerName = workerName;
        this.workerSalary = workerSalary;
        this.workWeekHours = workWeekHours;
        this.dateOfYear = dateOfYear;
    }
    public void tax(){
        if(workerSalary < 1000){
            System.out.println(workerSalary);
            workerSalary = newWorkerSalary;
            System.out.println("Tax: "+tax);
        }
        if(workerSalary >= 1000){
          this.tax = workerSalary*0.03;
          this.newWorkerSalary = workerSalary - (workerSalary*0.03);
          System.out.println("Tax: "+tax);
        }
    }
    public void bonus(){
        if(workWeekHours > 40){
            int workBonus = (workWeekHours - 40);
            bonus = (workBonus * 30);
            newWorkerSalary = newWorkerSalary+ workBonus;
            System.out.println("Bonus: " +bonus);
        }
    }
    public void raiseSalary(){
        int nowYear = 2021;
        int checkYear = nowYear - dateOfYear;
        
        if(checkYear > 19){
            newWorkerSalary = (newWorkerSalary*0.15) + newWorkerSalary;
            System.out.println("Total yaer "+checkYear);
        }
        else if(checkYear > 9 && checkYear < 19){
            newWorkerSalary = (newWorkerSalary*0.2) + newWorkerSalary;
            System.out.println("Total yaer "+checkYear);
        }
        else if(checkYear < 10){
            newWorkerSalary = (newWorkerSalary*0.05) + newWorkerSalary;
            System.out.println("Total year "+checkYear);
        }
    }
    public void getWorkerInformation(){
        tax();
        raiseSalary();
        bonus();
        bracket();
        System.out.println("WORKER CARD");
        bracket();
        System.out.println("Name: " + workerName);
        System.out.println("Salary: " + workerSalary);
        System.out.println("Total work hour in week: " + workWeekHours);
        System.out.println("Date of year: " + dateOfYear);
        System.out.println("Tax: " + tax);
        System.out.println("Take a bonus: " + bonus);
        System.out.println("New Salary: " + newWorkerSalary);
        bracket();
    }
    public void bracket(){
        System.out.println("-------------------------");
    }
    
    
}
