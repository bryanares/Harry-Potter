package com.brian.potterbase

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.brian.potterbase.databinding.ActivityCharacterDetailBinding
import com.squareup.picasso.Picasso

class CharacterDetailActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityCharacterDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCharacterDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val characterImage: ImageView = binding.potterImage
        val characterName : TextView = binding.potterName
        val characterSpecies : TextView = binding.potterSpecies
        val characterActor : TextView = binding.potterActor
        val characterHouse : TextView = binding.potterHouse
        val characterAncestry : TextView = binding.potterAncestry
        val characterPatronus : TextView = binding.potterPatronus
        val characterBirthday : TextView = binding.potterBirthYear

        Picasso.get().load(intent.getStringExtra("PotterImage")).into(characterImage)
        characterName.text = intent.getStringExtra("PotterName").toString()
        characterSpecies.text = intent.getStringExtra("PotterSpecies").toString()
        characterActor.text = intent.getStringExtra("PotterActor").toString()
        characterHouse.text = intent.getStringExtra("PotterHouse").toString()
        characterAncestry.text = intent.getStringExtra("PotterAncestry").toString()
        characterPatronus.text = intent.getStringExtra("PotterPatronus").toString()
        characterBirthday.text = intent.getStringExtra("PotterBirthday").toString()


    }
}