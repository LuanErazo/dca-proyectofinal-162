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
import programaciondmi.dca.ecosistemas.sarmientomanzanomoncada.EspecieAzul;
import programaciondmi.dca.ecosistemas.sarmientomanzanomoncada.EspecieBlanca;
import programaciondmi.dca.ecosistemas.sarmientomanzanomoncada.LogoEjemplo;
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
	private LinkedList<EspecieAbstracta> especies;

	/**
	 * Constructor
	 */
	public EcosistemaPapus() {
		 Mundo ref = Mundo.ObtenerInstancia();
		 Logo boton= new Logo("../data/Logo.svg", this);
		 ref.agregarBoton(boton);

		app = Mundo.ObtenerInstancia().getApp();
		datos = new CargaDatos();
		app.imageMode(PConstants.CENTER);

		poblarPlantas();
		CargaHilosPrimeros();
	}

	/**
	 * Ejecuta las primeras plantas desde sus hilos
	 */
	private void CargaHilosPrimeros() {
		for (EspecieAbstracta especieAbstracta : especies) {
			Thread especie = new Thread(especieAbstracta);
			especie.start();
		}
//		for (PlantaAbstracta plantaAbstracta : agregarPlantas) {
//			Thread planta = new Thread(plantaAbstracta);
//			planta.start();
//		}
	}

	/**
	 * Ejecuta los hilos de las plantas que el usuario coloca
	 */
	private void CargaHilosSegundos() {
		for (PlantaAbstracta plantaAbstracta : agregarPlantas) {
			Thread plantita = new Thread(plantaAbstracta);
			plantita.start();
		}

	}

	/**
	 * metodo display
	 */
	@Override
	public void dibujar() {
		antiCamMov();
		for (int i = 0; i < agregarPlantas.size(); i++) {
			PlantaPapu planta = (PlantaPapu) agregarPlantas.get(i);
			
			planta.dibujar();

			for (int j = 0; j < especies.size(); j++) {
				EspeciePapu papulin = (EspeciePapu) especies.get(j);
				if (planta.recibirDano(papulin)) {
					planta.muerto(agregarPlantas, planta);
				}
			}
		}
		
		synchronized (especies) {
			Iterator<EspecieAbstracta> iteradorEspecies = especies.iterator();
			while(iteradorEspecies.hasNext()){
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
		especies = new LinkedList<EspecieAbstracta>();
		EspeciePapu nueva = new HerviboroPapu(this);
		especies.add(nueva);
		nueva = new HerviboroPapu(this);
		especies.add(nueva);
		nueva = new HerviboroPapu(this);
		especies.add(nueva);
		nueva = new HerviboroPapu(this);
		especies.add(nueva);
		return especies;
	}

	/**
	 * Pobla con las plantas iniciales el lienzo
	 */

	@Override
	protected LinkedList<PlantaAbstracta> poblarPlantas() {
		agregarPlantas = new LinkedList<PlantaAbstracta>();
		LinkedList<PlantaAbstracta> plantasIniciales = new LinkedList<PlantaAbstracta>();
		for (int i = 0; i < 10; i++) {
			plantasIniciales.add(new PMala());
			plantasIniciales.add(new PBuena());

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
			agregarPlantas
					.add(new PBuena(app.mouseX - ((app.width / 2) - camX), app.mouseY - ((app.height / 2) - camY)));

		} else if (app.mousePressed && (app.mouseButton == PConstants.RIGHT)) {

			agregarPlantas
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
	
	public LinkedList<EspecieAbstracta> getHerviborospapus(){
		return especies;
	}

	public static boolean validar(float XUno, float YUno, float XDos, float YDos, float distancia) {
		if (PApplet.dist(XUno, YUno, XDos, YDos) <= distancia)
			return true;
		return false;
	}

}