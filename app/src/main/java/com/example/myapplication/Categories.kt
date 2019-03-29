package com.example.myapplication

import android.app.ActivityOptions
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.util.Pair
import android.view.View
import kotlinx.android.synthetic.main.activity_categories.*
import android.view.animation.DecelerateInterpolator
import android.transition.ChangeBounds
import android.transition.Transition
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener


class Categories : AppCompatActivity() {


    lateinit var slider: CategorySlider
    var position: Int = 0
    val views: ArrayList<Category> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)

        window.enterTransition = enterTransition()
        window.exitTransition = returnTransition()

        FirebaseHelper.firebaseCategories.child("categories").addValueEventListener(object: ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                for (snap in p0!!.children) {

                    views.add(snap.getValue(Category::class.java)!!)
                    slider.notifyDataSetChanged()

                }
            }
        })

        slider = CategorySlider(this, views)
        sliderViewPager.adapter = slider

        sliderViewPager.setPageTransformer(true,ZoomOutTransformation())

//        materialScrollingLayout.setOnClickListener(object: View.OnClickListener{
//            override fun onClick(v: View?) {
//                Toast.makeText(this@Categories,"position is ${position}",Toast.LENGTH_LONG)

//            }
//        })




// then you can simply use the standard onClickListener ...

        sliderViewPager.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(p0: Int) {

            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {

            }

            override fun onPageSelected(p0: Int) {
                position = p0

            }



        })



    }

    private fun enterTransition(): Transition {
        val bounds = ChangeBounds()
        bounds.duration = 5000

        return bounds
    }

    private fun returnTransition(): Transition {
        val bounds = ChangeBounds()
        bounds.interpolator = DecelerateInterpolator()
        bounds.duration = 5000

        return bounds
    }

    fun selectItem(category: Category) {

    }

    public fun updateRange(v: View) {
        val inten: Intent = Intent(this@Categories,ItemsActivity::class.java)
        inten.putExtra("category",views[position].title)
        inten.putExtra("image",views[position].image)
//                val pairs: Array<Pair<View,String>> = arrayOf()
        val transition: ActivityOptions = ActivityOptions.makeSceneTransitionAnimation(this@Categories, Pair<View,String>(findViewById(R.id.menu_image),"category_image_transition"),Pair<View,String>(findViewById(R.id.materialScrollingLayout),"category_title_transition") )
        startActivity(inten,transition.toBundle())
    }


}
