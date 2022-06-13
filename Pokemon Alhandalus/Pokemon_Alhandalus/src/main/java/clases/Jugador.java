package clases;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexionBD.ConexionBD;
import enums.Genero;
import excepciones.nombreVacio;

public class Jugador extends Entrenador{
private String genero;
	 
	/**
	 *  Constructor que realiza inserts en la tabla Habilidad
	 * @param id
	 * @param nombre
	 * @param monedero
	 * @param aspecto
	 * @param equipoPokemon
	 * @param inventario
	 * @param genero
	 * @throws SQLException
	 * @throws nombreVacio
	 */
 public Jugador(int id,String nombre, int monedero,  String aspecto, ArrayList<Pokemon> equipoPokemon, ArrayList<Objeto> inventario ,String genero) throws SQLException, nombreVacio {
		super(id, nombre, monedero,  aspecto, equipoPokemon, inventario);
		Statement query=ConexionBD.conectar();
		if (query.executeUpdate("insert into Jugador(id_entrenador,nombre, dineroTotal, aspecto, genero) values("+id + ",'"  + nombre + "'," + monedero + ",'" +aspecto + "','" +genero  +"');") > 0) {
			this.genero=genero;
		}
		else {
			ConexionBD.desconectar();
			throw new SQLException("No se ha podido insertar");
		}
		ConexionBD.desconectar();
	}
 
 

/**
 * Constructor que realiza inserts en la tabla Habilidad 
 * @param id
 * @param nombre
 * @param monedero
 * @param aspecto
 * @param genero
 * @throws SQLException
 * @throws nombreVacio
 */
public Jugador(int id,String nombre, int monedero, String aspecto,String genero) throws SQLException, nombreVacio {
	super(nombre, monedero,aspecto);
	Statement query=ConexionBD.conectar();
	if (query.executeUpdate("insert into Jugador(id_entrenador,nombre, dineroTotal, aspecto, genero) values("+id + ",'"  + nombre + "'," + monedero + ",'" +aspecto + "','" +genero  +"');") > 0) {
		this.genero=genero;
	}
	else {
		ConexionBD.desconectar();
		throw new SQLException("No se ha podido insertar");
	}
	ConexionBD.desconectar();
}




/**
 * Un getter de to la vida devuelve la variable que casualmente le da nombre al getter 
 * @return
 */
public String getGenero() {
	return genero;
}

/**
 * El setter de toda la vida que lleva el nombre casualmente del parámetro que modifica, además de actualizar la 
	 * base de datos, hará lo mismo en las variables  
 * @param genero
 * @throws SQLException
 */
public void setGenero(String genero) throws SQLException {
	Statement smt=ConexionBD.conectar();
	if(smt.executeUpdate("Update Jugador set genero="+genero+" where genero="+this.genero+"")>0) {
		this.genero=genero;
		ConexionBD.desconectar();
	}else {
		ConexionBD.desconectar();
		throw new SQLException(" No se pudo cambiar el genero o ya estaba asiganado ");
	}
}



 
}
