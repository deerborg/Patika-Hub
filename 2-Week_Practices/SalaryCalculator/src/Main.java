/**
 * @author Furkan Aydemir, deerborg
 * @since 2024
 * @code .getWorkerInformation() : is a give to general information
 *       .tax() : tax calculation
 *       .raiseSalary() : Total work year calculation
 *       .bonus() : accumulated bonus information
 */
public class Main {
    public static void main(String[] args) {
        // String workerName, double workerSalary, int workPerHours, int dateOfYear
        Company company = new Company("Furkan", 2000, 50, 2010);
      
       company.getWorkerInformation();
       
      
    }
}
