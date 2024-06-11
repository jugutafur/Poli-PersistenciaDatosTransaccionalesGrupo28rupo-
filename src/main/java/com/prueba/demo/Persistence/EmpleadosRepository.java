package com.prueba.demo.Persistence;

import com.prueba.demo.Domain.Employes;
import com.prueba.demo.Domain.Repository.EmployesRepository;
import com.prueba.demo.Persistence.CRUD.EmpleadosCrudRepository;
import com.prueba.demo.Persistence.Entity.Empleados;
import com.prueba.demo.Persistence.Mapper.EmpleadosUsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmpleadosRepository implements EmployesRepository {

    @Autowired
    private EmpleadosCrudRepository empleadosCrudRepository;

    @Autowired
    private EmpleadosUsersMapper empleadosUsersMapper;

    @Override
    public List<Employes> getAll() {
        List<Empleados> empleadosList= (List<Empleados>) empleadosCrudRepository.findAll();
        return empleadosUsersMapper.toListEmployes(empleadosList);
    }

    @Override
    public Optional<Employes> getRegister(int id) {
        return empleadosCrudRepository.findById(id).map(
                MarvelUsuarios -> empleadosUsersMapper.toEmployes(MarvelUsuarios)
        );
    }

    @Override
    public Employes saveRegister(Employes employes) {
        Empleados empleados = empleadosUsersMapper.toEmpleados(employes);
        return empleadosUsersMapper.toEmployes(empleadosCrudRepository.save(empleados));
    }

    @Override
    public void delete(int empleadoId) {
        empleadosCrudRepository.deleteById(empleadoId);
    }
}
