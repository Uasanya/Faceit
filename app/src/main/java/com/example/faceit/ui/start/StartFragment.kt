package com.example.faceit.ui.start

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.faceit.databinding.FragmentStartBinding
import com.example.faceit.ui.base.BaseFragment
import com.example.faceit.ui.stats.StatsFragment


class StartFragment : BaseFragment() {

    private var _binding: FragmentStartBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonStats.setOnClickListener {
            navigate(StatsFragment.newInstance(binding.edNickname.text.toString()))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }






}