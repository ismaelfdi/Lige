package lige.grupo03.pr2.logica;

import lige.grupo03.pr2.Directions;
import lige.grupo03.pr2.VerbCommands;
import lige.grupo03.pr2.entradaSalida.UIConsola;
import lige.grupo03.pr2.jugador.Player;

/**
Clase que representa el juego 
@author Ignacio Lopez
@version 1.0 
*/
public class Game {
	/*Atributo que almacena las puertas*/
	private Map puertas;
	/*Atributo que representa la habitacion actual*/
	private Room habitacionActual;
	private Player jugador;
	/**
	Constructor por defecto
	*/
	public Game(){
		puertas = new Map();
		habitacionActual = new Room();
		jugador = new Player();
	}
	
	/**
	Constructor con dos parametros
	@param puertas contiene el vector de puertas
	@param habitacionActual contiene la habitación actual
	*/
	public Game(Map puertas, Room habitacionActual){
		this.puertas = puertas;
		this.habitacionActual = habitacionActual;
		this.jugador = new Player();
	}

	/**
	 * Muestra el inventario de la habitacion actual
	 * 
	 * @return Sin valor de retorno
	 */
	public void mostrarInventarioHabitacion(){
		UIConsola.printText(habitacionActual.mostrarInventario());
	}

	/**
	 * Utiliza el objeto con identificador id del inventario del jugador
	 * 
	 * @param id String que representa el identificador del Objeto a usar
	 * @return Sin valor de retorno
	 */
	public void usarObjeto(String id){
		if(jugador.tieneEnInventario(id)){
			Item item = jugador.obtenerObjeto(id);
			
			if(item.use(jugador, habitacionActual)){
				UIConsola.printText("Algo ha cambiado...");
				if(!item.canBeUsed()){
					jugador.borrarItem(id);
					UIConsola.printText("\n" + item.getId() + " ha sido borrado de tu inventario.\n");
					UIConsola.printText(jugador.mostrarPuntuacion());
				}
			}
			else
				UIConsola.printText("Como no fuiste a clase de LIGe la semana pasada no " +
									"sabes cómo usar los objetos de forma adecuada...");
			
		}else
			UIConsola.showError("Alguien robo tu " + id + ".");
	}
	
	/**
	 * Metodo que realiza la funcion de coger un id de la habitacion
	 * @param id String que representa el identificador del Item a coger
	 * @return Sin valor de retorno
	 */
	public void cogerId(String id){
		if(habitacionActual.estaObjeto(id)){
			if(!jugador.tieneEnInventario(id)){
				Item item = habitacionActual.cogerObjeto(id);
				jugador.agregaObjeto(item);
			}else{
				UIConsola.showError("Ya tienes otro " + id + " en tu inventario.");
			}
		}else{
			UIConsola.showError("El objeto " + id + " no está en esta habitación.");
		}		
	}
	
	/**
	 * Procedimiento especifico cuando se sale del juego
	 * 
	 * @return Sin valor de retorno
	 */
	public void salir() {
		UIConsola.printText("GAME OVER!!\nGracias por jugar.\n");
		UIConsola.printText( jugador.mostrarPuntuacion());	
	}
	
	/**
	 * Procedimiento especifico cuando el juego recibe el comando mirar
	 * 
	 * @param id String que representa el identificado del objeto a mirar
	 * @return Sin valor de retorno
	 */
	public void mirarId(String id) {
		if(id.equals(""))
			UIConsola.printText(jugador.mostrarInventario());
		else
			UIConsola.printText(jugador.mostrarItem(id));
		
	}

	/**
	 * Procedimiento especifico cuando se escribe el comando soltar
	 * @param id String con el identificador del objeto a soltar
	 * @return Sin valor de retorno
	 */
	public void soltarId(String id) {
		
		if(jugador.tieneEnInventario(id)){
			if(!habitacionActual.estaObjeto(id)){
				Item item = jugador.obtenerObjeto(id);
				jugador.borrarItem(id);
				habitacionActual.agregarItem(item);
				
			}else
				UIConsola.showError("El objeto " + id + " ya existe en esta habitacion.");	
		}else
			UIConsola.showError("No tienes " + id + " en tu inventario.");
		
	}
	
	/**
	 * Procedimiento especifico que indica hacia que habitacion IR
	 * 
	 * @param direccion Directions hacia donde ir
	 * @return Sin valor de retorno
	 */
	public void cambiarHabitacion(Directions direccion){

		String mensaje = "...moviéndonos al " + direccion.toString() + "\n";	
		Door puerta = puertas.devolverPuerta(habitacionActual, direccion);

		if((puerta != null) && puerta.isOpenDoor()){
			habitacionActual = puerta.nextRoom(habitacionActual);
			jugador.restarVida();
			mensaje += habitacionActual.mostrarInventario() + jugador.mostrarPuntuacion();
			UIConsola.printText(mensaje);
		}else if((puerta != null) && !puerta.isOpenDoor()){
			UIConsola.showError("Hay una puerta en dirección " + direccion.toString() + ", pero está cerrada.");
		}else{
			UIConsola.showError("El camino está cortado en dirección " + direccion.toString() + ".");
		}
		
	}


	
	/**
	* Metodo que da comienzo al juego
	*/
	public void comenzarJuego(){
		
		Command comando = new Comando();
		String entrada;
		
		UIConsola.printText(habitacionActual.mostrarInventario());
		UIConsola.printText(jugador.mostrarPuntuacion());
		while(!(comando.getVerbo().equals(VerbCommands.SALIR) || habitacionActual.getSalida() || !jugador.tieneNivelVida())){	
			entrada = UIConsola.askComand();
			comando = Parser.parsear(this, entrada);
			comando.ejecutar();
		}
				
		if(habitacionActual.getSalida())
			UIConsola.printText("\nHa ganado!!!");
	}



}