package lige.grupo03.pr2.logica;

public class Llave extends Persistente{
	
	/*Atributo puerta, indica la puerta que abre esta llave*/
	private Door puerta;

	public Llave(String id, String descripcion) {
		super(id, descripcion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void use(String who, String where) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean canBeUsed() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public static void main(String[] args) {
		Llave miLlave = new Llave("key0", "This key opens the door 0");
		
		System.out.println(miLlave.getId());

	}

}
