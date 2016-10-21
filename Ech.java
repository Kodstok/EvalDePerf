import java.util.LinkedList;

public class Ech {
	private LinkedList<Evt> list;
	private int lastsortie=0;
	public Ech()
	{
		list = new LinkedList<Evt>();
	}
	
	public void addEvt(Evt e)
	{
		int index;
		index = getIndex(e);
		list.add(index, e);
	}
	
	public Evt nexEvt()
	{
		if(lastsortie>0)
			lastsortie--;
		return list.removeFirst();
		
	}
	
	public boolean isEmpty()
	{
		return list.size()==0;
	}
	
	public String toString()
	{
		return list.toString();
	}
	
	private int getIndex(Evt e)
	{
	
			for(int j=list.size();j>0;j--)
			{
				if(e.getDate()>list.get(j-1).getDate())
				{
					return j;
				}
			}
		return 0;
	}
	
			
}
