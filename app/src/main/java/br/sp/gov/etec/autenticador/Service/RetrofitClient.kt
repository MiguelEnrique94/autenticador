package br.sp.gov.etec.autenticador.Service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

  class RetrofitClient {
  companion object {
      private const val BASE_URL = "http://172.23.112.11:8080/"
      val retrofit by lazy {
          Retrofit.Builder()
              .baseUrl(BASE_URL)
              .addConverterFactory(GsonConverterFactory.create())
              .build()

      }
  }

}