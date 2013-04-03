/**
 * 
 */
package lige.grupo03.pr2.logica;

import lige.grupo03.pr2.VerbCommands;
import lige.grupo03.pr2.entradaSalida.UIConsola;

/**
 * @author IsmaelLeonidas
 *
 */
public class ComandoAyuda extends Comando{
	
	public ComandoAyuda(VerbCommands verbo){
		super(verbo);
	}
	
	public VerbCommands getVerbo(){
		return super.getVerbo();
	}

	public void ejecutar() {
		UIConsola.printText(Parser.mensajeAyuda());
	}

}
