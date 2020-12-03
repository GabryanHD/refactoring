package refactoring;

import java.util.Date;

public class Lloguer {
	private static final double UNITATS_DE_COST_VEHICLE_BASIC = 3;
	private static final double UNITATS_DE_COST_VEHICLE_GENERAL = 4;
	private static final double DIES_INICIALS_BASIC = 3;
	private static final double DIES_INICIALS_GENERAL= 2;
	private static final double COST_EXTRA_BASIC = 1.5;
	private static final double COST_EXTRA_GENERAL = 2.5;
	private static final double COST_DELUXE = 6;
	
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
	
	protected double unitatsCost() {
    	double unitatsCost = 0;
    	switch (getVehicle().getCategoria()) {
	        case 0:
	        	unitatsCost += UNITATS_DE_COST_VEHICLE_BASIC;
	            if (getDies() > DIES_INICIALS_BASIC) {
	                unitatsCost += (getDies() - DIES_INICIALS_BASIC) * COST_EXTRA_BASIC;
	            }
	            break;
	        case 1:
	            unitatsCost += UNITATS_DE_COST_VEHICLE_GENERAL;
	            if (getDies() > DIES_INICIALS_GENERAL) {
	                unitatsCost += (getDies() - DIES_INICIALS_GENERAL) * COST_EXTRA_GENERAL;
	            }
	            break;
	        case 2:
	            unitatsCost += getDies() * COST_DELUXE;
	            break;
	    }
    	return unitatsCost;
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
