package co.uniquindio.Colegio;




/**
 * clase encargada de guardar las notas de los estudiantes
 * @author juane
 *
 */
public class Registro {
	
	private double nota1;
	private double nota2;
	private Fecha miFecha;
	
	
public Registro(double nota1, double nota2, Fecha miFecha) {
	super();
	this.nota1 = nota1;
	this.nota2 = nota2;
	this.miFecha = miFecha;
}	

/*public void fijarRegistro(double nota1, double nota2, Fecha miFecha, Estudiante estudiantes[]) {
	int posicion=-1;
	for (int i = 0; i < estudiantes.length; i++) {
		  if(posicion!= -1 ) {
			estudiantes[i].se  
		  }
	}
	
}
*/

public double getNota1() {
	return nota1;
}

public void setNota1(double nota1) {
	this.nota1 = nota1;
}

public double getNota2() {
	return nota2;
}

public void setNota2(double nota2) {
	this.nota2 = nota2;
}

public Fecha getMiFecha() {
	return miFecha;
}

public void setMiFecha(Fecha miFecha) {
	this.miFecha = miFecha;
}



}
