/**
 * 
 */
package lige.grupo03.pr2.logica;

import lige.grupo03.pr2.VerbCommands;

/**
 * Clase que representa un Comando EXAMINAR
 * 
 * @author Ismael Ventura & Ignacio Lopez
 * @version 2.0
 */
public class ComandoExaminar extends Comando{
	
	/*Atributo que contiene el juego en ejecuci�n*/
	private Game juego;

	/**
	 * Constructor parametrizado del Comando EXAMINAR
	 * 
	 * @param juego Representa el juego que esta en ejecuci�n
	 */
	public ComandoExaminar(Game juego){
		super(VerbCommands.EXAMINAR);
		this.juego = juego;
	}

	/**
	 * Procedimiento especifico del Comando EXAMINAR
	 * 
	 * @return in valor de retorno
	 */
	@Override
	public void ejecutar() {
		juego.mostrarInventarioHabitacion();
	}


}
