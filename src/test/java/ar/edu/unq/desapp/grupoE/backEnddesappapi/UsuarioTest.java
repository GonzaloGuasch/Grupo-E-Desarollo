package ar.edu.unq.desapp.grupoE.backEnddesappapi;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.mocks.LocalidadMock;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.mocks.ProjectMock;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;


class UsuarioTest {
	private ProjectMock proyectoDeDeDosMilHabitantes;
	private ProjectMock proyectoDeMenosDeDosMilHabitantes;
	private Usuario usuarioDonador;
	private LocalidadMock localidadMock;
	private LocalidadMock localidadDeMenosDeDosMilHabitantes;

	@BeforeEach
	public void setUp(){
		localidadMock = new LocalidadMock("lm", "bs", 2002, true);
		localidadDeMenosDeDosMilHabitantes = new LocalidadMock("lm", "bs", 800, true);
		proyectoDeMenosDeDosMilHabitantes = new ProjectMock("Prueba", null, null,null, null, localidadDeMenosDeDosMilHabitantes);
		proyectoDeDeDosMilHabitantes = new ProjectMock("prueba", null,null, null, null, localidadMock);
		usuarioDonador = new Usuario("Prueba", "prueba@gmail.com", "1234", "apodo");
	}
	@Test
	void test001UnUsuarioRecibeCeroPuntosAlDonarSiElProyectoTieneMenosDeDosMilHabitantesODonaMenosDeMilPesos() {
		usuarioDonador.donarAPor(proyectoDeDeDosMilHabitantes, 800);

		assertEquals(usuarioDonador.getCantidadDePuntos(), 0);
	}

	@Test
	void test002UnUsuarioRecibeLaMismaCantidadDePuntosSiDonaMasDeMilPesos() {
		usuarioDonador.donarAPor(proyectoDeDeDosMilHabitantes, 1001);

		assertEquals(usuarioDonador.getCantidadDePuntos(), 1001);
	}

	@Test
	void test003SiUnUsuarioDonaDosVecesElMismoMesRecibiraUnBonusDe500Puntos() {
		usuarioDonador.donarAPor(proyectoDeDeDosMilHabitantes, 1);
		usuarioDonador.donarAPor(proyectoDeDeDosMilHabitantes, 1);

		assertEquals(500, usuarioDonador.getCantidadDePuntos());
	}

	@Test
	void test004UnUsuarioTieneRegistradoTodasSusDonaciones() {
		usuarioDonador.donarAPor(proyectoDeDeDosMilHabitantes, 1);

		assertEquals(1, usuarioDonador.cantidadDeDonacionesHistoricas());
	}

	@Test
	void test005AlDonarAUnaLocalidadDeMenosDe2000SeRecibeElDobleDePuntos() {
		usuarioDonador.donarAPor(proyectoDeMenosDeDosMilHabitantes, 1000);

		assertEquals(usuarioDonador.getCantidadDePuntos(), 2000);
	}
}
