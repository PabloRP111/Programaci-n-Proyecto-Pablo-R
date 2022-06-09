package clases;

import java.util.ArrayList;

import enums.TipoPokemon;

public class Pokemon extends ElementoConNombre{

	private byte nivel;
	private byte puntosDeExperiencia;
	private ArrayList<Habilidad> habilidades = new ArrayList<Habilidad>();
	private TipoPokemon tipo;
	private String razaPokemon;
}
