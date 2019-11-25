package com.tencorners.sfgpetclinic.repositories;

import com.tencorners.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
