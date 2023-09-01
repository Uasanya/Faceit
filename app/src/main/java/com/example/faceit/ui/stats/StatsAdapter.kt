package com.example.faceit.ui.stats

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.faceit.R
import com.example.faceit.data.model.DateConverter
import com.example.faceit.data.model.MatchEntity
import com.example.faceit.databinding.ItemGameBinding

class StatsAdapter : RecyclerView.Adapter<StatsAdapter.StatsViewHolder>() {

    private var matches: List<MatchEntity> = emptyList()

    fun setStats(matchEntities: List<MatchEntity>) {
        matches = matchEntities
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatsViewHolder {
        val binding = ItemGameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StatsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StatsViewHolder, position: Int) {
        holder.bind(matches[position])
    }

    override fun getItemCount(): Int = matches.size

    inner class StatsViewHolder(private val binding: ItemGameBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(match: MatchEntity) {
            val date: Long = match.date
            val score: String = match.score
            val map: String = match.map
            val kills: Int = match.kills
            val deaths: Int = match.deaths
            val assists: Int = match.assists
            val kd: Double = match.kd
            val statistic = "$kills-$deaths-$assists (KD:$kd)"
            val time: String = DateConverter.convert(date)


            binding.tvTime.text = time
            binding.tvScore.text = score
            binding.tvMap.text = map
            binding.tvStat.text = statistic
            if (match.winner) {
                binding.tvStatus.text = itemView.context.getString(R.string.won)
                binding.tvStatus.setBackgroundResource(R.color.win)
                binding.tvScore.setBackgroundResource(R.color.win)
                binding.viewHolder.setBackgroundResource(R.drawable.border_win)
            } else {
                binding.tvStatus.text = itemView.context.getString(R.string.lost)
                binding.tvStatus.setBackgroundResource(R.color.lose)
                binding.tvScore.setBackgroundResource(R.color.lose)
                binding.viewHolder.setBackgroundResource(R.drawable.border_lose)
            }
        }
    }
}




