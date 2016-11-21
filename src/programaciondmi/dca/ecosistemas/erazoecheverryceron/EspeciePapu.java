package programaciondmi.dca.ecosistemas.erazoecheverryceron;

import processing.core.PApplet;
import processing.core.PVector;
import programaciondmi.dca.core.EcosistemaAbstracto;
import programaciondmi.dca.core.EspecieAbstracta;
import programaciondmi.dca.ejecucion.Mundo;

public class EspeciePapu extends EspecieAbstracta {

	protected PApplet app;
	protected PVector pos;
	protected float vida;

	protected float fuerza;
	protected int velocidad;
	protected float deff;

	protected EspecieAbstracta parejaCercana;
	protected PVector dir;
	protected int ciclo;

	protected float[] buffos;

	protected float enfermedad;
	protected boolean venom;

	public EspeciePapu(EcosistemaAbstracto ecosistema) {
		super(ecosistema);
		app = Mundo.ObtenerInstancia().getApp();
		x = (int) (Math.random() * 600);
		y = (int) (Math.random() * 500);
		pos = new PVector(x, y);
		ciclo = 0;

		buffos = new float[3];

		buffos[0] = fuerza;
		buffos[1] = deff;
		buffos[2] = velocidad;

	}

	@Override
	public void dibujar() {
		app.fill(0);
		app.ellipse(pos.x, pos.y, 50, 50);
	}

	protected void enfermarse() {
		if (venom) {
			if (ciclo % 60 * 5 == 0) {
				vida -= enfermedad;
			}
		}

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

	@Override
	public void mover() {

		if (ciclo % 60 * 3 == 0) {
			// Definir una direccion aleatoria cada 3 segundos
			int targetX = (int) (Math.random() * app.width);
			int targetY = (int) (Math.random() * app.height);
			PVector target = new PVector(targetX, targetY);
			dir = PVector.sub(target, pos);
			dir.normalize();
			dir.mult(velocidad);
		}

		pos.add(dir);

	}

	@Override
	public boolean recibirDano(EspecieAbstracta lastimador) {
		EspeciePapu papu = (EspeciePapu) lastimador;
		PVector v = new PVector(papu.getX(), papu.getY());

		if (EcosistemaPapus.validar(pos.x, pos.y, v.x, v.y, 10)) {
			if (this.venom == true) {
				papu.setVenom(true);
			}
			return true;

		}

		return false;
	}

	public void noneBuffo(int i) {
		this.buffos[i] = 0;
	}

	// ==========================getters and setters ======================

	public float getBuffo(int i) {
		return buffos[i];

	}

	public float getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public boolean isVenom() {
		return venom;
	}

	public void setVenom(boolean venom) {
		this.venom = venom;
	}

	public PVector getPos() {
		return pos;
	}

}
