package br.ucb.brfut

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.StringRes
import com.android.volley.Header
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_tela_tabela.*
import kotlinx.android.synthetic.main.activity_tela_time.*
import javax.security.auth.AuthPermission

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnBuscar.setOnClickListener {
            var nome_time:String = entradatime.text.toString()
            val intentTelaTime = Intent(this, TelaTime::class.java)
            startActivity(intentTelaTime)
            exibirTime(nome_time)

        }


    }

    fun exibirTime(time:String) {

        var idtime = null

        val first_queue = Volley.newRequestQueue(this)
        val url_times = "https://api.api-futebol.com.br/v1/partidas/10"

        val firtStringRequest = StringRequest(Request.Method.GET, url_times,
                Response.Listener<String> { response ->
                    val first_gson = GsonBuilder().create()
                    val first_resultado = first_gson.fromJson(response.toString(),
                            Array<Clube>::class.java)
                            .toList()
                    idtime = first_resultado.firstOrNull()?.time_id as Nothing?


                },
                Response.ErrorListener { nome_popular.text = "Deu ruim2" })
        first_queue.add(firtStringRequest)

        // Instatiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val url = "https://api.api-futebol.com.br/v1/times/${idtime}"

        val token = "live_bce21c345086b3d00ce55e583cb1ad"

        // Request a string response from the provided URL.
        val stringRequest = StringRequest(Request.Method.GET,  url,
                Response.Listener<String> { response ->

                    val gson = GsonBuilder().create()
                    val resultado = gson.fromJson(response.toString(), Array<Clube>::class.java)
                            .toList()

                    nome_popular.text = resultado.firstOrNull()?.nome_popular.toString()
                    sigla.text = resultado.firstOrNull()?.sigla.toString()
                },
                Response.ErrorListener { nome_popular.text = "Deu ruim" })
        queue.add(stringRequest)
    }
}


