package programaciondmi.dca.ecosistemas.erazoecheverryceron;

import programaciondmi.dca.core.EcosistemaAbstracto;
import programaciondmi.dca.core.EspecieAbstracta;

public class HijoPapu extends EspeciePapu {

	public HijoPapu(EcosistemaAbstracto ecosistema) {
		super(ecosistema);
		
	}

	@Override
	public void dibujar() {
		app.fill(30,30,30);
		app.ellipse(pos.x, pos.y, 20, 20);
	}
	
	@Override
	public boolean recibirDano(EspecieAbstracta lastimador) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
