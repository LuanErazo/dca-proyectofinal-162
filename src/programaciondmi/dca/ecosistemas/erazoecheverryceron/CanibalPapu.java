package programaciondmi.dca.ecosistemas.erazoecheverryceron;

import processing.core.PConstants;
import programaciondmi.dca.core.EcosistemaAbstracto;
import programaciondmi.dca.core.EspecieAbstracta;
import programaciondmi.dca.core.interfaces.ICanibal;

public class CanibalPapu extends EspeciePapu implements ICanibal {

	private int time;

	public CanibalPapu(EcosistemaAbstracto ecosistema) {
		super(ecosistema);
		imagenes = CargaDatos.Primero;
	}

	public void dibujar() {
		if (app.frameCount% 3 == 0) {
			time ++;
			if (time >= imagenes.length) {
				time = 0;
			}
		}
		
		app.imageMode(PConstants.CENTER);
		app.image(imagenes[time], pos.x, pos.y);
//		for (int i = 0; i < imagenes.length; i++) {
//			System.out.println(i);
//			app.image(imagenes[i], pos.x, pos.y);
//		}
	}
	
	@Override
	public void comer(EspecieAbstracta victima) {
		// TODO Auto-generated method stub
		
	}


}
