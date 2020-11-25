package guru.springframework.sfgpetclinic.controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.ModuleLayer.Controller;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fauxspring.ModelMapImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import guru.springframework.sfgpetclinic.fauxspring.Model;
import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.SpecialityMapService;
import guru.springframework.sfgpetclinic.services.map.VetMapService;

class VetControllerTest {

	VetService vetService;
	SpecialtyService specialtyService;
	VetController vetController;
	
	@BeforeEach
	void setUp() throws Exception {
		specialtyService = new SpecialityMapService();
		vetService = new VetMapService(specialtyService);
		vetController = new VetController(vetService);
		
	}

	@Test 
	void listVetsReturnsCorrectView() {
		 
	    Model model = new ModelMapImpl();
	    Set<Speciality> specialities = new HashSet<>();
	    		
		String result = vetController.listVets(model);
		
		assertEquals("vets/index", result);
		
	}

}
