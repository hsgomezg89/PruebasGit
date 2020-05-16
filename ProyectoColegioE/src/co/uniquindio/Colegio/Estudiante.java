package co.uniquindio.Colegio;




public class Estudiante {

	private String id;
	private String nombre;
	private String apellido;
	private String mail;

	
	public Estudiante() {
		
	}
	
	public Estudiante(String id, String nombre,String apellido, String mail) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return" \n"+" Estudiante : \n " +"Id : " + id + "\n" + "Nombre : " 
	+ nombre + "\n"+ "Apellido : " +apellido + "\n"+ "Correo : " + mail ;
	}
	
	public void fijarRegistro() {
		
	}
	
	public boolean validarLetraNombre(char letra){
		boolean respuesta = false;
		if (nombre.indexOf(letra) != -1){
			respuesta = true;
		}
		return respuesta;
	}
	


}
