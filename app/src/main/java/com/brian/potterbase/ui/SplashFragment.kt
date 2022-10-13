package com.brian.potterbase.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.brian.potterbase.R
import com.brian.potterbase.databinding.FragmentSplashBinding


class SplashFragment : Fragment() {

    private val viewModel : PotterViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentSplashBinding.inflate(inflater, container, false)

        viewModel.getCharacterItems()
        binding.splashButton.setOnClickListener{
           findNavController().navigate(R.id.action_splashFragment_to_potterListFragment)
        }
        val view = binding.root
        return view
    }
}