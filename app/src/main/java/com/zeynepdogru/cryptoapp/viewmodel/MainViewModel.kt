package com.zeynepdogru.cryptoapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zeynepdogru.cryptoapp.model.Crypto
import com.zeynepdogru.cryptoapp.service.CryptoAPIService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainViewModel: ViewModel() {

    private val cryptoAPI = CryptoAPIService()

    val productData = MutableLiveData<List<Crypto>>()
    val productError = MutableLiveData<Boolean>()


    fun getDataFromAPI() {
        cryptoAPI.getData().enqueue(object : Callback<List<Crypto>> {
            override fun onResponse(call: Call<List<Crypto>>, response: Response<List<Crypto>>) {
                productData.value=response.body()
                productError.value=false
            }

            override fun onFailure(call: Call<List<Crypto>>, t: Throwable) {
               productError.value=true
                Log.e("RetrofitError", t.message.toString())
            }


        })


    }
}