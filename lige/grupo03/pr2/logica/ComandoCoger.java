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
public class ComandoCoger extends Comando{

	private String id;
	private Game juego;

	public ComandoCoger(Game juego, String id){
		super(VerbCommands.COGER);
		this.id = id;
		this.juego = juego;
	}

	public VerbCommands getVerbo(){
		return super.getVerbo();
	}
	
	public String getId(){
		return id;
	}
	
	public boolean esValido() {
		return super.esValido() && (!id.equals(""));
	}

	public void ejecutar() {
		/*
		Room habitacionActual = juego.getHabitacionActual();
		Player jugador = juego.getJugador();
		*/
		if(juego.habitacionActualEstaObjeto(id)){
			if(!juego.jugadorTieneEnInventario(id)){
				Item item = juego.cogerObjetoHabitacion(id);
				juego.agregaObjetoAJugador(item);
			}else{
				UIConsola.showError("Ya tienes otro " + id + " en tu inventario.");
			}
		}else{
			UIConsola.showError("El objeto " + id + " no está en esta habitación.");
		}
			
	}

}
