package OOP.gametoori;



public class Player {
	
	int hp=100 , att=30 , def=10 , reg=1 ;
	String name="";
	int kill;
	boolean status = true;
	
	
	public Player(String name ,int hp ,int att ,int def ){
		this.name = name;
		this.hp = hp ; 
		this.att = att ;
		this.def = def;
	}
	public Player(String name ){
		this.name = name;
	}
	
	
	
	public void reging(Player p){
		long b = System.currentTimeMillis();
		while(p.hp<100){
			if(System.currentTimeMillis() - b ==2000){
			p.hp+=reg;
			b = System.currentTimeMillis();
			}
		}
	}
	
	
	public void attac(Player p) {
		System.out.println("player " + this.toString() + " is attacking " + p);
		p.hp -= this.att - p.def;
		System.out.println("player " + p + " hp:" + p.hp);
		//p.reging(p);
		if(p.hp<=0) {
			System.out.println("player " + p + " has beek killed by " + this.toString());
			p.status=false;
			this.kill++;
			System.out.println(this.toString() + " kill streak: " + this.kill);
		}
		if(this.kill%5==0&&this.kill!=0){
			this.reg++;
			this.att++;
			this.def++;
		}
	}
	
	public String toString(){
		return this.name;
	}
	public int gettype(){
		return 0;
	}
	public void healing(Player p){}
	public void revive(Player p){}
	
	
	
	
	
	

}
