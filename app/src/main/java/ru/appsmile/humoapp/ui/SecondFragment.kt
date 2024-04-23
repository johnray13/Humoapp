package ru.appsmile.humoapp.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.appsmile.humoapp.APP_ACTIVITY
import ru.appsmile.humoapp.CountriesAdapter.CountriesAdapter
import ru.appsmile.humoapp.R
import ru.appsmile.humoapp.data.Countries
import ru.appsmile.humoapp.databinding.SecondPartBinding
import ru.appsmile.humoapp.replaceFragment
import java.util.Locale


class SecondFragment : Fragment() {

    private lateinit var binding: SecondPartBinding
    private lateinit var rcView:RecyclerView
    private lateinit var adapter: CountriesAdapter

    private var countries = listOf<Countries>(
        Countries("Россия",R.drawable.rus),
        Countries("Узбекистан",R.drawable.uzb),
        Countries("Таджикистан",R.drawable.tjk),
        Countries("Казахстан",R.drawable.kaz),
        Countries("ОАЭ",R.drawable.oae),
        Countries("Корея",R.drawable.kor),
        Countries("Украина",R.drawable.uk),

        )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding=SecondPartBinding.inflate(layoutInflater,container,false)
        return (binding.root)


    }

    override fun onResume() {
        super.onResume()

        initRcView()

        binding.back.setOnClickListener {
            replaceFragment(MainFragment(),false)
        }

        binding.searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }
        })
    }

    private fun filterList(query: String?) {

        if (query!=null){
            val filteredList =ArrayList<Countries>()
            for (i in countries){
                if (i.title.lowercase(Locale.ROOT).contains(query)){
                    filteredList.add(i)
                }
            }

            if (filteredList.isEmpty()){
                Toast.makeText(APP_ACTIVITY,"Не нашлось такой страны !",Toast.LENGTH_SHORT).show()
                adapter.setFilterList(filteredList)
            }else{
                adapter.setFilterList(filteredList)
            }
        }
    }


    private fun initRcView(){
        rcView=binding.rcView
        rcView.layoutManager = LinearLayoutManager(APP_ACTIVITY)
        adapter = CountriesAdapter(countries)
        rcView.adapter=adapter
    }

}