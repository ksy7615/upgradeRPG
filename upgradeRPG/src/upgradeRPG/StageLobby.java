package upgradeRPG;

public class StageLobby extends Stage {

	@Override
	public boolean update() {
		System.out.println("╔══════════════════════╗");
		System.out.println("          LOBBY        ");
		System.out.println("         [1] 마을        ");
		System.out.println("         [2] 전투        ");
		System.out.println("         [0] 종료        ");
	    System.out.println("╚══════════════════════╝");
	    
	    int select = GameManager.scanner.nextInt();
	    
	    if(select == 1)
	    	GameManager.nextStage = "VILLAGE";
	    else if(select == 2)
	    	GameManager.nextStage = "BATTLE";
	    else if(select == 3)
	    	GameManager.nextStage = "";
	    
	    return false;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

}
