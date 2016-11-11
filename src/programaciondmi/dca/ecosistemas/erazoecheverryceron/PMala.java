package programaciondmi.dca.ecosistemas.erazoecheverryceron;

import programaciondmi.dca.core.EspecieAbstracta;

public class PMala extends PlantaPapu {

	private boolean venom;
	private float[] damages;
	private float toxic;
	private float damAtk;
	private float damDef;
	private float damVel;
	
	public PMala() {
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
		
	}
	
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
		
	}
	
	public void dibujar() {
		
		app.image(image, x, y); 
		
	}

	@Override
	public boolean recibirDano(EspecieAbstracta lastimador) {
		// TODO Auto-generated method stub
		return false;
	}
	


}
