package com.allerap.android.pulsechallenge.domain

import com.allerap.android.pulsechallenge.BuildConfig
import com.allerap.android.pulsechallenge.data.remote.ApiRemoteSource
import com.allerap.android.pulsechallenge.data.remote.ApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object BusinessModule {
    var repository: Repository

    init {
        val remoteSource = remoteSource(
                apiService(retrofitClient(okHttpClient(), BuildConfig.BASE_URL))
        )
        repository = getRepository(remoteSource)
    }

    private fun getRepository(remoteSource: ApiRemoteSource): Repository = Repository(remoteSource)

    private fun okHttpClient(): OkHttpClient =
            OkHttpClient.Builder().build()

    private fun retrofitClient(okHttpClient: OkHttpClient, baseUrl: String): Retrofit =
            Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .client(okHttpClient)
                    .build()

    private fun apiService(retrofit: Retrofit): ApiService =
            retrofit.create(ApiService::class.java)

    private fun remoteSource(
            apiService: ApiService
    ): ApiRemoteSource = ApiRemoteSource(apiService)

}
