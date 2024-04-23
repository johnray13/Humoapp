package ru.appsmile.humoapp.CountriesAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import ru.appsmile.humoapp.APP_ACTIVITY
import ru.appsmile.humoapp.R
import ru.appsmile.humoapp.data.Countries

class CountriesAdapter(
    private var list_country: List<Countries>,
    private val isPopularXml: Boolean = false
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class PopularCountryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.pop_country_image)
        val tvText: TextView = view.findViewById(R.id.country_txt)
    }


    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.country_image)
        val tvText: TextView = view.findViewById(R.id.country_txt_2)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (isPopularXml) {
            true -> {
                val itemView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.pop_countries_item, parent, false)
                PopularCountryViewHolder(itemView)
            }

            false -> {
                val itemView2 = LayoutInflater.from(parent.context)
                    .inflate(R.layout.countries_item, parent, false)
                MyViewHolder(itemView2)
            }
        }
    }

    override fun getItemCount(): Int = list_country.size


    fun setFilterList(list: List<Countries>) {
        this.list_country = list
        notifyDataSetChanged()

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is PopularCountryViewHolder -> {
                holder.imageView.setImageResource(list_country[position].image)
                holder.tvText.text = list_country[position].title
                holder.itemView.setOnClickListener {
                    Toast.makeText(
                        APP_ACTIVITY,
                        list_country[position].title,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            is MyViewHolder -> {
                holder.imageView.setImageResource(list_country[position].image)
                holder.tvText.text = list_country[position].title
                holder.itemView.setOnClickListener {
                    Toast.makeText(
                        APP_ACTIVITY,
                        list_country[position].title,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}