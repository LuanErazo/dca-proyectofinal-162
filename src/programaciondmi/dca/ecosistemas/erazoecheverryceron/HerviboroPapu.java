package programaciondmi.dca.ecosistemas.erazoecheverryceron;

import processing.core.PConstants;
import processing.core.PVector;
import programaciondmi.dca.core.EcosistemaAbstracto;
import programaciondmi.dca.core.EspecieAbstracta;
import programaciondmi.dca.core.PlantaAbstracta;
import programaciondmi.dca.core.interfaces.IApareable;
import programaciondmi.dca.core.interfaces.IHerbivoro;
import programaciondmi.dca.ecosistemas.sarmientomanzanomoncada.HijoBlanco;

public class HerviboroPapu extends EspeciePapu implements IHerbivoro, IApareable {

	private PVector tx;
	private boolean sexo;
	private int time;

	public HerviboroPapu(EcosistemaAbstracto ecosistema) {
		super(ecosistema);
		vida = 30;
		imagenes = CargaDatos.Segundo;
		fuerza = 10;
		deff = 15;
		velocidad = 3;

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
		app.fill(30,50,60);
		app.ellipse(dir.x, dir.y, 20, 20);
	}

	@Override
	public EspecieAbstracta aparear(IApareable apareable) {
		HerviboroPapu hijo = new HerviboroPapu(ecosistema);
		hijo.setPos(pos);
		ecosistema.agregarEspecie(hijo);
		return hijo;
	}

	
	
	@Override
	public void mover() {

		if (ciclo % 60 * 3 == 0) {
			// Definir una direccion aleatoria cada 3 segundos
//			int targetX = (int) (Math.random() * app.width);
//			int targetY = (int) (Math.random() * app.height);
//			PVector target = new PVector(targetX, targetY);
			dir = PVector.sub(temporal(), pos);
			if (pos.x < temporal().x) {
				System.out.println("entra");
				imagenes = CargaDatos.SegundoPerfil;
			} else if (pos.y < temporal().y) {
				System.out.println("YY");
				imagenes = CargaDatos.Segundo;
			} else if (pos.y > temporal().y) {
				System.out.println("YY");
				imagenes = CargaDatos.Segundo;
			} else if (pos.x > temporal().x) {
				System.out.println("YY");
				imagenes = CargaDatos.Segundo;
			}
//			if (tx != null) {
//				if (EcosistemaPapus.validar(pos.x, pos.y, tx.x, tx.y, 100)) {
//					dir = PVector.sub(tx, pos);
//				}
//				for (int i = 0; i < ecosistema.getEspecies().size(); i++) {
//					EspeciePapu papu = (EspeciePapu) ecosistema.getEspecies().get(i);
//					for (int j = 0; j < ecosistema.getEspecies().size(); j++) {
//						EspeciePapu papulin = (EspeciePapu) ecosistema.getEspecies().get(j);
//						if ( papu != papulin) {
//							if (papu instanceof IApareable) {
//								if (EcosistemaPapus.validar(pos.x, pos.y, papu.getPos().x, papu.getPos().y, 100)) {
//									// tx = papu.getPos();
//									dir = PVector.sub(papu.getPos(), pos);
//									System.out.println("pareja >:V");
//								}
//							}
//						}
//					}
//
//				}
			}
			dir.normalize();
			dir.mult(velocidad);
		
		
		pos.add(dir);
		if (ciclo % 60*5 == 0) {
			sexo = true;
		}

//		if (EcosistemaPapus.validar(pos.x, pos.y, dir.x, dir.y, 50)) {
//			pos = tx;
//		} else {
//			pos.add(dir);
//		}

	}

	public void apareable() {
		if (ecosistema.getEspecies().size() > 0) {
			for (int i = 0; i < ecosistema.getEspecies().size(); i++) {
				EspeciePapu papu = (EspeciePapu) ecosistema.getEspecies().get(i);
				if (papu.equals(this) == false) {
					if (papu instanceof IApareable) {
						if (sexo) {
							if (EcosistemaPapus.validar(pos.x, pos.y, papu.getPos().x, papu.getPos().y, 20)) {
								ecosistema.agregarEspecie(aparear((IApareable)
										papu));
								ecosistema.getEspecies().add(aparear((IApareable)
										papu));
								sexo = false;
							}
						}
					}
				}
			}
		}
	}

	@Override
	public void run() {
		while (vida > 0) {
			mover();
			enfermarse();
			apareable();
			try {
				Thread.sleep(33);
				ciclo++;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	@Override
	public void comerPlanta(PlantaAbstracta victima) {
		PlantaPapu planta = (PlantaPapu) victima;
		if (EcosistemaPapus.validar(pos.x, pos.y, planta.getPos().x, planta.getPos().y, 120)) {
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
			if (ciclo % 30 == 0) {
				vida += 1;
			}
			// System.out.println(enfermedad);
		}
	}

}
