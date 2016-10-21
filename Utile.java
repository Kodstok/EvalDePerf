
public class Utile {
	
	public static double loiExpo(double t,double param)
	{
		double x = Math.random();
		while(x==0)
		{
			x = Math.random();
		}
		double res= t+((-Math.log(1-x))/param);
		return res;
	
	}
	

}
