package com.zeynepdogru.cryptoapp.view

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.zeynepdogru.cryptoapp.adapter.CryptoAdapter
import com.zeynepdogru.cryptoapp.R
import com.zeynepdogru.cryptoapp.databinding.ActivityMainBinding
import com.zeynepdogru.cryptoapp.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    private var cryptoAdapter= CryptoAdapter(arrayListOf())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)
        viewModel=ViewModelProvider(this)[MainViewModel::class.java]
        binding.productRV.adapter=cryptoAdapter
        binding.productRV.layoutManager= LinearLayoutManager(this)
        viewModel.getDataFromAPI()
        setObserves()



    }


    private fun setObserves(){
        viewModel.productData.observe(this, Observer {
            cryptoAdapter.updateList(it)

        })
        viewModel.productError.observe(this, Observer {
            if(it){
                binding.errorTV.visibility= View.VISIBLE

            }else
                binding.errorTV.visibility=View.GONE

        })

    }
}