package lige.grupo03.pr2.logica;

import lige.grupo03.pr2.jugador.Player;

public class ObjetoValor extends Consumible{

	public ObjetoValor(String id, String descripcion, int puntos) {
		super(id, descripcion, puntos);
	}
	
	public String mostrar(){
		return "--item[" + super.getId() + "]=" + super.getDescripcion() + " " + super.getPuntos() + "//1";
}


	@Override
	public boolean use(Player who, Room where) {
		
		if(canBeUsed()){
			who.agregaPuntuacion(super.getPuntos());
			super.setPuntos(0);
			return true;
		}else
			return false;
	}
	
	
	

}
