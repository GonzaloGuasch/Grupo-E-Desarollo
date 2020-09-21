package ar.edu.unq.desapp.grupoE.backEnddesappapi;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.mocks.LocalityMock;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.mocks.ProjectMock;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;


class UserTest {
	private ProjectMock proyectoDeDeDosMilHabitantes;
	private ProjectMock proyectoDeMenosDeDosMilHabitantes;
	private User userDonador;
	private LocalityMock localidadMock;
	private LocalityMock localidadDeMenosDeDosMilHabitantes;

	@BeforeEach
	public void setUp(){
		localidadMock = new LocalityMock("lm", "bs", 2002, true);
		localidadDeMenosDeDosMilHabitantes = new LocalityMock("lm", "bs", 800, true);
		proyectoDeMenosDeDosMilHabitantes = new ProjectMock("Prueba", null, null,null, null, localidadDeMenosDeDosMilHabitantes);
		proyectoDeDeDosMilHabitantes = new ProjectMock("prueba", null,null, null, null, localidadMock);
		userDonador = new User("Prueba", "prueba@gmail.com", "1234", "apodo");
	}
	@Test
	void test001AnUserRecivesCeroPointsIfheDonatesLessThan1000() {
		userDonador.donateFor(proyectoDeDeDosMilHabitantes, 800);

		assertEquals(userDonador.getAmountOfPoints(), 0);
	}

	@Test
	void test002IfTheUserDonatesMoreThan1000HeOrSheRecivesTheSameAmountOfPoints() {
		userDonador.donateFor(proyectoDeDeDosMilHabitantes, 1001);

		assertEquals(userDonador.getAmountOfPoints(), 1001);
	}

	@Test
	void test003IfIsTheSecondDonationOfTheMonthHeOrSheReceiveAn500Bonus() {
		userDonador.donateFor(proyectoDeDeDosMilHabitantes, 1);
		userDonador.donateFor(proyectoDeDeDosMilHabitantes, 1);

		assertEquals(500, userDonador.getAmountOfPoints());
	}

	@Test
	void test004EveryUserHasAllDonationsRegistrated() {
		userDonador.donateFor(proyectoDeDeDosMilHabitantes, 1);

		assertEquals(1, userDonador.amountOfHistoricalDonations());
	}

	@Test
	void test005IfTheLocalityHasLessThan2000WhenYouDonateItGiveYouDoublePoints() {
		userDonador.donateFor(proyectoDeMenosDeDosMilHabitantes, 1000);

		assertEquals(userDonador.getAmountOfPoints(), 2000);
	}
}
