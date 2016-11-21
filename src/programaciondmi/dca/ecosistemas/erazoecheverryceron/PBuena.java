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

		cure = (float) (Math.random() * 20);
		buffAtk = (float) (Math.random() * 10);
		buffDef = (float) (Math.random() * 10);
		buffVel = (float) (Math.random() * 10);

		buffos = new float[3];
		buffos[0] = buffAtk;
		buffos[1] = buffDef;
		buffos[2] = buffVel;
		
//		oWith = CargaDatos.PBuena.width / 2;
//		oHeight = CargaDatos.PBuena.height / 2;
		
		
		if (Math.random() > 0.5f) {
			curing = true;
		} else {
			curing = false;
		}
	}

	public PBuena(int x, int y) {
		super(x, y);
		image = CargaDatos.PBuena;

		cure = (float) (Math.random() * 20);
		buffAtk = (float) (Math.random() * 10);
		buffDef = (float) (Math.random() * 10);
		buffVel = (float) (Math.random() * 10);

		buffos = new float[3];
		buffos[0] = buffAtk;
		buffos[1] = buffDef;
		buffos[2] = buffVel;

		
		if (Math.random() > 0.5f) {
			curing = true;
		} else {
			curing = false;
		}
		
//		oWith = CargaDatos.PBuena.width/2;
//		oHeight = CargaDatos.PBuena.height/2;
		
	}

	public void dibujar() {

		app.image(image, x, y);
	}



	public float chooseBuff(int i) {
		return buffos[i];

	}

	public float getCure() {
		if (curing) {
			return cure;			
		}
		return 0;
	}
	
	

}
