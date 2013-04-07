/**
 * 
 */
package lige.grupo03.pr2.logica;

import lige.grupo03.pr2.jugador.Player;

/**
 * Clase abstracta que representa un Item Consumible - Comida u ObjetoValor
 * Los Items Consumibles suman o quitan puntos:
 * 		<ul>
 * 			<li>Item Comida: Suma o resta al Nivel de vida del jugador</li>
 * 			<li>Item ObjetoValor: Siempre suma puntos</li>
 * 		</ul>
 * 
 * @author Ismael Ventura & Ignacio Lopez
 * @version 1.0
 */
public abstract class Consumible extends Item{
	
	/*Atributo que contiene los puntos que otorga o resta un Item Consumible*/
	private int puntos;
	
	/**
	 * Constructor parametrizado del Item Consumible
	 * 
	 * @param puntos repesenta el valor que otorga o resta un Item Consumible
	 */
	public Consumible(String id, String descripcion, int puntos) {
		super(id, descripcion);
		this.puntos = puntos;
	}
	
	/**
	 * Devuelve el valor de los puntos que otorga un Item
	 * 
	 * @return Int con el valor del atributo puntos
	 */
	public int getPuntos(){
		return puntos;
	}
	
	/**
	 * Modifica el atributo puntos de un Item al consumirse
	 * 
	 * @param puntos int que se asignara al atributo puntos
	 */
	public void setPuntos(int puntos){
		this.puntos = puntos;
	}
	
	/**
	 * Metodo sobreescrito que muestra la informacion del Item Consumible
	 * 
	 * @return String con la informacion del Item debidamente presentado
	 */
	@Override
	public String mostrar(){	
		return "--item[" + super.getId() + "]=This " + super.getDescripcion() + "value is " + puntos;
	}
	
	/**
	 * Implementacion del metodo abstracto para un Item Consumible
	 * 
	 * @return boolean indicando si un Item Consumible puede ser usado o no
	 */
	@Override
	public boolean canBeUsed() {
		return (puntos > 0);
	}

	/**
	 * Metodo abstracto concreto que ejecutará cada Item al invocar el comando USAR
	 * 
	 * @param who Player que invoca el comando
	 * @param where Habitacion desde donde se invoca el Comando
	 * @return boolean Indicando que se pudo usar el Comando
	 */
	@Override
	public abstract boolean use(Player who, Room where);
	
	/**
	 * Metodo abstracto que copia un Item
	 *  
	 * @return Item que es una copia del Item original
	 */
	public abstract Item clone();

}
