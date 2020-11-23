package guru.springframework.sfgpetclinic.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class OwnerTest {

	@Disabled (value = "testing diasbled")
	@Test
	void dependantAssertions() {
		Owner owner = new Owner(1l, "Joe", "Buck");
		owner.setCity("warmville");
		owner.setTelephone("125456789");
		
		assertAll("propertiesTest",
				() -> assertAll("Person Properties",
						() -> assertEquals("Joe", owner.getFirstName(), "First Name did not match"),
						() -> assertEquals("Duck", owner.getLastName(), "Last Name did not match")),	
				() -> assertAll("Owner Properties",
						() -> assertEquals("warville", owner.getCity()),
						() -> assertEquals("125456789", owner.getTelephone())
				));
	}

}
