package model;

public class Departamento extends Propiedad {
	private double mts2Tot;
	private boolean balcon;
	private boolean terraza;
	
    public Departamento( int cant_baños, int cant_dormitorios, String tipo_propiedad, double precio, boolean cochera, String descripcion,
    		int id_propietario, String direccion, String estado, double mts2Tot, boolean balcon, String orientacion, boolean terraza) {
		super();
		this.setCant_baños(cant_baños);
		this.setCant_dormitorios(cant_dormitorios);
		this.setTipo_propiedad(tipo_propiedad);
		this.setPrecio(precio);
		this.setCochera(cochera);
		this.setDescripcion(descripcion);
		this.setId_propietario(id_propietario);
		this.setDireccion(direccion);
		this.setEstado(estado);
		this.mts2Tot = mts2Tot;
		this.balcon = balcon;
		this.setOrientacion(orientacion);
		this.terraza = terraza;
    }
    
    public Departamento(int idPropiedad, int cant_baños, int cant_dormitorios, String tipo_propiedad, double precio, boolean cochera, String descripcion,
    		int id_propietario, String direccion, String estado, double mts2Tot, boolean balcon, String orientacion, boolean terraza) {
		super();
		this.setId_propiedad(idPropiedad);
		this.setCant_baños(cant_baños);
		this.setCant_dormitorios(cant_dormitorios);
		this.setTipo_propiedad(tipo_propiedad);
		this.setPrecio(precio);
		this.setCochera(cochera);
		this.setDescripcion(descripcion);
		this.setId_propietario(id_propietario);
		this.setDireccion(direccion);
		this.setEstado(estado);
		this.mts2Tot = mts2Tot;
		this.balcon = balcon;
		this.setOrientacion(orientacion);
		this.terraza = terraza;
    }
	
	public double getMts2Tot() {
		return mts2Tot;
	}
	public void setMts2Tot(double mts2Tot) {
		this.mts2Tot = mts2Tot;
	}
	public boolean tieneBalcon() {
		return balcon;
	}
	public void setBalcon(boolean balcon) {
		this.balcon = balcon;
	}
	
	public boolean tieneTerraza() {
		return terraza;
	}
	public void setTerraza(boolean terraza) {
		this.terraza = terraza;
	}
	
	
}
