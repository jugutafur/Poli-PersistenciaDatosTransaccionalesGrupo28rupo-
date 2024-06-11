package com.prueba.demo.Domain.Repository;

import com.prueba.demo.Domain.Employes;

import java.util.List;
import java.util.Optional;

public interface EmployesRepository {
    List<Employes> getAll();
    Optional<Employes> getRegister(int id);
    Employes saveRegister(Employes employes);
    void delete(int employesId);
}
