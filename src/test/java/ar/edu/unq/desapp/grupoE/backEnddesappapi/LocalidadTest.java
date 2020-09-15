package ar.edu.unq.desapp.grupoE.backEnddesappapi;

import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.Localidad;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocalidadTest {


    @Test
    public void creo_una_localiad_con_nombre_provincia_cantidadPoblacion_y_si_esta_conectada() {
        Localidad nuevaLocalidad = new Localidad("Quilmes", "Buenos Aires", 400000, true);

        assertEquals(nuevaLocalidad.getnombre(), "Quilmes");
    }
}
