/**
 * 
 */
package lige.grupo03.pr2.logica;

import lige.grupo03.pr2.jugador.Player;

/**
 * @author IsmaelLeonidas
 *
 */
public abstract class Consumible extends Item{
	
	private int puntos;
	
	public Consumible(String id, String descripcion, int puntos) {
		super(id, descripcion);
		this.puntos = puntos;
		// TODO Auto-generated constructor stub
	}
	
	public int getPuntos(){
		return puntos;
	}
	
	public void setPuntos(int puntos){
		this.puntos = puntos;
	}
	
	public String mostrar(){	
		return "--item[" + super.getId() + "]=This " + super.getDescripcion() + "value is " + puntos;
	}

	@Override
	public boolean canBeUsed() {
		return (puntos > 0);
	}

	@Override
	public abstract boolean use(Player who, Room where);

}
