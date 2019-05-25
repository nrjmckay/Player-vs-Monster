import java.util.Scanner;
import java.util.ArrayList;
import java.text.DecimalFormat;


public class BattleGame{
  //method to assign txt files to characters
  public static void playGame(){
    //after assignming txt files, print the stats of each character
    Character player = FileIO.readCharacter("player.txt");
    System.out.println(player.getStats(0));
    Character enemy = FileIO.readCharacter("monster.txt");
    System.out.println(enemy.getStats(1));
    ArrayList <Spell> spells = FileIO.readSpells("spells.txt");
    for(int i = 0; i < spells.size(); i++){
      System.out.println(spells.get(i));
    }
    player.setSpells(spells);
    
    //take input from the user
    Scanner sc = new Scanner(System.in);
    //get the current health of each player
    //double plCurrentHealth = player.getCurrentHealth();
    //double enCurrentHealth = enemy.getCurrentHealth();
    
    //while both of the characters health are above 0 keep playing
    while(player.getCurrentHealth() > 0 && enemy.getCurrentHealth() > 0){
      System.out.println("Please enter a command (attack or quit)");
      String input = sc.next().toLowerCase();
      //if command is attack, use the doattack method
      //System.out.println("this is" + sc.next());
      if(input.equals("quit")){
        System.out.println("Goodbye, thanks for playing");
        break;
      }
      else if(input.equals("attack")){
        doAttack(player, enemy);
        doAttack(enemy, player);
      }
      
      //if anything other than "attack" or "quit" print a message telling them to input either attack or quit
      //if anything else other than spell or attack use spell
      else{
        double damage = player.castSpell(input);
        //use spells and check if it is a spell
        enemy.takeDamage(damage);
        enemy.getStats(1);
      }
      
    }
    //will only leave after loop when healths are zero
    
    //if player is health is lower than 0 add wins to increase wins
    if(player.getCurrentHealth() <= 0){
      System.out.println("Your player's health is now zero, you have lost");
      enemy.increaseWins();
      FileIO.writeCharacter(enemy, "monster.txt");
    }
    //if enemy health is lower than 0
    if(enemy.getCurrentHealth() <= 0){
      System.out.println("The monster's health is now zero, you have won");
      player.increaseWins();
      
      FileIO.writeCharacter(player, "player.txt");
      
    }
  }
  
  public static void doAttack(Character a, Character b){
    if(a.getCurrentHealth() > 0){//get damage value from using characters a attack value
      double damage = a.calcAttack();
      DecimalFormat df = new DecimalFormat("#.##");      
      damage = Double.valueOf(df.format(damage));
      //print out players name and the damage they will do
      System.out.println(a.getName() + " did " +  damage + "damage to " + b.getName() );
      
      //apply takeDamage to b
      b.takeDamage(damage);
      
      if(b.getCurrentHealth() > 0){
        System.out.println(b.getName() + " currently has " + b.getCurrentHealth() + " health left");                     
      }
      else{
        System.out.println(b.getName() + " was knocked out");
      }
    }
  }
  
  public static void main(String[] args){
    
    playGame();
    
  }
}
