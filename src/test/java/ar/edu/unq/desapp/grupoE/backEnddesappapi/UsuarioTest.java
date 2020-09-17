package ar.edu.unq.desapp.grupoE.backEnddesappapi;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.mocks.LocalidadMock;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.mocks.ProyectoMock;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.Localidad;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;


class UsuarioTest {
	ProyectoMock proyectoDeDeDosMilHabitantes;
	ProyectoMock proyectoDeMenosDeDosMilHabitantes;
	Usuario usuarioDonador;
	LocalidadMock localidadMock;
	LocalidadMock localidadDeMenosDeDosMilHabitantes;

	@BeforeEach
	public void setUp(){
		localidadMock = new LocalidadMock("lm", "bs", 2002, true);
		localidadDeMenosDeDosMilHabitantes = new LocalidadMock("lm", "bs", 800, true);
		proyectoDeMenosDeDosMilHabitantes = new ProyectoMock("Prueba", null, null,null, null, localidadDeMenosDeDosMilHabitantes);
		proyectoDeDeDosMilHabitantes = new ProyectoMock("prueba", null,null, null, null, localidadMock);
		usuarioDonador = new Usuario("Prueba", "prueba@gmail.com", "1234", "apodo");
	}
	@Test
	void test001_Un_usuario_recibe_cero_puntos_al_donar_si_el_proyecto_tiene_menos_de_dos_mil_habitantes_o_dona_menos_de_mil_pesos() {
		usuarioDonador.donarAPor(proyectoDeDeDosMilHabitantes, 800);

		assertEquals(usuarioDonador.getCantidadDePuntos(), 0);
	}

	@Test
	void test002_Un_usuario_recibe_la_misma_cantidad_de_puntos_si_dona_mas_de_mil_pesos() {
		usuarioDonador.donarAPor(proyectoDeDeDosMilHabitantes, 1001);

		assertEquals(usuarioDonador.getCantidadDePuntos(), 1001);
	}

	@Test
	void test003_Si_un_usuario_dona_dos_veces_el_mismo_mes_recibira_un_bonus_de_500_puntos() {
		usuarioDonador.donarAPor(proyectoDeDeDosMilHabitantes, 1);
		usuarioDonador.donarAPor(proyectoDeDeDosMilHabitantes, 1);

		assertEquals(500, usuarioDonador.getCantidadDePuntos());
	}

	@Test
	void test004_un_usuario_tiene_registrado_todas_sus_donaciones() {
		usuarioDonador.donarAPor(proyectoDeDeDosMilHabitantes, 1);

		assertEquals(1, usuarioDonador.cantidadDeDonacionesHistoricas());
	}

	@Test
	void test005_al_donar_a_una_localidad_de_menos_de_2000_se_recibe_el_doble_de_puntos() {
		usuarioDonador.donarAPor(proyectoDeMenosDeDosMilHabitantes, 1000);

		assertEquals(usuarioDonador.getCantidadDePuntos(), 2000);
	}
}
