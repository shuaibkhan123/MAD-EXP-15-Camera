package com.example.cameraimgdisplay

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {
    lateinit var imgPhoto : ImageView
    private val REQUEST_CODE_TAKE_PICTURE = 100
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imgPhoto = findViewById(R.id.imgPhoto)
        val btTakePhoto : Button = findViewById(R.id.btTakePhoto)
        ActivityCompat.requestPermissions(this,
            arrayOf(android.Manifest.permission.CAMERA),REQUEST_CODE_TAKE_PICTURE )
        btTakePhoto.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, REQUEST_CODE_TAKE_PICTURE)
        }
        btTakePhoto.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, REQUEST_CODE_TAKE_PICTURE)
        }

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
    {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_CODE_TAKE_PICTURE && resultCode == RESULT_OK) {
            val photo = data!!.extras!!["data"] as Bitmap
            imgPhoto.setImageBitmap(photo)
        }
    }
}