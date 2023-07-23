package com.a7dev.moststarredgithubrepos_cleanarchitecture.ui.getMostStarredRepos

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.a7dev.domain.entity.ReposModel
import com.a7dev.moststarredgithubrepos_cleanarchitecture.R
import com.a7dev.moststarredgithubrepos_cleanarchitecture.databinding.FragmentReposBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ReposFragment : Fragment() {

    private val viewModel: ReposViewModel by activityViewModels()
    private lateinit var binding: FragmentReposBinding
    private lateinit var adapter: ReposAdapter
    private var page: Int = 2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentReposBinding.inflate(inflater)
        setupRecyclerView()
        getData()
        binding.lifecycleOwner = this@ReposFragment
        binding.viewmodel = viewModel
        return binding.root
    }
    private fun setupRecyclerView() {
        adapter = ReposAdapter(requireContext())
        val layoutManager = LinearLayoutManager(requireContext())
        binding.idReposListRV.layoutManager = layoutManager
        binding.idReposListRV.adapter = adapter
        // activatePagination(binding.idReposListRV, layoutManager)
    }
    private fun getData() {
        viewModel.getMostStarredRepositories()
        hideListAndShowLoading()
        lifecycleScope.launch {
            viewModel.mostStarredRepos.collect {
                it?.items?.let { it1 ->
                    adapter.refillList(it1)
                    adapter.notifyDataSetChanged()
                    showListAndHideLoading()
                }
            }
        }
    }
    private fun showListAndHideLoading() {
        binding.loadingLayout.visibility = View.GONE
        binding.idReposListRV.visibility = View.VISIBLE
    }
    private fun hideListAndShowLoading() {
        binding.loadingLayout.visibility = View.VISIBLE
        binding.idReposListRV.visibility = View.GONE
    }

}