package br.ucb.brfut

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_tela_tabela.*
import kotlinx.android.synthetic.main.activity_tela_time.*
import org.json.JSONObject
import java.net.URL
import javax.security.auth.AuthPermission


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnBuscar.setOnClickListener {
            var nome_time:String = entradatime.text.toString()
            exibirTime(nome_time)
        }
    }

    fun exibirTime(param_time:String) {
        var idtime = retorna_times(param_time)
        val first_queue = Volley.newRequestQueue(this)

        val url_times = "https://api.api-futebol.com.br/v1/times/${idtime}"

        println("idtime: " + idtime)

        val accessTokenRequest: JsonObjectRequest = object : JsonObjectRequest(
                Request.Method.GET, url_times, JSONObject(),
                Response.Listener<JSONObject?> { response ->
                    var nome_time = response.getString("nome_popular")
                    var sigla = response.getString("sigla")

                    val intentTelaTime = Intent(this, TelaTime::class.java)
                    intentTelaTime.putExtra("nome_time", nome_time.toString())
                    intentTelaTime.putExtra("sigla", sigla.toString())
                    startActivity(intentTelaTime)

                }, Response.ErrorListener {
                    println("ERRO")
                }) {
                    override fun getHeaders(): Map<String, String>? {
                        val headers: MutableMap<String, String> = HashMap()
//                        headers["Authorization"] = "Bearer test_9f7800a1c03cc1aeb725c5f1d20b78"
                        headers["Authorization"] = "Bearer live_bce21c345086b3d00ce55e583cb1ad"
                        return headers
                }
        }
        first_queue.add(accessTokenRequest)
    }

    fun retorna_times(times:String): Int {
        if(times == "América-MG"){
            return 33
        } else if(times == "Athletico-PR") {
            return 185
        }else if(times == "Atlético-GO") {
            return 98
        }else if(times == "Atlético-MG") {
            return 185
        }else if(times == "Athletico-PR") {
            return 185
        }else if(times == "Athletico-PR") {
            return 185
        }else if(times == "Athletico-PR") {
            return 185
        }else if(times == "Athletico-PR") {
            return 185
        }else if(times == "Athletico-PR") {
            return 185
        }else if(times == "Athletico-PR") {
            return 185
        }else if(times == "Athletico-PR") {
            return 185
        }else if(times == "Athletico-PR") {
            return 185
        }else if(times == "Athletico-PR") {
            return 185
        }else if(times == "Athletico-PR") {
            return 185
        }else if(times == "Athletico-PR") {
            return 185
        }else if(times == "Athletico-PR") {
            return 185
        }else if(times == "Athletico-PR") {
            return 185
        }else if(times == "Athletico-PR") {
            return 185
        }else if(times == "Athletico-PR") {
            return 185
        }else if(times == "Athletico-PR") {
            return 185
        }
        return 0



    }

}








