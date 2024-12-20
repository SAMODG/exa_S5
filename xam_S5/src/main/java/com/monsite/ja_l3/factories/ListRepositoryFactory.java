package com.monsite.ja_l3.factories;
import com.monsite.ja_l3.repositories.ClassesRepository;
import com.monsite.ja_l3.repositories.CoursRepository;
import com.monsite.ja_l3.repositories.ProfesseurRepository;

import com.monsite.ja_l3.repositories.list.*;


public class ListRepositoryFactory implements RepositoryFactory {

   @Override
    public CoursRepository getCoursRepository() {
        return new CoursRepositoryList();
    }

    @Override
    public ClassesRepository getClassesRepository() {
        return new ClassesRepositoryList();
    }

    @Override
    public ProfesseurRepository getProfesseurRepository() {
        return new ProfesseurRepositoryList();
    }
}
