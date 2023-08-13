package com.trinityjayd.biggerpicturenews.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.trinityjayd.biggerpicturenews.ApiClients.NewsApiClient
import com.trinityjayd.biggerpicturenews.BuildConfig
import com.trinityjayd.biggerpicturenews.R
import com.trinityjayd.biggerpicturenews.Models.NewsModels.Article
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NewsFragment : Fragment(), OnItemClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: NewsItemRecyclerViewAdapter

    private lateinit var newsList: List<Article>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_item_list, container, false)

        recyclerView = view.findViewById(R.id.list)
        val service = NewsApiClient.getClient()
        CoroutineScope(Dispatchers.IO).launch {
            val newsSource = arguments?.getString("newsSource")

            var response = service.getNews(BuildConfig.NEWS_API_KEY,"news24")
            if (newsSource != null) {
                response = service.getNews(BuildConfig.NEWS_API_KEY,newsSource)
            }

            if (response.isSuccessful) {
                val responseBody = response.body()
                responseBody?.articles?.let { newsList ->
                    withContext(Dispatchers.Main) {
                        recyclerView.layoutManager = LinearLayoutManager(context)
                        adapter = NewsItemRecyclerViewAdapter(newsList, this@NewsFragment)
                        recyclerView.adapter = adapter
                        adapter.notifyDataSetChanged()
                    }
                }
            }
        }

        return view

    }

    override fun onItemClick(article: Article) {
        val bundle = Bundle()
        bundle.putParcelable("article", article)
        val articleFragment = ArticleFragment()
        articleFragment.arguments = bundle
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.newsAndRateContainer, articleFragment)
            .addToBackStack(null)
            .commit()
    }


}