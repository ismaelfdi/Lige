/**
 * 
 */
package lige.grupo03.pr2.logica;

import lige.grupo03.pr2.entradaSalida.UIConsola;
import lige.grupo03.pr2.VerbCommands;

/**
 * @author IsmaelLeonidas
 *
 */
public class Comando implements Command{
	
	private VerbCommands verbo;
	
	public Comando(){
		this.verbo = VerbCommands.DESCONOCIDO;
	}
	
	public Comando(VerbCommands verbo){
		this.verbo = verbo;
	}
	
	public VerbCommands getVerbo() {
		return this.verbo;
	}

	@Override
	public boolean esValido() {
		return !(this.verbo.equals(VerbCommands.DESCONOCIDO));
	}

	@Override
	public void ejecutar() {
		UIConsola.showError("Lo siento, no le he entendido.\n");
	}

}
