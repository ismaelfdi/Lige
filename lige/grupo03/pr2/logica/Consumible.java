/**
 * 
 */
package lige.grupo03.pr2.logica;

import lige.grupo03.pr2.jugador.Player;

/**
 * @author IsmaelLeonidas
 *
 */
public class Consumible extends Item{
	
	private int puntos;
	
	public Consumible(String id, String descripcion, int puntos) {
		super(id, descripcion);
		this.puntos = puntos;
		// TODO Auto-generated constructor stub
	}
	
	public int getPuntos(){
		return puntos;
	}


	@Override
	public boolean canBeUsed() {
		return false;
	}

	@Override
	public void use(Player who, Room where) {
		// TODO Auto-generated method stub
		
	}

}
