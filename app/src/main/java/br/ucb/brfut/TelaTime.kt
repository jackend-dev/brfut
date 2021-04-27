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

class TelaTime : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_time)

        var nome = intent.getStringExtra("nome_time")
        var sigla_time = intent.getStringExtra("sigla")
        nome_popular.text = nome
        sigla.text = sigla_time

        btnBrasileiro.setOnClickListener {
            val urlBrasileirao = "https://api.api-futebol.com.br/v1/campeonatos/10"
            exibirTabela(urlBrasileirao)
//            val intentBrasileirao = Intent(this, TelaClassificacao::class.java)
//            startActivity(intentBrasileirao)
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

        val accessTokenRequest: JsonArrayRequest = object : JsonArrayRequest(
            Request.Method.GET, url, JSONArray(),
            Response.Listener<JSONArray?> { response ->
                println("RE: "+ response)
//                var nome_time = response.getString("nome_popular")
//                var sigla = response.getString("sigla")
//
//                val intentTelaTime = Intent(this, TelaTime::class.java)
//                intentTelaTime.putExtra("nome_time", nome_time.toString())
//                intentTelaTime.putExtra("sigla", sigla.toString())
//                startActivity(intentTelaTime)

            }, Response.ErrorListener {
                println("ERRO")
            }) {
            override fun getHeaders(): Map<String, String>? {
                val headers: MutableMap<String, String> = HashMap()
                headers["Authorization"] = "Bearer test_9f7800a1c03cc1aeb725c5f1d20b78"
//                        headers["Authorization"] = "Bearer live_bce21c345086b3d00ce55e583cb1ad"
                return headers
            }
        }
        queue.add(accessTokenRequest)
    }

//        val stringRequest = StringRequest(Request.Method.GET,  url,
//                Response.Listener<String> { response ->
//
//                    val gson = GsonBuilder().create()
//                    val resultado = gson.fromJson(response.toString(), Array<Clube>::class.java)
//                            .toList()
//                    println("resultado: "+resultado)
////                    nome_popular.text = resultado.firstOrNull()?.nome_popular.toString()
////                    sigla.text = resultado.firstOrNull()?.sigla.toString()
//                }, Response.ErrorListener {
////            println("ERRO" +Response.ErrorListener)
////                nome_popular.text = "Deu ruim2"//To change body of created functions use File | Settings | File Templates.
//        }){
//            fun getHeaders(): Map<String, String>? {
//                val headers: MutableMap<String, String> = HashMap()
//                headers["Authorization"] = "Bearer test_9f7800a1c03cc1aeb725c5f1d20b78"
////                headers["Authorization"] = "Bearer live_bce21c345086b3d00ce55e583cb1ad"
//                return headers
//            }
//
//        }
//        queue.add(stringRequest as Request<Any>?)
//
//
//    }
//
//    private fun StringRequest(get: Int, url: String, listener: Response.Listener<String>, errorListener: Response.ErrorListener, function: () -> Unit) {
//
//    }

}