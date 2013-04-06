/**
 * 
 */
package lige.grupo03.pr2.logica;

import lige.grupo03.pr2.jugador.Player;

/**
 * @author IsmaelLeonidas
 *
 */
public abstract class Persistente extends Item{

	public Persistente(String id, String descripcion) {
		super(id, descripcion);
	}

	@Override
	public boolean canBeUsed(){
		return true;
	}
	
	@Override
	public abstract boolean use(Player who, Room where);



}
