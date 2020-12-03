package refactoring;

public class Vehicle {
	
	private String model;
	private String marca;
	private int categoria;
	
	public Vehicle(String model, String marca, int categoria) {
		super();
		this.model = model;
		this.marca = marca;
		this.categoria = categoria;
	}

	public void setModel(String model) {this.model = model;}
	
	public void setMarca(String marca) {this.marca = marca;}

	public void setCategoria(int categoria) {this.categoria = categoria;}

	public String getModel() {return model;}
	
	public String getMarca() {return marca;}

	public int getCategoria() {return categoria;}
	

}