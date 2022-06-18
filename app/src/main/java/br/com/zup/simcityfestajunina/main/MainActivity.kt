package br.com.zup.simcityfestajunina.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.zup.simcityfestajunina.R
import br.com.zup.simcityfestajunina.cadastro.CadastroActivity
import br.com.zup.simcityfestajunina.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBotaoMain.setOnClickListener {
            startActivity(Intent(this, CadastroActivity::class.java))
        }
    }
}