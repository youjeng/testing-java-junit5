package guru.springframework.sfgpetclinic.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class IndexControllerTest {

	IndexController controller;

	@BeforeEach
	void setUp() throws Exception {
		controller = new IndexController();
	}

	@DisplayName("Test proper view name is returned for index page")
	@Test
	void index() {
		assertEquals("index", controller.index(), "Wrong view returned yo");
	}
	
	@Test
	@DisplayName("Tests Ops handler")
	void oupsHandler() {
		
		assertThrows(ValueNotFoundException.class, () -> {
			controller.oopsHandler();
			});
	}
	
	@Disabled("Demo of timeout")
	@Test
	@DisplayName("Testing times out")
	void testTimeOut() {
		assertTimeout(Duration.ofMillis(100), () -> {
			Thread.sleep(2000);
		});
	}

	@Disabled("Demo of timeout")
	@Test
	@DisplayName("Testing times out")
	void testTimeOutPrempt() {
		assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
			Thread.sleep(2000);
		});
	}
	
}
