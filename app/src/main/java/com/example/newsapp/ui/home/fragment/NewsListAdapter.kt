package com.example.shopingapp.ui.home.fragment

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.data.model.NewsResponse
import com.example.shopingapp.databinding.AdapterMainCategoryBinding

import com.example.shopingapp.BR


class NewsListAdapter (
    private val context: Context,
    private val dataList: MutableList<NewsResponse>,
    private val  listner: HomeFragment
) : RecyclerView.Adapter<NewsListAdapter.BindingViewHolder>() {

    override fun getItemCount() = dataList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder {
        val rootView: ViewDataBinding =
            AdapterMainCategoryBinding.inflate(LayoutInflater.from(context), parent, false)
        return BindingViewHolder(
            rootView
        )
    }

    override fun onBindViewHolder(holder: BindingViewHolder, position: Int) {
        val model = dataList[position]

       /* holder.itemBinding.setVariable(BR.mainCategory, model)
        holder.itemBinding.executePendingBindings()
        holder.itemBinding.setVariable(BR.mainCategoryListner, listner as HomeListner)*/
    }

    class BindingViewHolder(val itemBinding: ViewDataBinding) : RecyclerView.ViewHolder(itemBinding.root)


}
