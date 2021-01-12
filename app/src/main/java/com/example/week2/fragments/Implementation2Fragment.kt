package com.example.week2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.week2.R
import kotlinx.android.synthetic.main.fragment_implementation2.*

/**
 * A simple [Fragment] subclass.
 * Use the [Implementation2Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Implementation2Fragment : Fragment() {
    private var stackCount: Int? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*
         *   Read Value from arguments from the newInstance constructor
         *   Allows for Persistence on fragment change states.
         */
        arguments?.let {
            stackCount = it.getInt(ARG_COUNT) + 1 // Increase backStackEntryCount by 1 since the first value returned is 0.
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_implementation2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Set fragment count on the fragment textview
        fragment_text.text = getString(R.string.fragment_text_placeholder, stackCount)
    }

    companion object {
        private const val ARG_COUNT: String = "param1"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param count Parameter 1.
         * @return A new instance of fragment Implementation2Fragment.
         */
        @JvmStatic
        fun newInstance(count: Int) =
            Implementation2Fragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COUNT, count)
                }
            }

    }
}