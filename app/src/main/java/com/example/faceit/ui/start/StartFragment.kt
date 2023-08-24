package com.example.faceit.ui.start

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.faceit.R
import com.example.faceit.ui.stats.StatsFragment
import com.example.faceit.ui.base.BaseFragment


class StartFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_start, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nickname: EditText = view.findViewById(R.id.ed_nickname)
        val showStat: Button = view.findViewById(R.id.button_stats)

        showStat.setOnClickListener {
            val text: String = nickname.text.toString()
            navigate(StatsFragment.newInstance(text))
        }
    }






}