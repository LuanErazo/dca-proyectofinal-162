package programaciondmi.dca.ecosistemas.erazoecheverryceron;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

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
	private LinkedList<PlantaAbstracta> plantasIniciales;
	private LinkedList<PlantaAbstracta> agregarPlantas;

	/**
	 * Constructor
	 */
	public EcosistemaPapus() {
//		Mundo ref = Mundo.ObtenerInstancia();
//		Logo boton= new Logo("../data/botonPlantaBuena.png", this);
//		ref.agregarBoton(boton);
		
		app = Mundo.ObtenerInstancia().getApp();
		datos = new CargaDatos();
		app.imageMode(PConstants.CENTER);
		agregarPlantas = new LinkedList<PlantaAbstracta>();

		
		poblarPlantas();
		CargaHilosPrimeros();
	}

	/**
	 * Ejecuta las primeras plantas desde sus hilos
	 */
	private void CargaHilosPrimeros() {
		for (PlantaAbstracta plantaAbstracta : plantasIniciales) {
			Thread plantita = new Thread(plantaAbstracta);
			plantita.start();
		}
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
		for (PlantaAbstracta planta : plantasIniciales) {
			planta.dibujar();
		}
		for (PlantaAbstracta planta : agregarPlantas) {
			planta.dibujar();
		}
		synchronized (especies) {
			Iterator<EspecieAbstracta> iteradorEspecies = especies.iterator();
			while(iteradorEspecies.hasNext()){
				EspecieAbstracta actual = iteradorEspecies.next();
				actual.dibujar();
			}
		}
		generarPlantas();
		
	}

	/**
	 * Pobla con las primeras especies el lienzo
	 */
	@Override
	protected LinkedList<EspecieAbstracta> poblarEspecies() {
		LinkedList<EspecieAbstracta> especies = new LinkedList<EspecieAbstracta>();
		EspeciePapu nueva = new EspeciePapu(this);
		especies.add(nueva);		
		nueva = new EspeciePapu(this);
		especies.add(nueva);		
		return especies;
	}

	/**
	 * Pobla con las plantas iniciales el lienzo
	 */
	@Override
	protected LinkedList<PlantaAbstracta> poblarPlantas() {
		plantasIniciales = new LinkedList<PlantaAbstracta>();
		for (int i = 0; i < 10; i++) {
			plantasIniciales.add(new PMala());
			plantasIniciales.add(new PBuena());

		}
		return plantasIniciales;
	}

	@Override
	protected List<EspecieAbstracta> generarIndividuos() {
		return null;
	}

	@Override
	protected List<PlantaAbstracta> generarPlantas() {
		if (app.mousePressed) {
//			antiCamMov();
			agregarPlantas.add(new PBuena(app.mouseX - ((app.width / 2)), app.mouseY - ((app.height / 2))));
		}
		return agregarPlantas;
	}



	private void crearPlantas() {
		if (app.mousePressed) {
			System.out.println("entra");
			agregarPlantas.add(new PBuena(app.mouseX - ((app.width / 2) - camX), app.mouseY - ((app.height / 2)) - camY));
		}
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
		if (app.mouseX < 3 * app.height / 4) {
			camY++;

		}
	}


	public static boolean validar(float XUno, float YUno, float XDos, float YDos, float distancia) {
		if (PApplet.dist(XUno, YUno, XDos, YDos) <= distancia)
			return true;
		return false;
	}

}