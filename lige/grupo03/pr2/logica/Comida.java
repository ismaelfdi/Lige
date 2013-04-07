package lige.grupo03.pr2.logica;

import lige.grupo03.pr2.jugador.Player;

/**
 * Clase que representa el Item Consumible Comida
 * 
 * @author Ismael Ventura & Ignacio Lopez
 * @version 1.0
 */
public class Comida extends Consumible{
	
	/*Atributo que indica el numero de veces que se puede consumir un Item Comida*/
	private int numeroVeces;

	/**
	 * Constructor parametrizado con 4 parametros
	 * 
	 * @param id String que representa el identificador
	 * @param descripcion String que representa la descripcion
	 * @param puntos int que almacena el valor que otorga al nivel de vida
	 * @param numeroVeces int que almacena el numero de veces a usar el objeto
	 */
	public Comida(String id, String descripcion, int puntos, int numeroVeces) {
		super(id, descripcion, puntos);
		this.numeroVeces = numeroVeces;
	}

	/**
	 * Metodo sobreescrito que muestra la informacion del Item Consumible
	 * 
	 * @return String con la informacion del Item debidamente presentado
	 */
	@Override
	public String mostrar(){	
		return "--item[" + super.getId() + "]=This " + super.getDescripcion() + " value is " + super.getPuntos() + "//" + numeroVeces;
	}

	/**
	 * Metodo concreto que ejecuta el Item Comida al invocar el comando USAR
	 * 
	 * @param who Player que invoca el comando
	 * @param where Habitacion desde donde se invoca el Comando
	 * @return boolean Indicando que se pudo usar el Comando
	 */
	@Override
	public boolean use(Player who, Room where) {
		
		if(canBeUsed()){
			who.sumarVida(super.getPuntos());
			numeroVeces--;
			return true;
		}else
			return false;
	}

	/**
	 * Metodo abstracto que copia un Item
	 *  
	 * @return Item que es una copia del Item original
	 */
	@Override
	public Comida clone() {
		return new Comida(this.getId(),this.getDescripcion(),this.getPuntos(),this.numeroVeces);
	}

}
