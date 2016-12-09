package OOP.gametoori;

import java.util.Scanner;

public class GameLike {

	static Player[] statchk(Player[] p){
		int flag=0;
		for(int i=0 ; i<p.length ; i++){
			if(p[i].status==false){
				flag=1;
			}
		}
		Player[] temp = new Player[p.length-flag];
		for(int i=0,j=0 ; i<p.length ; i++){
			if(p[i].status==true){
				temp[j]=p[i];
				j++;
			}
		}
		p=temp;
		
		return p;
		
	}
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int gameflag=0;
		int i=0;
		int j=-1;
		
		Player[] players = new Player[i];
		
		boolean addflag = false ; 
		
		while (!addflag){
			
			System.out.println(" 1:add hero , 2:add monster , 3:add wizard , 4:end adding");
			int turn=sc.nextInt();
			sc.nextLine();
			
			
			switch(turn){
				
			case 1:
				//add hero
				i++;
				String st1 = sc.nextLine();
				Player[] temp = new Player[i];
				for(int m=0 ; m<players.length ; m++){
					temp[m] = players[m];
				}
				temp[i-1] = new hero(st1);
				players = new Player[i];
				players = temp;
				break;
				
			case 2:
				//add monster
				i++;
				st1 = sc.nextLine();
				temp = new Player[i];
				for(int m=0 ; m<players.length ; m++){
					temp[m] = players[m];
				}
				temp[i-1] = new monster(st1);
				players = new Player[i];
				players = temp;
				break;
				
			case 3:
				//add wizard
				i++;	
				st1 = sc.nextLine();
				temp = new Player[i];
				for(int m=0 ; m<players.length ; m++){
					temp[m] = players[m];
				}
				temp[i-1] = new Wizard(st1);
				players = new Player[i];
				players = temp;
				break;
				
			case 4:
				addflag=true;
				break;
			}
		}
		//sc.nextLine();
		
		 while (gameflag==0){
			System.out.println("1: attac , 2:wiz:heal , '3:wiz:revive'(out of order) , 4:end game");
			if(j<i-1)
				j++;
			else
				j=0;
			if(players.length>0 && j>=0)
				System.out.println("it is "+players[j]+"'s turn!");
			int turn=0;;

			while (true){
				turn=sc.nextInt();
				sc.nextLine();
				if(players[j].gettype()!=3 && (turn==2|turn==3)){
					System.out.println("/n invalid command for this player type");
				}else{
					break;
				}
				
			}
			
			
			switch(turn){
			case 1:
				//attack
				int x=0;
				String target = sc.nextLine();
				for(int m=0 ; m<players.length ; m++){
					if(target.equals(players[m].toString())){
						x=m;
						break;
					}
				}
				players[j].attac(players[x]);
				break;
				
			case 2:
				//wiz heal
				if(players[j].gettype()==3){
					 x=0;
					 target = sc.nextLine();
					for(int m=0 ; m<players.length ; m++){
						if(target.equals(players[m].toString())){
							x=m;
							break;
						}
					}
					players[j].healing(players[x]);
				}
				break;
				
//			case 3:
//				//wiz revive
//				if(players[j].gettype()==3){
//					 x=0;
//					 target = sc.nextLine();
//					for(int m=0 ; m<players.length ; m++){
//						if(target.equals(players[m].toString())){
//							x=m;
//							break;
//						}
//					}
//					players[j].revive(players[x]);
//				}
//				break;
				
			
			case 4:
				gameflag=1;
				break;
				
			}
			
			
			
			players = statchk(players);
			
			
			
			
		}
		
		
		 sc.close();
	}

	
}
