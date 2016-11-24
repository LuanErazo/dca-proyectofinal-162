package programaciondmi.dca.ecosistemas.erazoecheverryceron;

import processing.core.PConstants;
import processing.core.PVector;
import programaciondmi.dca.core.EcosistemaAbstracto;
import programaciondmi.dca.core.EspecieAbstracta;
import programaciondmi.dca.core.interfaces.ICarnivoro;

public class CarnivoroPapu extends EspeciePapu implements ICarnivoro {
	private boolean caceria;
	private PVector tx;
	private int time;

	public CarnivoroPapu(EcosistemaAbstracto ecosistema) {
		super(ecosistema);
		imagenes = CargaDatos.Cuatro;
		velocidad = 5;
		vida = 50;
		fuerza = 30;
		deff = 20;

	}

	@Override
	public void run() {
		while (vida > 0) {
			mover();
			try {
				Thread.sleep(33);
				ciclo++;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

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
			imagenes = CargaDatos.CuatroPerfil;
		}
		app.imageMode(app.CENTER);
		app.image(imagenes[time], pos.x, pos.y);
	}	
	
	@Override
	public void mover() {
		if (caceria == false) {

			if (ciclo % 60 * 2 == 0) {
				System.out.println("el ciclo cumple");
				// Definir una direccion aleatoria cada 3 segundos
				int targetX = (int) (Math.random() * app.width);
				int targetY = (int) (Math.random() * app.height);
				PVector target = new PVector(targetX, targetY);
				dir = PVector.sub(target, pos);
			}
		} else {
			dir = PVector.sub(tx, pos);
		}

		dir.normalize();
		dir.mult(velocidad);

		pos.add(dir);

	}

	@Override
	public void comer(EspecieAbstracta victima) {
		EspeciePapu  papuV = (EspeciePapu) victima;
		PVector v = new PVector(papuV.getX(), papuV.getY());
		if (EcosistemaPapus.validar(pos.x, pos.y, v.x, v.y, 50)) {
			if (victima instanceof HerviboroPapu) {
				caceria = true;
				tx = v;
				if (EcosistemaPapus.validar(pos.x, pos.y, v.x, v.y, 10)) {
					int ram = (int) app.random(3);
					
					if (ram == 0) {
						fuerza += papuV.getBuffo(ram);
						papuV.noneBuffo(ram);
					}
					
					if (ram == 1){
						deff += papuV.getBuffo(ram);
						papuV.noneBuffo(ram);

					}
					
					if (ram == 2) {
						velocidad += papuV.getBuffo(ram);
						papuV.noneBuffo(ram);
					}
					
					vida += papuV.getVida();
				}
			}

		}


	}

}
