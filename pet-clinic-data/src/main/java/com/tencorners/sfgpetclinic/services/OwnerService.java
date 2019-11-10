package com.tencorners.sfgpetclinic.services;

import com.tencorners.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>
{
    Owner findByLastName(String lastName);
}
