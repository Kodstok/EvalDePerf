
public class MM1 {
	
	
	public static void main(String args[])
	{
		long debut = System.currentTimeMillis();
		if(args.length != 4)
		{
			System.out.println("Usage : "+ "MM1" +" lambda mu duree debug");
			System.exit(1);
		}
		double DerniereArrivee=0;
		double DernierDepart=0;
		double lambda=Double.parseDouble(args[0]);
		double mu=Double.parseDouble(args[1]);
		double limite=Double.parseDouble(args[2]);
		boolean debug =(Integer.parseInt(args[3])==1);
		Ech ech = new Ech();
		Stats stats=new Stats(lambda,mu,limite);
		DerniereArrivee= Utile.loiExpo(DerniereArrivee, lambda);
		int i=0;
		
	
		while(DerniereArrivee<limite)
		{
			if(ech.isEmpty())
			{
				DerniereArrivee= Utile.loiExpo(DerniereArrivee, lambda);
				ech.addEvt(new Evt(DerniereArrivee,i));
				DernierDepart=Utile.loiExpo(DerniereArrivee,mu);
				Evt depart =new Evt(DerniereArrivee,i);
				depart.switchType(DernierDepart);
				ech.addEvt(depart);
				i++;
			}
			else
			{
				DerniereArrivee= Utile.loiExpo(DerniereArrivee, lambda);
				ech.addEvt(new Evt(DerniereArrivee,i));
				if(DernierDepart>DerniereArrivee)
				{
					DernierDepart=Utile.loiExpo(DernierDepart,mu);
				}
				else
				{
					DernierDepart=Utile.loiExpo(DerniereArrivee,mu);
					stats.nbServicesSansAttente++;
				}
				stats.tempsDeSejourTotal+=DernierDepart-DerniereArrivee;
				if(debug)
				{
					Evt depart =new Evt(DerniereArrivee,i);
					depart.switchType(DernierDepart);
					ech.addEvt(depart);
				}
				i++;
				
				Evt out = ech.nexEvt();
				if(debug)
					System.out.println(out);
				
				
			}
			
		}
		
		while(!ech.isEmpty())
		{
			
			Evt out = ech.nexEvt();
			if(debug)
				System.out.println(out);
			
		}
		stats.nbTotalClients = i;
		
		stats.affichage();
		System.out.println((System.currentTimeMillis()-debut)/1000.0);
	}
}
