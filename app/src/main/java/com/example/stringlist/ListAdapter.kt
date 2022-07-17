package com.example.stringlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.custom_row.view.*

    class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

        private var stringList = emptyList<StringItem>()

        class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))
        }

        override fun getItemCount(): Int {
            return stringList.size
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            val currentItem = stringList[position]
            holder.itemView.id_txt.text = currentItem.id.toString()
            holder.itemView.string_txt.text = currentItem.string


            holder.itemView.rowLayout.setOnClickListener {
                val action = ListFragmentDirections.actionListFragmentToUpdateFragment(currentItem)
                holder.itemView.findNavController().navigate(action)
            }
        }

        fun setData(stringItem: List<StringItem>){
            this.stringList = stringItem
            notifyDataSetChanged()
        }
    }
