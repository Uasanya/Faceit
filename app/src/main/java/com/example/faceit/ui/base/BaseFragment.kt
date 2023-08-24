package com.example.faceit.ui.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.faceit.R

abstract class BaseFragment: Fragment() {

    private var fm: FragmentManager? = null

        override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        fm = requireActivity().supportFragmentManager
    }

    protected fun navigate(fragment: Fragment){
        val ft : FragmentTransaction? = fm?.beginTransaction()
        ft?.replace(R.id.container, fragment, fragment.tag )?.addToBackStack(null)?.commit()
    }

}