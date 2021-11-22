
package gameFiles;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * The game logic class is used to create the major game mechanics and functions.
 * This includes battle mechanics, shop, and event layout. This also deals with the
 * output and game prompts as well as interfaces for the character info.
 * @author Avneet Prasad 16946880 and Kayle Pangilinan 15902932
 */
public class GameLogic {

    static Scanner scanner = new Scanner(System.in);

    public static Player player;
    public static String playerName;
    public static saveData sData;

    //boolean variable that determines if the game is running or is killed
    public static boolean isRunning;

    //random encounters within the game
    public static String[] encounters = {"Battle", "Battle", "Battle", "Rest", "Rest"};

    //enemy names 
    public static String[] enemies = {"Bandit", "Bandit", "Bandit", "Goblin", "Wolves"};

    //Story act's as well as locations
    public static int place = 0, act = 1;
    public static String[] places = {"Bandit River", "Twisted Caves", "Devils Volcano", "Devils Layer"};

    /**
     * get user input from the console
     * @param prompt for user to read
     * @param userChoices for answer
     * @return 
     */
    public static int readInt(String prompt, int userChoices) {
        int input;

        do {
            //show prompt
            System.out.println(prompt);
            try {
                //input a integer, if no integer input then give message to input a integer
                input = Integer.parseInt(scanner.next());
            } catch (Exception e) {
                input = -1;
                System.out.println("Please enter an integer!");
            }
        } while (input < 1 || input > userChoices);
        return input;
    }

    /**
     * clear console by printing nothing for all lines
     */
    public static void clearConsole() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    /**
     * line separators for making the console look neat and less cluttered
     * @param n number of separator dashes
     */
    public static void printSeperator(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    /**
     * print the heading in between print seperators
     * @param title of heading
     */
    public static void printHeading(String title) {
        printSeperator(30);
        System.out.println(title);
        printSeperator(30);
    }

    /**
     * waits for user to input anything then press enter to continue the game
     */
    public static void anythingToContinue() {
        System.out.println("\nEnter anything to continue...");
        scanner.next();
    }

    /**
     * starts the game method which takes care of the player name then jumps to game loop
     */
    public static void startGame() {
        boolean nameSet = false;    //used to tell if name has been set
        String name;
        clearConsole();
        printSeperator(40);
        printSeperator(30);
        System.out.println("THE AWAKENING");
        System.out.println("TEXT RPG BY AVNEET PRASAD AND KAYLE PANGILINAN");
        printSeperator(30);
        printSeperator(40);
        anythingToContinue();

        do {
            clearConsole();
            printHeading("What's your name?");
            name = scanner.next();  //save next user input into name string 

            while(Pattern.compile( "[0-9]" ).matcher( name ).find() == true){   //checks if name string contains numbers
                System.out.println("Please enter name without any numbers");
                name = scanner.next();
            }

            playerName = name;  // save name string into player variable for saving
            clearConsole();
            //verify with player if they are confident with their chosen name
            printHeading("Your name is " + name + ".\nIs that correct?");
            System.out.println("(1) Yes!");
            System.out.println("(2) No, I want to change my name.");
            int input = readInt("-> ", 2);
            if (input == 1) {
                nameSet = true;
            }
            //if the name is not what the player wanted it prompts to input name again
        } while (!nameSet); 

        //print the introduction of the storyline
        Story.printIntro();

        //create new player object with the name
        player = new Player(name);

        //print first act introduction for the story
        Story.printFirstActIntro();

        //set the game to start running
        isRunning = true;

        //start game loop
        gameLoop();
    }

    /**
     * changes the game location and chapter based on xp
     */
    public static void checkAct() {
        if (player.xp >= 10 && act == 1) {
            //change act and place
            act = 2;
            place = 1;
            //print story outro of first act
            Story.printFirstActOutro();
            //let player choose a weapon or armour
            player.chooseTrait();
            //print story intro of second act
            Story.printSecondActIntro();
            //assign names to enemies that player will encounter
            enemies[0] = "Evil Bandit";
            enemies[1] = "Goblin";
            enemies[2] = "Wolve Pack";
            enemies[3] = "Evil Bandit";
            enemies[4] = "Cannibal";
            //set encounters
            encounters[0] = "Battle";
            encounters[1] = "Battle";
            encounters[2] = "Battle";
            encounters[3] = "Rest";
            encounters[4] = "Shop";
        } else if (player.xp >= 50 && act == 2) {
            //set new act and place
            act = 3;
            place = 2;
            //print outro of second act
            Story.printSecondActOutro();
            //let player choose another armour or weapon
            player.chooseTrait();
            //print third act introduction for the storyline
            Story.printThirdActIntro();
            //assign names to enemies that player will encounter
            enemies[0] = "Demon Hound";
            enemies[1] = "Demon Hound";
            enemies[2] = "Demon Guard";
            enemies[3] = "Demon Guard";
            enemies[4] = "Demon Guard";
            //set encounters for player
            encounters[0] = "Battle";
            encounters[1] = "Battle";
            encounters[2] = "Battle";
            encounters[3] = "Battle";
            encounters[4] = "Shop";
            //fully heal the player before he enters the final boss fight
            player.hp = player.maxHp;
        } else if (player.xp >= 100 && act == 3) {
            //set new place and act
            act = 4;
            place = 3;
            //print outro for third act of the story
            Story.printThirdActOutro();
            //let player choose new weapon or armour
            player.chooseTrait();
            //print story intro for fourth act
            Story.printFourthActIntro();
            //fully heal the player for the boss fight
            player.hp = player.maxHp;
            //start final boss battle
            finalBattle();
        }
    }

    /**
     * create random encounter for the player by using random number generators
     */
    public static void randomEncounter() {
        //random number between 0 and the length of the encounters array
        int encounter = (int) (Math.random() * encounters.length);
        //set what the random number for the encounter does
        if (encounters[encounter].equals("Battle")) {
            randomBattle();
        } else if (encounters[encounter].equals("Rest")) {
            takeRest();
        } else {
            shop();
        }
    }

    /**
     * give player new encounters as long as they are not in the final act
     */
    public static void continueJourney() {
        //check if act must be increased
        checkAct();
        //check if game isn't in last act
        if (act != 4) {
            randomEncounter();
        }
    }

    /**
     * print out important player data such as hp, xp, potions
     */
    public static void characterInfo() {
        clearConsole();
        printHeading("CHARACTER INFO");
        //player name, player hp out of player max hp
        System.out.println(player.name + "\tHP: " + player.hp + "/" + player.maxHp);
        printSeperator(20);
        //player xp and gold
        System.out.println("XP: " + player.xp + "\tGold: " + player.gold);
        printSeperator(20);
        //number of healing potions the player has
        System.out.println("# of Potions: " + player.pots);
        printSeperator(20);

        //printing the items the player has equipped (weapon and/or armour)
        if (player.numAtkUpgrades > 0) {
            System.out.println("Offensive trait: " + player.atkUpgrades[player.numAtkUpgrades - 1]);
            printSeperator(20);
        }
        if (player.numDefUpgrades > 0) {
            System.out.println("Defensive trait: " + player.defUpgrades[player.numDefUpgrades - 1]);
        }
        
        //player can press anythin go continue
        anythingToContinue();
    }

    /**
     * encountering random trader or shop to buy potions
     */
    public static void shop() {
        clearConsole();
        printHeading("You meet a mysterious stranger.\nHe offers you something:");
        int price = (int) (Math.random() * (10 + player.pots * 3) + 10 + player.pots);
        System.out.println("- Healing Potion: " + price + " gold.\n\n\n");
        System.out.println("You have " + player.gold + " gold.");

        printSeperator(20);
        //ask the player to buy one
        System.out.println("Do you want to buy?\n(1) Yes!\n(2) No thanks.");
        int input = readInt("-> ", 2);
        //check if player wants to buy
        if (input == 1) {
            int amount = 0;
            clearConsole();
            printHeading("How many would you like?");
            try{
                amount = Integer.parseInt(scanner.next());
            } catch(Exception e){
                input = -1;
                System.out.println("Please enter a Integer");
            }
             //amount player might like to purchase
            //check if player has enough gold
            if (player.gold >= (price*amount)) {
                printHeading("You bought " + amount+ " healiing potion for " + (amount*price) + " gold.");
                //add healing potions
                for(int i=0; i<amount; i++){
                    player.pots++;
                }
                player.gold -= (price*amount);
            } else {    //if not enough money
                printHeading("You don't have enough gold to buy this...");
            }
        }
            anythingToContinue();
        
    }

    /**
     * take a healing rest
     */
    public static void takeRest() {
        clearConsole();
        //checck if player has more than one rests available
        if (player.restsLeft >= 1) {
            printHeading("Do you want to take a rest? (" + player.restsLeft + " rest(s) left).");
            System.out.println("(1) Yes\n(2) No, not now.");
            //check player choice
            int input = readInt("-> ", 2);
            //if player says yes, player takes rest
            if (input == 1) {
                clearConsole();
                //player heals random amount depending on amount of xp
                if (player.hp < player.maxHp) {
                    int hpRestored = (int) (Math.random() * (player.xp / 4 + 1) + 10);
                    //heal player
                    player.hp += hpRestored;
                    //if overheals, set player hp back to max hp
                    if (player.hp > player.maxHp) {
                        player.hp = player.maxHp;
                    }
                    //print outcomes
                    System.out.println("You took a rest and restored up to " + hpRestored + " health.");
                    System.out.println("You're now at " + player.hp + "/" + player.maxHp + " health.");
                    player.restsLeft--;
                } else {
                    System.out.println("You're at full health. You don't need to rest now!");
                }
            }
            anythingToContinue();
        }
    }

    /**
     * create a random battle for player to boost xp if player is behind
     */
    public static void randomBattle() {
        clearConsole();
        //warn player of hostile
        printHeading("You encountered an hostile creature. You'll have to fight it!");
        anythingToContinue();
        //create new enemy with random name
        battle(new Hostiles(enemies[(int) (Math.random() * enemies.length)], player.xp));
    }

    /**
     * battle method that deals with player and enemy interaction and damage
     * @param enemy hostiles the player fights against
     */
    public static void battle(Hostiles enemy) {
        //battle loop 
        while (true) {
            clearConsole();
            //display enemy data and player data
            printHeading(enemy.name + "\nHP: " + enemy.hp + "/" + enemy.maxHp);
            printHeading(player.name + "\nHP: " + player.hp + "/" + player.maxHp);
            //show player battle options
            System.out.println("Choose an action:");
            printSeperator(20);
            System.out.println("(1) Fight\n(2) Use Potion\n(3) Run Away");
            int input = readInt("-> ", 3);
            //if chosen to attack
            if (input == 1) {
                //calculate damage done by enemy to player and by player to enemy
                int dmg = player.attack() - enemy.defend();
                int dmgTook = enemy.attack() - player.defend();
                //if defence is too high, damage may be negative, healing the player
                //
                if (dmgTook < 0) {
                    //prevent the player or enemy from healing due to defence being too high
                    //and blocking more damage then is being dealt to it.
                    dmg -= dmgTook / 2;
                    dmgTook = 0;
                }
                if (dmg < 0) {
                    dmg = 0;
                }
                //deal damge to player and enemy
                player.hp -= dmgTook;
                enemy.hp -= dmg;
                //print battle information
                clearConsole();
                printHeading("BATTLE");
                System.out.println("You dealt " + dmg + " damage to the " + enemy.name + ".");
                printSeperator(15);
                System.out.println("The " + enemy.name + " dealt " + dmgTook + " damage to you.");
                anythingToContinue();
                //check if player is alive
                if (player.hp <= 0) {
                    playerDied(); //method to end the game
                    break;
                } else if (enemy.hp <= 0) {
                    //if enemy dies announce players victory
                    clearConsole();
                    printHeading("You defeated the " + enemy.name + "!");
                    //add xp gained to player
                    player.xp += enemy.xp;
                    System.out.println("You earned " + enemy.xp + " XP!");
                    //add rest and/or gold if randomly dropped
                    boolean addRest = (Math.random() * 5 + 1 <= 2.4);
                    int goldEarned = (int) (Math.random() * enemy.xp + 2);
                    if (addRest) {
                        player.restsLeft++;
                        System.out.println("You earned the chance to get an additional rest!");
                    }
                    if (goldEarned > 0) {
                        player.gold += goldEarned;
                        System.out.println("You collect " + goldEarned + " gold from the " + enemy.name + "'s corpse!");
                    }
                    anythingToContinue();
                    break;
                }
                //if player uses potion
            } else if (input == 2){
                clearConsole();
                //check if there are potions and if player has lost hp
                if (player.pots > 0 && player.hp < player.maxHp) {
                    //confirm that player wants to use the potion
                    printHeading("Do you want to drink a potion? (" + player.pots + " left).");
                    System.out.println("(1) Yes\n(2) No, maybe later");
                    input = readInt("-> ", 2);
                    //if yes, player drinks potion and gets to max hp
                    if (input == 1) {
                        //player actually took it
                        player.hp = player.maxHp;
                        clearConsole();
                        printHeading("You drank a healing potion. It restored your health back to " + player.maxHp);
                        anythingToContinue();
                    }
                } else {
                    //if player does not have any potions or is full hp, print this and dont heal
                    printHeading("You don't have any potions or you're at full health.");
                    anythingToContinue();
                }
                //if player runs away from fight
            } else if(input == 3){
                clearConsole();
                //check that player isn't in last act (final boss battle)
                if (act != 4) {
                    //chance of 35% to escape
                    if (Math.random() * 10 + 1 <= 3.5) {
                        printHeading("You ran away from the " + enemy.name + "!");
                        anythingToContinue();
                        break;
                        //if player fails to escape, player takes damage from enemy
                    } else {
                        printHeading("You didn't manage to escape.");
                        //calculate damage the player takes
                        int dmgTook = enemy.attack();
                        System.out.println("In your hurry you took " + dmgTook + " damage!");
                        player.hp = player.hp - enemy.attack();
                        anythingToContinue();
                        //check if player's still alive
                        if (player.hp <= 0) {
                            playerDied();
                        }
                    }
                } else {
                    printHeading("YOU CANNOT ESCAPE THE EVIL EMPEROR!!!");
                    anythingToContinue();
                }

            }
        }
    }

    /**
     * print the main menu in between places and fights
     */
    public static void printMenu() {
        clearConsole();
        printHeading(places[place]);
        System.out.println("Choose an action:");
        printSeperator(20);
        System.out.println("(1) Continue on your journey");
        System.out.println("(2) Character Info");
        System.out.println("(3) Exit Game");
        System.out.println();
    }

    /**
     * the final boss battle of the game
     */
    public static void finalBattle() {
        //creating the boss and letting the player fight against him
        battle(new Hostiles("Demon King", 150));
        //printing the proper ending
        if(player.hp>0){
            Story.printEnd(player);
            isRunning = false;
        }
        
    }

    /**
     * display this when player is dead
     */
    public static void playerDied() {
        clearConsole();
        printHeading("You died...");
        printHeading("You earned " + player.xp + " XP on your journey. Try to earn more next time!");
        System.out.println("Thank you for playing my game. I hope you enjoyed it :)");
        isRunning = false;
    }

    /**
     * game loop that is regularly called
     */
    public static void gameLoop() {
        while (isRunning) {
            printMenu();
            int input = readInt("-> ", 3);
            if (input == 1) {
                continueJourney();
            } else if (input == 2) {
                characterInfo();
            } else {
                isRunning = false;
            }

        }
    }
    
    /**
     * 
     * @return act
     */
    public int getAct() {
        return this.act;
    }
    
    /**
     * 
     * @return playerName
     */
    public static String getPlayerName() {
        return playerName;
    }

}
