package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;
    final Long ownerId = 1L;
    final String lastName = "Kerzlin";

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        ownerMapService.save(Owner.builder().id(ownerId).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> owner = ownerMapService.findAll();
        assertEquals(1, owner.size());
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(ownerId);
        assertEquals(ownerId, owner.getId());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Owner owner = Owner.builder().id(id).build();
        Owner ownerSaved = ownerMapService.save(owner);
        assertEquals(id, ownerSaved.getId());
    }
    @Test
    void saveNoId() {
        Owner owner = Owner.builder().build();
        Owner ownerSaved =  ownerMapService.save(owner);
        assertNotNull(ownerSaved);
        assertNotNull(ownerSaved.getId());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(ownerId);
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerId));
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner owner = ownerMapService.findByLastName(lastName);
        assertEquals(lastName, owner.getLastName());
        assertNotNull(owner.getLastName());
    }

    @Test
    void findByLastNameNotFound() {
        Owner owner = ownerMapService.findByLastName("Milivojevic");
        assertNull(owner);
    }
    @Test
    void findAllByLastNameLike() {
    }
}