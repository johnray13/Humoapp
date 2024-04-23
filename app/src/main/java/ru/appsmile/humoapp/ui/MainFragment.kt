package ru.appsmile.humoapp.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.appsmile.humoapp.CountriesAdapter.CountriesAdapter
import ru.appsmile.humoapp.R
import ru.appsmile.humoapp.data.Countries
import ru.appsmile.humoapp.databinding.MainPartBinding
import ru.appsmile.humoapp.replaceFragment


class MainFragment : Fragment() {

    private lateinit var binding: MainPartBinding
    private lateinit var rcView: RecyclerView
    private lateinit var adapter: CountriesAdapter

    private var popCountriesList = listOf<Countries>(
        Countries("Таджикистан", R.drawable.tjk),
        Countries("Россия", R.drawable.rus),
        Countries("Узбекстан", R.drawable.uzb)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainPartBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        initRcView()

        binding.sentm.setOnClickListener {
            replaceFragment(SecondFragment())
        }

        binding.cardV3.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/details?id=tj.humo.transfer"))
            )
        }
    }


    private fun initRcView() {
        rcView = binding.rcView
        rcView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        adapter = CountriesAdapter(popCountriesList,true)
        rcView.adapter = adapter
    }


}