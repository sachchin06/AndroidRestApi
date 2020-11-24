package com.ram.android.assignment01

import retrofit2.Call
import retrofit2.http.GET

interface RestServiceInterface {
    @get:GET("posts")
    val posts : Call<List<UsersRepo?>?>?

}