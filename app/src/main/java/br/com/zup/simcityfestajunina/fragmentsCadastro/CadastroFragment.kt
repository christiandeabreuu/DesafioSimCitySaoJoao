package br.com.zup.simcityfestajunina.fragmentsCadastro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.NavHostFragment
import br.com.zup.simcityfestajunina.R
import br.com.zup.simcityfestajunina.databinding.FragmentCadastroBinding
import br.com.zup.simcityfestajunina.model.Produto


class CadastroFragment : Fragment() {
    private lateinit var binding: FragmentCadastroBinding
    private var listaProduto = ArrayList<Produto>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCadastroBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnVerProdutos = binding.btnVerProdutos
        btnVerProdutos.setOnClickListener {
            val bundle = bundleOf("LISTA_PRODUTO" to listaProduto)
            NavHostFragment.findNavController(this).navigate(
                R.id.action_cadastroFragment_to_listaProdutoFragment, bundle
            )

        }
        binding.btnCadastrarNovoProduto.setOnClickListener {
            cadastrarProdutos()

        }
    }

    private fun cadastrarProdutos() {
        val nomeProduto = binding.etNomeProduto.text.toString()
        val qtoProduto = binding.etQtdProduto.text.toString()
        val valorProduto = binding.etValorUnidadeProduto.text.toString()
        val receitaProduto = binding.etReceitaProduto.text.toString()

        if (nomeProduto.isNotBlank() && qtoProduto.isNotBlank() && valorProduto.isNotBlank() && receitaProduto.isNotBlank()) {
            listaProduto.add(
                Produto(
                    nomeProduto,
                    qtoProduto.toInt(),
                    valorProduto.toDouble(),
                    receitaProduto
                )
            )
            limparEditText()
            msgToast()
        } else {
            binding.etNomeProduto.error = if (nomeProduto.isBlank()) "Campo Obrigatório" else null
            binding.etQtdProduto.error = if (qtoProduto.isBlank()) "Campo Obrigatório" else null
            binding.etValorUnidadeProduto.error =
                if (valorProduto.isBlank()) "Campo Obrigatório" else null
            binding.etReceitaProduto.error =
                if (receitaProduto.isBlank()) "Campo Obrigatório" else null
        }
    }

    private fun limparEditText() {
        binding.etNomeProduto.text.clear()
        binding.etQtdProduto.text.clear()
        binding.etValorUnidadeProduto.text.clear()
        binding.etReceitaProduto.text.clear()
    }

    private fun msgToast() {
        Toast.makeText(context, "Produto cadastrado", Toast.LENGTH_SHORT).show()
    }
}



