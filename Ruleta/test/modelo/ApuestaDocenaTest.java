package modelo;

import org.junit.Assert;
import org.junit.Test;


public class ApuestaDocenaTest {

	@Test
	public void gano_salio25YAposteTerceraDocenaYGane() {
		ApuestaDocena apuesta = new ApuestaDocena();
		boolean gano = apuesta.gano(25, "Tercera");
		Assert.assertTrue("Deberia haber ganado", gano);
	}
	
	@Test
	public void gano_salio26YAposteTerceraDocenaYGane() {
		ApuestaDocena apuesta = new ApuestaDocena();
		boolean gano = apuesta.gano(26, "Tercera");
		Assert.assertTrue("Deberia haber ganado", gano);
	}
	
	@Test
	public void gano_salio36YAposteTerceraDocenaYGane() {
		ApuestaDocena apuesta = new ApuestaDocena();
		boolean gano = apuesta.gano(36, "Tercera");
		Assert.assertTrue("Deberia haber ganado", gano);
	}
	
	@Test
	public void gano_salio1YApostePrimeraDocenaYGane() {
		ApuestaDocena apuesta = new ApuestaDocena();
		boolean gano = apuesta.gano(1, "Primera");
		Assert.assertTrue("Deberia haber ganado", gano);
	}
}
