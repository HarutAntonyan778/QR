package com.example.myapplication

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.squareup.picasso.Picasso


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


//        imageSlider.setImageResource(views[position].image)
        Picasso.get().load(views[position].image).into(imageSlider)
        title.setText(views[position].title)
        description.setText(views[position].description)



        container.addView(view)
        return view
    }



    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as LinearLayout)
    }
}