package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

class PetControllerTest {

    MockMvc mockMvc;
    @Mock
    PetService petService;
    @Mock
    OwnerService ownerService;
    @Mock
    PetTypeService petTypeService;
    @InjectMocks
    PetController petController;
    private static final String VIEWS_PETS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdatePetForm";

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(petController).build();
    }

    @Test
    void initCreationForm() throws Exception {
        mockMvc.perform(get("/owners/1/pets/new"))
                .andExpect(model().attributeExists("pet"))
                .andExpect(model().attributeExists("owner"))
                .andExpect(view().name(VIEWS_PETS_CREATE_OR_UPDATE_FORM));
    }
}