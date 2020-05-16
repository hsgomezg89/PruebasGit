package co.uniquindio.Colegio;


import java.lang.reflect.Array;
import java.util.Arrays;


/**
 * Clase principal del sistema
 * @author juane
 *
 */
public class Colegio {

	private String nombre;
	private Estudiante [] estudiantes;
	private int [] telefonos;
	int contEstudiantes;
	//private ArrayList<Registro> listaEstudiantes;
	
	/**
	 * metodo constructor de la clase
	 * @param nombre
	 * @param cantidadEstudiante
	 */
	public Colegio(String nombre, int cantidadEstudiante) {
		this.nombre = nombre;
		this.estudiantes = new Estudiante[cantidadEstudiante];
		this.telefonos = new int[10];
		contEstudiantes=0;
	}
	public Colegio(){
		
		
	}

	/**
	 * metodo que me permite adicionar un estudiante
	 * @param estudianteNuevo - estudiante a a�adir
	 * @throws NohayCupoEstudiante - excepcion del metodo
	 */
	public void adicionarEstudiante(Estudiante estudianteNuevo) throws NohayCupoEstudiante {
		
		int posicion=buscarPosicionEstudianteVacia();
		if(posicion!=-1) {
			estudiantes[posicion] = estudianteNuevo;
		}
		else
		{
			

			throw new NohayCupoEstudiante("no hay cupo libre");			
		}		
	}
	
	
	/**
	 * metodo que me permite buscar una posicion libre
	 * @return  - posicion vacia
	 */
	private int buscarPosicionEstudianteVacia() {
		int posicion=-1;
		for (int i = 0; i < estudiantes.length&&posicion==-1; i++) {
			if(estudiantes[i]==null) {
				posicion=i;
			}
		}
		return posicion;
	}
	
	/*
	 * retornar la posicion donde esta el estudiante del ID recibido por parametro, 
	 * en caso de no existir retorna -1 
	 * */
	public int buscarPosicionEstudianteXCodigo(String id) {
		int posicion=-1;
		for (int i = 0; i < estudiantes.length&&posicion==-1; i++) {
			if(estudiantes[i]!= null && estudiantes[i].getId().equals(id)) {
				posicion=i;
			}
		}
		return posicion;
	}
	/*
	 * retorna el objeto estudiante de id recibido por parametro, en caso de no existir
	 * retornar�a null
	 * */
	
	public Estudiante buscarEstudiante(String id) {
		Estudiante estAux=null;
		int posicion=buscarPosicionEstudianteXCodigo(id);
		if(posicion!=-1) {
			estAux=estudiantes[posicion];
		}
		return estAux;
	}
	
	/**
	 * metodo que me permite eliminar un estudiante por su id
	 * @param id - id ingresado por el usuario
	 */
	
	public boolean eliminarEstudiante(String id) {
		
		int posicion= buscarPosicionEstudianteXCodigo(id);
		if(posicion!=-1) {
			estudiantes[posicion]=null;
			return false;
		}
		return true;
	}
	
	/**
	 * metodo que me actualiza el nombre de un alumno por su id
	 * @param id - id ingresado por el usuario
	 * @param nombre - nombre ingresado por el usuario a cambiar
	 * @return
	 */
	public boolean actualizarNombreAlumno(String id, String nombre,String apellido,String email ) {
		int posicion= buscarPosicionEstudianteXCodigo(id);
		if(posicion!=-1) {
			estudiantes[posicion].setNombre(nombre);
			estudiantes[posicion].setApellido(apellido);
			estudiantes[posicion].setMail(email);
		
			
			return true;
		}
	
			return false;
	}
	/** 
	 * metodo para validar si esta la vocal en el nombre
	 * @param letra - letra ingresada por el usuario
	 * @return
	 */
	public boolean validarEstudianteTieneVocal(char letra ) {
		boolean existe = false;
	
		for(int i =0; i < estudiantes.length && existe != true ; i++){
		if( estudiantes[i].validarLetraNombre(letra)){
		existe = true;
		}
		}
		return existe;
	}
	
	public Estudiante[] recoggerArregloEstudiante() {
		
		for (int i = 0; i < estudiantes.length; i++) {
			estudiantes[i].getId();
			estudiantes[i].getNombre();
			estudiantes[i].getApellido();
			estudiantes[i].getMail();
			
		}
		return estudiantes;
	}

	

	@Override
	public String toString() {
		return "Colegio [nombre=" + nombre + ", estudiantes=" + Arrays.toString(estudiantes) + ", telefonos="
				+ Arrays.toString(telefonos) + "]";
	}

}
