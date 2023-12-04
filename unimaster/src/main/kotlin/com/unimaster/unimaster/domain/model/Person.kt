package com.unimaster.unimaster.domain.model

import jakarta.persistence.*

@Entity(name = "pessoa")
@Table(name = "pessoa")
data class Person(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpessoa")
    var personID: Long = 0,

    @Column(name = "cpf", nullable = false, length = 14)
    var cpf: String,

    @Column(name = "nome", nullable = false, length = 45)
    var name: String,

    @Column(name = "rg", nullable = false, length = 45)
    var rg: String,

    @Column(name = "telefone", nullable = false, length = 45)
    var telephone: String,

    @Column(name = "cep", nullable = false, length = 45)
    var cep: String,

    @Column(name = "logradouro", nullable = false, length = 45)
    var address: String,

    @Column(name = "numero", nullable = false, length = 45)
    var number: String,

    @Column(name = "bairro", nullable = false, length = 45)
    var neighborhood: String,

    @Column(name = "cidade", nullable = false, length = 45)
    var city: String,

    @Column(name = "estado", nullable = false, length = 45)
    var state: String,

    @Column(name = "nomepai", nullable = false, length = 45)
    var fatherName: String,

    @Column(name = "nomemae", nullable = false, length = 45)
    var motherName: String,

    @Column(name = "salario", nullable = false)
    var salary: Double,
)
