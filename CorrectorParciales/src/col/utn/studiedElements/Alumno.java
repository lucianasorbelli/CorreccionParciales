package col.utn.studiedElements;

public class Alumno {
	private Parcial parcial;

	public Alumno(Parcial parc) {
		parcial = parc;
	}

	public void contestarPregunta(Object respuesta, Integer idPregunta) {
		parcial.responderPregunta(idPregunta, respuesta);
	}

	public double notaFinal() {
		return parcial.calificacionParcial();
	}
}
