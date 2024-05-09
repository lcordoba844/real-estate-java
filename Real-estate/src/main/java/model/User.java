package model;

public class User {
		private String username;
		private String password;
		private Rol tipoUser;
		
		public static enum Rol {
			ADMIN,
			CLIENTE
		}
		
		
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Rol getTipoUser() {
		return tipoUser;
	}
	public void setTipoUser(Rol tipoUser) {
		this.tipoUser = tipoUser;
	}
	
}
