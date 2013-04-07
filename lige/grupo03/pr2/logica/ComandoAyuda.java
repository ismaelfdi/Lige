/**
 * 
 */
package lige.grupo03.pr2.logica;

import lige.grupo03.pr2.VerbCommands;
import lige.grupo03.pr2.entradaSalida.UIConsola;

/**
 * Clase que representa un Comando AYUDA
 * 
 * @author IsmaelLeonidas
 * @version 2.0
 */
public class ComandoAyuda extends Comando{
	
	/**
	 * Constructor por defecto, construye un objeto Comando del tipo AYUDA
	 */
	public ComandoAyuda(){
		super(VerbCommands.AYUDA);
	}
	
	/**
	 * Procedimiento especifico del Comando Ayuda, que muestra por pantalla la 
	 * informacion de ayuda al usuario
	 * 
	 * @return Sin valor de retorno
	 */
	@Override
	public void ejecutar() {
		UIConsola.printText(Parser.mensajeAyuda());
	}

}
