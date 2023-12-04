package com.unimaster.unimaster.controller.dto

data class PersonDTO(
    val nome: String = "",
    val foto: String = "",
    val cpf: String = "",
    val rg: String = "",
    val telefone: String = "",
    val cep: String = "",
    val logradouro: String = "",
    val numero: String = "",
    val bairro: String = "",
    val cidade: String = "",
    val estado: String = "",
    val nomePai: String = "",
    val nomeMae: String = "",
    val salario: Double = 0.0
)