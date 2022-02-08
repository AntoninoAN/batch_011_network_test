package com.example.networktest.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.networktest.databinding.DetailBookFragmentLayoutBinding
import com.example.networktest.model.presentation.VolumeItem

class DetailFragment: Fragment() {

    companion object{
        const val DETAIL_BOOK = "DetailBook"
        private const val TAG = "DetailFragment"

        fun newInstance(book: VolumeItem): DetailFragment{
            return DetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(DETAIL_BOOK,book)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DetailBookFragmentLayoutBinding.inflate(inflater,
        container,
        false)

        arguments?.getParcelable<VolumeItem>(DETAIL_BOOK)?.let {
            binding.tvDetailTitle.text = it.title
        }
        super.onCreateView(inflater, container, savedInstanceState)

        return binding.root
    }
}