package com.tencorners.sfgpetclinic.services.map;

import com.tencorners.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;

    final Long ownerId = 1L;
    final String lastName = "Test";

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());

        Owner owner = new Owner();
        owner.setId(ownerId);
        owner.setLastName(lastName);
        ownerServiceMap.save(owner);
    }

    @Test
    void findAll() {

        Set<Owner> ownerSet = ownerServiceMap.findAll();

        assertEquals(1, ownerSet.size());

    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(ownerId);

        assertEquals(ownerId, owner.getId());
    }

    @Test
    void saveExistsId() {
        Long id = 2L;
        Owner owner = new Owner();
        owner.setId(id);

        Owner savedOwner = ownerServiceMap.save(owner);

        assertEquals(id, savedOwner.getId());
    }

    @Test
    void saveNoId() {
        Owner owner = new Owner();

        Owner savedOwner = ownerServiceMap.save(owner);

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void delete() {

        ownerServiceMap.delete(ownerServiceMap.findById(ownerId));

        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void deleteById() {

        ownerServiceMap.deleteById(ownerId);

        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void findByLastName() {

        Owner owner = ownerServiceMap.findByLastName(lastName);

        assertNotNull(owner);

        assertEquals(ownerId, owner.getId());
    }

    @Test
    void findByLastNameNotFound() {

        Owner owner = ownerServiceMap.findByLastName("foo");

        assertNull(owner);
    }
}