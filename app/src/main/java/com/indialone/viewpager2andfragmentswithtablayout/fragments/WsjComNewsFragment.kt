package com.indialone.viewpager2andfragmentswithtablayout.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.indialone.viewpager2andfragmentswithtablayout.R
import com.indialone.viewpager2andfragmentswithtablayout.databinding.FragmentWsjComNewsBinding
import com.indialone.viewpager2andfragmentswithtablayout.news.NewsItemAdapter
import com.indialone.viewpager2andfragmentswithtablayout.news.model.ArticlesItem
import com.indialone.viewpager2andfragmentswithtablayout.news.viewmodel.NewsViewModel
import com.indialone.viewpager2andfragmentswithtablayout.news.viewmodel.ViewModelFactory
import javax.inject.Inject

class WsjComNewsFragment : Fragment() {

    private lateinit var newsViewModel: NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentWsjComNewsBinding.inflate(inflater, container, false)

        newsViewModel = ViewModelProvider(this, ViewModelFactory()).get(NewsViewModel::class.java)

        newsViewModel.getWsjComNews().observe(viewLifecycleOwner) { newsEntity ->
            binding.rvWsjCom.layoutManager = LinearLayoutManager(context)
            binding.rvWsjCom.adapter =
                NewsItemAdapter(newsEntity.articles as ArrayList<ArticlesItem>)
        }

        return binding.root
    }

}