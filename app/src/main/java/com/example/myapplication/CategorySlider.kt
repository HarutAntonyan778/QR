package com.example.myapplication

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView

class CategorySlider(var context: Context, val views: ArrayList<Category>): PagerAdapter() {
    lateinit var layoutInflater: LayoutInflater
    override fun isViewFromObject(p0: View, p1: Any): Boolean {
       return p0 == p1 as LinearLayout
    }

    override fun getCount(): Int {
        return views.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var view: View = layoutInflater.inflate(R.layout.category_slider,container,false)


//        var imageSlider: ImageView = view.findViewById(R.id.imageView)
        var title: TextView = view.findViewById(R.id.textView)
        var description: TextView = view.findViewById(R.id.textView2)

//        imageSlider.setImageResource(views[position].image)
        title.setText(views[position].name)
        description.setText(views[position].description)


        container.addView(view)
        return view
    }

    fun addV(image: Int, name: String, description: String) {
        views.add(Category(image,description,name))
        notifyDataSetChanged()
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as LinearLayout)
    }
}