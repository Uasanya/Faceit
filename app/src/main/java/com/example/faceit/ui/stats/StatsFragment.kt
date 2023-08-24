package com.example.faceit.ui.stats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.faceit.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StatsFragment : Fragment() {

    private var text: String? = null
    private val statsAdapter: StatsAdapter = StatsAdapter()
    private val viewModel: StatsViewModel by viewModels()

    companion object {
        private const val ARG_PARAM1: String = "key"

        fun newInstance(nickname: String): Fragment {
            val statsFragment = StatsFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, nickname)
            statsFragment.arguments = args
            return statsFragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        text = arguments?.getString(ARG_PARAM1)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_stats, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nickname: TextView = view.findViewById(R.id.tv_nickname)
        nickname.text = text
        val rv: RecyclerView = view.findViewById(R.id.rv)
        rv.adapter = statsAdapter

       //let == if (text != null)
        text?.let { viewModel.getStats(it) }

        viewModel.statsLiveData.observe(viewLifecycleOwner){matches ->
            statsAdapter.setStats(matches)
        }
    }
}