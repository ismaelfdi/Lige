package lige.grupo03.pr2.logica;

import java.util.ArrayList;

//import java.util.ArrayList;

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
	private Lista inventarioHabitacion;
	/**
	Constructor por defecto 
	*/
	public Room(){
		this.descripcion = null;
		this.salida = false;
		this.inventarioHabitacion = new Lista();
	};
	
	/**
	Constructor con 2 parametros 
	@param descripcion: String con la descripcion de la habitación.
	@param salida: TRUE o FALSE segun sea el caso.
	*/
	public Room(String descripcion, boolean salida){
		this.descripcion = descripcion;
		this.salida = salida;
		this.inventarioHabitacion = new Lista();
	}

	public Room(String descripcion, boolean salida, Lista inventarioHabitacion){
		this.descripcion = descripcion;
		this.salida = salida;
		this.inventarioHabitacion = inventarioHabitacion;
	}
	
	
	public void setInventarioHabitacion(Lista inventarioHabitacion){
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
	
	public Lista getInventarioHabitacion(){
		return inventarioHabitacion;
	}
	

	
	/*Agrega un objeto al inventario*/
	public boolean agregarItem(Item item){		
		return inventarioHabitacion.addItem(item);
	}

	public Item obtenerObjeto(String id){
		return inventarioHabitacion.obtenerItem(id);
	}

	public boolean estaObjeto(String id){
		return inventarioHabitacion.estaItem(id);
	}
	
	public Item cogerObjeto(String id){
		return inventarioHabitacion.cogerObjeto(id);
	}
	/*
	public String mostrarListaHabitacion(){
		return inventarioHabitacion.showItems();
	}
	*/
	public String mostrarInventario(){
		
		String cadena = inventarioHabitacion.showItems();
		
		if(!cadena.equals(""))
			cadena = descripcion + "\nLa habitación contiene los siguientes objetos:\n" + cadena;
		else
			cadena = "\nLa habitación está vacía.\n";
		
		return cadena;
	}

	public void setInventarioHabitacion(ArrayList<Item> lista) {
		// TODO Auto-generated method stub
		this.inventarioHabitacion = new Lista(lista);
	}
}
