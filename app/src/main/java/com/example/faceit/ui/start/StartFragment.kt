package com.example.faceit.ui.start

import android.os.Bundle
import android.view.View
import com.example.faceit.databinding.FragmentStartBinding
import com.example.faceit.ui.base.BaseFragment
import com.example.faceit.ui.stats.StatsFragment


class StartFragment : BaseFragment<FragmentStartBinding>(FragmentStartBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonStats.setOnClickListener {
            navigate(StatsFragment.newInstance(binding.edNickname.text.toString()))
        }
    }
}