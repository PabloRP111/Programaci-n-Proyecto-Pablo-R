package clases;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexionBD.ConexionBD;

public class Pokemon extends ElementoConNombre{
	
	private int id;
	private String nombre;
	private byte nivel;
	private byte ptsExperiencia;
	private ArrayList<Habilidad> habilidades = new ArrayList<Habilidad>();
	private String tipo;
	private String raza;
	private byte vida;
	
	public Pokemon(int id,String nombre, byte ptsExperiencia, byte nivel, String raza, String tipo, byte vida, ArrayList<Habilidad> habilidades) throws SQLException{
		super();
		//Implementar inserts para los arrays
		Statement query=ConexionBD.conectar();

			if (query.executeUpdate("insert into Pokemon values(" + id + "','" + nombre + "','" + ptsExperiencia + "','" + nivel + "',"
					+ nivel+ "','"+raza +"','"+tipo +"','"+vida +")") > 0) {
				this.id=id;
				this.nombre=nombre;
				this.nivel=nivel;
				this.ptsExperiencia=ptsExperiencia;
				this.tipo=tipo;
				this.raza=raza;
				this.vida=vida;
			
			}
			else {
				ConexionBD.desconectar();
				throw new SQLException("No se ha podido insertar");
			}
			ConexionBD.desconectar();
		
		}
	
	
	public Pokemon(String nombre, int puntosEXP, int nivel, String raza, String tipoPokemon, int vida) throws SQLException {
		super();
		//Implementar inserts para los arrays
		Statement query=ConexionBD.conectar();

			if (query.executeUpdate("insert into Pokemon(nombre, puntosExp, nivel, raza, tipoPokemon, vida) values('" +  nombre + "'," + ptsExperiencia +  ","+ nivel + ",'"+raza +"','"+tipo +"',"+vida +")") > 0) {
				
				this.nombre=nombre;
				this.nivel=(byte) nivel;
				this.ptsExperiencia=ptsExperiencia;
				this.tipo=tipo;
				this.raza=raza;
				this.vida=(byte) vida;
			
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
		if(smt.executeUpdate("Update Pokemon set id="+id+" where id="+this.id+"")>0) {
			this.id=id;
			ConexionBD.desconectar();
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se pudo cambiar el id o ya estaba asiganado ");
		}
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) throws SQLException {
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update Pokemon set nombre="+nombre+" where id="+this.nombre+"")>0) {
			this.nombre=nombre;
			ConexionBD.desconectar();
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se pudo cambiar el nombre o ya estaba asiganado ");
		}
	}




	public byte getPtsExperiencia() {
		return ptsExperiencia;
	}




	public void setPtsExperiencia(byte ptsExperiencia) throws SQLException {
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update Pokemon set ptsExperiencia="+ptsExperiencia+" where ptsExperiencia="+this.ptsExperiencia+"")>0) {
			this.ptsExperiencia=ptsExperiencia;
			ConexionBD.desconectar();
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se pudo cambiar los puntos de experiencia o ya estaba asiganado ");
		}
	}




	public byte getNivel() {
		return nivel;
	}

	public void setNivel(byte nivel) throws SQLException {
		
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("update pokemon set nivel="
		+nivel+" where id='"+this.nivel+"'")>0) {
			
			this.nivel = nivel;
		}else {
			ConexionBD.desconectar();
			throw new SQLException("No se ha podido cambiar el nivel");
		}
		ConexionBD.desconectar();
	}
	


	public ArrayList<Habilidad> getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(ArrayList<Habilidad> habilidades) throws SQLException {
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update Pokemon set habilidad="+habilidades+" where habilidades="+this.habilidades+"")>0) {
			this.habilidades=habilidades;
			ConexionBD.desconectar();
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se pudo cambiar las habilidades o ya estaba asiganado ");
		}
	
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) throws SQLException {
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update Pokemon set tipoPokemon="+tipo+" where tipo="+this.tipo+"")>0) {
			this.tipo=tipo;
			ConexionBD.desconectar();
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se pudo cambiar los tipo o ya estaba asiganado ");
		}
	}

	public String getRazaPokemon() {
		return raza;
	}

	public void setRazaPokemon(String raza) throws SQLException {
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update Pokemon set razaPokemon="+raza+" where tipo="+this.raza+"")>0) {
			this.raza=raza;
			ConexionBD.desconectar();
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se pudo cambiar la razaPokemon o ya estaba asiganado ");
		}
		
	}
	
	
}
