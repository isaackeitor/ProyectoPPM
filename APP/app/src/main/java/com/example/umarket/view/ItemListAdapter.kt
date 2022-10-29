package com.example.umarket.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.umarket.model.Item
import com.example.umarket.databinding.ItemsViewFragmentBinding
import com.squareup.picasso.Picasso


class ItemListAdapter(private val itemList: List<Item>) : RecyclerView.Adapter<ItemListAdapter.ItemListHolder>() {

    inner class ItemListHolder(val binding: ItemsViewFragmentBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemListHolder {
        val binding = ItemsViewFragmentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemListHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemListHolder, position: Int) {
        val item = itemList[position]
        holder.binding.itemName.text = item.title
        holder.binding.itemPrice.text = "$"+item.price.toString()
        holder.binding.itemPlace.text = item.category
        //holder.binding.itemPrice.text = item.price.toString()
        Picasso.get().load(item.imageUrlFront).into(holder.binding.pokemonPhoto)
    }
    override fun getItemCount(): Int {
        return itemList.size
    }
}