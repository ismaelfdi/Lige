package lige.grupo03.pr2.logica;

import lige.grupo03.pr2.VerbCommands;

/**
 * Clase que representa un Comando MIRAR, que puede ser:
 * 		<ul>
 * 			<li>MIRAR</li>
 * 			<li>MIRAR id</li>
 * 		</ul>
 * 
 * @author Ismael Ventura & Ignacio Lopez
 * @version 2.0
 */
public class ComandoMirar extends Comando{

	/*Atributo que puede ser una String vacio o el id del Item a Mirar*/
	private String id;
	/*Atributo que representa el juego en ejecucion*/
	private Game juego;
	
	/**
	 * Constructor con un parametro, cuando el comando es: <b>MIRAR</b>
	 * 
	 * @param juego Game que representa el juego que esta en ejecución
	 */
	public ComandoMirar(Game juego){
		super(VerbCommands.MIRAR);
		this.id = "";
		this.juego = juego;
	}
	
	/**
	 * Constructor con dos parametros, cuando el comando es: <b>MIRAR id</b>
	 * 
	 * @param juego Game que representa el juego que esta en ejecución
	 * @param id String con el identificador del Item a Mirar
	 */
	public ComandoMirar(Game juego, String id){
		super(VerbCommands.MIRAR);
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
	 * Procedimiento especifico del Comando Mirar
	 * 
	 * @return Sin valor de retorno
	 */
	@Override
	public void ejecutar(){
		juego.mirarId(id);
	}

}
