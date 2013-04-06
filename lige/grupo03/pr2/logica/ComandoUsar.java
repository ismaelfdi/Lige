/**
 * 
 */
package lige.grupo03.pr2.logica;

import lige.grupo03.pr2.VerbCommands;

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
		juego.usarObjeto(id);
	}

}
