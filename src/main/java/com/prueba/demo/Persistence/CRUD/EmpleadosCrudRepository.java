package com.prueba.demo.Persistence.CRUD;

import com.prueba.demo.Persistence.Entity.Empleados;
import org.springframework.data.repository.CrudRepository;

public interface EmpleadosCrudRepository extends CrudRepository<Empleados, Integer> {
}
