package clases;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexionBD.ConexionBD;
import excepciones.nombreVacio;

/**
 * DAO de la clase LiderGymnasio
 * @author Pablo R
 *
 */
public class LiderGymnasio extends Entrenador {

	private String medalla;
	/**
	 * Constructor que realiza inserts en la tabla Habilidad 
	 * @param id
	 * @param nombre
	 * @param monedero
	 * @param aspecto
	 * @param equipoPokemon
	 * @param inventario
	 * @param medalla
	 * @throws SQLException
	 * @throws nombreVacio
	 */
	public LiderGymnasio(int id, String nombre, short monedero, String aspecto, ArrayList<Pokemon> equipoPokemon, ArrayList<Objeto> inventario,String medalla) throws SQLException, nombreVacio {
		super(id, nombre, monedero, aspecto, equipoPokemon, inventario);
		Statement query=ConexionBD.conectar();
		if (query.executeUpdate("insert into LiderGymnasio values(" + id + "','" + nombre + "','" + monedero + "','" + aspecto + "','" +medalla+")") > 0) {

			this.medalla=medalla;
		}
		else {
			ConexionBD.desconectar();
			throw new SQLException("No se ha podido insertar");
		}
		ConexionBD.desconectar();
		
	}

	public String getMedalla() {
		return medalla;
	}

	public void setMedalla(String medalla) throws SQLException {
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update LiderGymnasio set medalla="+medalla+" where medalla="+this.medalla+"")>0) {
			this.medalla=medalla;
			ConexionBD.desconectar();
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se pudo cambiar el aspecto o ya estaba asiganado ");
		}
	}

	
	
}
