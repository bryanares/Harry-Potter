package com.brian.potterbase.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.brian.potterbase.CharacterDetailActivity
import com.brian.potterbase.databinding.FragmentPotterListBinding
import com.brian.potterbase.network.PotterCharacterItem

class PotterListFragment : Fragment() {

    private var _binding: FragmentPotterListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: PotterViewModel by activityViewModels()
    private lateinit var potterListAdapter: PotterListAdapter
    private lateinit var character : PotterCharacterItem

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPotterListBinding.inflate(inflater, container, false)
        potterListAdapter = PotterListAdapter(this)
        viewModel.getCharacter()
//        setupRecyclerView()
        return binding.root
    }

//    private fun setupRecyclerView() = binding.potterListRecyclerView.apply {
//        adapter = potterListAdapter
//        layoutManager = LinearLayoutManager(this.context)
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.potterCharacterItems.observe(viewLifecycleOwner) {
            binding.potterListRecyclerView.adapter = potterListAdapter
            potterListAdapter.allItem = it
            binding.potterListRecyclerView.layoutManager = LinearLayoutManager(this.context)
        }
    }

    fun onItemClick(position: Int) {
        Toast.makeText(this.context, "Character clicked", Toast.LENGTH_SHORT).show()
        val intent = Intent(this.context, CharacterDetailActivity::class.java)

        intent.putExtra("PotterImage", potterListAdapter.allItem[position].image)
        intent.putExtra("PotterName", potterListAdapter.allItem[position].name)
        intent.putExtra("PotterSpecies", potterListAdapter.allItem[position].species)
        intent.putExtra("PotterHouse", potterListAdapter.allItem[position].house)
        intent.putExtra("PotterAncestry", potterListAdapter.allItem[position].ancestry)
        intent.putExtra("PotterPatronus", potterListAdapter.allItem[position].patronus)
        intent.putExtra("PotterActor", potterListAdapter.allItem[position].actor)
        intent.putExtra("PotterBirthday", potterListAdapter.allItem[position].dateOfBirth)

        startActivity(intent)
    }


}