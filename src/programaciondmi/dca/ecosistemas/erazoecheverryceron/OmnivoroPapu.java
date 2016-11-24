package programaciondmi.dca.ecosistemas.erazoecheverryceron;

import processing.core.PConstants;
import processing.core.PVector;
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
		if (venom) {
			imagenes = CargaDatos.TerceroEnfermo;
			app.image(imagenes[time], pos.x, pos.y);

		} else{
			imagenes = CargaDatos.Tercero;
			app.image(imagenes[time], pos.x, pos.y, imagenes[time].width/2, imagenes[time].height/2);

		}
//		for (int i = 0; i < imagenes.length; i++) {
//			System.out.println(i);
//			app.image(imagenes[i], pos.x, pos.y);
//		}
	}
	
	@Override
	public void comer(EspecieAbstracta victima) {
		// TODO Auto-generated method stub
		
	}

	public void comerPlanta(PlantaAbstracta victima) {
		PlantaPapu planta = (PlantaPapu) victima;
		if (EcosistemaPapus.validar(pos.x, pos.y, planta.getX(), planta.getY(), 100)) {
			tx = new PVector(planta.getX(), planta.getY());
		}
		if (EcosistemaPapus.validar(pos.x, pos.y, planta.getX(), planta.getY(), 50)) {
			if (planta instanceof PBuena) {
				enfermedad = ((PBuena) planta).getCure();
				if (enfermedad <= 0) {
					venom = false;
				}
			}
			if (planta instanceof PMala) {
				enfermedad = ((PMala) planta).getToxic();
				if (enfermedad > 0) {
					venom = true;
				}
			}
			if (ciclo % 30 == 0) {
				vida += 1;
			}
			// System.out.println(enfermedad);
		}
	}

}
