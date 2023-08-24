package com.example.faceit.ui.stats

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.faceit.R
import com.example.faceit.data.model.DateConverter
import com.example.faceit.data.model.MatchEntity

class StatsAdapter : RecyclerView.Adapter<StatsAdapter.StatsViewHolder>() {

    private var matches: List<MatchEntity> = emptyList()

    fun setStats(matchEntities: List<MatchEntity>) {
        matches = matchEntities
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatsViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_game, parent, false)
        return StatsViewHolder(view)
    }

    override fun onBindViewHolder(holder: StatsViewHolder, position: Int) {
        holder.bind(matches[position])
    }

    override fun getItemCount(): Int = matches.size

    inner class StatsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val tvDateHolder: TextView = itemView.findViewById(R.id.tv_time)
        private val tvStatusHolder: TextView = itemView.findViewById(R.id.tv_status)
        private val tvScoreHolder: TextView = itemView.findViewById(R.id.tv_score)
        private val tvMapHolder: TextView = itemView.findViewById(R.id.tv_map)
        private val tvStatHolder: TextView = itemView.findViewById(R.id.tv_stat)
        private val tvViewHolder: View = itemView.findViewById(R.id.view_holder)



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


            tvDateHolder.text = time
            tvScoreHolder.text = score
            tvMapHolder.text = map
            tvStatHolder.text = statistic
            if (match.winner) {
                tvStatusHolder.text = itemView.context.getString(R.string.won)
                tvStatusHolder.setBackgroundResource(R.color.win)
                tvScoreHolder.setBackgroundResource(R.color.win)
                tvViewHolder.setBackgroundResource(R.drawable.border_win)
            } else {
                tvStatusHolder.text = itemView.context.getString(R.string.lost)
                tvStatusHolder.setBackgroundResource(R.color.lose)
                tvScoreHolder.setBackgroundResource(R.color.lose)
                tvViewHolder.setBackgroundResource(R.drawable.border_lose)
            }
        }
    }
}




