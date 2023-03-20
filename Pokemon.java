public class Pokemon {
	private String name;
	private boolean fainted;
	//basic stats
	private int health;
	private int maxHealth;
	private int speed;
	private int attack;
	private int specialAttack;
	private int defense;
	private int specialDefense;

	//store list of moves in a String array
	private String[] moves;

	//list of all valid moves
	private static String[] validMoves = {"debug"};

	//basic constructor
	public Pokemon(){
		defaultStats();
	}

	//use in constructors so that you don't need to retype defaults
	private void defaultStats(){
		name = "default";
		fainted = false;
		health = 1;
		maxHealth = health;
		speed = 1;
		attack = 1;
		specialAttack = 1;
		defense = 1;
		specialDefense = 1;
		moves = new String[4];
	}

	//basic setters
	public void setHealth(int newHealth){
		health = newHealth;
	}
	public void setSpeed(int newSpeed){
		speed = newSpeed;
	}	
	public void setAttack(int newAttack){
		attack = newAttack;
	}	
	public void setSpecialAttack(int newSpecialAttack){
		specialAttack = newSpecialAttack;
	}	
	public void setDefense(int newDefense){
		defense = newDefense;
	}	
	public void setSpecialDefense(int newSpecialDefense){
		specialDefense = newSpecialDefense;
	}
	public void setMove(String move, int index){
		moves[index] = move;
	}

	//basic getters
	public String getName(){return name;}
	public int getHealth(){return health;}
	public int getMaxHealth(){return maxHealth;}
	public int getSpeed(){return speed;}	
	public int getAttack(){return attack;}	
	public int getSpecialAttack(){return specialAttack;}	
	public int getDefense(){return defense;}	
	public int getSpecialDefense(){return specialDefense;}
	public String getMove(int index){return moves[index];}

	//check to see if fainted
	//if it has, return true
	public boolean checkHealth(){
		if (health <= 0){
			fainted = true;
			return true;
		}
		return false;
	}

	public void print(){
		System.out.println("-----------------");
		System.out.println("Name: " + name);
		System.out.println("Health: " + Math.round((health/maxHealth*100)) + "%");
		System.out.println("Move[0]: " + moves[0]);
		System.out.println("Move[1]: " + moves[1]);
		System.out.println("Move[2]: " + moves[2]);
		System.out.println("Move[3]: " + moves[3]);
		System.out.println("-----------------");
	}

	//return random number
	private int roll(int sides){
		return (int) (Math.random() * sides);
	}

	//see if all moves in a given Pokemon are valid
	public static boolean validateMoves(Pokemon target){
		for(int i = 0; i < 4; i++){
			boolean found = false;
			for(String move : validMoves){
				if(move.equals(target.getMove(i))){
					found = true;
				}
			}
			if (!found){
				return false;
			}
		}
		return true;
	}

	//see if all stats in a given Pokemon are valid
	public static boolean validateStats(Pokemon target, int maxPoints){
		int pointSum = (
			target.getMaxHealth() + target.getSpeed() + target.getAttack() +
			target.getSpecialAttack() + target.getDefense() + target.getSpecialDefense()
		);
		if (pointSum <= maxPoints){
			return true;
		}
		return false;
	}

	//validate a pokemon in its entirety
	public static boolean validate(Pokemon target, int maxPoints){
		if(Pokemon.validateMoves(target) && Pokemon.validateStats(target, maxPoints)){
			return true;
		}
		return false;
	}
	
}