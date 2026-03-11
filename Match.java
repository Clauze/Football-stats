import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Match implements Runnable{

	private int code;
	private TotalMatch t;
	
	
	public Match(int code) {
		super();
		this.code = code;
		t=new TotalMatch();
		new Thread(this).start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			int i=0;
			/*while(i<20) {
				if(code!=Main.squad.get(i).getCode()) {*/
					Thread.sleep(1000);
					URL url = new URL ("https://api.sportradar.com/soccer-extended/trial/v4/it/competitors/sr:competitor:"+code+"/versus/sr:competitor:2711/summaries.json?api_key=key");
					
					HttpURLConnection conn = (HttpURLConnection)url.openConnection();
					conn.setRequestMethod("GET"); 
					conn.connect();
					if(conn.getResponseCode()!=200) {
						System.out.println("error "+conn.getResponseCode());
					}
	
					Thread.sleep(1000);
					Scanner sc=new Scanner(url.openStream());
					
					String inputLine= Main.readAll(sc);
					JSONObject json=new JSONObject(inputLine);
					JSONArray js=json.getJSONArray("last_meetings");
					MatchVsSame mv=new MatchVsSame();

					for(int j=0;j<js.length();j++) {
						JSONObject jo=js.getJSONObject(j);
						int cornerHome=jo.getJSONObject("statistics").getJSONObject("totals").getJSONArray("competitors").getJSONObject(0).getJSONObject("statistics").getInt("corner_kicks");
						int cornerAway=jo.getJSONObject("statistics").getJSONObject("totals").getJSONArray("competitors").getJSONObject(1).getJSONObject("statistics").getInt("corner_kicks");
						int shotHome=jo.getJSONObject("statistics").getJSONObject("totals").getJSONArray("competitors").getJSONObject(0).getJSONObject("statistics").getInt("shots_total");
						int shotAway=jo.getJSONObject("statistics").getJSONObject("totals").getJSONArray("competitors").getJSONObject(1).getJSONObject("statistics").getInt("shots_total");
						int ballPossessionHome=jo.getJSONObject("statistics").getJSONObject("totals").getJSONArray("competitors").getJSONObject(0).getJSONObject("statistics").getInt("ball_possession");
						int ballPossessionAway=jo.getJSONObject("statistics").getJSONObject("totals").getJSONArray("competitors").getJSONObject(1).getJSONObject("statistics").getInt("ball_possession");
						SimpleDateFormat formatoData = new SimpleDateFormat("yyyy/MM/dd");
						Date date=new Date();
						try {
							String s=jo.getJSONObject("sport_event").getString("start_time").substring(0,10);
							date=formatoData.parse(s.replace("-", "/"));
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						String homeTeam=jo.getJSONObject("sport_event").getJSONArray("competitors").getJSONObject(0).getString("name");
						String awayTeam=jo.getJSONObject("sport_event").getJSONArray("competitors").getJSONObject(1).getString("name");
						int homeGol=jo.getJSONObject("sport_event_status").getInt("home_score");
						int awayGol=jo.getJSONObject("sport_event_status").getInt("away_score");
						
						mv.add(new SingleMatch(cornerHome, cornerAway, shotHome, shotAway, ballPossessionHome, ballPossessionAway, date, homeTeam, awayTeam, homeGol, awayGol));
						
					}
					mv.printMatch();
					t.add(mv);
					i++;
				//}
			//}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
