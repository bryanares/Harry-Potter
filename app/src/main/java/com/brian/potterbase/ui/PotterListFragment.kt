package com.brian.potterbase.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.brian.potterbase.R
import com.brian.potterbase.databinding.FragmentPotterListBinding
import com.brian.potterbase.network.PotterApi

class PotterListFragment : Fragment() {
    private var _binding : FragmentPotterListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: PotterViewModel by activityViewModels()
    private lateinit var potterListAdapter: PotterListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPotterListBinding.inflate(inflater, container, false)
        viewModel.getCharacterItems()


//        setupRecyclerView()


        val view = binding.root
        return view
    }

//    private fun setupRecyclerView() = binding.potterListRecyclerView.apply {
//        adapter = potterListAdapter
//        layoutManager = LinearLayoutManager(this.context)
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        potterListAdapter = PotterListAdapter(mutableListOf())
        val adapter = potterListAdapter

        binding.potterListRecyclerView.apply {
            binding.potterListRecyclerView.adapter = adapter
            binding.potterListRecyclerView.layoutManager = LinearLayoutManager(this.context)
            viewModel.getCharacterItems()
        }
    }

}