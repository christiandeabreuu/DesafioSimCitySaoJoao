package br.com.zup.simcityfestajunina.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.simcityfestajunina.databinding.ItemProdutoBinding
import br.com.zup.simcityfestajunina.model.Produto

class ProdutoAdapter(val listaProduto: ArrayList<Produto>, val irParaDetalhe :(produto: Produto)-> Unit)  :
    RecyclerView.Adapter<ProdutoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemProdutoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = listaProduto[position]
        holder.receberInformacoes(produto)
        holder.binding.cvProduto.setOnClickListener{irParaDetalhe(produto)}

    }

    override fun getItemCount(): Int {
        return listaProduto.size
    }

    class ViewHolder(
        val binding: ItemProdutoBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun receberInformacoes(produto: Produto){
            binding.tvItensLayout.text = "${produto.getQtd()} - ${produto.getNome()} "
        }
    }



}
