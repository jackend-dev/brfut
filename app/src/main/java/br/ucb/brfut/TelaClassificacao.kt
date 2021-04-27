package br.ucb.brfut

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_tela_classificacao.*
import kotlinx.android.synthetic.main.activity_tela_time.*

class TelaClassificacao : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_classificacao)
        var nome = intent.getStringExtra("nome_time")
        var valor_posicao = intent.getStringExtra("posicao")
        var valor_pontos = intent.getStringExtra("pontos")
        var valor_jogos = intent.getStringExtra("jogos")
        var valor_vitorias = intent.getStringExtra("vitorias")
        var valor_empates = intent.getStringExtra("empates")
        var valor_derrotas = intent.getStringExtra("derrotas")
        var valor_saldoGols = intent.getStringExtra("saldo_gols")

        posicao.text = "Posição: "+valor_posicao
        pontos.text = "Pontos: "+valor_pontos
        jogos.text = "Jogos: "+valor_jogos
        vitorias.text = "Vitórias: "+valor_vitorias
        empates.text = "Empates: "+valor_empates
        derrotas.text = "Derrotas: "+valor_derrotas
        saldo_gols.text = "Salgo de gols: "+valor_saldoGols

        if (nome.toString() == "Bahia"){
            escudoClube.setImageResource(R.drawable.bahia)
        }

        btnSaibaMais.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.cbf.com.br"
            ))
            startActivity(intent)
        }
//
    }
}