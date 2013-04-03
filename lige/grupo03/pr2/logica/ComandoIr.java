/**
 * 
 */
package lige.grupo03.pr2.logica;

import lige.grupo03.pr2.Directions;
import lige.grupo03.pr2.VerbCommands;

/**
 * @author IsmaelLeonidas
 *
 */
public class ComandoIr extends Comando{
	private Directions direccion;
	private Game juego;
	/*
	public ComandoIr(VerbCommands verbo, Directions direccion){
		super(verbo);
		this.direccion = direccion;
	}
	*/
	public ComandoIr(Game juego, VerbCommands verbo, Directions direccion){
		super(verbo);
		this.direccion = direccion;
		this.juego = juego;
	}
	
	public VerbCommands getVerbo(){
		return super.getVerbo();
	}
	
	public Directions getDireccion(){
		return direccion;
	}
	
	public Game getJuego(){
		return this.juego;
	}

	@Override
	public boolean esValido() {
		return super.esValido() && !(direccion.equals(Directions.DESCONOCIDO));
	}

	
	public void ejecutar() {
		juego.cambiarHabitacion(direccion);
	}

}
