package clases;

import java.sql.SQLException;
import java.sql.Statement;

import conexionBD.ConexionBD;

public class ObjetoCuración extends Objeto {

	private byte vidaCurada;

	public ObjetoCuración(int id, String nombre, String tipoObjeto, byte vidaCurada) throws SQLException {
		super(id, nombre, tipoObjeto);
	
		Statement query=ConexionBD.conectar();
		if (query.executeUpdate("insert into objetoCuracion values(" + id + "','" + nombre + "','" + tipoObjeto + "','" +vidaCurada  +")") > 0) {

			this.vidaCurada=vidaCurada;	
		}
		else {
			ConexionBD.desconectar();
			throw new SQLException("No se ha podido insertar");
		}
		ConexionBD.desconectar();
	
		
	}

	public byte getVidaCurada() {
		return vidaCurada;
	}

	public void setVidaCurada(byte vidaCurada) throws SQLException {
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update objetoCuracion set vidaCurada="+vidaCurada+" where vidaCurada="+this.vidaCurada+"")>0) {
			this.vidaCurada=vidaCurada;
			ConexionBD.desconectar();
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se pudo cambiar los equipoPokemon o ya estaba asiganado ");
		}
	}

  
  
}
