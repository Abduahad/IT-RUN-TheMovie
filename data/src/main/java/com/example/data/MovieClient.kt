package com.example.data

import com.example.data.interceptors.APILoggingInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MovieClient {
    //ToDo: Use NDK to store API Key
    private const val BASE_URL = "https://api.themoviedb.org/3/"
    private const val API_KEY =
        "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJhMzVmMmMxNTY2YzZmMWU2OWM1MWVlZmIxNzkxOTkzOCIsInN1YiI6IjY2MWQ3NTZlZmQ0YTk2MDE4NjZjNjMyMyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.8qJvqhvn0SdU-Sq9pcs3Jviy__2mE6d9sep-roAHAfU"

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(APILoggingInterceptor())
        .addInterceptor { chain ->
            val original = chain.request()
            val requestBuilder = original.newBuilder()
                .header("Authorization", "Bearer $API_KEY")
                .method(original.method, original.body)
            val request = requestBuilder.build()
            chain.proceed(request)
        }
        .build()

    val apiService: MovieService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieService::class.java)
    }
}