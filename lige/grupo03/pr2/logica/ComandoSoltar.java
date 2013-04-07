package lige.grupo03.pr2.logica;

import lige.grupo03.pr2.VerbCommands;

public class ComandoSoltar extends Comando{
	
	private String id;
	private Game juego;
	
	public ComandoSoltar(Game juego, String id){
		super(VerbCommands.SOLTAR);
		this.id = id;
		this.juego = juego;
	}
	
	public String getId(){
		return id;
	}
	
	public boolean esValido(){
		return (super.esValido() && (!id.equals("")));
	}
	
	public void ejecutar(){
		juego.soltarId(id);
	}

}
