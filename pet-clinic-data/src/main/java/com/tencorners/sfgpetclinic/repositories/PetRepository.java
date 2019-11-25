package com.tencorners.sfgpetclinic.repositories;

import com.tencorners.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
