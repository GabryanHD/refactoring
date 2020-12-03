package refactoring;

import java.util.Vector;

public class Client {
	private static final double EUROS_PER_UNITAT_DE_COST = 30;

    private String nif;
    private String nom;
    private String telefon;
    private Vector<Lloguer> lloguers;

    public Client(String nif, String nom, String telefon) {
        this.nif = nif;
        this.nom = nom;
        this.telefon = telefon;
        this.lloguers = new Vector<Lloguer>();
    }

    public String getNif()     { return nif;     }
    
    public String getNom()     { return nom;     }
    
    public String getTelefon() { return telefon; }

    public void setNif(String nif) { this.nif = nif; }
    
    public void setNom(String nom) { this.nom = nom; }
    
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    
    public void afegeix(Lloguer lloguer) {
        if (! lloguers.contains(lloguer) ) {
            lloguers.add(lloguer);
        }
    }
    
    public void elimina(Lloguer lloguer) {
        if (lloguers.contains(lloguer) ) {
            lloguers.remove(lloguer);
        }
    }
    
    public boolean conte(Lloguer lloguer) {
        return lloguers.contains(lloguer);
    }

    public String informe() {
        return composaCapsalera() +
               composaDetall() +
               composaPeu();
    }
    
    public double importTotal() {
    	double total = 0;
    	
    	for (Lloguer lloguer: lloguers) {
    		total += lloguer.quantitat() * EUROS_PER_UNITAT_DE_COST;
    	}
    	return total;
    }
    
    public int bonificacionsTotals() {
    	int bonificacions = 0;
    	
    	for (Lloguer lloguer: lloguers) {
    		bonificacions += lloguer.bonificacions();
    	}
    	return bonificacions;
    }
    
    public String composaCapsalera() {
    	
    	return "Informe de lloguers del client " + getNom() +
    			" (" + getNif() + ")\n";
    }
    
    public String composaDetall() {
    	
    	String resultat = "";
    	for (Lloguer lloguer: lloguers) {;
	        resultat += "\t" +
	            lloguer.getVehicle().getMarca() +
	            " " +
	            lloguer.getVehicle().getModel() + ": " +
	            (lloguer.quantitat() * EUROS_PER_UNITAT_DE_COST) + "€" + "\n";
    	}
    	return resultat;
    }
    
    public String composaPeu() {
    	
	    return "Import a pagar: " + importTotal() + "€\n" +
	        "Punts guanyats: " + bonificacionsTotals() + "\n";
    }
}