package model;

public class Servicio {
	private int id_servicio;
	private String descripcion;
	private double precio_a_la_fecha;
	
	public int getId_servicio() {
		return id_servicio;
	}
	public void setId_servicio(int id_servicio) {
		this.id_servicio = id_servicio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public double getPrecio_a_la_fecha() {
		return precio_a_la_fecha;
	}
	public void setPrecio_a_la_fecha(double precio_a_la_fecha) {
		this.precio_a_la_fecha = precio_a_la_fecha;
	}
}
