package programaciondmi.dca.ecosistemas.erazoecheverryceron;

import programaciondmi.dca.core.EspecieAbstracta;

public class PMala extends PlantaPapu {

	private boolean venom;
	private float[] damages;
	private float toxic;
	private float damAtk;
	private float damDef;
	private float damVel;
		
	public PMala(int x, int y) {
		super(x, y);
		image = CargaDatos.PMala;
//		oWith = image.width;
//		oHeight = image.height;
		toxic = (float) (Math.random()*20);
		damAtk = (float) (Math.random()*10);
		damDef = (float) (Math.random()*10);
		damVel = (float) (Math.random()*10);
		
		damages = new float[3];
		
		damages[0] = damAtk;
		damages[1] = damDef;
		damages[2] = damVel;	
		
		if (Math.random() > 0.5f) {
			venom = true;
		} else {
			venom = false;
		}
	}
	
	public void dibujar() {
		
		app.image(CargaDatos.PMala, x, y); 
		
	}

	
	public float chooseDamage(){
		return damages[(int) app.random(3)];
		
	}
	
	
	// ========================================== Getters and Setters ================================

	public float getToxic(){
		if (venom) {
			return toxic;
		} else {
			return 0;
		}
	}
	
}
