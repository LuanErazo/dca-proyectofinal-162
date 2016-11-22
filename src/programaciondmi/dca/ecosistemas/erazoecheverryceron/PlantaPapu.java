package programaciondmi.dca.ecosistemas.erazoecheverryceron;

import java.util.ArrayList;
import java.util.LinkedList;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PShape;
import processing.core.PVector;
import programaciondmi.dca.core.EspecieAbstracta;
import programaciondmi.dca.core.PlantaAbstracta;
import programaciondmi.dca.ejecucion.Mundo;

public abstract class PlantaPapu extends PlantaAbstracta {

	protected PVector pos;
	protected float vida;
	protected boolean vive;
	protected PApplet app;
	protected PImage image;
	protected PShape fondo;
	protected float contCrecer;
	protected int oWith;
	protected int oHeight;
	protected long sleeping;
	private int ciclo;

	public PlantaPapu() {
		app = Mundo.ObtenerInstancia().getApp();
		fondo = app.loadShape("global_data/mapa.svg");
		x = (int) (Math.random() * (fondo.width - 50)) - app.width / 2;
		y = (int) (Math.random() * (fondo.height - 50)) - app.height / 2;
		sleeping = 20;
		pos = new PVector(x, y);
		contCrecer = 1;
		vive = true;
		vida = 200;

	}

	public PlantaPapu(int x, int y) {
		super(x, y);
		app = EcosistemaPapus.app;
		this.x = x;
		this.y = y;
		sleeping = 200;
		pos = new PVector(x, y);
		contCrecer = 1;
		vive = true;
		vida = 200;

	}

	@Override
	public void run() {
		while (vive) {
			try {
				// crecer();
				Thread.sleep(sleeping);
				contCrecer += 0.5f;
				ciclo++;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	protected void crecer() {

		if (image.width <= oWith && image.height <= oHeight) {
			image.resize((int) (oWith * contCrecer), (int) (oHeight * contCrecer));
		}
	}

	public void muerto(LinkedList<PlantaAbstracta> lista, PlantaAbstracta planta) {
		PlantaPapu plant = (PlantaPapu) planta;

		if (ciclo % 60 * 2 == 0) {
			vida -= 2;
		}
		if (vida < 0) {
			vive = false; 
		}

		if (plant.isVive() == false) {
			lista.remove(planta);
		}
	}

	@Override
	public boolean recibirDano(EspecieAbstracta lastimador) {
		if (lastimador instanceof HerviboroPapu) {
			HerviboroPapu hervi = (HerviboroPapu) lastimador;
			if (EcosistemaPapus.validar(pos.x, pos.y, hervi.getPos().x, hervi.getPos().y, 50)) {
				return true;
			}
		}
		return false;
	}

	// ============================== getters and setters
	// =================================================

	public float getVida() {
		return vida;
	}

	public void setVida(float vida) {
		this.vida = vida;
	}

	public boolean isVive() {
		return vive;
	}

	public void setVive(boolean vive) {
		this.vive = vive;
	}

	public PVector getPos() {
		return pos;
	}
}
