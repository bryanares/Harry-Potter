package com.brian.potterbase.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.brian.potterbase.databinding.PotterItemBinding
import com.brian.potterbase.network.PotterCharacterItem
import com.squareup.picasso.Picasso


class PotterListAdapter(private val listener: PotterListFragment) :
    RecyclerView.Adapter<PotterListAdapter.PotterListViewHolder>() {


    var allItem: List<PotterCharacterItem> = emptyList()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class PotterListViewHolder(private val binding: PotterItemBinding) :
        RecyclerView.ViewHolder(binding.root),
        View.OnClickListener {

        fun bind(potter: PotterCharacterItem) {
            Picasso.get().load(potter.image).into(binding.potterImageView)
            binding.potterName.text = potter.name
            binding.potterHouse.text = potter.house

        }

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PotterListViewHolder {
        val view = LayoutInflater.from(parent.context)
        val binding = PotterItemBinding.inflate(view, parent, false)
        return PotterListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PotterListViewHolder, position: Int) {
        val character = allItem[position]
        holder.bind(character)
    }

    override fun getItemCount(): Int {
        return allItem.size
    }


    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

}


//class PotterListAdapter(
//    potterList: MutableList<PotterCharacterItem>
//) :
//    RecyclerView.Adapter<PotterListAdapter.PotterListViewHolder>() {
//
//    inner class PotterListViewHolder(val view: View) :
//        RecyclerView.ViewHolder(view) {
//        val potterImageView: ImageView = view.findViewById(R.id.potterImageView)
//        val potterName : TextView = view.findViewById(R.id.potterName)
//        val potterHouse : TextView = view.findViewById(R.id.potterHouse)
//
//
//    }
//
//    private val diffCallback = object : DiffUtil.ItemCallback<PotterCharacterItem>() {
//        override fun areItemsTheSame(
//            oldItem: PotterCharacterItem,
//            newItem: PotterCharacterItem
//        ): Boolean {
//            return oldItem.image == newItem.image
//        }
//
//        override fun areContentsTheSame(
//            oldItem: PotterCharacterItem,
//            newItem: PotterCharacterItem
//        ): Boolean {
//            return oldItem == newItem
//        }
//    }
//
//    private val differ = AsyncListDiffer(this, diffCallback)
//    private var potters: MutableList<PotterCharacterItem>
//        get() = differ.currentList
//        set(value) {
//            differ.submitList(value)
//        }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PotterListViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.potter_item, parent, false)
//        return PotterListViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: PotterListViewHolder, position: Int) {
//
//        holder.view.apply {
//            val potter = potters[position]
//            Picasso.get().load(potter.image).into(holder.potterImageView)
//            holder.potterName.text = potter.name
//            holder.potterHouse.text = potter.house
//        }
////        holder.binding.apply {
////            val potter = potters[position]
////            Picasso.get().load(potter.image).into(potterImageView)
////           potterName.text = potter.name
////            potterHouse.text = potter.house
////        }
//    }
//
//    override fun getItemCount(): Int {
//        return potters.size
//    }
//}