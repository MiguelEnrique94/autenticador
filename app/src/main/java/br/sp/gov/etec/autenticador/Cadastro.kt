package br.sp.gov.etec.autenticador

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import br.sp.gov.etec.autenticador.Service.ApiService
import br.sp.gov.etec.autenticador.Service.RetrofitClient
import br.sp.gov.etec.autenticador.Service.RetrofitClient.Companion.retrofit
import br.sp.gov.etec.autenticador.model.CadastroUsuarioRequest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class Cadastro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cadastro)

        var botaoSalvar = findViewById<Button>(R.id.btn_salvar_usuario)
        var nomeEdit = findViewById<EditText>(R.id.editTextNome)
        var emailEdit = findViewById<EditText>(R.id.editTextEmail)
        var senhaEdit = findViewById<EditText>(R.id.editTextSenha)
        var telefoneEdit = findViewById<EditText>(R.id.editTextTelefone)
        botaoSalvar.setOnClickListener {
            val nome = nomeEdit.text.toString()
            val email = emailEdit.text.toString()
            val senha = senhaEdit.text.toString()
            val telefone = telefoneEdit.text.toString()
            CoroutineScope (Dispatchers.IO).launch {
                cadastrarUsuario(nome,email,senha,telefone)

            }
        }
    }

    private suspend fun cadastrarUsuario(nome: String, email: String, senha: String, telefone: String) {
      val chamadaApi = retrofit.create(ApiService::class.java)

        var request = CadastroUsuarioRequest(nome, email, senha, telefone)
        var response = chamadaApi.cadastrarUsuario(request)
        print(response.isSuccessful())
        if(response.isSuccessful){
            Toast.makeText(this, "Usuario cadastrado com sucesso!!", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this,"Erro no cadastro..", Toast.LENGTH_LONG).show()
        }
    }


}
