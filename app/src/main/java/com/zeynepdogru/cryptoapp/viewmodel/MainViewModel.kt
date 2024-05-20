package com.zeynepdogru.cryptoapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zeynepdogru.cryptoapp.model.Crypto
import com.zeynepdogru.cryptoapp.model.CryptoResponse
import com.zeynepdogru.cryptoapp.service.CryptoAPIService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainViewModel: ViewModel() {
    private val cryptoAPI = CryptoAPIService()
    val productData = MutableLiveData<List<Crypto>>()
    val productError = MutableLiveData<Boolean>()

    fun getDataFromAPI() {
        cryptoAPI.getData().enqueue(object : Callback<CryptoResponse> { // Dikkat edin, Callback türü artık CryptoResponse
            override fun onResponse(call: Call<CryptoResponse>, response: Response<CryptoResponse>) {
                if (response.isSuccessful) {
                    // Doğru şekilde erişim sağlamak için response.body()?.data kullanın
                    productData.value = response.body()?.data
                    productError.value = false
                } else {
                    productError.value = true
                }
            }

            override fun onFailure(call: Call<CryptoResponse>, t: Throwable) {
                productError.value = true
                Log.e("RetrofitError", t.message.toString())
            }
        })
    }
}

