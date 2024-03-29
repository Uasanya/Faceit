package com.example.faceit.ui.stats

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.faceit.databinding.FragmentStatsBinding
import com.example.faceit.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StatsFragment : BaseFragment<FragmentStatsBinding>(FragmentStatsBinding::inflate) {

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvNickname.text = text
        binding.rv.adapter = statsAdapter
        text?.let { viewModel.getStats(it) }
        viewModel.statsLiveData.observe(viewLifecycleOwner) { matches ->
            statsAdapter.setStats(matches)
            binding.progressBar.visibility = ProgressBar.GONE
        }
        viewModel.errorLiveData.observe(viewLifecycleOwner) {
            binding.tvNoData.visibility = View.VISIBLE
            binding.rv.visibility = View.GONE
        }
    }
}