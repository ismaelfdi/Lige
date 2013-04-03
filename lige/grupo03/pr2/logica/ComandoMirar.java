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
public class ComandoMirar extends Comando{

	private String id;
	private Game juego;
	
	public ComandoMirar(Game juego, VerbCommands verbo){
		super(verbo);
		this.id = "";
		this.juego = juego;
	}
	
	public ComandoMirar(Game juego, VerbCommands verbo, String id){
		super(verbo);
		this.id = id;
		this.juego = juego;
	}
	
	public VerbCommands getVerbo(){
		return super.getVerbo();
	}
	
	public String getId(){
		return id;
	}
	
	public void ejecutar(){
		if(id.equals(""))
			UIConsola.printText(juego.mostrarInventarioJugador());
		else
			UIConsola.printText(juego.mostrarItemJugador(id));
	}

}
