package programaciondmi.dca.ecosistemas.erazoecheverryceron;

import processing.core.PConstants;
import programaciondmi.dca.core.EcosistemaAbstracto;
import programaciondmi.dca.core.EspecieAbstracta;

public class HijoPapu extends EspeciePapu {

	private int time;

	public HijoPapu(EcosistemaAbstracto ecosistema) {
		super(ecosistema);
		imagenes = CargaDatos.Bebe;
	}

	@Override
	public void dibujar() {
		if (app.frameCount% 2 == 0) {
			time ++;
			if (time >= imagenes.length) {
				time = 0;
			}
		}
		
		app.imageMode(PConstants.CENTER);
		app.image(imagenes[time], pos.x, pos.y);
	}

	@Override
	public boolean recibirDano(EspecieAbstracta lastimador) {

		return false;
	}

}
