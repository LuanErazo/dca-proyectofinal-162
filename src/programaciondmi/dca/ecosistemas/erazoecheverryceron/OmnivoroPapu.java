package programaciondmi.dca.ecosistemas.erazoecheverryceron;

import processing.core.PConstants;
import programaciondmi.dca.core.EcosistemaAbstracto;
import programaciondmi.dca.core.EspecieAbstracta;
import programaciondmi.dca.core.PlantaAbstracta;
import programaciondmi.dca.core.interfaces.IOmnivoro;

public class OmnivoroPapu extends EspeciePapu implements IOmnivoro {

	private int time;

	public OmnivoroPapu(EcosistemaAbstracto ecosistema) {
		super(ecosistema);
		imagenes = CargaDatos.Tercero;
	}
	
	public void dibujar() {
		if (app.frameCount% 2 == 0) {
			time ++;
			if (time >= imagenes.length) {
				time = 0;
			}
		}
		
		app.imageMode(PConstants.CENTER);
		app.image(imagenes[time], pos.x, pos.y);
		app.fill(30,50,60);
		app.ellipse(dir.x, dir.y, 20, 20);
//		for (int i = 0; i < imagenes.length; i++) {
//			System.out.println(i);
//			app.image(imagenes[i], pos.x, pos.y);
//		}
		if (app.frameCount%1 == 0) {
			time ++;
			if (time >= imagenes.length) {
				time = 0;
			}
		}
		
		if (pos.x < temporal().x) {
			System.out.println("entra");
			imagenes = CargaDatos.TerceroPerfil;
		}
		app.imageMode(app.CENTER);
		app.image(imagenes[time], pos.x, pos.y);
	}
	
	@Override
	public void comer(EspecieAbstracta victima) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void comerPlanta(PlantaAbstracta victima) {
		// TODO Auto-generated method stub
		
	}

}
