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
}