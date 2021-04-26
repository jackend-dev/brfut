package br.ucb.brfut

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_tela_time.*

class TelaTime : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_time)

        btnBrasileiro.setOnClickListener {
            val urlBrasileirao = "https://api.api-futebol.com.br/v1/campeonatos/10/tabela"
            exibirTabela(urlBrasileirao)
            val intentBrasileirao = Intent(this, TelaClassificacao::class.java)
            startActivity(intentBrasileirao)
        }

        btnCopaBrasil.setOnClickListener {
            val urlCopaDoBrasil = "https://api.api-futebol.com.br/v1/campeonatos/10/tabela"
            exibirTabela(urlCopaDoBrasil)
            val intentCopaDoBrasil = Intent(this, TelaClassificacao::class.java)
            startActivity(intentCopaDoBrasil)

        }
    }

    fun exibirTabela(url_p:String){

        val queue = Volley.newRequestQueue(this)
        val url = url_p

        val stringRequest = StringRequest(Request.Method.GET, url,
                Response.Listener<String> { response ->

                    val gson = GsonBuilder().create()
                    val resultado = gson.fromJson(response.toString(),
                            Array<Tabela>::class.java).toList()
                    nome_popular.text = resultado.firstOrNull()?.nome_popular.toString()
                    sigla.text = resultado.firstOrNull()?.sigla.toString()
                },
                Response.ErrorListener { nome_popular.text = "Deu ruim" })
        queue.add(stringRequest)


    }

}