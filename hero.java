package OOP.gametoori;

public class hero extends Player {

	public hero(String name, int hp, int att, int def) {
		super(name, hp, att, def);
	}
	public hero(String name) {
		super(name);
	}
	public int gettype(){
		return 1;
	}

	
	
}