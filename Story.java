

package gameFiles;

/**
 * Lays out the story of the game for each chapter
 * @author Avneet Prasad 16946880 and Kayle Pangilinan 15902932
 */
//class that does nothing but storing methods to print out every part of the story

    
  public class Story {
	
      /**
       * Introduction story
       */
	public static void printIntro(){
		GameLogic.clearConsole();
		GameLogic.printSeperator(30);
		System.out.println("Introduction");
		GameLogic.printSeperator(30);
		System.out.println("You randomly wake up in the middle of the forest. Your memory is very shady and you dont't remember much of anything.");
		System.out.println("You look down and you see you clothes are ripped as if you had been in a battle. Everything hurts. Your have blood dripping from");
		System.out.println("your chest, arm and legs. You struggle to get yourself up and you get a sharp pain in your head. You close your eyes and see a glimpse");
                System.out.println("of your mother getting grabbed by the neck and lifted up as she burns to a crisp by a demon-like being. Revealing her bone structure as her skin gets sucked");
                System.out.println("into her body. You feel startled and extremely scared as you feel your memory return. Your family was attacked by a demon.");
                System.out.println("Your realise how you ended up where you are. You had escaped your villiage and were running to the nearest vigil base.");
		GameLogic.anythingToContinue();
	}
	
        /**
         * first Chapter introduction
         */
	public static void printFirstActIntro(){
		GameLogic.clearConsole();
		GameLogic.printSeperator(30);
		System.out.println("Chapter 1");
		GameLogic.printSeperator(30);
		System.out.println("As you begin your journey through the nearby woods, you reach a river. The river seems to be clean and calm.");
		System.out.println("Youv have never really been to this river as you were never allowed out of the villiage. You have heard many stories of the");
		System.out.println("Bandit River. You decide to go and take a quick dip in the river to clean your wounds and freshen up");
                System.out.println("\n You hear some branches crack not long after you get in.");
		GameLogic.anythingToContinue();
	}
	
        /**
         * end of first chapter
         */
	public static void printFirstActOutro(){
		GameLogic.clearConsole();
		GameLogic.printSeperator(30);
		System.out.println("Chapter 1");
		GameLogic.printSeperator(30);
		System.out.println("You managed to escape while taking minimal damage from the intruder. You decide to run to the vigil base and you see a large cloud of smoke.");
		System.out.println("As you get closer you see that the vigiles base has been lit on fire and you hear some scremaing. you decide to run away as far as you can when suddenly");
                System.out.println("you end up running into an old mage who was outside his little shack watering his herbs. He sees you running and stops you to ask what the problem is.");
                System.out.println("You get invited into his house and he gives you some tea. He says that he can see that you have a lot of potential and he has enchanted the tea.");
		System.out.println("\nYou feel empowered as you drink it and the experience you gained allows you to learn another trait!");
		GameLogic.anythingToContinue();
	}
	
        /**
         * second chapter intro
         */
	public static void printSecondActIntro(){
		GameLogic.clearConsole();
		GameLogic.printSeperator(30);
		System.out.println("Chapter 2");
		GameLogic.printSeperator(30);
		System.out.println("The wizard tells of great power hidden in a cave not far from there. So you change directions towards that cave.");
		System.out.println("As you venture through the lands you meet many hostile foes. You go around collecting gold from their bodies as you feel more confident and stronger");
		System.out.println("after meeting the wizard. Knowing that there are many travelling traders that you may end up running into, the gold can be quite useful.");
		System.out.println("You know exactly where the Twisted Caves are thanks to the wizard so you keep walking in that direction.");
		GameLogic.anythingToContinue();
	}
	
        /**
         * end of second chapter
         */
	public static void printSecondActOutro(){
		GameLogic.clearConsole();
		GameLogic.printSeperator(30);
		System.out.println("Chapter 2");
		GameLogic.printSeperator(30);
		System.out.println("You managed to get to the centre of the Twisted Caves and you're still alive! In the cave you stumble across a hidden room that contains some precious goods.");
		System.out.println("You decide to take on the Devil King on your own as you feel really powerful now.");
		System.out.println("You know that you probably can't rest there, so you make a last break to restore some health.");
		System.out.println("\nAfter all you've seen you feel empowered to learn another trait.");
		GameLogic.anythingToContinue();
	}
	
        /**
         * third chapter intro
         */
	public static void printThirdActIntro(){
		GameLogic.clearConsole();
		GameLogic.printSeperator(30);
		System.out.println("Chapter 3");
		GameLogic.printSeperator(30);
		System.out.println("You decide to head back to head towards the volcano as you have heard rumors that there is a Devil King that lives nearby.");
		System.out.println("As you head to the volcano, you can feel the power of the Devil King radiate all around the area giving you a slight overwhelming feeling. ");
		System.out.println("You go throught a small cave opening farr off from the main one so you dont end up getting the attention of the demonlings roaming around the volcano.");
		System.out.println("All you can do is sneak around and find the Devil Kings layer.");
		GameLogic.anythingToContinue();
	}
	
	/**
         * end of third chapter
         */
	public static void printThirdActOutro(){
		GameLogic.clearConsole();
		GameLogic.printSeperator(30);
		System.out.println("Chapter 3");
		GameLogic.printSeperator(30);
		System.out.println("You have defeated all the demons in your path and now you are outside the Demon Kings layer.");
		System.out.println("The area reeks of rotting and burnt flesh and all you can hear is screaming from dieing humans.");
		System.out.println("You try look for a opening that isnt the main entrance and you find a small room with many relic-like items.");
		System.out.println("You use one relic before entering the Demon Kings layer.");
		GameLogic.anythingToContinue();
	}
	
        /*
        * fourth chapter intro
        */
	public static void printFourthActIntro(){
		GameLogic.clearConsole();
		GameLogic.printSeperator(30);
		System.out.println("Chapter 4");
		GameLogic.printSeperator(30);
		System.out.println("You enter the Demon Kings layer and you can feel yourself get crushed by the radiating Demon Kings presence.");
		System.out.println("He stares you dead in the eyes. You feel the darkness around you.");
		System.out.println("He takes out the flaming sword that you can see reflects the fires of hell. You take out your weapon.");
		System.out.println("All you can do know is fight for your life and try your best to come out as the winner...");
		GameLogic.anythingToContinue();
	}
	
        /**
         * end of game
         * @param player has defeated demon king(boss)
         */
	public static void printEnd(Player player){
		GameLogic.clearConsole();
		GameLogic.printSeperator(30);
		System.out.println("Congratulations, " + player.name + "! You defeated the Demon King and saved the world!");
		GameLogic.printSeperator(30);
		System.out.println("This game was developed by Avneet Prasad and Kayle Pangilinan");
		System.out.println("Hope you had fun");
	}
}
