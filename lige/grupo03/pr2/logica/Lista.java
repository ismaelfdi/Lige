package lige.grupo03.pr2.logica;

import java.util.ArrayList;
import java.util.Iterator;

public class Lista {
	
	private ArrayList<Item> lista;
	
	public Lista(){
		lista = new ArrayList<Item>();
	}
	
	public ArrayList<Item> getLista(){
		return lista;
	}
	
	/*Agrega un objeto al inventario*/
	public boolean agregarItem(Item objeto){
		/*
		if(!estaObjeto(objeto.getId()))
			return inventarioHabitacion.add(objeto);
		else
			return false;
		*/
		if(!lista.contains(objeto))
			return lista.add(objeto);
		else 
			return false;
	}
	
	
	
	
	private Item obtenerItem(String id){
		
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

	public boolean estaItem(String id){
		return (obtenerItem(id)!= null);
	}
	
	public Item cogerObjeto(String id){
		Item item = obtenerItem(id);
		lista.remove(item);
		return item;
	}
	
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
	
	public boolean isEmpty(){
		return lista.isEmpty();
	}
	
/******************************************************************************/
/*	Metodo igual a public boolean estaObjeto(String id)
 
	public boolean tieneEnInventario(String id){
		return (obtenerObjeto(id) != null);
	}
*/
	
/*
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
*/
	
/*
	public boolean agregaObjeto(Item item){
		
		if(!inventarioPlayer.contains(item))
			return inventarioPlayer.add(item);
		else
			return false;
		
	}
*/	


}