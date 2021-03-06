package clases;

import java.sql.SQLException;
import java.sql.Statement;

import conexionBD.ConexionBD;

/***
 * DAO DE Objeto Contiene sus mismas variables
 * @author Pablo R
 *
 */
public class Objeto extends ElementoConNombre{
 
	private int id;
	private String nombre;
	private String tipoObjeto;
	
	/**
	 * Constructor que realiza inserts en la tabla Objeto
	 * @param id
	 * @param nombre
	 * @param tipoObjeto
	 * @throws SQLException
	 */
	public Objeto(int id, String nombre, String tipoObjeto) throws SQLException {
		super();
		Statement query=ConexionBD.conectar();
		if (query.executeUpdate("insert into objeto values(" + id + "','" + nombre + "','" + tipoObjeto  +")") > 0) {

			this.id=id;
			this.nombre=nombre;
			this.tipoObjeto=tipoObjeto;		
		}
		else {
			ConexionBD.desconectar();
			throw new SQLException("No se ha podido insertar");
		}
		ConexionBD.desconectar();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) throws SQLException {
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update Objeto set id="+id+" where id="+this.id+"")>0) {
			this.id=id;
			ConexionBD.desconectar();
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se pudo cambiar los equipoPokemon o ya estaba asiganado ");
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws SQLException {
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update Objeto set nombre="+nombre+" where nombre="+this.nombre+"")>0) {
			this.nombre=nombre;
			ConexionBD.desconectar();
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se pudo cambiar los equipoPokemon o ya estaba asiganado ");
		}
	}

	public String getTipoObjeto() {
		return tipoObjeto;
	}

	public void setTipoObjeto(String tipoObjeto) throws SQLException {
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update Objeto set tipoObjeto="+tipoObjeto+" where tipoObjeto="+this.tipoObjeto+"")>0) {
			this.tipoObjeto=tipoObjeto;
			ConexionBD.desconectar();
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se pudo cambiar los equipoPokemon o ya estaba asiganado ");
		}
	}
	
}
