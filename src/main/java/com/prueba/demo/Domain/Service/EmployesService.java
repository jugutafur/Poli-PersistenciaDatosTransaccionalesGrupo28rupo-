package com.prueba.demo.Domain.Service;

import com.prueba.demo.Domain.Employes;
import com.prueba.demo.Domain.Repository.EmployesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployesService {

    @Autowired
    private EmployesRepository employesRepository;

    public List<Employes> getAll(){
        return employesRepository.getAll();
    }

    public Optional<Employes> getRegister(int id){
        return employesRepository.getRegister(id);
    }
/*
    public Employes saveRegister(Employes employes){
        return employesRepository.saveRegister(employes);
    }

    public boolean delete(int userId){
        return getRegister(userId).map(Employes -> {
            employesRepository.delete(userId);
            return true;
        }).orElse(false);
    }*/
}
