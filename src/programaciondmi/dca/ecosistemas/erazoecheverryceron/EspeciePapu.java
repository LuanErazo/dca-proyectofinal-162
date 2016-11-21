package programaciondmi.dca.ecosistemas.erazoecheverryceron;

import processing.core.PApplet;
import programaciondmi.dca.core.EcosistemaAbstracto;
import programaciondmi.dca.core.EspecieAbstracta;
import programaciondmi.dca.ejecucion.Mundo;

public class EspeciePapu extends EspecieAbstracta {
	
	protected PApplet app;

	public EspeciePapu(EcosistemaAbstracto ecosistema) {
		super(ecosistema);	
		app = Mundo.ObtenerInstancia().getApp();
		x = (int) (Math.random()*600);
		y = (int) (Math.random()*500);
		
	}

	@Override
	public void run() {
		while (true) {
			try {
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}

	@Override
	public void dibujar() {
		app.fill(0);
		app.ellipse(x, y, 50, 50);
		
	}

	@Override
	public void mover() {
		
	}

	@Override
	public boolean recibirDano(EspecieAbstracta lastimador) {
		
		return false;
	}

}
