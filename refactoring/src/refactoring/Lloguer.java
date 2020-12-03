package refactoring;

import java.util.Date;

public class Lloguer {
	private Date data;
	private int dies;
	private Vehicle vehicle;
	
	public Lloguer(Date data, int dies, Vehicle vehicle) {
		super();
		this.data = data;
		this.dies = dies;
		this.vehicle = vehicle;
	}
	
	public void setData(Date data) { this.data = data;}

	public void setDies(int dies) {	this.dies = dies;}

	public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle;}
	
	public Date getData() {	return data;}

	public int getDies() { return dies;}

	public Vehicle getVehicle() { return vehicle;}
	
	protected double quantitat() {
    	double quantitat = 0;
    	switch (getVehicle().getCategoria()) {
	        case 0:
	            quantitat += 3;
	            if (getDies() > 3) {
	                quantitat += (getDies() - 3) * 1.5;
	            }
	            break;
	        case 1:
	            quantitat += 4;
	            if (getDies() > 2) {
	                quantitat += (getDies() - 2) * 2.5;
	            }
	            break;
	        case 2:
	            quantitat += getDies() * 6;
	            break;
	    }
    	return quantitat;
    }
	
	protected int bonificacions() {
    	// afegeix lloguers freqüents
        int bonificacions = 0;

        // afegeix bonificació per dos dies de lloguer de Luxe
        if (getVehicle().getCategoria() == 2 &&
                getDies()>1 ) {
            bonificacions ++;
        }
        return bonificacions;
    }
}
