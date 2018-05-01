package com.allerap.android.pulsechallenge.feature.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.allerap.android.pulsechallenge.R
import com.allerap.android.pulsechallenge.data.entities.Item
import kotlinx.android.synthetic.main.view_item.view.*

class MainAdapter(private val items: List<Item>, private val listener: MainAdapter.OnClickListener) : RecyclerView.Adapter<MainAdapter.RatesViewHolder>() {

    interface OnClickListener {
        fun onItemClick(item: Item)
    }

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): RatesViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.view_item, parent, false)
        return RatesViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(
            holder: RatesViewHolder,
            position: Int
    ) {
        val item = items[position]
        holder.bind(item)
        holder.itemView
        holder.itemView.setOnClickListener {
            listener.onItemClick(item)
        }
    }

    class RatesViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        private val tvTile = view.tvTitle
        private val tvSubtitle = view.tvSubtitle
        private val tvDate = view.tvDate

        fun bind(item: Item) {
            tvTile.text = item.title
            tvSubtitle.text = item.subtitle
            tvDate.text = item.date
        }
    }
}
