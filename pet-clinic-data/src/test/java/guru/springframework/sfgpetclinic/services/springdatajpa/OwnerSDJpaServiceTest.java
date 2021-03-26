package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import guru.springframework.sfgpetclinic.repositories.PetRepository;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {
   @Mock
   OwnerRepository ownerRepository;
   @Mock
   PetRepository petRepository;
   @Mock
   PetTypeRepository petTypeRepository;
   @InjectMocks
    OwnerSDJpaService ownerSDJpaService;
    public static final String LAST_NAME = "Smith";

    Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(1l).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);
        Owner smith =  ownerSDJpaService.findByLastName(LAST_NAME);
        assertEquals(smith.getLastName(), LAST_NAME);
        verify(ownerRepository, times(1)).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> owners = new HashSet<>();
        Owner returnOwner1 = Owner.builder().id(1l).build();
        Owner returnOwner2 = Owner.builder().id(2l).build();
        owners.add(returnOwner1);
        owners.add(returnOwner2);
        when(ownerRepository.findAll()).thenReturn(owners);
        Set<Owner> allOwners = ownerSDJpaService.findAll();
        assertEquals(2, owners.size());
        assertNotNull(owners);
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));
        Owner owner = ownerSDJpaService.findById(anyLong());
        assertNotNull(owner);
    }
    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        Owner owner = ownerSDJpaService.findById(anyLong());
        assertNull(owner);
    }
    @Test
    void save() {
        when(ownerRepository.save(any())).thenReturn(returnOwner);
        Owner owner = ownerSDJpaService.save(any());
        verify(ownerRepository, times(1)).save(any());
        assertNotNull(owner);
    }
    @Test
    void delete() {
        ownerSDJpaService.delete(returnOwner);
        verify(ownerRepository, times(1)).delete(any());
    }
    @Test
    void deleteById() {
        ownerSDJpaService.deleteById(returnOwner.getId());
        verify(ownerRepository, times(1)).deleteById(anyLong());
    }
}

