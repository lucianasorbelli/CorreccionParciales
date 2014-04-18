package col.utn.strategy;

public class CorreccionPorN implements EstrategiaCorreccion {
	private int n;

	public CorreccionPorN(int n) {
		this.n = n;
	}

	@Override
	public double notaFinal(double notaParcial) {
		return notaParcial - n;
	}

}
