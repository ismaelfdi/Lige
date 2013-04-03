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
/*	
	public Room getHabitacionActual(){
		return this.habitacionActual;
	}
	
	public Map getPuertas(){
		return this.puertas;
	}
	
	public Player getJugador(){
		return this.jugador;
	}
*/	
	public boolean jugadorTiene(String id){
		return jugador.tieneEnInventario(id);
	}
	
	public String mostrarPuntuacionJugador(){
		 return jugador.mostrarPuntuacion();
	}
	
	public String mostrarInventarioHabitacion(){
		return habitacionActual.mostrarInventario();
	}
	
	public String mostrarInventarioJugador(){
		return jugador.mostrarInventario();
	}
	
	public String mostrarItemJugador(String id){
		return jugador.mostrarItem(id);
	}
	
	public boolean habitacionActualEstaObjeto(String id){
		return habitacionActual.estaObjeto(id);
	}
	
	public boolean jugadorTieneEnInventario(String id){
		return jugador.tieneEnInventario(id);
	}
	
	public Item cogerObjetoHabitacion(String id){
		return habitacionActual.cogerObjeto(id);
	}
	
	public boolean agregaObjetoAJugador(Item item){
		return jugador.agregaObjeto(item);
	}
	
	public Item obtenerObjetoJuegador(String id){
		return jugador.obtenerObjeto(id);
	}
	
	public Door devolverPuerta(Directions direccion){
		return puertas.devolverPuerta(habitacionActual, direccion);
	}
	
	public void cambiarHabitacion(Directions direccion){

		String mensaje = "...moviéndonos al " + direccion.toString() + "\n";	
		Door puerta = puertas.devolverPuerta(habitacionActual, direccion);

		if((puerta != null) && puerta.isOpenDoor()){
			habitacionActual = puerta.nextRoom(habitacionActual);
			jugador.consumeNivelVida();
			mensaje += habitacionActual.mostrarInventario() + jugador.mostrarPuntuacion();
			UIConsola.printText(mensaje);
		}else if((puerta != null) && !puerta.isOpenDoor()){
			UIConsola.showError("Hay una puerta en dirección " + direccion.toString() + ", pero está cerrada.");
		}else{
			UIConsola.showError("El camino está cortado en dirección " + direccion.toString() + ".");
		}
		
	}
	
	/**
	Metodo que da comienzo al juego
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
			System.out.println("Ha ganado!!!");
	}
	
	/*
	
	public static void main(String[] args) {
		
		Room hab = new Room("Habitacion 0:\nEs tu última oportunidad para terminar la práctica a tiempo.\n", true);
		
		System.out.println(hab.getDescripcion());
		
		
		new Game(new Map(), hab).comenzarJuego();
		
	}
	*/
	
	
	
	
	

}
