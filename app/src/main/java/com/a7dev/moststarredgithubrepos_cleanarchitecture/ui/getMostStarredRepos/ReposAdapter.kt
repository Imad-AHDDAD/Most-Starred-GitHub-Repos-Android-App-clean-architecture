package com.a7dev.moststarredgithubrepos_cleanarchitecture.ui.getMostStarredRepos

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.a7dev.domain.entity.Items
import com.a7dev.moststarredgithubrepos_cleanarchitecture.R
import com.a7dev.moststarredgithubrepos_cleanarchitecture.databinding.ListItemBinding
import com.bumptech.glide.Glide

class ReposAdapter(private val context: Context) : RecyclerView.Adapter<ReposAdapter.ReposViewHolder>() {

    private var reposList = ArrayList<Items>()
    fun fillList(list: ArrayList<Items>){
        reposList.addAll(list)
    }
    fun refillList(list: ArrayList<Items>){
        reposList.clear()
        reposList.addAll(list)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReposViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return ReposViewHolder(view)
    }
    override fun getItemCount(): Int {
        return reposList.size
    }
    override fun onBindViewHolder(holder: ReposViewHolder, position: Int) {
        val item = reposList[position]
        holder.binding.idRepositoryNameTV.text = item.name
        holder.binding.idRepositoryDescriptionTV.text = item.description
        holder.binding.idStarsNumberTV.text = getStarsZoneText(item.stargazers_count)

        holder.binding.idOwnerNameTV.text = item.owner.login
        Glide.with(context).load(item.owner.avatar_url)
            .placeholder(R.drawable.avatar)
            .into(holder.binding.idProfileImageIV)

        holder.itemView.setOnClickListener {
            openRepoInBrowser(item.html_url)
        }
    }
    inner class ReposViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding: ListItemBinding = ListItemBinding.bind(itemView)
    }
    private fun getStarsZoneText(starsNumber: Int): String {
        val text = if(starsNumber >= 1000){
            val result = starsNumber.toFloat() / 1000
            val formattedResult = String.format("%.1f", result)
            "$formattedResult K"
        }else {
            "$starsNumber"
        }
        return text
    }
    private fun openRepoInBrowser(htmlUrl: String) {
        val openURL = Intent(Intent.ACTION_VIEW)
        openURL.data = Uri.parse(htmlUrl)
        context.startActivity(openURL)
    }


}