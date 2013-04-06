package lige.grupo03.pr2.logica;

import lige.grupo03.pr2.Directions;
import lige.grupo03.pr2.jugador.Player;

public class Llave extends Persistente{
	
	/*Atributo puerta, indica la puerta que abre esta llave*/
	private Door puerta;
	
	public Llave(String id, String descripcion) {
		super(id, descripcion);
		this.puerta = new Door();
	}

	public Llave(String id, String descripcion, Door puerta) {
		super(id, descripcion);
		this.puerta = puerta;
	}
	
	public Llave clone(){
		return new Llave(this.getId(),this.getDescripcion(),this.puerta);
	}

	@Override
	public boolean use(Player who, Room where) {
		
		boolean encontrado = false;
		Directions[] direcciones = Directions.values();
		int i = 0;
		while(!encontrado && (i < direcciones.length))
			encontrado = puerta.isInRoom(where, direcciones[i++]);

		if(encontrado)
			puerta.setOpenDoor(true);
			
			
		return encontrado;
	}

/*
	public static void main(String[] args) {
		Llave miLlave = new Llave("key0", "This key opens the door 0", new Door());
		
		System.out.println(miLlave.getId());

	}
*/
}
