package com.example.famousprogramminglanguageapp.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.famousprogramminglanguageapp.R
import com.example.famousprogramminglanguageapp.models.ProgrammingLanguages

class ProgrammingLanguageAdapter(
    private val context: Context,
    private val listOfLanguages: List<ProgrammingLanguages>
) : BaseAdapter() {
    private val layoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int = listOfLanguages.size

    override fun getItem(position: Int): Any = listOfLanguages[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = layoutInflater.inflate(R.layout.programming_language_detail, parent, false)

        val title = rowView.findViewById<TextView>(R.id.title)
        val date = rowView.findViewById<TextView>(R.id.date)
        val usagePercentage = rowView.findViewById<TextView>(R.id.usagePercentage)

        title.text = listOfLanguages[position].languageName
        date.text = listOfLanguages[position].createdDate
        usagePercentage.text = listOfLanguages[position].percentageUsage.toString()
        return rowView
    }

}