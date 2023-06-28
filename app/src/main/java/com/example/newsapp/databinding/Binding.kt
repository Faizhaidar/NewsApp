package com.example.shopingapp.databinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.data.model.NewsResponse
import com.example.shopingapp.ui.home.fragment.HomeFragment


@BindingAdapter("bindNewsList", "homelistner", requireAll = false)
fun bindNewsList(view: RecyclerView, list: List<NewsResponse>?, fragment: HomeFragment?) {
    if(list != null) {
       /* var adapter : NewsListAdapter? = view.adapter as? NewsListAdapter
        if(adapter == null){
            adapter = NewsListAdapter(view.context, list.toMutableList(),fragment!!)
            view.adapter = adapter
        }*/
        //adapter.updateList(list)
    }
}
@BindingAdapter("loadImageFromUrl")
fun loadImageFromUrl(view: ImageView, url: String?) {
    if(url != null) {
        Glide.with(view.context)
            .load(url)
            .into(view)
    }
}