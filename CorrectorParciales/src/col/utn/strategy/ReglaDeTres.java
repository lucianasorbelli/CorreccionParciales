package col.utn.strategy;

public class ReglaDeTres implements EstrategiaCorreccion {

	private int total;

	@Override
	public double notaFinal(double notaParcial) {
		return notaParcial * 10 / total;
	}

}
