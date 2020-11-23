package guru.springframework.sfgpetclinic.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.time.Duration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;


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
	
	@Test
	void testAssumptionTrue() {
		assumeTrue("GURU".equalsIgnoreCase(System.getenv("GURU_RUNTIME")));
	}
	
	@Test
	void testAssumptionTrueAssumptionIsTrue() {
		assumeTrue("GURU".equalsIgnoreCase("GURU"));
	}
	
	@EnabledOnOs(OS.MAC)
	@Test
	void testMeOnMac() {
		System.out.println();
	}
	
	@EnabledOnOs(OS.WINDOWS)
	@Test
	void testMeOnPC() {
		
	}
	
	@EnabledOnJre(JRE.OTHER)
	@Test
	void testMeOnJavaOther() {
		
	}
	
	@EnabledOnJre(JRE.JAVA_11)
	@Test
	void testMeOnJava11() {
		
	}
	
	@EnabledIfEnvironmentVariable(named = "USER", matches = "michaelcheich")
	@Test
	void testIfUserIsMe() {
		
	}
	
	
	
}























