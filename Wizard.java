package OOP.gametoori;

public class Wizard extends Player {
	
	int mana =100;
	int magdmg = 10;
	int heal=10;
	int att =10;
	
	public Wizard(String name, int hp, int att, int def ,int mana) {
		super(name, hp, att, def);
	}
	public Wizard(String name) {
		super(name);
	}
	
	
	public void manareg() {
		long b = System.currentTimeMillis();
		while(this.mana<100){
			if(System.currentTimeMillis() - b ==2000){
			this.mana+=3;
			b = System.currentTimeMillis();
			}
		}
	}
	
	public void attac(Player p){
		System.out.println("player " + this.toString() + " is attacking " + p);
		p.hp -= this.mana >= 5 ? (this.att +this.magdmg - p.def) : (this.att-p.def);
		System.out.println("player " + p + " hp: " + p.hp);
	//	p.reging(p);
		this.mana-=5;
		System.out.println(this.toString() + " mana: " + this.mana);
		//this.manareg();
		if(p.hp<=0) {
			System.out.println("player " + p + " has beek killed by " + this.toString());
			p.status=true;
			this.kill++;
			System.out.println(this.toString() + " kill streak: " + this.kill);
		}
		if(this.kill%5==0&&this.kill!=0){
			this.reg++;
			this.att++;
			this.def++;
			this.magdmg++;
		}
	}
	public void healing(Player p){
		if(this.mana>=15){
			p.hp+=this.heal;
			mana-=15;
			System.out.println("player " + p +" hp:" + p.hp );
			System.out.println(this.toString() + " mana: " + this.mana);
		}else System.out.println("lack of mana!");
	}
	public void revive(Player p){
		if(this.mana>=60){
			if(p.status){
				
				p.hp=60;
				this.mana-=60;
				System.out.println("player " + p + " has been revived!");
				System.out.println(this.toString() + " mana: " + this.mana);
			}
		}else System.out.println("lack of mana!");
	}
	public int gettype(){
		return 3;
	}
	

}
