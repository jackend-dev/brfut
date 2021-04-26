package br.ucb.brfut

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.*
class MyListAdapter(private val context: Activity, private val title: Array<String>, private val description: Array<String>, private val imgid: Array<Int>)
    : ArrayAdapter<String>(context, R.layout.activity_tela_tabela, title) {

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.activity_tela_tabela, null, true)

        val titleText = rowView.findViewById(R.id.titulo) as TextView
        val imageView = rowView.findViewById(R.id.escudo) as ImageView
        val subtitleText = rowView.findViewById(R.id.descricao) as TextView

        titleText.text = title[position]
        imageView.setImageResource(imgid[position])
        subtitleText.text = description[position]

        return rowView
    }
}