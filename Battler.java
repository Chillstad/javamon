public class Battler {
	//contains the two pokemon fighting
	private Pokemon[] fighters = new Pokemon[2];
	
	//battle order
	private int firstToGo;
	private int secondToGo;

	//constructor, also determines which is faster
	public Battler(Pokemon newFighterOne, Pokemon newFighterTwo, int maxPoints){
		if (!Pokemon.validate(newFighterOne, maxPoints))
			System.out.println(newFighterOne.getName() + "is illegal!");
		if (!Pokemon.validate(newFighterTwo, maxPoints))
			System.out.println(newFighterTwo.getName() + "is illegal!");
		
		fighters[0] = newFighterOne;
		fighters[1] = newFighterTwo;

		if (fighters[0].getSpeed() > fighters[1].getSpeed()){
			firstToGo = 0;
			secondToGo = 1;
		} else {
			firstToGo = 1;
			secondToGo = 0;
		}	
	}

	//take in a move, and perform whatever said move does
	private void moveDefinition(String move){
		switch(move){
			case "debug": 
				System.out.println("It does nothing!");
		}
	}
}