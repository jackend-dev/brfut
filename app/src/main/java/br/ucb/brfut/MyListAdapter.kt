package br.ucb.brfut

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
class MyListAdapter(context: Context, private val title: ArrayList<Clube>)

    : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val item = getItem(position) as Clube

        val rowView = inflater.inflate(R.layout.activity_list_view_customizada, parent,
                false)

        val nome_time = rowView.findViewById(R.id.titulo) as TextView
        val sigla_time = rowView.findViewById(R.id.descricao) as TextView

        nome_time.text = item.nome_popular
        sigla_time.text = item.sigla

        return rowView
    }

    override fun getItem(position: Int): Any {
        return title[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return title.size
    }

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)
            as LayoutInflater

}