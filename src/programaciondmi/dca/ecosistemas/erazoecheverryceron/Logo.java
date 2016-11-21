package programaciondmi.dca.ecosistemas.erazoecheverryceron;

import programaciondmi.dca.core.EcosistemaAbstracto;
import programaciondmi.dca.core.LogoAbstracto;

public class Logo extends LogoAbstracto {

	public Logo(String rutaLogo, EcosistemaAbstracto ecosistema) {
		super(rutaLogo, ecosistema);
	}

	@Override
	public void click() {
		
		EcosistemaPapus eco = (EcosistemaPapus) ecosistema;
		System.out.println("Hizo click el ecosistema"+eco);
			
	}

}
