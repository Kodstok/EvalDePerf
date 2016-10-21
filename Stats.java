
public class Stats {
	public int nbTotalClients;
    public int nbServicesSansAttente;
    public double tempsDeSejourTotal;
    double lambda;
	double mu;
	double limite;
	double ro;
    
    public Stats(double lambda,double mu, double limite)
    {
    	nbTotalClients=0;
    	nbServicesSansAttente=0;
    	tempsDeSejourTotal=0;
    	this.lambda=lambda;
    	this.mu=mu;
    	this.limite=limite;
    }
    
    public double tempsDeSejourMoyen()
    {
    	return tempsDeSejourTotal/nbTotalClients;
    }
    
    public double proportionClientsSansAttente()
    {
    	return (double)nbServicesSansAttente/(double)nbTotalClients;
    }
    
    public double debit()
    {
    	return nbTotalClients/limite;
    }
    
    public double nbMoyenClient()
    {
    	//return ((double)nbTotalClients-(double)nbServicesSansAttente)/(double)limite;
    	return tempsDeSejourTotal / limite;
    }
  
    

    void affichage()
    {
    	double ro= lambda/mu;
    	System.out.println("--------------------");
    	System.out.println("RESULTATS THEORIQUES");
    	System.out.println("--------------------");
    	System.out.println();
    	if(lambda<mu)
    		System.out.println("lambda<mu file stable");
    	else
    		System.out.println("lambda > mu file instable");
    	
    	System.out.println("ro (lambda/mu) = "+ro);
    	System.out.println("nombre de clients attendus (lambda x duree) = "+lambda*limite);
    	System.out.println("Prob de service sans attente (1 - ro) = "+(1-ro));
    	System.out.println("Prob file occupee (ro) = "+ro);
    	System.out.println("Debit (lambda) = "+lambda);
    	System.out.println("Esp nb clients (ro/1-ro) = "+ro/(1-(ro)));
    	System.out.println("Temps moyen de sejour (1/mu(1-ro)) "+(1/(mu*(1-ro))));
    	
    	System.out.println();
    	
    	System.out.println("--------------------");
    	System.out.println("RESULTATS SIMULATION");
    	System.out.println("--------------------");

    	System.out.println();
    	
    	System.out.println("Nombre total de clients = "+nbTotalClients);
    	System.out.println("Proportion clients sans attente = "+proportionClientsSansAttente());
    	System.out.println("Proportion clients avec attente = "+(1-proportionClientsSansAttente()));
    	System.out.println("Debit = "+debit());
    	System.out.println("Nb moyen de clients dans systeme = "+nbMoyenClient());
    	System.out.println("Temps moyen de sejour = "+tempsDeSejourMoyen());
    	
    	
    }
}
