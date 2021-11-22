
package gameFiles;

/**
 * it contains the general Character information for both Users and the hostiles 
 * the player would encounter when playing the game.
 * @author Avneet Prasad 16946880 and Kayle Pangilinan 15902932
 */
public abstract class Character {
    
   
	//Basic Attributes for all the characters to have including Hostiles
	public String name;
	public int maxHp, hp, xp;
	
	//Constructor for every characters including Hostiles
	public Character(String name, int maxHp, int xp){
		this.name = name;
		this.maxHp = maxHp;
		this.xp = xp;
		this.hp = maxHp;
	}
	
	//methods that each Characters have during the game
	public abstract int attack();
	public abstract int defend();
}
