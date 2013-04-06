/**
 * 
 */
package lige.grupo03.pr2.logica;

import lige.grupo03.pr2.jugador.Player;

/**
 * @author IsmaelLeonidas
 *
 */
public abstract class Item {
	
	private String id;
	private String descripcion;
	
	public Item(String id, String descripcion){
		this.id = id;
		this.descripcion = descripcion;
	}
	
	public String getId(){
		return id;
	}
	
	public String getDescripcion(){
		return descripcion;
	}
	
	public String mostrar(){
		
		return "--item[" + id + "]=" + descripcion;
	}
	
	public abstract boolean use(Player who, Room where);
	
	public abstract boolean canBeUsed();
	
		
	/*
	o use(who, where): comportamiento concreto que se ejecutará al
	invocar el comando USAR.
	o boolean canBeUsed(): devuelve si el item se puede utilizar o
	no. Un objeto se puede utilizar si no es consumible, o si es
	consumible y el número de instancias del objeto es mayor que
	cero.
	*/
	
}
