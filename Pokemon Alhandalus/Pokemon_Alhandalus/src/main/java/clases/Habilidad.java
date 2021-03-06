package clases;

import java.sql.SQLException;

import java.sql.Statement;

import conexionBD.ConexionBD;
/**
 * DAO de la clase Habilidad
 * @author Pablo R
 *
 */
public class Habilidad extends ElementoConNombre {
	private String tipoHabilidad;
	private String nombre;
	private byte ptsAtaque;
	private int id;	
	private int usos;

	/**
	 * Constructor que realiza inserts en la tabla Habilidad
	 * @param nombre
	 * @param tipoHabilidad
	 * @param ptsAtaque
	 * @param usos
	 * @throws SQLException
	 */
	public Habilidad(String nombre, String tipoHabilidad, byte ptsAtaque, int usos) throws SQLException {
		super();
		Statement query=ConexionBD.conectar();

			if (query.executeUpdate("insert into Habilidad(nombre, ptsAtaque, tipoHabilidad, usos) values('" + nombre + "'," +ptsAtaque  + ",'" + tipoHabilidad + "'," + usos +")") > 0) {
				this.nombre=nombre;
				this.ptsAtaque=ptsAtaque;
				this.tipoHabilidad=tipoHabilidad;
				this.usos=usos;
			
			}
			else {
				ConexionBD.desconectar();
				throw new SQLException("No se ha podido insertar");
			}
			ConexionBD.desconectar();
		
		
	};
	
	
/**
 * Un getter de to la vida devuelve la variable que casualmente le da nombre al getter 
 * @return
 */
	public int getUsos() {
		return usos;
	}

/**
 * El setter de toda la vida que lleva el nombre casualmente del par?metro que modifica, adem?s de actualizar la 
 * base de datos, har? lo mismo en las variables
 * @param usos
 * @throws SQLException
 */
	public void setUsos(int usos) throws SQLException {
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update Habilidad set usos="+usos+" where usos="+this.usos+"")>0) {
			this.usos=usos;
			ConexionBD.desconectar();
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se pudo cambiar los usos o ya estaba asiganado ");
		}
	}

	/**
	 * Un getter de to la vida devuelve la variable que casualmente le da nombre al getter 
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}

/**
 * * El setter de toda la vida que lleva el nombre casualmente del par?metro que modifica, adem?s de actualizar la 
	 * base de datos, har? lo mismo en las variables
 * @param nombre
 * @throws SQLException
 */
	public void setNombre(String nombre) throws SQLException {
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update Habilidad set nombre="+nombre+" where nombre="+this.nombre+"")>0) {
			this.nombre=nombre;
			ConexionBD.desconectar();
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se pudo cambiar los nombres o ya estaba asiganado ");
		}
	}

	/**
	 * Un getter de to la vida devuelve la variable que casualmente le da nombre al getter 
	 * @return
	 */
	public int getId() {
		return id;
	}

/**
  * El setter de toda la vida que lleva el nombre casualmente del par?metro que modifica, adem?s de actualizar la 
	 * base de datos, har? lo mismo en las variables 
 * @param id
 * @throws SQLException
 */
	public void setId(int id) throws SQLException {
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update Habilidad set id="+id+" where id="+this.id+"")>0) {
			this.id=id;
			ConexionBD.desconectar();
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se pudo cambiar los ptsAtaque o ya estaba asiganado ");
		}
	}

	/**
	 * Un getter de to la vida devuelve la variable que casualmente le da nombre al getter 
	 * @return
	 */
	public byte getPtsAtaque() {
		return ptsAtaque;
	}
	/**
	  * El setter de toda la vida que lleva el nombre casualmente del par?metro que modifica, adem?s de actualizar la 
	 * base de datos, har? lo mismo en las variables 
	 * @param ptsAtaque
	 * @throws SQLException
	 */
	public void setPtsAtaque(byte ptsAtaque) throws SQLException {
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update Habilidad set ptsAtaque="+ptsAtaque+" where ptsAtaque="+this.ptsAtaque+"")>0) {
			this.ptsAtaque=ptsAtaque;
			ConexionBD.desconectar();
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se pudo cambiar los ptsAtaque o ya estaba asiganado ");
		}
	}
	/**
	 * Un getter de to la vida devuelve la variable que casualmente le da nombre al getter 
	 * @return
	 */
	public String getTipoHabilidad() {
		return tipoHabilidad;
	}
	/**
	  * El setter de toda la vida que lleva el nombre casualmente del par?metro que modifica, adem?s de actualizar la 
	 * base de datos, har? lo mismo en las variables 
	 * @param tipoHabilidad
	 * @throws SQLException
	 */
	public void setTipoHabilidad(String tipoHabilidad) throws SQLException {
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update Habilidad set tipoHabilidad="+tipoHabilidad+" where tipoHabilidad="+this.tipoHabilidad+"")>0) {
			this.tipoHabilidad=tipoHabilidad;
			ConexionBD.desconectar();
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se pudo cambiar el tipoHabilidad o ya estaba asiganado ");
		}
		
	}
	
}
