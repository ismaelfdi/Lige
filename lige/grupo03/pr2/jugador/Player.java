/**
 * 
 */
package lige.grupo03.pr2.jugador;

import lige.grupo03.pr2.logica.Item;
import lige.grupo03.pr2.logica.Lista;

/**
 * Clase que representa un jugador
 * 
 * @author Ismael Ventura & Ignacio Lopez
 * @version 1.0
 */
public class Player {
	
	/*Atributo que almacena la puntuacion que va acumulando un jugador*/
	private int puntuacion;
	/*Atributo que almacena el nivel de vida del jugador*/
	private int nivelVida;
	/*Atributo que representa la lista de objetos que va recogiendo el jugador*/
	private Lista inventarioPlayer;
	
	/**
	 * Constructor por defecto
	 */
	public Player(){
		this.puntuacion = 0;
		this.nivelVida = 100;
		this.inventarioPlayer = new Lista();
	}
	
	/**
	 * Procedimiento que resta el nivel del jugador al cambiar de habitacion
	 * 
	 * @return Sin valor de retorno
	 */
	public void restarVida(){
		nivelVida -= 5;
	}
	
	/**
	 * Procedimiento que suma vida al consumir un Objeto Coonsumible
	 * 
	 * @param vida int con el valor de vida a sumar o restar segun sea el caso
	 * @return Sin valor de retorno
	 */
	public void sumarVida(int vida){
		nivelVida += vida;
	}
	
	/**
	 * Procedimiento que agrega puntos al consumir un objeto Consumible
	 * 
	 * @param puntos int que representa los puntos a sumar
	 * @return Sin valor de retorno
	 */
	public void agregaPuntuacion(int puntos){
		puntuacion += puntos;
	}
	
	/**
	 * Agrega un objeto al inventario del jugador
	 * 
	 * @param item Item a agregar en el inventario del jugador
	 * @return boolean indicando si el objeto se agrego al inventario
	 */
	public boolean agregaObjeto(Item item){		
		return inventarioPlayer.addItem(item);
	}
	
	/**
	 * Indica si al jugador aun le queda vida para seguir jugando
	 * 
	 * @return boolean verdadero o falso segun sea el caso
	 */
	public boolean tieneNivelVida(){
		return !(nivelVida == 0);
	}

	/**
	 * Indica si el Item con identificador id esta en el inventario
	 * 
	 * @param id String que representa el identificador del Item
	 * @return boolean verdadero o falso segun sea el caso
	 */
	public boolean tieneEnInventario(String id){
		return (obtenerObjeto(id) != null);
	}

	/**
	 * Devuelve del inventario el objeto con identificador id
	 * 
	 * @param id String que es el identificador del Item a devolver
	 * @return Item encontrado o null en caso que no se encuentre
	 */
	public Item obtenerObjeto(String id){		
		return inventarioPlayer.obtenerItem(id);
	}

	/**
	 * Devuelve la informacion del nivel de vida y puntuacion del jugador
	 * 
	 * @return String con la informacion de los puntos y novel de vida del jugador
	 */
	public String mostrarPuntuacion(){
		return "VIDA = " + nivelVida + ", PUNTUACI�N =" + puntuacion;
	}
		
	/**
	 * Devuelve la informacion del Item con identificador id
	 * 
	 * @param id String que representa el identificador del Item a mostrar
	 * @return String con la informacion del Item
	 */
	public String mostrarItem(String id){
		
		String mensaje = "";
		Item item = obtenerObjeto(id);
		
		if(item != null)
			mensaje += item.mostrar();
		else
			mensaje += "No hay " + id + " en tu inventario.";
			
		return mensaje;
	}
	
	/**
	 * Devuelve la informacion de todos los items del inventario del jugador
	 * 
	 * @return String con la informacion de todos los items del jugador
	 */
	public String mostrarInventario(){
		
		String cadena = inventarioPlayer.showItems();
		
		if(!cadena.equals(""))
			cadena = "Mis objetos son:\n" + cadena;
		else
			cadena = "Eres pobre, no tienes ning�n objeto (aun).";
		
		return cadena;
	}

	/**
	 * Eliminar un Item del inventario del jugador
	 * 
	 * @param id String que representa el identificador del Item a borrar
	 * @return Sin valor de retorno
	 */
	public void borrarItem(String id) {
		inventarioPlayer.borrarItem(id);
	}
}
