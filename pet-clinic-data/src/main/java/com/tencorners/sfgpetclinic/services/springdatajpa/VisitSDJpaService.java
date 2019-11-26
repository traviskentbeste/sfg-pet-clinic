package com.tencorners.sfgpetclinic.services.springdatajpa;

import com.tencorners.sfgpetclinic.model.Visit;
import com.tencorners.sfgpetclinic.repositories.VisitRespostiory;
import com.tencorners.sfgpetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VisitSDJpaService implements VisitService {

    private final VisitRespostiory visitRespostiory;

    public VisitSDJpaService(VisitRespostiory visitRespostiory) {
        this.visitRespostiory = visitRespostiory;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        visitRespostiory.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public Visit findById(Long aLong) {
        return visitRespostiory.findById(aLong).orElse(null);
    }

    @Override
    public Visit save(Visit object) {
        return visitRespostiory.save(object);
    }

    @Override
    public void delete(Visit object) {
        visitRespostiory.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        visitRespostiory.deleteById(aLong);
    }
}
