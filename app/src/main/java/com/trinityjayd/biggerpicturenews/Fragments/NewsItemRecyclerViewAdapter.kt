package com.trinityjayd.biggerpicturenews.Fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.trinityjayd.biggerpicturenews.Models.NewsModels.Article
import com.trinityjayd.biggerpicturenews.databinding.NewsFragmentItemBinding

class NewsItemRecyclerViewAdapter(
    private val articles: List<Article>
) : RecyclerView.Adapter<NewsItemRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = NewsFragmentItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = articles[position]
        holder.bind(article)
    }

    override fun getItemCount(): Int = articles.size

    inner class ViewHolder(private val binding: NewsFragmentItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(article: Article) {
            binding.headlineTextView.text = article.title

            // Load the article image using Picasso
            Picasso.get().load(article.urlToImage).into(binding.articleImageView)
        }
    }
}
