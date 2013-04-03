/**
 * 
 */
package lige.grupo03.pr2.logica;

import lige.grupo03.pr2.VerbCommands;

/**
@author Ismael Ventura

*/
public interface Command {
	boolean esValido();
	void ejecutar();
	VerbCommands getVerbo();
}
