package com.prueba.demo.Persistence.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "Empleados")
public class Empleados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empl_ID;
    private String empl_primer_nombre;
    private String empl_segundo_nombre;
    private String empl_email;
    private String empl_fecha_nac;
    private String empl_sueldo;
    private String empl_comision;
    private String empl_cargo_ID;
    private String empl_Gerente_ID;
    private String empl_dpto_ID;

    public Integer getEmpl_ID() {
        return empl_ID;
    }

    public void setEmpl_ID(Integer empl_ID) {
        this.empl_ID = empl_ID;
    }

    public String getEmpl_primer_nombre() {
        return empl_primer_nombre;
    }

    public void setEmpl_primer_nombre(String empl_primer_nombre) {
        this.empl_primer_nombre = empl_primer_nombre;
    }

    public String getEmpl_segundo_nombre() {
        return empl_segundo_nombre;
    }

    public void setEmpl_segundo_nombre(String empl_segundo_nombre) {
        this.empl_segundo_nombre = empl_segundo_nombre;
    }

    public String getEmpl_email() {
        return empl_email;
    }

    public void setEmpl_email(String empl_email) {
        this.empl_email = empl_email;
    }

    public String getEmpl_fecha_nac() {
        return empl_fecha_nac;
    }

    public void setEmpl_fecha_nac(String empl_fecha_nac) {
        this.empl_fecha_nac = empl_fecha_nac;
    }

    public String getEmpl_sueldo() {
        return empl_sueldo;
    }

    public void setEmpl_sueldo(String empl_sueldo) {
        this.empl_sueldo = empl_sueldo;
    }

    public String getEmpl_comision() {
        return empl_comision;
    }

    public void setEmpl_comision(String empl_comision) {
        this.empl_comision = empl_comision;
    }

    public String getEmpl_cargo_ID() {
        return empl_cargo_ID;
    }

    public void setEmpl_cargo_ID(String empl_cargo_ID) {
        this.empl_cargo_ID = empl_cargo_ID;
    }

    public String getEmpl_Gerente_ID() {
        return empl_Gerente_ID;
    }

    public void setEmpl_Gerente_ID(String empl_Gerente_ID) {
        this.empl_Gerente_ID = empl_Gerente_ID;
    }

    public String getEmpl_dpto_ID() {
        return empl_dpto_ID;
    }

    public void setEmpl_dpto_ID(String empl_dpto_ID) {
        this.empl_dpto_ID = empl_dpto_ID;
    }
}
