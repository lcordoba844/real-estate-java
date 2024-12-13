package model;

public class Casa extends Propiedad{
	private int cant_pisos;
	private double mts2cubiertos;
	private double mts2tot_terreno;
	
    public Casa(int cant_baños, int cant_dormitorios, String tipo_propiedad, double precio,
            boolean cochera, String descripcion, int idPropietario, String direccion, String estado, int cant_pisos, String orientacion,
            double mts2cubiertos, double mts2tot_terreno) {
	    super();
	    this.setCant_baños(cant_baños);
	    this.setCant_dormitorios(cant_dormitorios);
	    this.setTipo_propiedad(tipo_propiedad);
	    this.setPrecio(precio);
	    this.setCochera(cochera);
	    this.setDescripcion(descripcion);
	    this.setId_propietario(idPropietario);
	    this.setDireccion(direccion);
	    this.setEstado(estado);
	    this.cant_pisos = cant_pisos;
	    this.setOrientacion(orientacion);
	    this.mts2cubiertos = mts2cubiertos;
	    this.mts2tot_terreno = mts2tot_terreno;
    }
    
    public Casa(int idPropiedad, int cant_baños, int cant_dormitorios, String tipo_propiedad, double precio,
            boolean cochera, String descripcion, int idPropietario, String direccion, String estado, int cant_pisos, String orientacion,
            double mts2cubiertos, double mts2tot_terreno) {
	    super();
	    this.setId_propiedad(idPropiedad);
	    this.setCant_baños(cant_baños);
	    this.setCant_dormitorios(cant_dormitorios);
	    this.setTipo_propiedad(tipo_propiedad);
	    this.setPrecio(precio);
	    this.setCochera(cochera);
	    this.setDescripcion(descripcion);
	    this.setId_propietario(idPropietario);
	    this.setDireccion(direccion);
	    this.setEstado(estado);
	    this.cant_pisos = cant_pisos;
	    this.setOrientacion(orientacion);
	    this.mts2cubiertos = mts2cubiertos;
	    this.mts2tot_terreno = mts2tot_terreno;
    }
    
	public int getCant_pisos() {
		return cant_pisos;
	}
	public void setCant_pisos(int cant_pisos) {
		this.cant_pisos = cant_pisos;
	}
	public double getMts2cubiertos() {
		return mts2cubiertos;
	}
	public void setMts2cubiertos(double mts2cubiertos) {
		this.mts2cubiertos = mts2cubiertos;
	}
	public double getMts2tot_terreno() {
		return mts2tot_terreno;
	}
	public void setMts2tot_terreno(double mts2tot_terreno) {
		this.mts2tot_terreno = mts2tot_terreno;
	}

}
