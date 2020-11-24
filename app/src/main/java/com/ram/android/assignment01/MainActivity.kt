package com.ram.android.assignment01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        var retrofit=Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create()).build()
        var api=retrofit.create(RestServiceInterface::class.java)
        var callget =api.posts

        callget?.enqueue(object: Callback<List<UsersRepo?>?> {
            override fun onResponse(call: Call<List<UsersRepo?>?>, response: Response<List<UsersRepo?>?>) {

                var postlist = response.body()
                var post = arrayOfNulls<String>(postlist!!.size)

                for(i in postlist!!.indices )
                    post[i]=postlist!![i]!!.title.toString()

                var adapter = ArrayAdapter<String>(applicationContext,android.R.layout.simple_dropdown_item_1line,post)

                findViewById<ListView>(R.id.listView).adapter=adapter



            }

            override fun onFailure(call: Call<List<UsersRepo?>?>, t: Throwable) {



            }

        } )

    }
}