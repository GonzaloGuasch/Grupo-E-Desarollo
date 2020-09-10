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
		proyectoDeMenosDeDosMilHabitantes = new ProyectoMock(null, null, null, null);
		usuarioDonador = new Usuario("Prueba", "prueba@gmail.com", "1234", "apodo");
	}
	@Test
	void test001_Un_usuario_recibe_cero_puntos_al_donar_si_el_proyecto_tiene_menos_de_dos_mil_habitantes_o_dona_menos_de_mil_pesos() {
		usuarioDonador.donarAPor(proyectoDeMenosDeDosMilHabitantes, 800);

		assertEquals(usuarioDonador.getCantidadDePuntos(), 0);
	}

	@Test
	void test002_Un_usuario_recibe_la_misma_cantidad_de_puntos_si_dona_mas_de_mil_pesos() {
		usuarioDonador.donarAPor(proyectoDeMenosDeDosMilHabitantes, 1001);

		assertEquals(usuarioDonador.getCantidadDePuntos(), 1001);
	}

	@Test
	void test003_Si_un_usuario_dona_dos_veces_el_mismo_mes_recibira_un_bonus_de_500_puntos() {
		usuarioDonador.donarAPor(proyectoDeMenosDeDosMilHabitantes, 1);
		usuarioDonador.donarAPor(proyectoDeMenosDeDosMilHabitantes, 1);

		assertEquals(500, usuarioDonador.getCantidadDePuntos());
	}

	@Test
	void test004_un_usuario_tiene_registrado_todas_sus_donaciones() {
		usuarioDonador.donarAPor(proyectoDeMenosDeDosMilHabitantes, 1);

		assertEquals(1, usuarioDonador.cantidadDeDonacionesHistoricas());
	}

}
