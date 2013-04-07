/**
 * 
 */
package lige.grupo03.pr2.logica;

import lige.grupo03.pr2.VerbCommands;

/**
* Interface que implementa los distintos comandos a utilizar en el juego
*
* @author Ismael Ventura & Ignacio Lopez
* @version 2.0
*/
public interface Command {
	
	/**
	 * Indica si el comando es valido
	 * 
	 * @return True o false segun sea el caso
	 */
	boolean esValido();
	
	/**
	 * Realizar funciones especificas de cada comando
	 * 
	 * @return Sin valor de retorno
	 */
	void ejecutar();
	
	/**
	 * Devuelve el atributo verbo del comando especifico
	 * 
	 * @return VerbCommands que indica el tipo de comando
	 */
	VerbCommands getVerbo();
}
