package com.example.week2.activities

import android.content.res.Configuration
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.week2.R
import kotlinx.android.synthetic.main.activity_implementation1.*

class Implementation1Activity : AppCompatActivity() {

    companion object {
        private const val STATE_COUNTER = "counter" //Key for savedInstanceState
    }

    private var count = 0
    private val handler = Handler()

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(STATE_COUNTER, count) // save the rotation count to saveInstanceState
    }

    private fun showToast(msg: String) = Toast.makeText(this, msg, Toast.LENGTH_LONG).show()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implementation1)

        //set state textview to onCreate since onCreate state is called
        txt_state.text = getString(R.string.oncreate_text)
        showToast("Created")

        //If not null get the savedInstance count and assign it to count
        savedInstanceState?.let {
            count = it.getInt(STATE_COUNTER)
        }

        //Set orientation textview to display current device orientation and orientation count
        txt_orientation.text = when (resources.configuration.orientation) {
            Configuration.ORIENTATION_PORTRAIT -> "PORTRAIT: ${count++}"
            else -> "LANDSCAPE: ${count++}"
        }
    }

    override fun onStart() {
        super.onStart()

        //Use handler to delay setting OnStart text to state textview
        handler.postDelayed( {
            txt_state.text = getString(R.string.onstart_text)
        }, 1000)
        showToast("Onstart")
    }

    override fun onResume() {
        super.onResume()
        //Use handler to delay setting onResume text to state textview
        handler.postDelayed( {
            txt_state.text = getString(R.string.onresume_text)
        }, 1500)
        showToast("OnResume")
    }

    override fun onRestart() {
        super.onRestart()
        //Use handler to delay setting onRestart text to state textview
        handler.postDelayed( {
            txt_state.text = getString(R.string.onrestart_text)
        }, 2000)
        showToast("OnRestart")
    }

    override fun onStop() {
        super.onStop()
        //Set onStopped state to state textview
        txt_state.text = getString(R.string.onstop_text)
        showToast("OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        txt_state.text = getString(R.string.ondestroy_text)
        showToast("OnDestroy")
    }
}