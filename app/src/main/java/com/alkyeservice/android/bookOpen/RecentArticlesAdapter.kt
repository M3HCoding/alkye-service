package com.alkyeservice.android.bookOpen

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alkyeservice.android.activity.ArticleDetailActivity
import com.alkyeservice.android.databinding.ItemRecentArticlesBinding

class RecentArticlesAdapter(private val context: Context,
                            private val items: List<ArticleItem>) :
    RecyclerView.Adapter<RecentArticlesAdapter.RecentArticleViewHolder>() {

    inner class RecentArticleViewHolder(private val binding: ItemRecentArticlesBinding) : RecyclerView.ViewHolder(binding.root) {
        private var isExpanded = false

        @SuppressLint("SetTextI18n")
        fun bind(articleItem: ArticleItem) {
            binding.apply {
                tvDescription.text=articleItem.description

                root.setOnClickListener {
                    val articleDetailActivity = Intent(context, ArticleDetailActivity::class.java)
                    context.startActivity(articleDetailActivity)
                }
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentArticleViewHolder {
        val binding = ItemRecentArticlesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecentArticleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecentArticleViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

}
