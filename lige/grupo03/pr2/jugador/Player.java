/**
 * 
 */
package lige.grupo03.pr2.jugador;

import lige.grupo03.pr2.logica.Item;
import lige.grupo03.pr2.logica.Lista;

/**
 * @author IsmaelLeonidas
 *
 */
public class Player {
	
	private int puntuacion;
	private int nivelVida;
	private Lista inventarioPlayer;
	
	public Player(){
		this.puntuacion = 0;
		this.nivelVida = 100;
		this.inventarioPlayer = new Lista();
	}
	
	public void restarVida(){
		nivelVida -= 5;
	}
	
	public void sumarVida(int vida){
		nivelVida += vida;
	}
	
	public void agregaPuntuacion(int puntos){
		puntuacion += puntos;
	}
	
	public boolean agregaObjeto(Item item){		
		return inventarioPlayer.addItem(item);
	}
	
	public boolean tieneNivelVida(){
		return !(nivelVida == 0);
	}

	
	public boolean tieneEnInventario(String id){
		return (obtenerObjeto(id) != null);
	}

	public Item obtenerObjeto(String id){		
		return inventarioPlayer.obtenerItem(id);
	}

	public String mostrarPuntuacion(){
		return "VIDA = " + nivelVida + ", PUNTUACIÓN =" + puntuacion;
	}
		
	public String mostrarItem(String id){
		
		String mensaje = "";
		Item item = obtenerObjeto(id);
		
		if(item != null)
			mensaje += item.mostrar();
		else
			mensaje += "No hay " + id + " en tu inventario.";
			
		return mensaje;
	}
	
	public String mostrarInventario(){
		
		String cadena = inventarioPlayer.showItems();
		
		if(!cadena.equals(""))
			cadena = "Mis objetos son:\n" + cadena;
		else
			cadena = "Eres pobre, no tienes ningún objeto (aun).";
		
		return cadena;
	}

	public void borrarItem(String id) {
		inventarioPlayer.borrarItem(id);
	}
}
