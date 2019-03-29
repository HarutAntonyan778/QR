package com.example.myapplication

import android.app.ActivityOptions
import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Pair
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.google.firebase.FirebaseApp
import com.google.firebase.database.*
import com.google.firebase.firestore.FirebaseFirestore
import com.google.zxing.integration.android.IntentIntegrator
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.new_version.*
import java.io.File

class MainActivity : AppCompatActivity() {
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_version)
        menu_title.animation = AnimationUtils.loadAnimation(this,R.anim.title_animation)
        menu_icon.animation = AnimationUtils.loadAnimation(this,R.anim.icon_animation)
        database = FirebaseDatabase.getInstance().reference




    }

    public fun scanNow(v: View) {
        val inten:Intent = Intent(this,Categories::class.java)
//                val options: ActivityOptions = ActivityOptions.makeSceneTransitionAnimation(this, Pair(logo,"applogot"))
//                startActivity(inten,options.toBundle())
//        startActivity(inten)
            IntentIntegrator(this).initiateScan()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if(result.getContents() == null) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            } else {
                val inten:Intent = Intent(this,Categories::class.java)
//                val options: ActivityOptions = ActivityOptions.makeSceneTransitionAnimation(this, Pair(logo,"applogot"))
//                startActivity(inten,options.toBundle())
                val myRef = database.child("caffee").child(result.getContents())
                FirebaseHelper.firebaseCategories = myRef
                startActivity(inten)
                Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
