package lige.grupo03.pr2.logica;

import java.util.ArrayList;
import java.util.Iterator;

/**
Clase que representa una habitación indicando una descripción y si es una salida.
@author Ismael Ventura & Ignacio Aguirre
@version 1.0
*/
public class Room {
	/*Descripcion de la habitacion*/
	private String descripcion;
	/*Indica si es una habitacion de salida */
	private boolean salida;
	/*ArrayList conteniendo el inventario de una habitacion*/
	private ArrayList<Item> inventarioHabitacion;
	/**
	Constructor por defecto 
	*/
	public Room(){
		this.descripcion = null;
		this.salida = false;
		this.inventarioHabitacion = new ArrayList<Item>();
	};
	
	/**
	Constructor con 2 parametros 
	@param descripcion: String con la descripcion de la habitación.
	@param salida: TRUE o FALSE segun sea el caso.
	*/
	public Room(String descripcion, boolean salida, ArrayList<Item> inventarioHabitacion){
		this.descripcion = descripcion;
		this.salida = salida;
		this.inventarioHabitacion = inventarioHabitacion;
	}

	/**
	Accedente del atributo descripcion
	@return String con el valor del atributo descripcion.
	*/
	public String getDescripcion(){
		return descripcion;
	}
	
	/**
	Indica si la habitacion es una habitacion de salida.
	@return boolean TRUE o FALSE segun sea el caso.
	*/
	public boolean getSalida(){
		return salida;
	}
	
	public ArrayList<Item> getInventarioHabitacion(){
		return inventarioHabitacion;
	}
	

	
	/*Agrega un objeto al inventario*/
	public boolean agregarItem(Item objeto){
		/*
		if(!estaObjeto(objeto.getId()))
			return inventarioHabitacion.add(objeto);
		else
			return false;
		*/
		if(!inventarioHabitacion.contains(objeto))
			return inventarioHabitacion.add(objeto);
		else 
			return false;
	}

	private Item obtenerObjeto(String id){
		
		boolean encontrado = false;
		Iterator<Item> lista = inventarioHabitacion.iterator();
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

	public boolean estaObjeto(String id){
		/*
		boolean encontrado = false;
		Iterator<Item> lista = inventarioHabitacion.iterator();
		Item item;
		
		while (!encontrado && lista.hasNext()) {
			item = lista.next();
			encontrado = item.getId().equals(id);
		}
		return encontrado;		
		*/
		
		return (obtenerObjeto(id)!= null);
	}
	public Item cogerObjeto(String id){
		/*
		Iterator<Item> lista = inventarioHabitacion.iterator();
		boolean removido = false;
		Item item = null;
		
		while (!removido && lista.hasNext()) {
			item = lista.next();
			if(item.getId().equals(id.toLowerCase()))
				removido = inventarioHabitacion.remove(item);
		}
		return item;
		*/
		
		Item item = obtenerObjeto(id);
		inventarioHabitacion.remove(item);
		return item;
	}
	
	public String mostrarListaHabitacion(){
		String cadenaLista = "";
		Iterator<Item> lista = inventarioHabitacion.iterator();
		
		Item item;
		while (lista.hasNext()) {
			item = lista.next();
			cadenaLista += item.mostrar() + "\n";
		}		
		
		
		return cadenaLista;
	}
	
	public String mostrarInventario(){
		String mensaje = descripcion;
		
		if(!inventarioHabitacion.isEmpty())
			mensaje += "\nLa habitación contiene los siguientes objetos:\n" 
					 + mostrarListaHabitacion();
		else
			mensaje += "\nLa habitación está vacía.";
		
		
		return mensaje;
	}

	
	/*
	public Item cogerItem(String id){
		
		if(!estaEnInventario(item.getId())){
			return inventarioPlayer.add(item);
		}else{
			return null;
		}			
	}
	
	public Item cogerItem(String id){
		
		boolean encontrado = false;
		Iterator<Item> lista = inventarioHabitacion.iterator();
		Item item;
		
		while (!encontrado && lista.hasNext()) {
			item = lista.next();
			encontrado = item.getId() == id;
		}
		if (encontrado)
			return item;
		else 
			return null;
		
	}	
*/
}
