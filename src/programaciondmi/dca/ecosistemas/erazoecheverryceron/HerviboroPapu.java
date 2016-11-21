package programaciondmi.dca.ecosistemas.erazoecheverryceron;

import processing.core.PVector;
import programaciondmi.dca.core.EcosistemaAbstracto;
import programaciondmi.dca.core.EspecieAbstracta;
import programaciondmi.dca.core.PlantaAbstracta;
import programaciondmi.dca.core.interfaces.IApareable;
import programaciondmi.dca.core.interfaces.IHerbivoro;

public class HerviboroPapu extends EspeciePapu implements IHerbivoro, IApareable {

	private PVector tx;

	public HerviboroPapu(EcosistemaAbstracto ecosistema) {
		super(ecosistema);
		vida = 30;

		fuerza = 10;
		deff = 15;
		velocidad = 3;

	}

	@Override
	public EspecieAbstracta aparear(IApareable apareable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void mover() {

		if (ciclo % 60 * 3 == 0) {
			// Definir una direccion aleatoria cada 3 segundos
			int targetX = (int) (Math.random() * app.width);
			int targetY = (int) (Math.random() * app.height);
			PVector target = new PVector(targetX, targetY);
			dir = PVector.sub(target, pos);
			if (tx != null) {
				if (EcosistemaPapus.validar(pos.x, pos.y, tx.x, tx.y, 100)) {
					System.out.println("entro ciclo");
					dir = PVector.sub(tx, pos);
				}
			}
			dir.normalize();
			dir.mult(velocidad);
		}
			if (EcosistemaPapus.validar(pos.x, pos.y, dir.x, dir.y, 50)) {
				pos = tx;
			} else {
				pos.add(dir);
				
			}

	}

	@Override
	public void comerPlanta(PlantaAbstracta victima) {
		PlantaPapu planta = (PlantaPapu) victima;
		if (EcosistemaPapus.validar(pos.x, pos.y, planta.getPos().x, planta.getPos().y, 100)) {
			tx = planta.getPos();
		}
		if (EcosistemaPapus.validar(pos.x, pos.y, planta.getPos().x, planta.getPos().y, 50)) {
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
			vida += 0.5f;
		}

	}

}
