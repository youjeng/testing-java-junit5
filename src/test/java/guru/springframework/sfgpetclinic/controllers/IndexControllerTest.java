package guru.springframework.sfgpetclinic.controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IndexControllerTest {

	IndexController controller;

	@BeforeEach
	void setUp() throws Exception {
		controller = new IndexController();
	}

	@Test
	void index() {
		assertEquals("index", controller.index(), "Wrong view returned yo");
	}
	
	@Test
	void oupsHandler() {
		assertTrue("asdf".equals(controller.oupsHandler()), () -> "this is some expensice"
				+ "expensive method to run?");
	}

}
