package excepciones;

/***
 * Excepción que verifica que la casilla noAbogado no este desmarcada
 * @author PabloR
 *
 */
public class casillaDesmarcada extends Exception{

	public casillaDesmarcada(String msg){
		super(msg);
	}
}
