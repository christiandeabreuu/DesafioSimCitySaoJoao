package br.com.zup.simcityfestajunina.fragmentsListaProduto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.zup.simcityfestajunina.R
import br.com.zup.simcityfestajunina.adapter.ProdutoAdapter
import br.com.zup.simcityfestajunina.databinding.FragmentListaProdutoBinding
import br.com.zup.simcityfestajunina.model.Produto


class ListaProdutoFragment : Fragment() {
    private lateinit var binding : FragmentListaProdutoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentListaProdutoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listaProdutos = arguments?.getParcelableArrayList<Produto>("LISTA_PRODUTO")
        listaProdutos?.let {
            binding.rvProdutos.adapter = ProdutoAdapter(it, this::irParadetalheProduto)
            binding.rvProdutos.layoutManager = LinearLayoutManager(context)
        }
    }
    fun irParadetalheProduto(produto:Produto){
        val bundle = bundleOf("PRODUTO" to produto)
        NavHostFragment.findNavController(this).navigate(R.id.action_listaProdutoFragment_to_detalhesProdutoFragment, bundle)

    }
}