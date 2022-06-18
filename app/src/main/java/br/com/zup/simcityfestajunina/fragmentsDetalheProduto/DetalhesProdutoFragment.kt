package br.com.zup.simcityfestajunina.fragmentsDetalheProduto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import br.com.zup.simcityfestajunina.R
import br.com.zup.simcityfestajunina.databinding.FragmentDetalhesProdutoBinding
import br.com.zup.simcityfestajunina.databinding.FragmentListaProdutoBinding
import br.com.zup.simcityfestajunina.model.Produto


class DetalhesProdutoFragment : Fragment() {
    private lateinit var binding: FragmentDetalhesProdutoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDetalhesProdutoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val produto = arguments?.getParcelable<Produto>("PRODUTO")
        produto?.let {
            binding.tvResultadoNomeProduto.text = produto.getNome()
            binding.tvResultadoQtdProduto.text = "quantidade: ${produto.getQtd()}"
            binding.tvResultadoValorUnitario.text = "valor unitário: R$${produto.getValor()}"
            binding.tvResultadoReceita.text = "receita: ${produto.getReceita()}"
        }
        binding.ivCoracao.setOnClickListener {
            Toast.makeText(context, "Produto adicionado aos favoritos", Toast.LENGTH_SHORT).show()
        }
    }
}