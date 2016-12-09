package OOP.gametoori;

public class monster extends Player {
	
	public monster(String name, int hp, int att, int def) {
		super(name, hp, att, def);
	}	
	public monster(String name) {
		super(name);
	}
	public int gettype(){
		return 2;
	}
	

}
