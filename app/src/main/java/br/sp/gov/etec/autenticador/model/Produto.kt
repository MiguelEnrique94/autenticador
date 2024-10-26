package br.sp.gov.etec.autenticador.model

data class Produto (
    val id : Long,
    val nome : String,
    val preco : Double,
    val descricao : String,
    val categoria : Categoria

)
