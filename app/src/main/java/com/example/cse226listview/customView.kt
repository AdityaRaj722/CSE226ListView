package com.example.cse226listview

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.ColorSpace.Model
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.ListView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog

class customView : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    lateinit var edt1:EditText
    lateinit var edt2:EditText
    lateinit var add:Button
    private lateinit var imageView: ImageView
    private var selectedImageUri: Uri?=null
    private val Pick_Image=1
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_view)
        var listView: ListView = findViewById(R.id.listview)
        var list = mutableListOf<customview1>()
        edt1 = findViewById(R.id.edt1)
        edt2 = findViewById(R.id.edt2)
        add  = findViewById(R.id.addbtn)
        imageView = findViewById(R.id.custimg)
//        list.add(customview1("Fcaebook", "Fb description", R.drawable.ic_launcher_background))
//        list.add(customview1("Youtube", "yt description", R.drawable.ic_launcher_background))
//        list.add(customview1("Instagram", "Ig description", R.drawable.ic_launcher_background))
//        list.add(customview1("Chat", "chat description", R.drawable.ic_launcher_background))
        var ad = MyAdapter(
            this, R.layout.second, list
        )
        listView.adapter = ad
        imageView.setOnClickListener {
            val intent = Intent(
                Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI

            )
            startActivityForResult(intent,Pick_Image)
        }
        add.setOnClickListener {
            selectedImageUri?.let{
                list.add(customview1(edt1.text.toString(),edt2.text.toString(),it))
                Toast.makeText(this,"added",Toast.LENGTH_SHORT).show()
                ad.notifyDataSetChanged()
            }?:run{
                Toast.makeText(this,"Please select image",Toast.LENGTH_SHORT).show()
            }
        }
        // listView.adapter=MyAdapter(this,R.layout.second,list)
//        listView.setOnItemClickListener{ adapterView,view,i,l->
//            list.removeAt(i)
//            ad.notifyDataSetChanged()
//
//        }
//        listView.setOnItemLongClickListener{adapterView,view,i,l->
//            list.removeAt(i)
//            ad.notifyDataSetChanged()
//            true
//        }
//        listView.setOnItemClickListener{adapterView,view,i,l->
//            val b=AlertDialog.Builder(this)
//            b.setTitle("Are you sure?")
//            b.setCancelable(true)
//            b.setPositiveButton("yes"){
//                a,b->
//                list.removeAt(i)
//                ad.notifyDataSetChanged()
//            }
//            b.setNegativeButton("No") { a, b ->
//                a.dismiss()
//            }
//            b.show()
//            true
//
//        }
    }
        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)
            if(requestCode==1 && resultCode==Activity.RESULT_OK){
                selectedImageUri=data?.data
                selectedImageUri?.let{
                    val bitmap:Bitmap=MediaStore.Images.Media.getBitmap(this.contentResolver,it)
                    imageView.setImageBitmap(bitmap)
                }
            }
        }

}