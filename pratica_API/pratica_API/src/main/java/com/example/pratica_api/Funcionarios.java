package com.example.pratica_api;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Funcionarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    private String cargo;

    @Column(name="data_admissao")
    private Date data;

    private double salario;

    private String departamento;

    public Funcionarios(){}

    public Funcionarios(String nome, String cargo, Date data, double salario, String departamento) {
        this.nome = nome;
        this.cargo = cargo;
        this.data = data;
        this.salario = salario;
        this.departamento = departamento;
    }

    public Funcionarios(long id, String nome, String cargo, Date data, double salario, String departamento) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.data = data;
        this.salario = salario;
        this.departamento = departamento;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Date data() {
        return data;
    }

    public void data(Date data_nascimento) {
        this.data = data_nascimento;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Funcionarios{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cargo='" + cargo + '\'' +
                ", data_nascimento=" + data +
                ", salario=" + salario +
                ", departamento='" + departamento + '\'' +
                '}';
    }
}
