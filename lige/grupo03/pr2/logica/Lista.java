package lige.grupo03.pr2.logica;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Clase que representa una lista y toda su funcionalidad
 * 
 * @author Ismael Ventura & Ignacio Lopez
 * @version 1.0
 */
public class Lista {
	
	/*Atributo lista que almacenara los Item*/
	private ArrayList<Item> lista;
	
	/**
	 * Constructor por defecto
	 */
	public Lista(){
		lista = new ArrayList<Item>();
	}
	
	/**
	 * Constructor parametrizado con un parametro
	 * 
	 * @param lista ArrayList<Item> que representa una lista
	 */
	public Lista(ArrayList<Item> lista){
		this.lista = lista;
	}
	
	/**
	 * Agrega un objeto a la lista
	 * 
	 * @param item Item que se agregara a la lista
	 * @return boolean indicando si el Item pudo ser agregado a la lista
	 */
	public boolean addItem(Item item){
		if(!lista.contains(item))
			return lista.add(item);
		else 
			return false;
	}
	
	/**
	 * Devuelve el Item con el id indicadoen el parametro
	 * 
	 * @param id String con el valor del id
	 * @return Item que tiene el id pasado por parametro
	 */
	public Item obtenerItem(String id){
		
		boolean encontrado = false;
		Iterator<Item> listaObjetos = lista.iterator();
		Item item = null;

		while (!encontrado && listaObjetos.hasNext()) {
			item = listaObjetos.next();
			encontrado = item.getId().equals(id);
		}
		
		if(encontrado)
			return item;
		else
			return null;
	}

	/**
	 * Indica si el Item con este id se encuentra en la lista
	 * 
	 * @param id String con el valor del id a buscar en la lista
	 * @return boolean indicando si el item se encuentra en la lista
	 */
	public boolean estaItem(String id){
		return (obtenerItem(id)!= null);
	}
	
	/**
	 * Borra un Item con este id de la lista
	 * 
	 * @param id String con el valor del id a eliminar de la lista
	 */
	public void borrarItem(String id){
		Item item = obtenerItem(id);
		lista.remove(item);		
	}
	
	/**
	 * Devuelve el Item de la lista con el identificador id
	 * 
	 * @param id String que representa el identificador del Item a devolver
	 * @return Item con el identificador id
	 */
	public Item cogerObjeto(String id){
		Item item = obtenerItem(id);
		lista.remove(item);
		return item;
	}
	
	/**
	 * Muestra la informacion de cada Item de la lista debidamente formateada
	 * 
	 * @return String con la informacion de todos los items de la lista
	 */
	public String showItems(){
		String cadenaItems = "";
		Iterator<Item> listaObjetos = lista.iterator();
		Item item;
		
		while (listaObjetos.hasNext()) {
			item = listaObjetos.next();
			cadenaItems += item.mostrar() + "\n";
		}		
		
		return cadenaItems;
	}
	
	/**
	 * Indica si una lista tiene elementos
	 * 
	 * @return boolean indicando si la lista tiene elementos
	 */
	public boolean isEmpty(){
		return lista.isEmpty();
	}
	
}