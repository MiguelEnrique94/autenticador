package br.sp.gov.etec.autenticador.model

data class CadastroUsuarioRequest(
    val nome:String,
    val email: String,
    val senha: String,
    val telefone: String,
    )

