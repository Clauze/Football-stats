import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class SingleMatch implements Comparable<SingleMatch>{

	private int cornerHome;
	private int cornerAway;
	private int shotHome;
	private int shotAway;
	private int ballPossessionHome;
	private int ballPossessionAway;
	private Date date;
	private String homeTeam;
	private String awayTeam;
	private int homeGol;
	private int awayGol;
	


	public SingleMatch(int cornerHome, int cornerAway, int shotHome, int shotAway, int ballPossessionHome,
			int ballPossessionAway, Date date, String homeTeam, String awayTeam, int homeGol, int awayGol) {
		super();
		this.cornerHome = cornerHome;
		this.cornerAway = cornerAway;
		this.shotHome = shotHome;
		this.shotAway = shotAway;
		this.ballPossessionHome = ballPossessionHome;
		this.ballPossessionAway = ballPossessionAway;
		this.date = date;
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.homeGol = homeGol;
		this.awayGol = awayGol;
	}

	public int getCornerHome() {
		return cornerHome;
	}

	public void setCornerHome(int cornerHome) {
		this.cornerHome = cornerHome;
	}

	public int getCornerAway() {
		return cornerAway;
	}

	public void setCornerAway(int cornerAway) {
		this.cornerAway = cornerAway;
	}

	public int getShotHome() {
		return shotHome;
	}

	public void setShotHome(int shotHome) {
		this.shotHome = shotHome;
	}

	public int getShotAway() {
		return shotAway;
	}

	public void setShotAway(int shotAway) {
		this.shotAway = shotAway;
	}

	public int getBallPossessionHome() {
		return ballPossessionHome;
	}

	public void setBallPossessionHome(int ballPossessionHome) {
		this.ballPossessionHome = ballPossessionHome;
	}

	public int getBallPossessionAway() {
		return ballPossessionAway;
	}

	public void setBallPossessionAway(int ballPossessionAway) {
		this.ballPossessionAway = ballPossessionAway;
	}

	public Date getDate() {
		return date;
	}


	public String getHomeTeam() {
		return homeTeam;
	}


	public String getAwayTeam() {
		return awayTeam;
	}
	
	public int getHomeGol() {
		return homeGol;
	}

	public int getAwayGol() {
		return awayGol;
	}

	@Override
	public String toString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return "partita del "+dateFormat.format(date)+"\n"+homeTeam+" vs "+awayTeam+":"+homeGol+" "+awayGol+"\ncorner casa: "+cornerHome+"\tcorner ospiti: "+cornerAway+"\npossesso palla casa e ospiti: "+ballPossessionHome+" % "+ballPossessionAway+" %"+"\ntiri in porta casa e ospiti: "+shotHome+" "+shotAway+"\n";
	}

	@Override
	public int compareTo(SingleMatch o) {
		// TODO Auto-generated method stub
		return date.compareTo(o.date);
	}


	
	
}
