package ar.edu.unq.desapp.grupoE.backEnddesappapi;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.mocks.ProyectoMock;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class UsuarioTest {
	ProyectoMock proyectoDeMenosDeDosMilHabitantes;
	Usuario usuarioDonador;

	@BeforeEach
	public void setUp(){
		proyectoDeMenosDeDosMilHabitantes = new ProyectoMock();
		usuarioDonador = new Usuario("Prueba", "prueba@gmail.com", "1234", "apodo");
	}
	@Test
	void test001_Un_usuario_recibe_cero_puntos_al_donar_si_el_proyecto_tiene_menos_de_dos_mil_habitantes_o_dona_menos_de_mil_pesos() {
		usuarioDonador.donarAPor(proyectoDeMenosDeDosMilHabitantes, 800);

		assertEquals(usuarioDonador.getCantidadDePuntos(), 0);
	}

	@Test
	void test002_Un_Usuario_Recibe_la_misma_cantidad_de_puntos_si_dona_mas_de_mil_pesos(){
		usuarioDonador.donarAPor(proyectoDeMenosDeDosMilHabitantes, 1001);

		assertEquals(usuarioDonador.getCantidadDePuntos(), 1001);
	}

}
