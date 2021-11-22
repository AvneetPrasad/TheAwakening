/*
 * 
 */
package gameFiles;
import java.io.FileWriter;
import java.io.*;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
 * This class starts the GameLogic.startGame() method to run the game and then
 * it creates a new save data object every time the game ends.
 * @author Avneet Prasad 16946880 and Kayle Pangilinan 15902932

 */
public class Main {
    
    
    public static void main(String[] args) throws IOException{

        /**
         * the program grab the function from the GameLogic class to start the game
         * once the game has ended the sData would save the Users info in txt file.
         * 
         */
        GameLogic.startGame();
        saveData sData = new saveData();
        GameLogic.printHeading("High Scores");
        sData.displayHighScores("saveFile.txt");
       
        
    }
}
    
