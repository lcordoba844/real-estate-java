package model;

import java.util.List;

public abstract class Propiedad {

	private int id_propiedad;
	private int cant_baños;
	private int cant_dormitorios;
	private String tipo_propiedad;
	private double precio;
	private boolean cochera;
	private String descripcion;
	private String direccion;
	private Localidad localidad;
	private String estado;
	private String orientacion;
	private List<Tarea> lista_tareas;
	private int id_propietario;
	

	public int getId_propiedad() {
		return id_propiedad;
	}
	public void setId_propiedad(int id_propiedad) {
		this.id_propiedad = id_propiedad;
	}
	public int getCant_baños() {
		return cant_baños;
	}
	public void setCant_baños(int cant_baños) {
		this.cant_baños = cant_baños;
	}
	public int getCant_dormitorios() {
		return cant_dormitorios;
	}
	public void setCant_dormitorios(int cant_dormitorios) {
		this.cant_dormitorios = cant_dormitorios;
	}
	
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public boolean tieneCochera() {
		return cochera;
	}
	public void setCochera(boolean cochera) {
		this.cochera = cochera;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getTipo_propiedad() {
		return tipo_propiedad;
	}
	public void setTipo_propiedad(String tipo_propiedad) {
		this.tipo_propiedad = tipo_propiedad;
	}
	public Localidad getLocalidad() {
		return localidad;
	}
	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}
	public List<Tarea> getLista_tareas() {
		return lista_tareas;
	}
	public void setLista_tareas(List<Tarea> lista_tareas) {
		this.lista_tareas = lista_tareas;
	}
	public String getOrientacion() {
		return orientacion;
	}
	public void setOrientacion(String orientacion) {
		this.orientacion = orientacion;
	}
	public int getId_propietario() {
		return id_propietario;
	}
	public void setId_propietario(int id_propietario) {
		this.id_propietario = id_propietario;
	}
}
