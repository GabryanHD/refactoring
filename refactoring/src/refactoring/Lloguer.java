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
}
