package com.example.myapplication

import android.graphics.drawable.Drawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import kotlinx.android.synthetic.main.activity_categories.*

class Categories : AppCompatActivity() {
    lateinit var slider: CategorySlider
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)
        val views: ArrayList<Category> = ArrayList()
        views.add(Category(R.drawable.alcohol,"DRINK","The drink is the best thing that every kind of man can drink"))
        views.add(Category(R.drawable.food_c,"FOOD","The drink is the best thing that every kind of man can drink"))
        slider = CategorySlider(this,views)
        sliderViewPager.adapter = slider
        sliderViewPager.setOnPageChangeListener(object: ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(p0: Int) {

            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {

               materialScrollingLayout.background =resources.getDrawable(views.get(p0).image)
            }

            override fun onPageSelected(p0: Int) {

            }

        })
    }
}
