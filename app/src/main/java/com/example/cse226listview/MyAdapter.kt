package com.example.cse226listview

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.ColorSpace.Model
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MyAdapter(var mCtx: Context, var resourse:Int,
                var items:MutableList<customview1>):ArrayAdapter<customview1>(mCtx,resourse,items) {
    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater:LayoutInflater=LayoutInflater.from(mCtx)
        val view:View=layoutInflater.inflate(resourse,null)
        val imageView:ImageView=view.findViewById(R.id.image)
        val textView:TextView=view.findViewById(R.id.text1)
        val destextView:TextView=view.findViewById(R.id.destext)
        val delete:Button=view.findViewById(R.id.button)
        val mItem:customview1=items[position]
//        imageView.setImageDrawable(mCtx.resources.getDrawable(mItem.img))\
        imageView.setImageURI(Uri.parse(mItem.img.toString()))
        textView.text=mItem.title
        destextView.text=mItem.subtitle
        delete.setOnClickListener {
            items.removeAt(position)
            notifyDataSetChanged()
        }
        return view
        //return super.getView(position, convertView, parent)
    }
}