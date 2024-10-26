package br.sp.gov.etec.autenticador.model

import android.provider.ContactsContract.CommonDataKinds.Email

data class CadastroUsuarioResponse (
val id : Long,
    val nome :String,
    val email: Email,
    val senha : String,
    val telefone : String,
)
