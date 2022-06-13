package excepciones;

/**
 * Excepción que verifica quel nombre no este vacio
 * @author asrau
 *
 */
public class nombreVacio extends Exception {

	public nombreVacio(String msg) {
		super(msg);
	}
	
}
