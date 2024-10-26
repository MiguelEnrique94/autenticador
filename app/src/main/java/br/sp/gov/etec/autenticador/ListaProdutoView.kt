package br.sp.gov.etec.autenticador

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.sp.gov.etec.autenticador.Service.ApiService
import br.sp.gov.etec.autenticador.Service.RetrofitClient.Companion.retrofit
import br.sp.gov.etec.autenticador.adapter.ProdutosAdapter
import br.sp.gov.etec.autenticador.model.Produto
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListaProdutoView : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lista_produto_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.listaUsuario)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val chamadaApi = retrofit.create(ApiService::class.java)
        recyclerView = findViewById(R.id.recyclerViewProducts)
        recyclerView.layoutManager = LinearLayoutManager(this)

        CoroutineScope(Dispatchers.IO).launch {
            val listaProdutos = chamadaApi.listaDeProdutos().body()!!;
            recyclerView.adapter = ProdutosAdapter(listaProdutos)

        }
    }
}