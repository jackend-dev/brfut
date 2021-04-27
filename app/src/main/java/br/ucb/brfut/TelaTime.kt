package br.ucb.brfut

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_tela_time.*
import org.json.JSONArray
import org.json.JSONObject
import java.util.*
import kotlin.collections.HashMap

class TelaTime : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_time)

        var nome = intent.getStringExtra("nome_time")
        var sigla_time = intent.getStringExtra("sigla")
        nome_popular.text = nome
        sigla.text = sigla_time

        if (nome != null) {
            exibir_escudo(nome)
        }

        btnBrasileiro.setOnClickListener {
            val intentBrasileirao = Intent(this, TelaTabela::class.java)
            startActivity(intentBrasileirao)
        }

        btnCopaBrasil.setOnClickListener {
            val intentCopaDoBrasil = Intent(this, TelaTabela::class.java)
            startActivity(intentCopaDoBrasil)

        }
    }

    fun exibir_escudo(nome:String){
        if(nome.toString() == "América-MG"){
            escudoTime.setImageResource(R.drawable.americamg)
        } else if(nome.toString() == "Athletico-PR") {
            escudoTime.setImageResource(R.drawable.athleticopr)
        }else if(nome.toString() == "Atlético-GO") {
            escudoTime.setImageResource(R.drawable.athleticogo)
        }else if(nome.toString() == "Atlético-MG") {
            escudoTime.setImageResource(R.drawable.atleticomg)
        }else if(nome.toString() == "Bahia") {
            escudoTime.setImageResource(R.drawable.bahia)
        }else if(nome.toString() == "Bragantino") {
            escudoTime.setImageResource(R.drawable.bragantino)
        }else if(nome.toString() == "Ceará") {
            escudoTime.setImageResource(R.drawable.ceara)
        }else if(nome.toString() == "Chapecoense") {
            escudoTime.setImageResource(R.drawable.chapecoense)
        }else if(nome.toString() == "Corinthians") {
            escudoTime.setImageResource(R.drawable.corinthians)
        }else if(nome.toString() == "Cuiabá") {
            escudoTime.setImageResource(R.drawable.cuiaba)
        }else if(nome.toString() == "Flamengo") {
            escudoTime.setImageResource(R.drawable.flamengo)
        }else if(nome.toString() == "Fluminense") {
            escudoTime.setImageResource(R.drawable.fluminense)
        }else if(nome.toString() == "Fortaleza") {
            escudoTime.setImageResource(R.drawable.fortaleza)
        }else if(nome.toString() == "Grêmio") {
            escudoTime.setImageResource(R.drawable.gremio)
        }else if(nome.toString() == "Internacional") {
            escudoTime.setImageResource(R.drawable.internacional)
        }else if(nome.toString() == "Juventude") {
            escudoTime.setImageResource(R.drawable.juventude)
        }else if(nome.toString() == "Palmeiras") {
            escudoTime.setImageResource(R.drawable.palmeiras)
        }else if(nome.toString() == "Santos") {
            escudoTime.setImageResource(R.drawable.santos)
        }else if(nome.toString() == "São Paulo") {
            escudoTime.setImageResource(R.drawable.sao_paulo)
        }else if(nome.toString() == "Sport") {
            escudoTime.setImageResource(R.drawable.sport)
        }
    }

}