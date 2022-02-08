package com.example.networktest.view

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.networktest.R
import com.example.networktest.databinding.ItemLayoutBinding
import com.example.networktest.model.presentation.VolumeItem
import com.squareup.picasso.Picasso

private const val TAG = "BookViewHolder"
class BookViewHolder(private val binding: ItemLayoutBinding):
    RecyclerView.ViewHolder(binding.root) {

        fun onBind(volumeItem: VolumeItem, callback: (VolumeItem)-> Unit){
            //String templates
            // Title: ;klasd;lksafd;klasdf
            // Authors: "[Autho1,Aurtho2]"
            binding.tvBookAuthors.text = binding.root.context.getString(
                R.string.book_authors,
                volumeItem.authors.toString()
            )
            binding.tvBookTitle.text = binding.root.context.getString(
                R.string.book_title,
                volumeItem.title
            )

            Log.d(TAG, "onBind: ${volumeItem.imageLinks.thumbnail}")
            Picasso.get()
                .load(volumeItem.imageLinks.thumbnail)
                .into(binding.ivBookCover)

            binding.root.setOnClickListener {
                callback(volumeItem)
            }
        }
}