package model;

import java.util.Date;

public class Tarea {
	private int id_tarea;
	private String descripcion;
	private EstadoTarea estado;
	private double importe;
	private Date fecha_asignacion;
	private Date fecha_realizacion;
	private boolean pagado;
	private Date fecha_pago;	
	private Propiedad prop;
	
	public Tarea(String descripcion, EstadoTarea estado, double importe, boolean pagado, Date fecha_asignacion, Date fecha_pago, Propiedad prop) {
		this.setDescripcion(descripcion);
		this.setEstado(estado);
		this.setImporte(importe);
		this.setFecha_asignacion(fecha_asignacion);
		this.setPagado(pagado);
		this.setFecha_pago(fecha_pago);
		this.setProp(prop);
	}
	
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
	public Date getFecha_asignacion() {
		return fecha_asignacion;
	}
	public void setFecha_asignacion(Date fecha_asignacion) {
		this.fecha_asignacion = fecha_asignacion;
	}
	public boolean isPagado() {
		return pagado;
	}
	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}
	public Date getFecha_pago() {
		return fecha_pago;
	}
	public void setFecha_pago(Date fecha_pago) {
		this.fecha_pago = fecha_pago;
	}
	public Propiedad getProp() {
		return prop;
	}
	public void setProp(Propiedad prop) {
		this.prop = prop;
	}	
}
