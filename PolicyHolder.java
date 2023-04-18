public class PolicyHolder {
   private String firstName;
   private String lastName;
   private int age;
   private String smokingStatus; //"smoker" or "non-smoker"
   private double height; //in Inches
   private double weight; //in Pounds

   //No-arg constructor
   public PolicyHolder() {
      this.firstName     = "";
      this.lastName      = "";
      this.age           = 0;
      this.smokingStatus = "non-smoker";
      this.height        = 0.00;
      this.weight        = 0.00;
   }

   public PolicyHolder(String first, String last, int age, String smokeStatus, double height, double weight) {
      this.firstName     = first;
      this.lastName      = last;
      this.age           = age;
      this.smokingStatus = smokeStatus;
      this.height        = height;
      this.weight        = weight;
   }

   //Copy contructor
   public PolicyHolder(PolicyHolder other) {
      this.firstName     = other.firstName;
      this.lastName      = other.lastName;
      this.age           = other.age;
      this.smokingStatus = other.smokingStatus;
      this.height        = other.height;
      this.weight        = other.weight;
   }

   //Accessor methods
   /** @return the policyholder's first name */
   public String getFirstName()     { return firstName; }
   /** @return the policyholder's last name */
   public String getLastName()      { return lastName; }
   /** @return the policyholder's age */
   public int getAge()              { return age; }
   /** @return the smoking status of the policyholder */
   public String getSmokingStatus() { return smokingStatus; }
   /** @return the policyholder's height in inches */
   public double getHeight()        { return height; }
   /** @return the policyholder's weight in pounds */
   public double getWeight()        { return weight; }

   //Mutator methods
   /** @param fn the policyholder's first name */
   public void setFirstName(String fn)       { this.firstName = fn; }
   /** @param ln the policyholder's last name */
   public void setLastName(String ln)        { this.lastName = ln; }
   /** @param age the policyholder's age */
   public void setAge(int age)               { this.age = age; }
   /** @param ss the policyholder's smoking status either "smoker" or "non-smoker" */
   public void setSmokingStatus(String ss)   { this.smokingStatus = ss; }
   /** @param h the policyholder's height in inches */
   public void setHeight(double h)           { this.height = h; }
   /** @param w the policyholder's weight in pounds */
   public void setWeight(double w)           { this.weight = w; }

   //Calculating Methods
   /** @return the BMI of the policyholder */
   public double calcBMI() {
      return (this.weight * 703) / (this.height * this.height);
   }
   
   public String toString() {
      String s = "";
      s += "Policyholder's First Name: "     + this.firstName + "\n";
      s += "Policyholder's Last Name: "      + this.lastName + "\n";
      s += "Policyholder's Age: "            + this.age + "\n";
      s += "Policyholder's Smoking Status: " + this.smokingStatus + "\n";
      s += "Policyholder's Height: "         + String.format("%,.1f\n", this.height);
      s += "Policyholder's Weight: "         + String.format("%,.1f\n", this.weight);
      s += "Policyholder's BMI: "            + String.format("%,.2f\n", this.calcBMI());
      return s;
   }
}