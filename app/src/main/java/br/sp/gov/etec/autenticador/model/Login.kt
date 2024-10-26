package br.sp.gov.etec.autenticador.model

data class Login (
    val email : String,
    val senha : String,
    val autenticado: Boolean
)
