package programaciondmi.dca.ecosistemas.erazoecheverryceron;

import programaciondmi.dca.core.EspecieAbstracta;

public class PBuena extends PlantaPapu {

	private boolean curing;
	private float[] buffos;
	private float cure;
	private float buffAtk;
	private float buffDef;
	private float buffVel;

	public PBuena() {
		image = CargaDatos.PBuena;
		// oWith = image.width;
		// oHeight = image.height;

		cure = (float) (Math.random()*20);
		buffAtk = (float) (Math.random()*10);
		buffDef = (float) (Math.random()*10);
		buffVel = (float) (Math.random()*10);
		
		buffos = new float[3];
		buffos[0] = buffAtk;
		buffos[1] = buffDef;
		buffos[2] = buffVel;
	}

	public PBuena(int x, int y) {
		super(x, y);
		image = CargaDatos.PBuena;
		// oWith = image.width;
		// oHeight = image.height;
		
		cure = (float) (Math.random()*20);
		buffAtk = (float) (Math.random()*10);
		buffDef = (float) (Math.random()*10);
		buffVel = (float) (Math.random()*10);
		
		buffos = new float[3];
		buffos[0] = buffAtk;
		buffos[1] = buffDef;
		buffos[2] = buffVel;

	}

	public void dibujar() {

		app.image(image, x, y);
	}

	@Override
	public boolean recibirDano(EspecieAbstracta lastimador) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public float chooseBuff(){
		return buffos[(int) app.random(3)];
		
	}

}
