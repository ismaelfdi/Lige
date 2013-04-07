/**
 * 
 */
package lige.grupo03.pr2.logica;

import lige.grupo03.pr2.VerbCommands;

/**
 * @author IsmaelLeonidas
 *
 */
public class ComandoExaminar extends Comando{
	
	private Game juego;
	/*
	public ComandoExaminar(VerbCommands verbo){
		super(verbo);
	}	
	*/
	public ComandoExaminar(Game juego){
		super(VerbCommands.EXAMINAR);
		this.juego = juego;
	}
	
	public VerbCommands getVerbo(){
		return super.getVerbo();
	}

	@Override
	public void ejecutar() {
		juego.mostrarInventarioHabitacion();
	}


}
