package lige.grupo03.pr2.logica;

import lige.grupo03.pr2.jugador.Player;

/**
 * Clase que representa un Item ObjetoValor
 * 
 * @author Ismael Ventura & Ignacio Lopez
 * @version 1.0
 */
public class ObjetoValor extends Consumible{

	/**
	 * Constructor parametrizado con 3 parametros
	 * 
	 * @param id String que almacena el identificador del Item ObjetoValor
	 * @param descripcion String que almacena la descripcion del Item ObjetoValor
	 * @param puntos int que almacena los puntos que otorga
	 */
	public ObjetoValor(String id, String descripcion, int puntos) {
		super(id, descripcion, puntos);
	}
	
	/**
	 * Metodo sobreescrito que muestra la informacion del Item ObjetoValor
	 * 
	 * @return String con la informacion del Item debidamente presentado
	 */
	@Override
	public String mostrar(){
		return "--item[" + super.getId() + "]=" + super.getDescripcion() + " " + super.getPuntos() + "//1";
}

	/**
	 * Metodo concreto que ejecutará el Item ObjetoValor al invocar el comando USAR
	 * 
	 * @param who Player que invoca el comando
	 * @param where Habitacion desde donde se invoca el Comando
	 * @return boolean Indicando que se pudo usar el Comando
	 */
	@Override
	public boolean use(Player who, Room where) {
		
		if(canBeUsed()){
			who.agregaPuntuacion(super.getPuntos());
			super.setPuntos(0);
			return true;
		}else
			return false;
	}

	/**
	 * Implementacion del metodo abstracto clone
	 * 
	 * @return ObjetoValor que es una copia exacta del original
	 */
	@Override
	public ObjetoValor clone() {
		return new ObjetoValor(this.getId(), this.getDescripcion(), this.getPuntos());
	}
	
	
	

}
