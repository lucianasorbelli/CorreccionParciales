package col.utn.strategy;

import java.util.Map;

public class TablaDeConversion implements EstrategiaCorreccion {
	Map<Integer, Integer> tabla;

	@Override
	public double notaFinal(double notaParcial) {
		Integer valorEntero = (int) notaParcial;
		return tabla.get(valorEntero).doubleValue();
	}

}
