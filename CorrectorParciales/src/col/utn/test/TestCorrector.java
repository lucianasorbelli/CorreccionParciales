package col.utn.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import col.utn.strategy.CorreccionPorN;
import col.utn.strategy.CriteriosMasAlta;
import col.utn.strategy.CriteriosPromedio;
import col.utn.strategy.EstrategiaCorreccion;
import col.utn.strategy.ReglaDeTres;
import col.utn.strategy.TablaDeConversion;
import col.utn.studiedElements.Alumno;
import col.utn.studiedElements.Parcial;
import col.utn.studiedElements.Pregunta;

public class TestCorrector {

	private EstrategiaCorreccion est1, est2, est3, est4, est5;
	private Alumno alumno;
	private Pregunta preg1, preg2, preg3;
	private Parcial par;
	private List<Pregunta> pregs = new ArrayList<>();
	private List<EstrategiaCorreccion> ests = new ArrayList<>();

	@Before
	public void setup() {
		preg1 = new Pregunta("futurama", "bender?", 4);
		preg2 = new Pregunta(
				Boolean.TRUE,
				"tengo tu nariz..¿y yo tu billetera?",
				5);
		preg3 = new Pregunta(4, "pregunta de opciones", 1);

		pregs.add(preg1);
		pregs.add(preg2);
		pregs.add(preg3);
		est1 = new CorreccionPorN(1);
		est2 = new ReglaDeTres(10);
		Map<Integer, Integer> a = new HashMap<Integer, Integer>();
		for (int i = 0; i < 11; i++) {
			a.put(i, i);
		}
		est3 = new TablaDeConversion(a);
		ests.add(est1);
		ests.add(est2);
		ests.add(est3);
		est4 = new CriteriosMasAlta(ests.stream());
		est5 = new CriteriosPromedio(ests.stream());
		par = new Parcial(est5, pregs);
		alumno = new Alumno(par);
		alumno.contestarPregunta("futurama", 0);
		alumno.contestarPregunta("futurama", 1);
		alumno.contestarPregunta("futurama", 2);
		

	}

	@Test
	public void preguntas() {
		Assert.assertTrue(preg1.esCorrecta("futurama"));
		Assert.assertTrue(preg2.esCorrecta(Boolean.TRUE));
		Assert.assertTrue(preg3.esCorrecta(4));
		Assert.assertFalse(preg1.esCorrecta(1));
	}

	@Test
	public void estrategias() {
		Assert.assertEquals("Esta mal", 3d, est1.notaFinal(4d), 0);
		Assert.assertEquals("Esta mal", 4d, est2.notaFinal(4d), 0);
		Assert.assertEquals("Esta mal", 4d, est3.notaFinal(4d), 0);
		Assert.assertEquals("Esta mal", 4d, est4.notaFinal(4d), 0);
		Assert.assertEquals("Esta mal", 4d, est5.notaFinal(4d), 0.5);

	}

	@Test
	public void parcial() {
		Assert.assertEquals("Esta mal", 4d, par.calificacionParcial(), 0.5);

	}

	@Test
	public void alumno() {
		Assert.assertEquals("Esta mal", 4d, alumno.notaFinal(), 0.5);
	}
}
