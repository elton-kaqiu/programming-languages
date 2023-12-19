package com.example.famousprogramminglanguageapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

class ProgrammingLanguageAdapter(
    private val context: Context,
    private val listOfLanguages: List<ProgrammingLanguageAdapter>
) : BaseAdapter() {
    private val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int = listOfLanguages.size

    override fun getItem(position: Int): Any = listOfLanguages[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
    }

}