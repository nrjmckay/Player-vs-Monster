import java.util.Random;
//Nolan Mckay, 260685413
public class Spell{
  private String spellName;
  private double minDamage;
  private double maxDamage;
  private double success;
  
  public Spell(String spellName, double minDamage, double maxDamage, double success){
    this.spellName = spellName;
    this.minDamage = minDamage;
    this.maxDamage = maxDamage;
    this.success = success;
    if(minDamage < 0){
      throw new IllegalArgumentException("Your minimum damage can't be lower than 0");
    }
    else if(minDamage > maxDamage){
         throw new IllegalArgumentException("Your minimum damage can't be higher than your maximum damage"); 
    
    }
    else if(success > 1 || success < 0){
      throw new IllegalArgumentException("Your success value must be between 0 and 1"); 
    }
  }
  
  public String getName(){
    return spellName;
  }
  
  public double getDamage(){
    Random randomNum = new Random();
    double x = randomNum.nextDouble();
    if(x > success){
      return 0;
    }
    else{
      double y = randomNum.nextDouble()*(maxDamage- minDamage) + minDamage;
      return y;
    }
  }
  
  public String toString(){
    String s = "The spell's name is: " + spellName + ", the damage is: " + minDamage 
      + " - " + maxDamage + ", and the success chance is: " + success*100 + "%";
    return s;
  }
    
}