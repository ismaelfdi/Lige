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
public class ComandoUsar extends Comando{

	private String id;
	private Game juego;
	
	public ComandoUsar(Game juego, String id){
		super(VerbCommands.USAR);
		this.id = id;
		this.juego = juego;
	}
	
	public VerbCommands getVerbo(){
		return super.getVerbo();
	}
	
	public String getId(){
		return id;
	}

	@Override
	public boolean esValido() {
		return super.esValido() && (!id.equals(""));
	}

	@Override
	public void ejecutar() {
		/*
		Player jugador = juego.getJugador();
		*/
		if(juego.jugadorTieneEnInventario(id)){
			
			Item item = juego.obtenerObjetoJuegador(id);
			if(item.canBeUsed()){
				UIConsola.printText("Puede ser usado");
			}else{
				UIConsola.printText("Error, no puede ser usado");
			}
			
		}else
			UIConsola.showError("Alguien robo tu " + id + ".");
		
	}

}
