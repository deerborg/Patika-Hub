/**
 *
 * @author Furkan Aydemir, deerborg
 * @since 2024
 */
public class Main {
    public static void main(String[] args) {
        // String workerName, double workerSalary, int workPerHours, int dateOfYear
        Company company = new Company("Furkan", 2000, 50, 2010);
      
       company.raiseSalary();
       company.bonus();
       company.tax();
       
      
    }
}
