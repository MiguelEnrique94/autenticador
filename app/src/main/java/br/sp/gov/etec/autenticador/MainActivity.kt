package br.sp.gov.etec.autenticador

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.sp.gov.etec.autenticador.Service.ApiService
import br.sp.gov.etec.autenticador.Service.RetrofitClient.Companion.retrofit
import br.sp.gov.etec.autenticador.model.Login
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var linkCadastro =findViewById<TextView>(R.id.idLinkCadastro)
        var login = findViewById<TextView>(R.id.editLogin)
        var password = findViewById<TextView>(R.id.editPassword)
        var btnLogin = findViewById<Button>(R.id.btnLogin)

        linkCadastro.setOnClickListener{
            val intent =Intent(this, Cadastro::class.java)
            startActivity(intent)
        }

        btnLogin.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                efetuarLogin(login.text.toString(),password.text.toString())

            }
        }
    }

    private suspend fun efetuarLogin(login: String, senha: String) {
        val chamadaApi = retrofit.create(ApiService::class.java)
        var request = Login(login,senha,false)
        var response = chamadaApi.autenticar(request);

        withContext(Dispatchers.Main) {
        if (response.body()?.autenticado == true){
            val intent = Intent(this@MainActivity, ListaProdutoView::class.java)
            startActivity(intent)
            finish()
            Toast.makeText(this@MainActivity, "Usuario autenticado com sucesso..", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this@MainActivity, "Ixi!...Usuario não autenticado :(", Toast.LENGTH_LONG).show()
        }
    }
}
}