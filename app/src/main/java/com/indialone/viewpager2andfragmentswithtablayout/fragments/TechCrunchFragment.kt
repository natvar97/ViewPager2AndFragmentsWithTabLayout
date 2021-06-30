package com.indialone.viewpager2andfragmentswithtablayout.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.indialone.viewpager2andfragmentswithtablayout.R
import com.indialone.viewpager2andfragmentswithtablayout.databinding.FragmentTechCrunchBinding
import com.indialone.viewpager2andfragmentswithtablayout.news.NewsItemAdapter
import com.indialone.viewpager2andfragmentswithtablayout.news.model.ArticlesItem
import com.indialone.viewpager2andfragmentswithtablayout.news.viewmodel.NewsViewModel
import com.indialone.viewpager2andfragmentswithtablayout.news.viewmodel.ViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

class TechCrunchFragment : Fragment() {


    private lateinit var newsViewModel: NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentTechCrunchBinding.inflate(inflater, container, false)

        newsViewModel = ViewModelProvider(this, ViewModelFactory()).get(NewsViewModel::class.java)

        newsViewModel.getTechCrunchNews().observe(viewLifecycleOwner) { newsEntity ->
            binding.rvTechCrunch.layoutManager = LinearLayoutManager(context)
            binding.rvTechCrunch.adapter =
                NewsItemAdapter(newsEntity.articles as ArrayList<ArticlesItem>)
        }

        return binding.root
    }

}