/**
 * 
 */
package lige.grupo03.pr2.logica;
import lige.grupo03.pr2.VerbCommands;

/**
 * Clase que representa un Comando COGER
 * 
 * @author Ismael Ventura & Ignacio Lopez
 * @version 2.0
 */
public class ComandoCoger extends Comando{
	
	/*Atributo que almacena el id del Objeto a coger*/
	private String id;
	
	/*Atributo que contiene el juego en ejecucion*/
	private Game juego;

	/**
	 * Constructor parametrizado del Comando COGER
	 * 
	 * @param juego Es el juego que esta en ejecución
	 * @param id Identificador del Item a coger.
	 */
	public ComandoCoger(Game juego, String id){
		super(VerbCommands.COGER);
		this.id = id;
		this.juego = juego;
	}
	
	/**
	 * Metodo sobrecargado que determina si el Comando es valido
	 * 
	 * @return Booleano verdadero o falso segun sea el caso
	 */
	@Override
	public boolean esValido() {
		return super.esValido() && (!id.equals(""));
	}
	
	/**
	 * Procedimiento especifico del Comando Coger, que ejecuta la accion de coger un id
	 * 
	 * @return Sin valor de retorno
	 */
	@Override
	public void ejecutar() {
		juego.cogerId(id);	
	}

}
