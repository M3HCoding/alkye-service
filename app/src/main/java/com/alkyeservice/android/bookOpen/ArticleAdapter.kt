package com.alkyeservice.android.bookOpen

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.alkyeservice.android.activity.ArticleDetailActivity
import com.alkyeservice.android.activity.HomeActivity
import com.alkyeservice.android.databinding.ItemArticleBinding

class ArticleAdapter(private val context: Context,
                     private val items: List<ArticleItem>) :
    RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {

    inner class ArticleViewHolder(private val binding: ItemArticleBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(articleItem: ArticleItem) {
            binding.apply {
                tvCategory.text=articleItem.category
               // tvDescription.text=articleItem.description
                tvDate.text=articleItem.date

                root.setOnClickListener {
                    val articleDetailActivity = Intent(context, ArticleDetailActivity::class.java)
                    context.startActivity(articleDetailActivity)
                }
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val binding = ItemArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

}
