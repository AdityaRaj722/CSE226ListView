package com.example.cse226listview

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    lateinit var  lv:ListView
    lateinit var  ad:ArrayAdapter<String>
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ar= arrayOf("India","USA","Germany","Canada","Mongolia");
        lv=findViewById(R.id.listitem)
        ad=ArrayAdapter(this,android.R.layout.simple_list_item_1,ar)
        lv.adapter=ad

    }
}