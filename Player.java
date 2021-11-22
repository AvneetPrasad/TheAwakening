
package gameFiles;

/**
 * this contains the balancing mechanism for the Player that would 
 * be used through out the game. It is a extension of the character class
 * @author Avneet Prasad 16946880 and Kayle Pangilinan 15902932
 */
public class Player extends Character{
	
        
	//variable that stores the Players attack and defence upgrades
	public int numAtkUpgrades, numDefUpgrades;
        public String name;
	
	//additional player information that could obtain during the course of the game
	int gold, restsLeft, pots;
	
	//Arrays containing the Player's traits that could effect the whole game
	public String[] atkUpgrades = {"Iron Sword", "Steel Sword", "Enchanted sword of King Arthur", "Excalibur"};
	public String[] defUpgrades = {"Leather Armour", "Steel Armour", "Dragon Knight Armour", "Demon Slayer Armour"};
	
	//Player specific constructor from the start of the game 
	public Player(String name) {
		//calling constructor of superclass
		super(name, 100, 5);
		//initial attack and defence upgrades
		this.numAtkUpgrades = 0;
		this.numDefUpgrades = 0;
		//initial additional player information
		this.gold = 5;
		this.restsLeft = 1;
		this.pots = 0;
                this.name = name;
		//let the player choose their initial starting trait when creating a new character
		chooseTrait();
	}

	
	//Player specific methods

        /**
         * base on the player's xp this would randomly generate the attack damage the player will
         * deal to the Hostiles
         * @return attack damage
         */
	@Override
	public int attack() {
		// TODO Auto-generated method stub
		return (int) (Math.random()*(xp/3 + numAtkUpgrades*3 + 3) + xp/12 + numAtkUpgrades*2 + numDefUpgrades + 1);
	}
        /**
         * base on the player's xp this would randomly generate the defence points the player will
         * recieve
         * @return defence points 
         */
	@Override
	public int defend() {
		// TODO Auto-generated method stub
		return (int) (Math.random()*(xp/2 + numDefUpgrades*3 + 3) + xp/8 + numDefUpgrades*2 + numAtkUpgrades + 1);
	}
	
	//allow the player to choose which traits his character would aquire during the course of the game
	public void chooseTrait(){
		GameLogic.clearConsole();
		GameLogic.printHeading("Choose a Weapon or Armour:");
		System.out.println("(1) " + atkUpgrades[numAtkUpgrades]);
		System.out.println("(2) " + defUpgrades[numDefUpgrades]);
		//obtain the player's choice
		int input = GameLogic.readInt("-> ", 2);
		GameLogic.clearConsole();
		//deals with both cases 
		if(input == 1){
			GameLogic.printHeading("You chose " + atkUpgrades[numAtkUpgrades] + "!");
			numAtkUpgrades++;
		}else{
			GameLogic.printHeading("You chose " + defUpgrades[numDefUpgrades] + "!");
			numDefUpgrades++;
		}
		GameLogic.anythingToContinue();
	}
        //this set method allows the player's name to be used over the course of the game
        public void setName(String name){
            this.name = name;
        }
        //this get method allows the game to store the player's name
        public String getName(){
            return name;
        }
        // this get method allows the game to store the player's health points
        public int getHp(){
            return this.hp;
        }
        // this get method allows the game to store the player's Gold count
        public int getGold(){
            return this.gold;
        }
        // this get method allows the game to store the player's experience points
        public int getXP(){
            return this.xp;
        }
        // this get method allows the game to store the player's Max health points
        public int getMaxHP(){
            return this.maxHp;
        }
        
}