package col.utn.strategy;

import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class CriteriosPromedio implements EstrategiaCorreccion {

	private Stream<EstrategiaCorreccion> criterios;

	public CriteriosPromedio(Stream<EstrategiaCorreccion> est) {
		criterios = est;
	}

	@Override
	public double notaFinal(double notaParcial) {
		return notasCriterios(notaParcial).average().getAsDouble();
	}

	private DoubleStream notasCriterios(double notaParcial) {
		return criterios.map(criterio -> criterio.notaFinal(notaParcial))
				.mapToDouble(Double::doubleValue);
	}

}
