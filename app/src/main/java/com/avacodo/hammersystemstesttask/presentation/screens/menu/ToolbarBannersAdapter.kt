package com.avacodo.hammersystemstesttask.presentation.screens.menu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.avacodo.hammersystemstesttask.databinding.ToolbarBannerItemBinding
import com.avacodo.hammersystemstesttask.domain.models.ToolbarBannerDomain

class ToolbarBannersAdapter :
    RecyclerView.Adapter<ToolbarBannersAdapter.ToolbarBannersViewHolder>() {

    private var bannersList = listOf<ToolbarBannerDomain>()

    fun setData(mBannersList: List<ToolbarBannerDomain>) {
        val diffUtilCallback = DiffUtilCallback(bannersList, mBannersList)
        bannersList = mBannersList
        DiffUtil.calculateDiff(diffUtilCallback).dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToolbarBannersViewHolder {
        return ToolbarBannersViewHolder(
            (ToolbarBannerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false))
                .root)
    }

    override fun onBindViewHolder(holder: ToolbarBannersViewHolder, position: Int) {
        holder.bind(bannersList[position])
    }

    override fun getItemCount(): Int {
        return bannersList.size
    }

    inner class ToolbarBannersViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(toolbarBannerDomain: ToolbarBannerDomain) {
            ToolbarBannerItemBinding.bind(itemView).apply {
                toolbarBannerItemImageView.load(toolbarBannerDomain.imageSource)
            }
        }
    }

    class DiffUtilCallback(
        private val oldList: List<ToolbarBannerDomain>,
        private val newList: List<ToolbarBannerDomain>,
    ) : DiffUtil.Callback() {

        override fun getOldListSize(): Int = oldList.size
        override fun getNewListSize(): Int = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return areContentsTheSame(oldItemPosition, newItemPosition)
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldItem = oldList[oldItemPosition]
            val newItem = newList[newItemPosition]
            return oldItem == newItem
        }
    }
}

fun interface OnRecyclerItemClickListener {
    fun onItemClick(locationID: String)
}