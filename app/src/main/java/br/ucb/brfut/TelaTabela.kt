package br.ucb.brfut

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_list_view_customizada.*
import kotlinx.android.synthetic.main.activity_tela_tabela.*
import kotlinx.android.synthetic.main.activity_tela_time.*
import org.json.JSONArray
import org.json.JSONObject


class TelaTabela : AppCompatActivity() {
    private var queue: RequestQueue? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_tabela)
        queue = Volley.newRequestQueue(this@TelaTabela)
        getTimes()
    }

    private fun getTimes(){
        val lista = arrayListOf<Clube>()
        var dados_classificacao: JSONObject? = null
        val url = "https://api.api-futebol.com.br/v1/campeonatos/10/tabela"

        val request = object : JsonArrayRequest(Request.Method.GET, url, JSONArray(),
                Response.Listener<JSONArray?> { response ->

            for (i in 0 until response.length()){
                var objeto: JSONObject = response.getJSONObject(i)
                var time = JSONObject(objeto.get("time").toString())
                dados_classificacao = objeto

                lista.add(
                        Clube(
//                        time.getString("time_id"),
                        time.getString("nome_popular"),
                        time.getString("sigla")
                ))
            }

            val adapter = MyListAdapter(this, lista)
            println("list: "+ adapter)
            list_view.adapter = adapter

            list_view.onItemClickListener = AdapterView.OnItemClickListener {
                parent, view, position, id ->

                val intent = Intent(this, TelaClassificacao::class.java)
                intent.putExtra("posicao", dados_classificacao?.get("posicao").toString())
                intent.putExtra("pontos", dados_classificacao?.get("pontos").toString())
                intent.putExtra("jogos", dados_classificacao?.get("jogos").toString())
                intent.putExtra("vitorias", dados_classificacao?.get("vitorias").toString())
                intent.putExtra("empates", dados_classificacao?.get("empates").toString())
                intent.putExtra("derrotas", dados_classificacao?.get("derrotas").toString())
                intent.putExtra("saldo_gols", dados_classificacao?.get("saldo_gols").toString())
                startActivity(intent)

            }

        }, Response.ErrorListener { e ->
            e.message?.let { Log.d(">>>>>", it) }
        }) {
            override fun getHeaders(): Map<String, String>? {
                val headers: MutableMap<String, String> = HashMap()
                headers["Authorization"] = "Bearer test_9f7800a1c03cc1aeb725c5f1d20b78"
//                headers["Authorization"] = "Bearer live_bce21c345086b3d00ce55e583cb1ad"
                return headers
            }
        }
        queue!!.add(request)
    }

}