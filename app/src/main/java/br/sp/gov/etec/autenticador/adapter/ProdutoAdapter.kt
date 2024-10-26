package br.sp.gov.etec.autenticador.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.sp.gov.etec.autenticador.R
import br.sp.gov.etec.autenticador.model.Produto


class ProdutosAdapter(private val produtos: List<Produto>) :
    RecyclerView.Adapter<ProdutosAdapter.ProdutoViewHolder>() {

    class ProdutoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nome = itemView.findViewById<TextView>(R.id.textNomeProduto)
        val preco = itemView.findViewById<TextView>(R.id.textPrecoProduto)
        val descricao = itemView.findViewById<TextView>(R.id.textDescricao)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.produto_item, parent, false)
        return ProdutoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProdutoViewHolder, position: Int) {
        val produto = produtos[position]
        holder.nome.text = produto.nome
        holder.preco.text = "R$ ${produto.preco}"
        holder.descricao.text = produto.descricao
    }

    override fun getItemCount(): Int {
        return produtos.size
    }
}
