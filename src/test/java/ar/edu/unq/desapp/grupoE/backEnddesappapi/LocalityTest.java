package ar.edu.unq.desapp.grupoE.backEnddesappapi;

import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.Locality;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocalityTest {


    @Test
    public void aLocalityHasANameProvinceAmountOfPeopleAndAVaribleToSeeIfIsConected() {
        Locality nuevaLocality = new Locality("Quilmes", "Buenos Aires", 400000, true);

        assertEquals(nuevaLocality.getName(), "Quilmes");
    }
}
