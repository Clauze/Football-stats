import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONObject;


//https://api.sportradar.com/soccer-extended/trial/v4/en/competitions/sr:competition:23/seasons.json?api_key=key elenco stagioni
//https://api.sportradar.com/soccer-extended/trial/v4/en/competitions.json?api_key=key elenco campionati
//https://api.sportradar.com/soccer-extended/trial/v4/en/seasons/sr:season:66441/standings.json?api_key=key
public class Main {

	public static ArrayList<Squad> squad;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		squad=new ArrayList<Squad>();
		readData();
		
	}
	
	private static void readData() {
		URL url;
		try {
			url = new URL ("https://api.sportradar.com/soccer-extended/trial/v4/en/seasons/sr:season:83944/competitors.json?api_key=eehfs36ehatfujdb9qe4g2hh");
			URLConnection yc = url.openConnection();
			Scanner s=new Scanner(yc.getInputStream());
			String inputLine= readAll(s);
			JSONObject json=new JSONObject(inputLine);
			System.out.println(printSquad(json));
			//System.out.println(json.getJSONArray("standings").getJSONObject(0).getJSONArray("groups").getJSONObject(0).getJSONObject("stage").get("year"));
			readMatch(2699);
			   	
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	private static void readMatch(int code) {
		// TODO Auto-generated method stub
	
		new Match(code);
		
	}

	private static String printSquad(JSONObject json) {
		// TODO Auto-generated method stub
		String s="",name="";
		
		for(int i=0;i<20;i++) {
			name=json.getJSONArray("season_competitors").getJSONObject(i).getString("name");
			String code = json.getJSONArray("season_competitors").getJSONObject(i).getString("id");
			squad.add(new Squad(Integer.parseInt(code.substring(14)),name));
			s+=name+"\n";
		}
		return s;
	}

	public static String readAll(Scanner rd) throws IOException {
	    StringBuilder sb = new StringBuilder();
	    while(rd.hasNext()) {
	    	sb.append(rd.nextLine());
	    }
	    return sb.toString();
	  }

}
