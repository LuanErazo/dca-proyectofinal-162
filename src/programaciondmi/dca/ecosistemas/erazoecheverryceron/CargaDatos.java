package programaciondmi.dca.ecosistemas.erazoecheverryceron;

import processing.core.PApplet;
import processing.core.PImage;

public class CargaDatos {

	private PApplet app;
	public static PImage PBuena;
	public static PImage PMala;
	public static PImage botonPlantaMala;
	public static PImage botonPlantaBuena;
	public static PImage[] Primero = new PImage[12];
	public static PImage[] Segundo = new PImage[12];
	public static PImage[] Tercero = new PImage[12];
	public static PImage[] Cuatro = new PImage[12];
	public static PImage[] PrimeroEnfermo = new PImage[12];
	public static PImage[] SegundoEnfermo = new PImage[12];
	public static PImage[] TerceroEnfermo = new PImage[12];
	public static PImage[] CuatroEnfermo = new PImage[12];
	public static PImage[] PrimeroEnfermitoFinal = new PImage[12];
	public static PImage[] SegundoEnfermitoFinal = new PImage[12];
	public static PImage[] TerceroEnfermitoFinal = new PImage[12];
	public static PImage[] CuatroEnfermitoFinal = new PImage[12];
	public static PImage[] PrimeroPerfil = new PImage[12];
	public static PImage[] SegundoPerfil = new PImage[12];
	public static PImage[] TerceroPerfil = new PImage[12];
	public static PImage[] CuatroPerfil = new PImage[12];
	public static PImage[] PrimeroPerfilEnfermo = new PImage[12];
	public static PImage[] SegundoPerfilEnfermo = new PImage[12];
	public static PImage[] TerceroPerfilEnfermo = new PImage[12];
	public static PImage[] CuatroPerfilEnfermo = new PImage[12];
	public static PImage[] PrimeroPerfilEnfermitoFinal = new PImage[12];
	public static PImage[] SegundoPerfilEnfermitoFinal= new PImage[12];
	public static PImage[] TerceroPerfilEnfermitoFinal= new PImage[12];
	public static PImage[] CuatroPerfilEnfermitoFinal= new PImage[12];

	public CargaDatos() {
		app = EcosistemaPapus.app;
		PBuena = app.loadImage("../data/plantaBuena.png");
		PMala = app.loadImage("../data/plantaMala.png");
		botonPlantaBuena = app.loadImage("../data/botonPlantaBuena.png");
		botonPlantaMala = app.loadImage("../data/botonPlantaMala.png");
		for (int i = 0; i < Primero.length; i++) {
			if (i < 10) {
				Primero[i] = app.loadImage("../data/Frontal/Primero/Primero0" + i + ".png");							
			} else {
				Primero[i] = app.loadImage("../data/Frontal/Primero/Primero" + i + ".png");							
			}
		}
		for (int i = 0; i < Segundo.length; i++) {
			if (i < 10) {
				Segundo[i] = app.loadImage("../data/Frontal/Segundo/Segundo0" + i + ".png");							
			} else {
				Segundo[i] = app.loadImage("../data/Frontal/Segundo/Segundo" + i + ".png");							
			}
		}
		for (int i = 0; i < Tercero.length; i++) {
			if (i < 10) {
				Tercero[i] = app.loadImage("../data/Frontal/Tercero/Tercero0" + i + ".png");							
			} else {
				Tercero[i] = app.loadImage("../data/Frontal/Tercero/Tercero" + i + ".png");							
			}
		}
		for (int i = 0; i < Cuatro.length; i++) {
			if (i < 10) {
				Cuatro[i] = app.loadImage("../data/Frontal/Cuatro/Cuatro0" + i + ".png");							
			} else {
				Cuatro[i] = app.loadImage("../data/Frontal/Cuatro/Cuatro" + i + ".png");							
			}
		}
		for (int i = 0; i < PrimeroEnfermo.length; i++) {
			if (i < 10) {
				PrimeroEnfermo[i] = app.loadImage("../data/Frontal/PrimeroEnfermo/PrimeroEnfermo0" + i + ".png");							
			} else {
				PrimeroEnfermo[i] = app.loadImage("../data/Frontal/PrimeroEnfermo/PrimeroEnfermo" + i + ".png");							
			}
		}
		for (int i = 0; i < SegundoEnfermo.length; i++) {
			if (i < 10) {
				SegundoEnfermo[i] = app.loadImage("../data/Frontal/SegundoEnfermo/SegundoEnfermo0" + i + ".png");							
			} else {
				SegundoEnfermo[i] = app.loadImage("../data/Frontal/SegundoEnfermo/SegundoEnfermo" + i + ".png");							
			}
		}
		for (int i = 0; i < TerceroEnfermo.length; i++) {
			if (i < 10) {
				TerceroEnfermo[i] = app.loadImage("../data/Frontal/TerceroEnfermo/TerceroEnfermo0" + i + ".png");							
			} else {
				TerceroEnfermo[i] = app.loadImage("../data/Frontal/TerceroEnfermo/TerceroEnfermo" + i + ".png");							
			}
		}		for (int i = 0; i < CuatroEnfermo.length; i++) {
			if (i < 10) {
				CuatroEnfermo[i] = app.loadImage("../data/Frontal/CuatroEnfermo/CuatroEnfermo0" + i + ".png");							
			} else {
				CuatroEnfermo[i] = app.loadImage("../data/Frontal/CuatroEnfermo/CuartoEnfermo" + i + ".png");							
			}
		}
		for (int i = 0; i < PrimeroEnfermitoFinal.length; i++) {
			if (i < 10) {
				PrimeroEnfermitoFinal[i] = app.loadImage("../data/Frontal/PrimeroEnfermitoFinal/PrimeroEnfermitoFinal0" + i + ".png");							
			} else {
				PrimeroEnfermitoFinal[i] = app.loadImage("../data/Frontal/PrimeroEnfermitoFinal/PrimeroEnfermitoFinal" + i + ".png");							
			}
		}
		for (int i = 0; i < SegundoEnfermitoFinal.length; i++) {
			if (i < 10) {
				SegundoEnfermitoFinal[i] = app.loadImage("../data/Frontal/SegundoEnfermitoFinal/SegundoEnfermitoFinal0" + i + ".png");							
			} else {
				SegundoEnfermitoFinal[i] = app.loadImage("../data/Frontal/SegundoEnfermitoFinal/SegundoEnfermitoFinal" + i + ".png");							
			}
		}
		for (int i = 0; i < TerceroEnfermitoFinal.length; i++) {
			if (i < 10) {
				TerceroEnfermitoFinal[i] = app.loadImage("../data/Frontal/TerceroEnfermitoFinal/TerceroEnfermitoFinal0" + i + ".png");							
			} else {
				TerceroEnfermitoFinal[i] = app.loadImage("../data/Frontal/TerceroEnfermitoFinal/TerceroEnfermitoFinal" + i + ".png");							
			}
		}
		for (int i = 0; i < CuatroEnfermitoFinal.length; i++) {
			if (i < 10) {
				CuatroEnfermitoFinal[i] = app.loadImage("../data/Frontal/CuatroEnfermitoFinal/CuatroEnfermitoFinal0" + i + ".png");							
			} else {
				CuatroEnfermitoFinal[i] = app.loadImage("../data/Frontal/CuatroEnfermitoFinal/CuatroEnfermitoFinal" + i + ".png");							
			}
		}
		for (int i = 0; i < PrimeroPerfil.length; i++) {
			if (i < 10) {
				PrimeroPerfil[i] = app.loadImage("../data/Perfil/PrimeroPerfil/PrimeroPerfil0" + i + ".png");							
			} else {
				PrimeroPerfil[i] = app.loadImage("../data/Perfil/PrimeroPerfil/PrimeroPerfil" + i + ".png");							
			}
		}
		for (int i = 0; i < SegundoPerfil.length; i++) {
			if (i < 10) {
				SegundoPerfil[i] = app.loadImage("../data/Perfil/SegundoPerfil/SegundoPerfil0" + i + ".png");							
			} else {
				SegundoPerfil[i] = app.loadImage("../data/Perfil/SegundoPerfil/SegundoPerfil" + i + ".png");							
			}
		}
		for (int i = 0; i < TerceroPerfil.length; i++) {
			if (i < 10) {
				TerceroPerfil[i] = app.loadImage("../data/Perfil/TerceroPerfil/TercerPerfil0" + i + ".png");							
			} else {
				TerceroPerfil[i] = app.loadImage("../data/Perfil/TerceroPerfil/TercerPerfil" + i + ".png");							
			}
		}
		for (int i = 0; i < CuatroPerfil.length; i++) {
			if (i < 10) {
				CuatroPerfil[i] = app.loadImage("../data/Perfil/CuartoPerfil/CuatroPerfil0" + i + ".png");							
			} else {
				CuatroPerfil[i] = app.loadImage("../data/Perfil/CuartoPerfil/CuatroPerfil" + i + ".png");							
			}
		}
		for (int i = 0; i < PrimeroPerfilEnfermo.length; i++) {
			if (i < 10) {
				PrimeroPerfilEnfermo[i] = app.loadImage("../data/Perfil/PrimeroPerfilEnfermo/PrimeroPerfilEnfermo0" + i + ".png");							
			} else {
				PrimeroPerfilEnfermo[i] = app.loadImage("../data/Perfil/PrimeroPerfilEnfermo/PrimeroPerfilEnfermo" + i + ".png");							
			}
		}
		for (int i = 0; i <SegundoPerfilEnfermo.length; i++) {
			if (i < 10) {
				SegundoPerfilEnfermo[i] = app.loadImage("../data/Perfil/SegundoPerfilEnfermo/SegundoPerfilEnfermo0" + i + ".png");							
			} else {
				SegundoPerfilEnfermo[i] = app.loadImage("../data/Perfil/SegundoPerfilEnfermo/SegundoPerfilEnfermo" + i + ".png");							
			}
		}
		for (int i = 0; i <TerceroPerfilEnfermo.length; i++) {
			if (i < 10) {
				TerceroPerfilEnfermo[i] = app.loadImage("../data/Perfil/TercerPerfilEnfermo/TercerPerfilEnfermo0" + i + ".png");							
			} else {
				TerceroPerfilEnfermo[i] = app.loadImage("../data/Perfil/TercerPerfilEnfermo/TercerPerfilEnfermo" + i + ".png");							
			}
		}
		for (int i = 0; i <CuatroPerfilEnfermo.length; i++) {
			if (i < 10) {
				CuatroPerfilEnfermo[i] = app.loadImage("../data/Perfil/CuartoPerfilEnfermo/CuatroPerfilEnfermo0" + i + ".png");							
			} else {
				CuatroPerfilEnfermo[i] = app.loadImage("../data/Perfil/CuartoPerfilEnfermo/CuatroPerfilEnfermo" + i + ".png");							
			}
		}
		for (int i = 0; i <PrimeroPerfilEnfermitoFinal.length; i++) {
			if (i < 10) {
				PrimeroPerfilEnfermitoFinal[i] = app.loadImage("../data/Perfil/PrimeroPerfilEnfermitoFinal/PrimeroPerfilEnfermitoFinal0" + i + ".png");							
			} else {
				PrimeroPerfilEnfermitoFinal[i] = app.loadImage("../data/Perfil/PrimeroPerfilEnfermitoFinal/PrimeroPerfilEnfermitoFinal" + i + ".png");							
			}
		}
		for (int i = 0; i <SegundoPerfilEnfermitoFinal.length; i++) {
			if (i < 10) {
				SegundoPerfilEnfermitoFinal[i] = app.loadImage("../data/Perfil/SegundoPerfilEnfermitoFinal/SegundoPerfilEnfermitoFinal0" + i + ".png");							
			} else {
				SegundoPerfilEnfermitoFinal[i] = app.loadImage("../data/Perfil/SegundoPerfilEnfermitoFinal/SegundoPerfilEnfermitoFinal" + i + ".png");							
			}
		}
		for (int i = 0; i <TerceroPerfilEnfermitoFinal.length; i++) {
			if (i < 10) {
				TerceroPerfilEnfermitoFinal[i] = app.loadImage("../data/Perfil/TercerPerfilEnfermitoFinal/TercerPerfilEnfermitoFinal0" + i + ".png");							
			} else {
				TerceroPerfilEnfermitoFinal[i] = app.loadImage("../data/Perfil/TercerPerfilEnfermitoFinal/TercerPerfilEnfermitoFinal" + i + ".png");							
			}
		}
		for (int i = 0; i <CuatroPerfilEnfermitoFinal.length; i++) {
			if (i < 10) {
				CuatroPerfilEnfermitoFinal[i] = app.loadImage("../data/Perfil/CuatroPerfilEnfermitoFinal/CuatroPerfilEnfermitoFinal0" + i + ".png");							
			} else {
				CuatroPerfilEnfermitoFinal[i] = app.loadImage("../data/Perfil/CuatroPerfilEnfermitoFinal/CuatroPerfilEnfermitoFinal" + i + ".png");							
			}
		}
	}
}
