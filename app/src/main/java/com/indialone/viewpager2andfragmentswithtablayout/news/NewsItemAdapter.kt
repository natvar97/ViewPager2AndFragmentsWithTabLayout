package com.indialone.viewpager2andfragmentswithtablayout.news

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.indialone.viewpager2andfragmentswithtablayout.R
import com.indialone.viewpager2andfragmentswithtablayout.databinding.NewsItemLayoutBinding
import com.indialone.viewpager2andfragmentswithtablayout.news.model.ArticlesItem

class NewsItemAdapter(
    private val news: ArrayList<ArticlesItem>
) : RecyclerView.Adapter<NewsItemAdapter.NewsItemViewHolder>() {
    class NewsItemViewHolder(itemView: NewsItemLayoutBinding) :
        RecyclerView.ViewHolder(itemView.root) {
        private val tvAuthor = itemView.tvAuthor
        private val tvTitle = itemView.tvTitle
        private val tvDescription = itemView.tvDescription
        private val tvContent = itemView.tvContent
        private val tvPublishedAt = itemView.tvPublishedDate
        private val ivImageNews = itemView.ivImageNews

        fun bind(article: ArticlesItem) {
            tvAuthor.text = article.author
            tvTitle.text = article.title
            tvDescription.text = article.description
            tvContent.text = article.content
            tvPublishedAt.text = article.publishedAt
            Glide.with(itemView.context)
                .load(article.urlToImage)
                .placeholder(R.drawable.error_image)
                .into(ivImageNews)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsItemViewHolder {
        val view = NewsItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsItemViewHolder, position: Int) {
        val newsItem = news[position]
        holder.bind(newsItem)
        holder.itemView.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(newsItem.url)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return news.size
    }
}