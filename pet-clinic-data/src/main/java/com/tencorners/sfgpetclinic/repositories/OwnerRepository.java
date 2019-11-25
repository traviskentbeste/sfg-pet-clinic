package com.tencorners.sfgpetclinic.repositories;

import com.tencorners.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
