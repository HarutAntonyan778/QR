package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_items.*

class ItemsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)
        view.setBackgroundColor(Color.parseColor(intent.getStringExtra("color")))
        menu_image.setImageDrawable(getDrawable(intent.getIntExtra("image",0)))
        items_category_name.text = intent.getStringExtra("category")
    }
}
