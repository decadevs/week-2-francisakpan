package com.example.week2.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week2.fragments.Implementation2Fragment
import com.example.week2.R
import kotlinx.android.synthetic.main.activity_implementation2.*

class Implementation2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implementation2)

        // Set listener to add fragments to the screen on each button press.
        btn_add.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace( // Replaces a new fragment on top of a previous fragment in the backstack
                    R.id.frag_container,
                    Implementation2Fragment.newInstance(supportFragmentManager.backStackEntryCount)
                )
                .addToBackStack(null)
                .commit()
        }

        // Set listener to remove fragment from the screen by mimicking onBackPressed
        btn_remove.setOnClickListener {
            val fragment = supportFragmentManager.findFragmentById(R.id.frag_container)
            if (fragment != null) {
                this.onBackPressed()
            }
        }
    }
}