import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * This class reads policy information from a text file and creates an ArrayList of Policy objects.
 * It then prints out the policy information, including the policy number, provider name, policyholder's first and last name,
 * age, smoking status, height, weight, BMI, and policy price. Finally, it calculates and prints the number of policies with smokers and non-smokers.
 */
public class Project_Joseph_Vysotsky {
    /**
    * The main method is the entry point of the program.
    * It reads the policy information from a file and creates an ArrayList of Policy objects.
    * It then loops through the ArrayList and prints out the policy information.
    * @param args The command-line arguments.
    */
   public static void main(String args[]) {
      try {
         File policyFile = new File("PolicyInformation.txt");
         Scanner policyInformation = new Scanner(policyFile);
         ArrayList<Policy> policies = new ArrayList<Policy>();
         
         while(policyInformation.hasNextLine()) {
            int policyNumber = policyInformation.nextInt();
            policyInformation.nextLine();
            
            String providerName = policyInformation.nextLine();
            String phFirst = policyInformation.nextLine();
            String phLast = policyInformation.nextLine();
            
            int phAge = policyInformation.nextInt();
            policyInformation.nextLine();
            
            String phSmokingStatus = policyInformation.nextLine();
            
            double phHeight = policyInformation.nextDouble();
            policyInformation.nextLine();
            
            double phWeight = policyInformation.nextDouble();
            if (policyInformation.hasNextLine()) policyInformation.nextLine();
            
            PolicyHolder holder = new PolicyHolder(phFirst, phLast, phAge, phSmokingStatus, phHeight, phWeight);
            Policy policy = new Policy(policyNumber, providerName, holder);
            policies.add(policy);
         }
         
         int numSmoker = 0;
         for(Policy policy : policies) {
            if (policy.getPolicyHolder().getSmokingStatus().equalsIgnoreCase("smoker")) numSmoker++;
            
            System.out.println("");
            System.out.print(policy);
         }
         System.out.println();
         System.out.printf("There were %d Policy objects created.\n", Policy.getNumObjects());
         System.out.println();
         System.out.printf("The number of policies with a smoker is: %d\n", numSmoker);
         System.out.printf("The number of policies with a non-smoker is: %d\n", policies.size() - numSmoker);
      } catch (FileNotFoundException e) {}
   }
}
