package com.brian.potterbase.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.brian.potterbase.R
import com.brian.potterbase.network.PotterCharacterItem
import com.squareup.picasso.Picasso


class PotterListAdapter(
    potterList: MutableList<PotterCharacterItem>
) :
    RecyclerView.Adapter<PotterListAdapter.PotterListViewHolder>() {

    inner class PotterListViewHolder(val view: View) :
        RecyclerView.ViewHolder(view) {

            val potterImageView: ImageView = view.findViewById(R.id.potterImageView)
        val potterName : TextView = view.findViewById(R.id.potterName)
        val potterHouse : TextView = view.findViewById(R.id.potterHouse)

    }

    private val diffCallback = object : DiffUtil.ItemCallback<PotterCharacterItem>() {
        override fun areItemsTheSame(
            oldItem: PotterCharacterItem,
            newItem: PotterCharacterItem
        ): Boolean {
            return oldItem.image == newItem.image
        }

        override fun areContentsTheSame(
            oldItem: PotterCharacterItem,
            newItem: PotterCharacterItem
        ): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)
    private var potters: MutableList<PotterCharacterItem>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PotterListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.potter_item, parent, false)
        return PotterListViewHolder(view)
    }

    override fun onBindViewHolder(holder: PotterListViewHolder, position: Int) {

        holder.view.apply {
            val potter = potters[position]
            Picasso.get().load(potter.image).into(holder.potterImageView)
            holder.potterName.text = potter.name
            holder.potterHouse.text = potter.house
        }
//        holder.binding.apply {
//            val potter = potters[position]
//            Picasso.get().load(potter.image).into(potterImageView)
//           potterName.text = potter.name
//            potterHouse.text = potter.house
//        }
    }

    override fun getItemCount(): Int {
        return potters.size
    }
}
















//class PotterListAdapter(potterItemList: LiveData<List<PotterCharacterItem>>) :
//    ListAdapter<PotterCharacterItem, PotterListAdapter.PotterListViewHolder>(DiffCallback) {
//
//
//    inner class PotterListViewHolder(val binding: PotterItemBinding) :
//        RecyclerView.ViewHolder(binding.root) {
//
//
//    }
//
//    override fun onCreateViewHolder(
//        parent: ViewGroup,
//        viewType: Int
//    ): PotterListAdapter.PotterListViewHolder {
//        return PotterListViewHolder(
//            PotterItemBinding.inflate(
//                LayoutInflater.from(parent.context),
//                parent,
//                false
//            )
//        )
//
//    }
//
//    override fun onBindViewHolder(holder: PotterListViewHolder, position: Int) {
//        val potterItem = getItem(position)
//        holder.binding.apply {
//            Picasso.get().load(potterItem.image).into(potterImageView)
//            potterName.text = potterItem.name
//            potterHouse.text = potterItem.house
//        }
//    }
//
//    companion object DiffCallback : DiffUtil.ItemCallback<PotterCharacterItem>(){
//        override fun areItemsTheSame(
//            oldItem: PotterCharacterItem,
//            newItem: PotterCharacterItem
//        ): Boolean {
//            return oldItem.name == newItem.name
//        }
//
//        override fun areContentsTheSame(
//            oldItem: PotterCharacterItem,
//            newItem: PotterCharacterItem
//        ): Boolean {
//            return oldItem.image == newItem.image
//        }
//
//    }
//
//
//}