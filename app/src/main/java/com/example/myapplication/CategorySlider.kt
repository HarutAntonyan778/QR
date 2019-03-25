package com.example.myapplication

import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.support.constraint.ConstraintLayout
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.util.Pair
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

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


        var imageSlider: ImageView = view.findViewById(R.id.menu_image)
        var title: TextView = view.findViewById(R.id.textView)
        var description: TextView = view.findViewById(R.id.textView2)

        imageSlider.setImageResource(views[position].image)
        title.setTextColor(Color.parseColor(views[position].color))
        description.setTextColor(Color.parseColor(views[position].color))
        title.setText(views[position].name)
        description.setText(views[position].description)



        container.addView(view)
        return view
    }



    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as LinearLayout)
    }
}