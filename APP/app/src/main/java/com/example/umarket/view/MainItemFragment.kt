package com.example.umarket.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.umarket.Repository.ItemRepository
import com.example.umarket.databinding.FragmentMainBinding
import com.example.umarket.model.ProductResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainItemFragment: Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val client = ItemRepository.apiService.fetchProduct("100")
        client.enqueue(object : Callback<ProductResponse> {

            override fun onResponse(
                call: Call<ProductResponse>,
                response: Response<ProductResponse>
            ){
                if (response.isSuccessful){
                    Log.d("Products",""+response.body())
                    val itemList = response.body()?.result
                    recyclerView = binding.recyclerView
                    recyclerView.layoutManager = GridLayoutManager(context, 2)
                    recyclerView.adapter = ItemListAdapter(itemList!!)
                    binding.recyclerView.visibility = View.VISIBLE

//                    Toast.makeText(requireContext(), "FETCHED: " +itemList.size, Toast.LENGTH_LONG).show()
                }

            }
            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                Toast.makeText(requireContext(), "ERROR", Toast.LENGTH_LONG).show()
                //Log.e("failed",""+t.message)
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}



