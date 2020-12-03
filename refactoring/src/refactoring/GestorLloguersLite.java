package refactoring;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class GestorLloguersLite {

	public static void main(String[] args) throws ParseException {
		
		Client c = new Client("12345678E","Gabriel","654321987");
		
		// demostració de construcció d'un vehicle de categoria BASIC
		Vehicle vehicleBasic = new Vehicle("Tata", "Vista", 0);

		// demostració de construccuó d'un lloguer amb una data
		SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
		Date date = dateFormat.parse("2/8/2013");
		Lloguer lloguerBasic = new Lloguer(date, 2, vehicleBasic);

		// demostració de formatat d'una data
		System.out.println(dateFormat.format(lloguerBasic.getData()));
		
		c.afegeix(lloguerBasic);		

		
		Vehicle vehicleGeneral = new Vehicle("Corsa", "Opel", 1);

		Date date2 = dateFormat.parse("3/8/2013");
		Lloguer lloguerGeneral = new Lloguer(date2, 2, vehicleGeneral);	
		c.afegeix(lloguerGeneral);
		
		Vehicle vehicleDeluxe = new Vehicle("Gallardo", "Lamborghini", 2);

		Date date3 = dateFormat.parse("4/8/2013");
		Lloguer lloguerDeluxe = new Lloguer(date3, 2, vehicleDeluxe);	
		c.afegeix(lloguerDeluxe);
	}
	
	public String informe() {
	    double total = 0;
	    int bonificacions = 0;
	    String resultat = "Informe de lloguers del client " +
	        getNom() +
	        " (" + getNif() + ")\n";
	    for (Lloguer lloguer: lloguers) {
	        double quantitat = 0;
	        switch (lloguer.getVehicle().getCategoria()) {
	            case Vehicle.BASIC:
	                quantitat += 3;
	                if (lloguer.getDies() > 3) {
	                    quantitat += (lloguer.getDies() - 3) * 1.5;
	                }
	                break;
	            case Vehicle.GENERAL:
	                quantitat += 4;
	                if (lloguer.getDies() > 2) {
	                    quantitat += (lloguer.getDies() - 2) * 2.5;
	                }
	                break;
	            case Vehicle.LUXE:
	                quantitat += lloguer.getDies() * 6;
	                break;
	        }

	        // afegeix lloguers freqüents
	        bonificacions ++;

	        // afegeix bonificació per dos dies de lloguer de Luxe
	        if (lloguer.getVehicle().getCategoria() == Vehicle.LUXE &&
	                lloguer.getDies()>1 ) {
	            bonificacions ++;
	        }

	        // composa els resultats d'aquest lloguer
	        resultat += "\t" +
	            lloguer.getVehicle().getMarca() +
	            " " +
	            lloguer.getVehicle().getModel() + ": " +
	            (quantitat * 30) + "€" + "\n";
	        total += quantitat * 30;
	    }

	    // afegeix informació final
	    resultat += "Import a pagar: " + total + "€\n" +
	        "Punts guanyats: " + bonificacions + "\n";
	    return resultat;
	}
}