package com.monsite.ja_l3.factories;

import com.monsite.ja_l3.repositories.ClassesRepository;
import com.monsite.ja_l3.repositories.CoursRepository;
import com.monsite.ja_l3.repositories.ProfesseurRepository;




public interface RepositoryFactory{

    CoursRepository getCoursRepository();
    ClassesRepository getClassesRepository();
    ProfesseurRepository getProfesseurRepository();

}
