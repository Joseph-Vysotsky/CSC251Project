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
            
            Policy policy = new Policy(policyNumber, providerName, phFirst, phLast, phAge, phSmokingStatus, phHeight, phWeight);
            policies.add(policy);
         }
         
         
         for(Policy policy : policies) {
            
            
            System.out.println("");
            System.out.printf("Policy Number: %d\n",                 policy.getPolicyNumber());
            System.out.printf("Provider Name: %s\n",                 policy.getProviderName());
            System.out.printf("Policyholder's First Name: %s\n",     policy.getPolicyholderFirstName());
            System.out.printf("Policyholder's Last Name: %s\n",      policy.getPolicyholderLastName());
            System.out.printf("Policyholder's Age: %d\n",            policy.getPolicyholderAge());
            System.out.printf("Policyholder's Smoking Status (smoker/non-smoker): %s\n", policy.getPolicyholderSmokingStatus());
            System.out.printf("Policyholder's Height: %,.1f\n",      policy.getPolicyholderHeight());
            System.out.printf("Policyholder's Weight: %,.1f\n",      policy.getPolicyholderWeight());
            System.out.printf("Policyholder's BMI: %,.2f\n",         policy.calcBMI());
            System.out.printf("Policy Price: $%,.2f\n",              policy.calcPolicyPrice());
         }
         
      } catch (FileNotFoundException e) {}
   }
}
