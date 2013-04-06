package lige.grupo03.pr2.logica;

import lige.grupo03.pr2.jugador.Player;

public class Comida extends Consumible{
	
	private int numeroVeces;

	public Comida(String id, String descripcion, int puntos, int numeroVeces) {
		super(id, descripcion, puntos);
		this.numeroVeces = numeroVeces;
	}
	
	public int getNumeroveces(){
		return numeroVeces;
	}
	
	public String mostrar(){	
		return "--item[" + super.getId() + "]=This " + super.getDescripcion() + " value is " + super.getPuntos() + "//" + numeroVeces;
	}

	@Override
	public boolean use(Player who, Room where) {
		
		if(canBeUsed()){
			who.sumarVida(super.getPuntos());
			numeroVeces--;
			return true;
		}else
			return false;
	}

	@Override
	public Comida clone() {
		return new Comida(this.getId(),this.getDescripcion(),this.getPuntos(),this.numeroVeces);
	}

}
