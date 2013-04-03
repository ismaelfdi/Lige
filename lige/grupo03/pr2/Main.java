package lige.grupo03.pr2;

import java.util.ArrayList;
import java.util.Random;

import lige.grupo03.pr2.logica.Comida;
import lige.grupo03.pr2.logica.Door;
import lige.grupo03.pr2.logica.Game;
import lige.grupo03.pr2.logica.Item;
import lige.grupo03.pr2.logica.Llave;
import lige.grupo03.pr2.logica.Map;
import lige.grupo03.pr2.logica.ObjetoValor;
import lige.grupo03.pr2.logica.Room;

public class Main {
	
	private static ArrayList<Item> crearLista(){
		
		ArrayList<Item> lista = new ArrayList<Item>();
		
		lista.add(new Llave("key0", "This key opens the door 0"));
		lista.add(new Llave("key1", "This key opens the door 1"));
		lista.add(new Llave("key2", "This key opens the door 2"));
		lista.add(new Llave("key3", "This key opens the door 3"));
		lista.add(new Llave("key4", "This key opens the door 4"));
		lista.add(new Llave("key5", "This key opens the door 5"));
		lista.add(new Comida("food0", "Comida", 40, 5));
		lista.add(new ObjetoValor("Honor1", "Gold coin", 200));
		
		return lista;
	}
	
	/**
	Room[] createRooms: Crea un array con las habitaciones de la
	aventura. La primera habitación será siempre la de partida.
	*/
	private static Room[] createRooms(int n){
		
		Room[] habitaciones = new Room[n];
		boolean salida;
		String descripcion;
		ArrayList<Item> lista;
		
		lista = crearLista();
		
		habitaciones[0] = new Room("Room 0", false, lista);
		for(int i = 1; i < n-1; i++){
			int j = new Random().nextInt(2);
			salida = (j == 0)?false:true;
			descripcion = "Room " + i;
			habitaciones[i] = new Room(descripcion, salida, lista);
		}
		n--;
		habitaciones[n-1] = new Room("Room" + n , false, lista);
		
		return habitaciones;
	}
	
	/**
	Añade las puertas del juego en el mapa.
	@param m Mapa donde añadir las puertas
	@param habitaciones habitaciones del juego
	*/
	private static void insertDoors(Map m, Room[] habitaciones){
		m.agregarPuerta(new Door(habitaciones[0],Directions.NORTE,habitaciones[2], false));
		m.agregarPuerta(new Door(habitaciones[1],Directions.NORTE,habitaciones[0], false));
		m.agregarPuerta(new Door(habitaciones[2],Directions.OESTE,habitaciones[3], false));
		m.agregarPuerta(new Door(habitaciones[2],Directions.ESTE,habitaciones[4], false));
		m.agregarPuerta(new Door(habitaciones[2],Directions.NORTE,habitaciones[5], false));
		m.agregarPuerta(new Door(habitaciones[3],Directions.OESTE,habitaciones[9], false));
		m.agregarPuerta(new Door(habitaciones[3],Directions.SUR,habitaciones[10], false));
		m.agregarPuerta(new Door(habitaciones[4],Directions.NORTE,habitaciones[8], false));
		m.agregarPuerta(new Door(habitaciones[4],Directions.ESTE,habitaciones[6], false));
		m.agregarPuerta(new Door(habitaciones[4],Directions.SUR,habitaciones[7], false));
		m.agregarPuerta(new Door(habitaciones[5],Directions.ESTE,habitaciones[11], false));
		m.agregarPuerta(new Door(habitaciones[5],Directions.OESTE,habitaciones[12], false));
		m.agregarPuerta(new Door(habitaciones[5],Directions.NORTE,habitaciones[13], false));
		m.agregarPuerta(new Door(habitaciones[13],Directions.ESTE,habitaciones[14], false));
		m.agregarPuerta(new Door(habitaciones[14],Directions.SUR,habitaciones[15], false));
	}
	
	
	/* main Principal */
	public static void main(String[] args) {
		
		Map m = new Map();
		Room[] habitaciones = createRooms(16);
		insertDoors(m, habitaciones);
		Game juego = new Game(m, habitaciones[0]);
		juego.comenzarJuego();

	}

}
