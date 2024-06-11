package com.prueba.demo.Persistence.Mapper;

import com.prueba.demo.Domain.Employes;
import com.prueba.demo.Persistence.Entity.Empleados;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmpleadosUsersMapper {
    @Mappings({
            @Mapping(source = "empl_ID", target = "empl_ID"),
            @Mapping(source = "empl_primer_nombre", target = "empl_first_name"),
            @Mapping(source = "empl_segundo_nombre", target = "empl_last_nombre"),
            @Mapping(source = "empl_email", target = "empl_emailOutlook"),
            @Mapping(source = "empl_fecha_nac", target = "empl_date_nac"),
            @Mapping(source = "empl_sueldo", target = "empl_salary"),
            @Mapping(source = "empl_comision", target = "empl_commission"),
            @Mapping(source = "empl_cargo_ID", target = "empl_profesion_ID"),
            @Mapping(source = "empl_Gerente_ID", target = "empl_manager_ID"),
            @Mapping(source = "empl_dpto_ID", target = "empl_session_ID")
    })
    Employes toEmployes (Empleados empleados);
    List<Employes> toListEmployes(List<Empleados> empleadosList);

    //MarvelUser toMarvelUser (MarvelUsuarios marvelUsuarios);
    //List<MarvelUser> toMarvelUsers(List<MarvelUsuarios> marvelUsuarios);

    @InheritInverseConfiguration
//    MarvelUsuarios toMarvelUsuarios(MarvelUser marvelUser);
    Empleados toEmpleados(Employes employes);
}
