/*
 * 
 */
package gameFiles;

/**
 * this contains the balancing mechanism for the every Hostile encounter the User
 * would face base on how much the player xp obtain during the course of the game.
 * This would effect on the Hostiles attack dealt to the player and 
 * amount of defence the Hostiles can protect themselves from the player.
 * @author Avneet Prasad 16946880 and Kayle Pangilinan 15902932
 */
public class Hostiles extends Character{
    
	//variable to store the player's xp 
	int playerXp;
	
	//enemy specific constructor
	public Hostiles(String name, int playerXp) {
		super(name, (int) (Math.random()*playerXp + playerXp/3 + 2), (int) (Math.random()*(playerXp + 3)));
		//the player's xp variable
		this.playerXp = playerXp;
	
	}

	/**
         * Hostiles Balancing Mechanism for attack deliver to the player xp
         * @return attack damage
         */
	@Override
	public int attack() {
		return (int) (Math.random()*(2*playerXp/3 + 1) + xp/2 + 3);
	}
        /**
         * Hostiles Balancing Mechanism for defence taken from the player xp
         * @return defence points
         */
	@Override
	public int defend() {
		return (int) (Math.random()*(playerXp/4 + 1) + xp/4 + 3);
	}

}
