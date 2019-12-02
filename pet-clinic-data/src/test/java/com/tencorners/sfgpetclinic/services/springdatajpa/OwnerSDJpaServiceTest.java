package com.tencorners.sfgpetclinic.services.springdatajpa;

import com.tencorners.sfgpetclinic.model.Owner;
import com.tencorners.sfgpetclinic.repositories.OwnerRepository;
import com.tencorners.sfgpetclinic.repositories.PetRepository;
import com.tencorners.sfgpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    public static final String LAST_NAME = "Smith";

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;

    Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner = new Owner();
        returnOwner.setId(1L);
        returnOwner.setLastName(LAST_NAME);
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

        Owner owner = ownerSDJpaService.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, owner.getLastName());

        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {
        // setup the mock data
        Set<Owner> ownerSet = new HashSet<>();
        ownerSet.add(returnOwner);

        when(ownerRepository.findAll()).thenReturn(ownerSet);

        // now use our service to find all
        Set<Owner> owners = ownerSDJpaService.findAll();

        // make sure we have some results
        assertNotNull(owners);

        assertEquals(1, owners.size());
    }

    @Test
    void findById() {

        // setup the mock data

        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));

        // now use our service to find all
        Owner owner = ownerSDJpaService.findById(1L);

        assertNotNull(owner);

        assertEquals(1L, owner.getId());
    }

    @Test
    void save() {

        Owner ownerToSave = new Owner();
        ownerToSave.setId(1L);

        when(ownerRepository.save(any())).thenReturn(ownerToSave);

        Owner savedOwner = ownerSDJpaService.save(ownerToSave);

        assertNotNull(savedOwner);

        assertEquals(savedOwner.getId(), ownerToSave.getId());
    }

    @Test
    void delete() {

        ownerRepository.delete(returnOwner);

        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {

        ownerSDJpaService.deleteById(1L);

        verify(ownerRepository, times(1)).deleteById(anyLong());
    }
}