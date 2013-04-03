package lige.grupo03.pr2.logica;

public class Comida extends Consumible{
	
	private int numeroVeces;

	public Comida(String id, String descripcion, int puntos, int numeroVeces) {
		super(id, descripcion, puntos);
		this.numeroVeces = numeroVeces;
	}
	
	public int getNumeroveces(){
		return numeroVeces;
	}

}
