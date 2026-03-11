import java.util.ArrayList;

public class TotalMatch {
	private ArrayList<MatchVsSame> t;

	public TotalMatch() {
		super();
		this.t = new ArrayList<MatchVsSame>();
	}
	
	public void add(MatchVsSame s) {
		t.add(s);
	}
	public void printMatch() {
	
		for(int i=0;i<t.size();i++) {
			t.get(i).printMatch();
		}
		
	}
	
	public void statsTotal() {
		for(int i=0;i<t.size();i++) {
			
		}
	}
}
