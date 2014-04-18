package col.utn.strategy;

import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class CriteriosMasAlta implements EstrategiaCorreccion{
	private Stream<EstrategiaCorreccion> criterios;

	@Override
	public double notaFinal(double notaParcial) {
		return notasCriterios(notaParcial).max().getAsDouble();
	}
	
	
	private DoubleStream notasCriterios(double notaParcial){
		return criterios.map(criterio -> criterio.notaFinal(notaParcial)).mapToDouble(Double::doubleValue);
	}
}
