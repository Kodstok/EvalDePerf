
public class Evt {
	private double date;
	private double arrivee=0;
	private boolean type;//depart arrivé
	int id;
	public Evt(double date,int id)
	{
		this.date=date;
		this.type=true;
		this.arrivee=date;
		this.id=id;
	}
	
	public double getDate()
	{
		return date;
	}
	
	
	public String toString()
	{
		if(type)
		{
			return "Date = "+getDate()+" Type : Arrivée Client 	#"+id;
		}
		else
		{
			return "Date = "+getDate()+" Type : Depart Client 	#"+id +" Arrive à t = "+arrivee;
		}
		
	}

	public void switchType(double date) {
		this.type=!this.type;
		this.arrivee = this.date;
		this.date = date;
	}

	public boolean isType() {
		return type;
	}

}
