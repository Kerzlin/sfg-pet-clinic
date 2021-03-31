package guru.springframework.sfgpetclinic.services.map;


import guru.springframework.sfgpetclinic.model.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PetMapServiceTest {

    private PetMapService petMapService;
    private final Long petId = 1L;

    @BeforeEach
    void setUp() {
        petMapService = new PetMapService();
        petMapService.save(Pet.builder().id(petId).build());
    }

    @Test
    public void findAll() {
        Set<Pet> pets = petMapService.findAll();
        assertEquals(1, pets.size());
    }

    @Test
    public void findByExistingId() {
        Pet pet = petMapService.findById(petId);
        assertEquals(pet.getId(), petId);
    }

    @Test
    public void findByIdNotExistingId() {
        Pet pet = petMapService.findById(5L);
        assertNull(pet);
    }

    @Test
    public void saveExistingId() {
        Pet savePet = Pet.builder().id(4L).build();
        Pet pet = petMapService.save(savePet);
        assertEquals(pet.getId(), savePet.getId());
    }

    @Test
    void deletePet() {
        petMapService.delete(petMapService.findById(petId));
        assertEquals(0, petMapService.findAll().size());
    }

    @Test
    void deleteByIdCorrectId() {
        petMapService.deleteById(petId);
        assertEquals(0, petMapService.findAll().size());
    }
}