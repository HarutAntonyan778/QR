package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_items.*

class ItemsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)
        view.setBackgroundColor(Color.parseColor(intent.getStringExtra("color")))
        menu_image.setImageDrawable(getDrawable(intent.getIntExtra("image",0)))
        items_category_name.text = intent.getStringExtra("category")
        val items = ArrayList<Item>()
        var adapter = RecycleViewAdapter(this,items)
        recycler_layout.adapter =  adapter
        recycler_layout.layoutManager = LinearLayoutManager(this)
        Handler().postDelayed(Runnable {
            items.add(Item("Hello","500 AMD",R.drawable.alcohol, "Will be ready in 5 mins"))
            items.add(Item("Hello","500 AMD",R.drawable.alcohol, "Will be ready in 5 mins"))
            items.add(Item("Hello","500 AMD",R.drawable.alcohol, "Will be ready in 5 mins"))
            items.add(Item("Hello","500 AMD",R.drawable.alcohol, "Will be ready in 5 mins"))
            items.add(Item("Hello","500 AMD",R.drawable.alcohol, "Will be ready in 5 mins"))
            items.add(Item("Hello","500 AMD",R.drawable.alcohol, "Will be ready in 5 mins"))
            items.add(Item("Hello","500 AMD",R.drawable.alcohol, "Will be ready in 5 mins"))
            items.add(Item("Hello","500 AMD",R.drawable.alcohol, "Will be ready in 5 mins"))
            items.add(Item("Hello","500 AMD",R.drawable.alcohol, "Will be ready in 5 mins"))
            items.add(Item("Hello","500 AMD",R.drawable.alcohol, "Will be ready in 5 mins"))
            items.add(Item("Hello","500 AMD",R.drawable.alcohol, "Will be ready in 5 mins"))
            items.add(Item("Hello","500 AMD",R.drawable.alcohol, "Will be ready in 5 mins"))
            items.add(Item("Hello","500 AMD",R.drawable.alcohol, "Will be ready in 5 mins"))
            items.add(Item("Hello","500 AMD",R.drawable.alcohol, "Will be ready in 5 mins"))
            items.add(Item("Hello","500 AMD",R.drawable.alcohol, "Will be ready in 5 mins"))
            items.add(Item("Hello","500 AMD",R.drawable.alcohol, "Will be ready in 5 mins"))
            items.add(Item("Hello","500 AMD",R.drawable.alcohol, "Will be ready in 5 mins"))
            items.add(Item("Hello","500 AMD",R.drawable.alcohol, "Will be ready in 5 mins"))
            items.add(Item("Hello","500 AMD",R.drawable.alcohol, "Will be ready in 5 mins"))
            items.add(Item("Hello","500 AMD",R.drawable.alcohol, "Will be ready in 5 mins"))
            items.add(Item("Hello","500 AMD",R.drawable.alcohol, "Will be ready in 5 mins"))

            adapter.shim = false
            adapter.notifyDataSetChanged()
        },1000)
    }
}
