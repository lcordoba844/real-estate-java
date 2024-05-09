package model;

import java.util.Date;

public class Tarea {
	private int id_tarea;
	private String descripcion;
	private EstadoTarea estado;
	private double importe;
	private Date fecha_realizacion;
	
	public enum EstadoTarea {
	    PENDIENTE,
	    REALIZADO
	}
	
	public int getId_tarea() {
		return id_tarea;
	}
	public void setId_tarea(int id_tarea) {
		this.id_tarea = id_tarea;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public EstadoTarea getEstado() {
		return estado;
	}
	public void setEstado(EstadoTarea estado) {
		this.estado = estado;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	public Date getFecha_realizacion() {
		return fecha_realizacion;
	}
	public void setFecha_realizacion(Date fecha_realizacion) {
		this.fecha_realizacion = fecha_realizacion;
	}	
}
