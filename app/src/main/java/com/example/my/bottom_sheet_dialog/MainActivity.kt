package com.example.my.bottom_sheet_dialog

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetDialog

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        val imgShow: ImageView = findViewById(R.id.img_show)
        imgShow.setOnClickListener {
            val view: View = layoutInflater.inflate(R.layout.diaolog_sheet, null)
            val diaolog = BottomSheetDialog(this)
            val vk = view.findViewById<ImageView>(R.id.vk)
            vk.setOnClickListener {
                val url = ""
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(url)
                startActivity(intent)
            }
            val close = view.findViewById<TextView>(R.id.tv_close)
            close.setOnClickListener {
                diaolog.dismiss()
            }
            diaolog.setCancelable(false)
            diaolog.setContentView(view)
            diaolog.show()
        }
    }

}