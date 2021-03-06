package clases;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexionBD.ConexionBD;
import excepciones.nombreVacio;

/**
 * En esta clase se guardan los datos del Entrenador mediante inserts en la tabla del mismo nombre
 *@param equipoPokemon arrayList que representaria los datos de la tabla Entrenador Pokemon
 *@param inventario ArrayList que representa los datos de la tabla Entrenador Objeto
 *@param int monedero el dinero del entrenador
 *@param String nombre el nombre de entrenador
 *@param id el id del entrenador
 *@author PabloR 
 **/

public class Entrenador extends ElementoConNombre {

	private ArrayList<Pokemon> equipoPokemon=new ArrayList<Pokemon>();
	private ArrayList<Objeto> inventario=new ArrayList<Objeto>();
	private int monedero;
	private String nombre; 
	private int id;
	private String aspecto;
	
	/**
	 * Constructor que recibe por argumentos los datos de la tabla entrenador
	 * @param id
	 * @param nombre
	 * @param monedero
	 * @param aspecto
	 * @param equipoPokemon
	 * @param inventario
	 * @throws SQLException excepcion de sql
	 * @throws nombreVacio excepcion propia
	 */
	public Entrenador(int id,String nombre, int monedero,  String aspecto, ArrayList<Pokemon> equipoPokemon, ArrayList<Objeto> inventario ) throws SQLException, nombreVacio {
		
		super();
		
		if(!nombreValido(nombre)) {
            throw new nombreVacio("El nombre no puede estar vacio");
        }
		
		Statement query=ConexionBD.conectar();
		if (query.executeUpdate("insert into Entrenador(nombre, dineroTotal, aspecto) values("+ nombre + "','" + monedero + "','" + aspecto +");") > 0) {

			this.id=id;
			this.nombre=nombre;
			this.monedero=monedero;
			this.aspecto=aspecto;
			
		}
		else {
			ConexionBD.desconectar();
			throw new SQLException("No se ha podido insertar");
		}
		ConexionBD.desconectar();
		System.out.println("Desconectado");
	}
	

	/**
	 * Segundo constructor, tiene menos parámetros pero el objetivo es el mismo quel primero, insertar
	 * @param nombre
	 * @param monedero
	 * @param aspecto
	 * @throws SQLException
	 * @throws nombreVacio
	 */
	public Entrenador(String nombre, int monedero,  String aspecto) throws SQLException, nombreVacio {
		super();
		
		if(!nombreValido(nombre)) {
            throw new nombreVacio("El nombre no puede estar vacio");
        }
		
		Statement query=ConexionBD.conectar();
		if (query.executeUpdate("insert into Entrenador(nombre, dineroTotal, aspecto) values('"+ nombre + "'," + monedero + ",'" + aspecto +"');") > 0) {
			this.nombre=nombre;
			this.monedero=monedero;
			this.aspecto=aspecto;
			
		}
		else {
			ConexionBD.desconectar();
			throw new SQLException("No se ha podido insertar");
		}
		ConexionBD.desconectar();
		System.out.println("Desconectado");
	}
	
	/**
	 * Un getter de to la vida devuelve la variable que casualmente le da nombre al getter
	 * @return equipoPokemon
	 */
	public ArrayList<Pokemon> getEquipoPokemon() {
		return equipoPokemon;
	}

	/***
	 * El setter de toda la vida que lleva el nombre casualmente del parámetro que modifica, además de actualizar la 
	 * base de datos, hará lo mismo en las variables
	 * @param equipoPokemon
	 * @throws SQLException
	 */
	public void setEquipoPokemon(ArrayList<Pokemon> equipoPokemon) throws SQLException {
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update Entrenador set equipoPokemon="+equipoPokemon+" where equipoPokemon="+this.equipoPokemon+"")>0) {
			this.equipoPokemon=equipoPokemon;
			ConexionBD.desconectar();
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se pudo cambiar los equipoPokemon o ya estaba asiganado ");
		}
	}

	/**
	 * Un getter de to la vida devuelve la variable que casualmente le da nombre al getter
	 * @return inventario
	 */
	public ArrayList<Objeto> getInventario() {
		return inventario;
	}

	/**
	 * El setter de toda la vida que lleva el nombre casualmente del parámetro que modifica, además de actualizar la 
	 * base de datos, hará lo mismo en las variables
	 * @param inventario
	 * @throws SQLException
	 */
	public void setInventario(ArrayList<Objeto> inventario) throws SQLException {
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update Entrenador set inventario="+inventario+" where inventario="+this.inventario+"")>0) {
			this.inventario=inventario;
			ConexionBD.desconectar();
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se pudo cambiar los inventarios o ya estaba asiganado ");
		}
	}

	/**
	 * Un getter de to la vida devuelve la variable que casualmente le da nombre al getter
	 * @return monedero 
	 */
	public int getMonedero() {
		return monedero;
	}

	/**
	 * El setter de toda la vida que lleva el nombre casualmente del parámetro que modifica, además de actualizar la 
	 * base de datos, hará lo mismo en las variables
	 * @param monedero
	 * @throws SQLException
	 */
	public void setMonedero(int monedero) throws SQLException {
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update Entrenador set monedero="+monedero+" where monedero="+this.monedero+"")>0) {
			this.monedero=monedero;
			ConexionBD.desconectar();
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se pudo cambiar el monedero o ya estaba asiganado ");
		}
	}


	/**
	 * Un getter de to la vida devuelve la variable que casualmente le da nombre al getter
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

/**
 	 * El setter de toda la vida que lleva el nombre casualmente del parámetro que modifica, además de actualizar la 
	 * base de datos, hará lo mismo en las variables
 * @param nombre
 * @throws SQLException
 * @throws nombreVacio
 */
	public void setNombre(String nombre) throws SQLException, nombreVacio {
		if(!nombreValido(nombre)) {
            throw new nombreVacio("El nombre no puede estar vacio");
        }
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update Entrenador set nombre="+nombre+" where nombre="+this.nombre+"")>0) {
			this.nombre=nombre;
			ConexionBD.desconectar();
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se pudo cambiar el nombre o ya estaba asiganado ");
		}
	}


	/**
	 * Un getter de to la vida devuelve la variable que casualmente le da nombre al getter
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * El setter de toda la vida que lleva el nombre casualmente del parámetro que modifica, además de actualizar la 
	 * base de datos, hará lo mismo en las variables
	 * @param id
	 * @throws SQLException
	 */
	public void setId(int id) throws SQLException {
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update Entrenador set id="+id+" where id="+this.id+"")>0) {
			this.id=id;
			ConexionBD.desconectar();
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se pudo cambiar el id o ya estaba asiganado ");
		}
	}


	/**
	 * Un getter de to la vida devuelve la variable que casualmente le da nombre al getter
	 * @return aspecto
	 */
	public String getAspecto() {
		return aspecto;
	}

	/**
	  * El setter de toda la vida que lleva el nombre casualmente del parámetro que modifica, además de actualizar la 
	 * base de datos, hará lo mismo en las variables
	 * @param aspecto
	 * @throws SQLException
	 */
	public void setAspecto(String aspecto) throws SQLException {
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update Entrenador set aspecto="+aspecto+" where aspecto="+this.aspecto+"")>0) {
			this.aspecto=aspecto;
			ConexionBD.desconectar();
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se pudo cambiar el aspecto o ya estaba asiganado ");
		}
	}
	
	/**
	 * La función que define la causa del throw de la excepción, esta ocurrira cuando el nombre este en blanco
	 * @param String nombre
	 * @return
	 */
	protected static boolean nombreValido(String nombre) {
		return !nombre.isBlank();
	}
	
	
}
