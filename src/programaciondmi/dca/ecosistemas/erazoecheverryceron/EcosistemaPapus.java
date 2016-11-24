package programaciondmi.dca.ecosistemas.erazoecheverryceron;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javafx.print.PageLayout;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
import programaciondmi.dca.core.EcosistemaAbstracto;
import programaciondmi.dca.core.EspecieAbstracta;
import programaciondmi.dca.core.PlantaAbstracta;
import programaciondmi.dca.ejecucion.Ejecutable;
import programaciondmi.dca.ejecucion.Mundo;

public class EcosistemaPapus extends EcosistemaAbstracto {
	// Para utilizar el app de forma rapida en cualquier clase y que no haya
	// sido llamado se debe escribir app = EcosistemaPapu.app;
	public static PApplet app;
	private CargaDatos datos;
	private int camX;
	private int camY;
	private LinkedList<PlantaAbstracta> agregarPlantas;
	private LinkedList<EspecieAbstracta> especiesPapu;

	/**
	 * Constructor
	 */
	public EcosistemaPapus() {
		app = Mundo.ObtenerInstancia().getApp();
		datos = new CargaDatos();
		Mundo ref = Mundo.ObtenerInstancia();
		Logo boton = new Logo("../data/Logo.svg", this);
		ref.agregarBoton(boton);

		app.imageMode(PConstants.CENTER);

		poblarPlantas();
	}

	/**
	 * Ejecuta las primeras plantas desde sus hilos
	 */
	private void CargaHilosPrimeros() {
		synchronized (especies) {
			for (EspecieAbstracta especieAbstracta : especies) {
				Thread especie = new Thread(especieAbstracta);
				if (especie.isAlive() == false) {
					especie.start();
				}
			}			
		}
	}

	/**
	 * Ejecuta los hilos de las plantas que el usuario coloca
	 */
	private void CargaHilosSegundos() {
//		for (PlantaAbstracta plantaAbstracta : agregarPlantas) {
//			Thread plantita = new Thread(plantaAbstracta);
//			plantita.start();
//		}
		synchronized (especies) {
			for (EspecieAbstracta especieAbstracta : especies) {
				Thread especie = new Thread(especieAbstracta);
				especie.start();
			}			
		}
	}

	/**
	 * metodo display
	 */
	@Override
	public void dibujar() {
		antiCamMov();
		for (int i = 0; i < agregarPlantas.size(); i++) {

		}
		synchronized (plantas) {
			Iterator<PlantaAbstracta> iteradorPlantas = plantas.iterator();
			while (iteradorPlantas.hasNext()) {
				PlantaAbstracta actual = iteradorPlantas.next();
				actual.dibujar();

				for (int j = 0; j < especies.size(); j++) {
					EspeciePapu papulin = (EspeciePapu) especiesPapu.get(j);
					if (actual.recibirDano(papulin)) {
						((PlantaPapu) actual)
								.muerto((LinkedList<PlantaAbstracta>) Mundo.ObtenerInstancia().getPlantas(), actual);
					}
				}
			}
		}

		synchronized (especies) {
			Iterator<EspecieAbstracta> iteradorEspecies = especies.iterator();
			while (iteradorEspecies.hasNext()) {
				EspecieAbstracta actual = iteradorEspecies.next();
				actual.dibujar();
				if (actual instanceof HerviboroPapu) {
					for (int i = 0; i < agregarPlantas.size(); i++) {
						((HerviboroPapu) actual).comerPlanta(agregarPlantas.get(i));
					}
				}
			}
		}

		generarPlantas();

	}

	/**
	 * Pobla con las primeras especies el lienzo
	 */

	@Override
	protected LinkedList<EspecieAbstracta> poblarEspecies() {
		especiesPapu = new LinkedList<EspecieAbstracta>();

		for (int i = 0; i < 2; i++) {
			especiesPapu.add(new HerviboroPapu(this));
			especiesPapu.add(new CanibalPapu(this));
			especiesPapu.add(new CarnivoroPapu(this));
			especiesPapu.add(new OmnivoroPapu(this));

		}
		return especiesPapu;
	}

	/**
	 * Pobla con las plantas iniciales el lienzo
	 */

	@Override
	protected LinkedList<PlantaAbstracta> poblarPlantas() {
		agregarPlantas = new LinkedList<PlantaAbstracta>();
		LinkedList<PlantaAbstracta> plantasIniciales = new LinkedList<PlantaAbstracta>();
		for (int i = 0; i < 10; i++) {
			plantasIniciales.add(new PMala((int) (Math.random() * 1000), (int) (Math.random() * 1000)));
			plantasIniciales.add(new PBuena((int) (Math.random() * 1000), (int) (Math.random() * 1000)));

		}
		agregarPlantas.addAll(plantasIniciales);
		return plantasIniciales;
	}

	@Override
	protected List<EspecieAbstracta> generarIndividuos() {
		return null;
	}

	@Override
	protected List<PlantaAbstracta> generarPlantas() {
		if (app.mousePressed && (app.mouseButton == PConstants.LEFT)) {
			Mundo.ObtenerInstancia().getPlantas()
					.add(new PBuena(app.mouseX - ((app.width / 2) - camX), app.mouseY - ((app.height / 2) - camY)));

		} else if (app.mousePressed && (app.mouseButton == PConstants.RIGHT)) {

			Mundo.ObtenerInstancia().getPlantas()
					.add(new PMala(app.mouseX - ((app.width / 2) - camX), app.mouseY - ((app.height / 2) - camY)));

		}
		return agregarPlantas;
	}

	private void antiCamMov() {

		if (app.mouseX < app.width / 4) {
			camX--;
		}
		if (app.mouseX > 3 * app.width / 4) {
			camX++;

		}
		if (app.mouseY < app.height / 4) {
			camY--;

		}
		if (app.mouseX < 3 * app.height / 4 && app.mouseY < app.height - 100) {
			camY++;

		}
	}

	public LinkedList<EspecieAbstracta> getHerviborospapus() {
		return especiesPapu;
	}

	public static boolean validar(float XUno, float YUno, float XDos, float YDos, float distancia) {
		if (PApplet.dist(XUno, YUno, XDos, YDos) <= distancia)
			return true;
		return false;
	}

}