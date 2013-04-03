/**
 * 
 */
package lige.grupo03.pr2.jugador;

import java.util.ArrayList;
import java.util.Iterator;

import lige.grupo03.pr2.logica.Item;

/**
 * @author IsmaelLeonidas
 *
 */
public class Player {
	
	private int puntuacion;
	private int nivelVida;
	private ArrayList<Item> inventarioPlayer;
	
	public Player(){
		this.puntuacion = 0;
		this.nivelVida = 100;
		this.inventarioPlayer = new ArrayList<Item>();
	}
	
	public void consumeNivelVida(){
		nivelVida -= 5;
	}
	
	public void agregaPuntuacion(int puntos){
		puntuacion += puntos;
	}
	
	public boolean agregaObjeto(Item item){
		
		if(!inventarioPlayer.contains(item))
			return inventarioPlayer.add(item);
		else
			return false;
		
	}
	
	public boolean tieneNivelVida(){
		return !(nivelVida == 0);
	}
	
	

	
	public boolean tieneEnInventario(String id){
		return (obtenerObjeto(id) != null);
	}

	public Item obtenerObjeto(String id){
		
		boolean encontrado = false;
		Iterator<Item> lista = inventarioPlayer.iterator();
		Item item = null;

		while (!encontrado && lista.hasNext()) {
			item = lista.next();
			encontrado = item.getId().equals(id);
		}
		
		if(encontrado)
			return item;
		else
			return null;
	}
	
	public String mostrarPuntuacion(){
		return "VIDA = " + nivelVida + ", PUNTUACI�N =" + puntuacion;
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
		
		String mensaje = "";

		if(!inventarioPlayer.isEmpty()){
			Iterator<Item> lista = inventarioPlayer.iterator();
			Item item;
			mensaje += "Mis objetos son:\n";
			while (lista.hasNext()) {
				item = lista.next();
				mensaje += item.mostrar() + "\n";
			}				
				
		}else
			mensaje += "Eres pobre, no tienes ning�n objeto (aun).";
			
		return mensaje;
	}
	
	

}