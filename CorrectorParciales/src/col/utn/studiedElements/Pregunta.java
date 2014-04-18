package col.utn.studiedElements;

public class Pregunta {
	private Object respuesta;
	public String pregunta;
	public double pesoEspecifico;
	
	public Pregunta(Object resp,String preg, double peso){
		respuesta=resp;
		pregunta=preg;
		pesoEspecifico=peso;
	}
	
	public Boolean esCorrecta(Object respuesta){
		return this.respuesta==respuesta || this.respuesta.equals(respuesta) ;
	}
	
	
}
