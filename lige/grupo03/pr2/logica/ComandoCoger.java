/**
 * 
 */
package lige.grupo03.pr2.logica;
import lige.grupo03.pr2.VerbCommands;

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
		juego.cogerId(id);	
	}

}
