package br.ucb.brfut

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_list_view_customizada.*
import kotlinx.android.synthetic.main.activity_tela_time.*

class TelaTabela : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_tabela)

        // Variavel carros recebe recebe um array de strings
        val carros = arrayOf("")

        // Variável descrição recebe um array de strings
        val descricao = arrayOf("","")

        // Variável imagemId recebe um arrays com o objeto de cada imagem
//        val imagemId = arrayOf("")
//
//        // Recebe a classe e passa as variáveis de acordo com cada argumento
//        val novaListAdapter = MyListAdapter(this, carros, descricao, imagemId)

//        list_view.adapter = novaListAdapter

        // recebe a lista adaptada e ao clicar chama outra intent com a imagem do carro
        list_view.onItemClickListener = AdapterView.OnItemClickListener {
            parent, view, position, id ->

            var itemCliclado = parent.getItemAtPosition(position)
            val intent = Intent(this,TelaClassificacao::class.java)
            intent.putExtra("nome_popular", itemCliclado.toString())
            startActivity(intent)
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