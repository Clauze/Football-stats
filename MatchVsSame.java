import java.util.ArrayList;

public class MatchVsSame {
	
	private ArrayList<SingleMatch> s;
	private int cornerTotal;
	private int cornerTeam1;
	private int cornerTeam2;
	private int shotTotal;
	private int shotTeam1;
	private int shotTeam2;
	private int golTotal;
	private int golTeam1;
	private int golTeam2;
	private int ballPossTeam1;
	private int ballPossTeam2;


	
	public MatchVsSame() {
		super();
		this.s = new ArrayList<SingleMatch>();
	}
	
	public void add(SingleMatch sM) {
		calculteAverage(sM);
		s.add(sM);
		
	}
	
	public void printMatch() {
		System.out.println("numero partite "+s.size()+"\nmedia gol "+((double) golTotal/s.size())+"\nmedia tiri "+((double) shotTotal/s.size())+"\nmedia corner "+((double) cornerTotal/s.size()));
		System.out.println("\nstatistiche "+s.get(0).getHomeTeam()+"\nmedia gol "+((double) golTeam1/s.size())+"\nmedia tiri "+((double) shotTeam1/s.size())+"\nmedia corner "+((double) cornerTeam1/s.size())+"\nmedia possesso palla "+((double) ballPossTeam1/s.size()));
		System.out.println("\nstatistiche "+s.get(0).getAwayTeam()+"\nmedia gol "+((double) golTeam2/s.size())+"\nmedia tiri "+((double) shotTeam2/s.size())+"\nmedia corner "+((double) cornerTeam2/s.size())+"\nmedia possesso palla "+((double) ballPossTeam2/s.size())+"\n");

		for(int i=0;i<s.size();i++) {
			System.out.println(s.get(i));
		}
	}

	private void calculteAverage(SingleMatch sM) {
		// TODO Auto-generated method stub
		cornerTotal+=sM.getCornerAway()+sM.getCornerHome();
		shotTotal+=sM.getShotAway()+sM.getShotHome();
		golTotal+=sM.getAwayGol()+sM.getHomeGol();

		if(s.size()!=0 && s.get(0).getAwayTeam().compareTo(sM.getAwayTeam())!=0) {
			cornerTeam1+=sM.getCornerAway();
			cornerTeam2+=sM.getCornerHome();
			shotTeam1+=sM.getShotAway();
			shotTeam2+=sM.getShotHome();
			golTeam1+=sM.getAwayGol();
			golTeam2+=sM.getHomeGol();
			ballPossTeam1+=sM.getBallPossessionAway();
			ballPossTeam2+=sM.getBallPossessionHome();
		}
		else {
			
			cornerTeam2+=sM.getCornerAway();
			cornerTeam1+=sM.getCornerHome();
			shotTeam2+=sM.getShotAway();
			shotTeam1+=sM.getShotHome();
			golTeam2+=sM.getAwayGol();
			golTeam1+=sM.getHomeGol();
			ballPossTeam2+=sM.getBallPossessionAway();
			ballPossTeam1+=sM.getBallPossessionHome();
		}
		
	}
}
