package com.monsite.ja_l3.factories;

import com.monsite.ja_l3.repositories.ClassesRepository;
import com.monsite.ja_l3.repositories.CoursRepository;
import com.monsite.ja_l3.repositories.ProfesseurRepository;
import com.monsite.ja_l3.repositories.bd.*;

public class BdRepositoryFactory implements RepositoryFactory {

    @Override
    public CoursRepository getCoursRepository() {
        return new CoursRepositoryBd();
    }

    @Override
    public ClassesRepository getClassesRepository() {
        return new ClassesRepositoryBd();
    }

    @Override
    public ProfesseurRepository getProfesseurRepository() {
        return new ProfesseurRepositoryBd();
    }

}
