package com.trinityjayd.biggerpicturenews.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.trinityjayd.biggerpicturenews.Models.NewsModels.Article
import com.trinityjayd.biggerpicturenews.R

class ArticleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_article, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Get the article from the bundle
        val article = arguments?.getParcelable<Article>("article")

        if (article != null) {
            val image = view.findViewById<ImageView>(R.id.articleImageView)
            // Load the article image using Picasso
            Picasso.get().load(article.urlToImage).into(image)

            view.findViewById<TextView>(R.id.titleTextView).text = article.title
            view.findViewById<TextView>(R.id.authorTextView).text = article.author
            view.findViewById<TextView>(R.id.sourceTextView).text = article.source.name
            view.findViewById<TextView>(R.id.publishedAtTextView).text = article.publishedAt
            view.findViewById<TextView>(R.id.descriptionTextView).text = article.description
            view.findViewById<TextView>(R.id.contentTextView).text = article.content
        }
    }
}
