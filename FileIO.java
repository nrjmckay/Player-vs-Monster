import java.io.*;
import java.util.ArrayList;
//Nolan Mckay, 260685413
public class FileIO{
  //this method takes as input a filename(String fileName)
  //and returns a new character
  public static Character readCharacter(String fileName){
    //Set the values of the characters(name of the character, attack value, max health and number of wins) to an empty value
    String characterName = "";
    double attack = 0;
    double health = 0;
    int numWins = 0;
    //set up file reader/buffer reader
    try{
      FileReader fr = new FileReader(fileName);
      BufferedReader br = new BufferedReader(fr);
      //get the currentline
      String currentLine = br.readLine();
      
      //each file is formatted the same, so run up to 4
      for(int i = 0; i < 4; i++){
        if( i == 0){
          characterName = currentLine;
        }
        
        if( i == 1){
          attack = Double.parseDouble(currentLine);
        }
        
        if( i == 2){
          health = Double.parseDouble(currentLine);
        }
        
        if( i == 3){
          numWins = Integer.parseInt(currentLine);
        }
        
        currentLine = br.readLine(); 
      }
      
     br.close();
     fr.close();
    }
    //catch the exceptions
    catch (FileNotFoundException e){
      System.out.println("Sorry, could not find file: " + fileName);
    }
    catch (IOException e){
      System.out.println("Sorry, there is a problem with file: " + fileName);
    } //close the bufferread and filereader
      
    
    //set the values from textfile to the new character
    Character character = new Character(characterName, attack, health, numWins);
    return character;
  }
  
  public static ArrayList<Spell> readSpells(String fileName){
    ArrayList <Spell> spellsArray = new ArrayList<Spell>();
    try{
      FileReader fr = new FileReader(fileName);
      BufferedReader br = new BufferedReader(fr);
      //get the currentline
      String currentLine = br.readLine();
      while(currentLine != null){
        String[] spellTokens = currentLine.split(" ");
        String name = spellTokens[0];
        double minDamage = Double.parseDouble(spellTokens[1]);
        double maxDamage = Double.parseDouble(spellTokens[2]);
        double chance = Double.parseDouble(spellTokens[3]);
        Spell spell = new Spell(name, minDamage, maxDamage, chance);
        spellsArray.add(spell);
        currentLine = br.readLine();
      }
      br.close();
      fr.close();
    }
    //catch the exceptions
    catch (FileNotFoundException e){
      System.out.println("Sorry, could not find file: " + fileName);
    }
    catch (IOException e){
      System.out.println("Sorry, there is a problem with file: " + fileName);
    }
    
    return spellsArray;
  }
  public static void writeCharacter(Character a, String fileName){
    try{FileWriter fw = new FileWriter(fileName);
      BufferedWriter bw = new BufferedWriter(fw);
      bw.write(a.getName() + "\n");
      bw.write("" + a.getAttack()+ "\n");
      bw.write("" + a.getAttack() + "\n");
      bw.write("" + a.getNumWins()+ "\n");
      
      bw.close();
      fw.close();
    }
    //catch the exceptions
    catch (IOException e){
      System.out.println("Sorry, there is a problem with file: " + fileName);
    }
  }
  
  public static void main(String[] args){
    System.out.println(readSpells("spells.txt"));
  }
  
}