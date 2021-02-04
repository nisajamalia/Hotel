package com.nisa.hotelappskotlin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.nisa.hotelappskotlin.adapter.RecyclerViewAdapter
import com.nisa.hotelappskotlin.model.Model
import kotlinx.android.synthetic.main.activity_hotel_list.*

class HotelListActivity : AppCompatActivity() {
//    private val listHotel = ArrayList<Model>()
    private lateinit var popularHotelAdapter: RecyclerViewAdapter

//    private lateinit var adapter: Adapter
//    private var model2 = arrayListOf<Model>()
//    private lateinit var dataTitle: Array<String>
//    private lateinit var dataDesc: Array<String>
//    private lateinit var image: TypedArray


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotel_list)
//        rv_all_popular.setHasFixedSize(true)
//        listHotel.addAll(getListHotel())
        supportActionBar?.hide()
        showRecyclerGrid()

//        adapter = Adapter(this)
//
//        lv.adapter = adapter
//        attachData()
//        loadData()

    }

    private fun getListHotel(): ArrayList<Model> {
        val dataName = resources.getStringArray(R.array.title)
        val dataDesc = resources.getStringArray(R.array.desc)
        val dataAddress = resources.getStringArray(R.array.address)
        val dataharga = resources.getStringArray(R.array.data_price)
        val dataPhoto = resources.obtainTypedArray(R.array.image)

        //u ngelooping
        val listHotel = ArrayList<Model>()
        for (position in dataName.indices) {
            val hotel = Model(
                dataName[position],
                dataDesc[position],
                dataAddress[position],
                dataharga[position],
                dataPhoto.getResourceId(position, -1)

            )
            listHotel.add(hotel)
        }
        return listHotel


    }

    private fun showRecyclerGrid() {
        //buat variable untuk nampung klass ini
        popularHotelAdapter = RecyclerViewAdapter { showSelected(it) }
        popularHotelAdapter.notifyDataSetChanged()
        popularHotelAdapter.setData(getListHotel())
        rv_all_popular.setHasFixedSize(true)

        val layoutManagerStaggered = StaggeredGridLayoutManager(2, GridLayoutManager.VERTICAL)
        rv_all_popular.layoutManager = layoutManagerStaggered
        rv_all_popular.adapter = popularHotelAdapter


    }

    private fun showSelected(it: Model) {
        val page = Intent(this, DetailPopularHotelActivity::class.java)
        page.putExtra(DetailPopularHotelActivity.KEY_POPULAR_HOTEL, it)
        startActivity(page)
    }


//    private fun loadData() {
//        for (position in dataTitle.indices) {
//            val model = Model(
//                dataTitle[position],
//                dataDesc[position],
//                image.getResourceId(position, -1)
//            )
//            model2.add(model)
//        }
//        adapter.hotel = model2
//
//    }
//
//    private fun attachData() {
//        dataTitle = resources.getStringArray(R.array.title)
//        dataDesc = resources.getStringArray(R.array.desc)
//        image = resources.obtainTypedArray(R.array.image)
//    }


}
