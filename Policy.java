public class Policy {
   private int policyNumber;
   private String providerName;
   private PolicyHolder holder;
   
   //No-arg constructor
   public Policy() {
      this.policyNumber    = 0;
      this.providerName    = "";
      this.holder          = new PolicyHolder();
   }
   
   public Policy(int policyNumber, String providerName, PolicyHolder holder) {
      this.policyNumber    = policyNumber;
      this.providerName    = providerName;
      this.holder          = new PolicyHolder(holder);
   }
   
   //Accessor methods
   /** @return the policy number */
   public int getPolicyNumber()                 { return policyNumber; }
   /** @return the provider's name */
   public String getProviderName()              { return providerName; }
   /** @return the policyholder */
   public PolicyHolder getPolicyHolder()        { return new PolicyHolder(holder); }
   
   //Mutator methods
   /** @param pn the policy number */
   public void setPolicyNumber(int pn)                   { this.policyNumber = pn; }
   /** @param pn the provider's name */
   public void setProviderName(String pn)                { this.providerName = pn; }
   /** @param ph the policyholder */
   public void setPolicyHolder(PolicyHolder ph)          { this.holder = new PolicyHolder(ph); }
   
   //Calculating methods
   /** @return the price of the policy */
   public double calcPolicyPrice() {
      double price = 600;
      if (this.holder.getAge() > 50) price += 75;
      if (this.holder.getSmokingStatus().equalsIgnoreCase("smoker")) price += 100;
      double bmi = this.holder.calcBMI();
      if (bmi > 35) price += (bmi - 35) * 20;
      return price;
   }
   
   public String toString() {
      String s = "";
      s += "Policy Number: " + policyNumber + "\n";
      s += "Provider Name: " + providerName + "\n";
      s += holder;
      s += "Policy Price: " + String.format("$%,.2f\n", this.calcPolicyPrice());
      return s;
   }
}