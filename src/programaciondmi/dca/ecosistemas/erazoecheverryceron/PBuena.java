package programaciondmi.dca.ecosistemas.erazoecheverryceron;

import programaciondmi.dca.core.EspecieAbstracta;

public class PBuena extends PlantaPapu {

	
	public PBuena() {
		image = CargaDatos.PBuena;
//		oWith = image.width;
//		oHeight = image.height;
		
	}
	
	public PBuena(int x, int y) {
		super(x, y);
		image = CargaDatos.PBuena;
//		oWith = image.width;
//		oHeight = image.height;
		
	}
	
	public void dibujar() {
		
		app.image(image, x, y);
		
	}

	@Override
	public boolean recibirDano(EspecieAbstracta lastimador) {
		// TODO Auto-generated method stub
		return false;
	}

}
