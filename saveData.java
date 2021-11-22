
package gameFiles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/**
 * This class is used to save data to a file named saveFile.txt. The file contains
 * important data such as player name, hp, xp, gold, weapon, armour and act when they
 * exit the game. This is also used to get that information to calculate a highscore for
 * the players and save it to the file. Then at the end of the game it reads the data and
 * highscores and prints it to the terminal
 * @author Avneet Prasad 16946880 and Kayle Pangilinan 15902932
 */
public class saveData {
    Scanner scanner;
    Player player;
    GameLogic gameLogic;
    
    String playerName = GameLogic.player.name;
    int playerHealth = GameLogic.player.hp; // updated
    int playerGold = GameLogic.player.getGold();
    int playerXP = GameLogic.player.getXP();
    int playerAct = GameLogic.act;
    int playerAttack = GameLogic.player.numAtkUpgrades;
    int playerDefence = GameLogic.player.numDefUpgrades;
    
    int highScore = (playerGold+playerXP+playerAttack+playerDefence);
    
    //save the information as a string array
    String[] saveInfo = {playerName, Integer.toString(playerHealth), Integer.toString(playerGold), Integer.toString(playerXP), Integer.toString(playerAct), Integer.toString(playerAttack), Integer.toString(playerDefence), Integer.toString(highScore)};
    int pName = 0;
    int pHP = 1;
    int pGold = 2;
    int pXP = 3;
    int pAct = 4;
    int pAtk = 5;
    int pDef = 6;
    int pHS = 7;

    /**
     * constructor that saves data to saveFile.txt after each game
     */
    public saveData() {
        saveData("saveFile.txt");

    }
    
    /**
     * gives name to each array sector as well as converts the data to a string
     */
    public void writingArray(){
        saveInfo[pName] = playerName;
        saveInfo[pHP] = Integer.toString(playerHealth);
        saveInfo[pGold] = Integer.toString(playerGold);
        saveInfo[pXP] = Integer.toString(playerXP);
        saveInfo[pAct] = Integer.toString(playerAct);
        saveInfo[pAtk] = Integer.toString(playerAttack);
        saveInfo[pDef] = Integer.toString(playerDefence);
    }
    
    /**
     * displays high scores from the file
     * @param fileName is where the saved data is taken from
     * @throws IOException if file isn't found
     */
    public void displayHighScores(String fileName) throws IOException {
        fileName = "saveFile.txt";
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);
        while(scanner.hasNextLine()){
            String line  = scanner.nextLine();
            String[] saveInfo = line.split(" ");
            
            System.out.println(saveInfo[0] + " = " + saveInfo[7]);
        }
        scanner.close();
    }

    /**
     * print data to saveFile.txt one line every game
     * @param filePath is where the data is saved in 
     */
    private void saveData(String filePath) {

        File outputFile;
        PrintWriter outputWriter;
        try (FileWriter f = new FileWriter("saveFile.txt", true); BufferedWriter b = new BufferedWriter(f); PrintWriter p = new PrintWriter(b);){

            StringBuffer sb = new StringBuffer();
            
            for(int i=0; i<saveInfo.length; i++){
                sb.append(saveInfo[i] + " ");
            }
            String dataLine = sb.toString();

                p.println(dataLine);
                        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        
}
