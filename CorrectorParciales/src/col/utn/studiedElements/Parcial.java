package col.utn.studiedElements;

import java.util.ArrayList;
import java.util.List;

import col.utn.strategy.EstrategiaCorreccion;

public class Parcial {
	private List<Pregunta> preguntas;
	private EstrategiaCorreccion criterioCorreccion;
	private List<Object> respuestas = new ArrayList<>();

	public Parcial(EstrategiaCorreccion est, List<Pregunta> pregs) {
		preguntas = pregs;
		criterioCorreccion = est;
	}

	public void responderPregunta(Integer id, Object respuesta) {
		respuestas.add(id, respuesta);
	}

	public double calificacionParcial() {

		return criterioCorreccion.notaFinal(notaAcumulativaParcial());
	}

	public double sumarPuntos(List<Pregunta> pregs) {
		return pregs.stream().mapToDouble(p -> p.pesoEspecifico).max()
				.getAsDouble();
	}

	public double totalPuntosParcial() {
		return sumarPuntos(preguntas);
	}

	public double notaAcumulativaParcial() {
		return sumarPuntos(preguntasCorrectas());
	}

	public List<Pregunta> preguntasCorrectas() {
		List<Pregunta> preguntasCorrectas = new ArrayList<Pregunta>();
		for (int i = 0; i < preguntas.size(); i++) {
			Pregunta preg = preguntas.get(i);
			if (preg.esCorrecta(respuestas.get(i))) {
				preguntasCorrectas.add(preg);
			}

		}
		return preguntasCorrectas;
	}
}
