import java.util.Random;
import java.util.ArrayList;
//Nolan Mckay, 260685413
public class Character{
  private String name;
  private double attackValue;
  private double maxHealthValue;
  private double currentHealthValue;
  private int numWins;
  private static ArrayList<Spell> spells;
  
  public Character(String name, double attackValue, double maxHealthValue, int numWins){
    this.name = name;
    this.attackValue = attackValue;
    this.maxHealthValue = maxHealthValue;
    this.currentHealthValue = maxHealthValue;
    this.numWins = numWins;
  }
  
  //method to return the characters name and current health
  public String toString(){
    String s = name + " currently has " + currentHealthValue + " left"; 
    return s; 
  }
  
  //method to calculate attack damage, returns the calculated attack
  public double calcAttack(){
    Random randNum = new Random();
    //store random number in variable x
    double x = randNum.nextDouble()*0.4 + 0.3;
    //the attack damage is the attackValue * a random number between 0.3 and 0.7
    double attack = attackValue*x;
    return attack;
  }
  
  //method to return the current health after taking damage
  public void takeDamage(double damage){
    this.currentHealthValue -= damage;
  }
  //methid to get current health
  public double getCurrentHealth(){
    return currentHealthValue;
  }
  
  //increase wins after winning
  public void increaseWins(){
    numWins++;
  }
  //method to get name
  public String getName(){
    return name;
  }
  
  
  public void setSpells(ArrayList<Spell> spells){
    this.spells = new ArrayList<Spell>(spells);
    
  }
  
  public double castSpell(String spellOfName){
    //set to all lower case
    String spellName = spellOfName.toLowerCase();
    //get length of the spell arrayList
    int spellLen = spells.size();
    //set damageDone to 0
    double damageDone = 0;
    //run for loop the length of the arraylist
    for(int i = 0; i < spellLen; i++){
      Spell s = spells.get(i);
      String g = s.getName();
      if(g.equals(spellName)){
        damageDone = s.getDamage();
        if(damageDone == 0){
          System.out.print(this.name + "'s spell failed to cast");
          return 0;   
        }
        else{
          return damageDone;
        }
      }
      else{
        System.out.println(this.name + " tried to cast an unknown spell");
        return 0;
      }
    }
    return damageDone;
  }
  
  //make get attack value
  public double getAttack(){
    return attackValue;
  }
  //make get max health
  public double getMaxHealth(){
    return maxHealthValue;
  }
  //make get numWins
  public int getNumWins(){
    return numWins;
  }
  
  /*method to print the stats of a character
   * if x=0 then it's the heros stats, 1 otherwise
   */
  public String getStats(int x){
    String xc = "";
    if(x==0){
      xc = "Our Hero's ";
    }else{xc = "The Monster's "; }
    return( xc + " name is: " + name + "\n" +
           name + "'s attack value is: " + attackValue + "\n" +
           name + "'s current health value is: " + currentHealthValue  + "\n" +
           name + "'s number of wins is: " + numWins);
  }
}