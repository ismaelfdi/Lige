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
public class ComandoSalir extends Comando{
	
	private Game juego;
	
	public ComandoSalir(Game juego){
		super(VerbCommands.SALIR);
		this.juego = juego;
	}
	
	public VerbCommands getVerbo(){
		return super.getVerbo();
	}

	public void ejecutar() {
		UIConsola.printText("GAME OVER!!\nGracias por jugar.\n");
		UIConsola.printText(juego.mostrarPuntuacionJugador());
	}

}
