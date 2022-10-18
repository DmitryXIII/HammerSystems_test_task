package com.avacodo.hammersystemstesttask.presentation.screens.menu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.avacodo.hammersystemstesttask.R
import com.avacodo.hammersystemstesttask.databinding.ProductItemBinding
import com.avacodo.hammersystemstesttask.domain.models.ProductDomain
import com.avacodo.hammersystemstesttask.presentation.DiffUtilCallback

class ProductsAdapter : RecyclerView.Adapter<ProductsAdapter.ProductsViewHolder>() {

    private var productsList = listOf<ProductDomain>()

    fun setData(mProductsList: List<ProductDomain>) {
        val diffUtilCallback = DiffUtilCallback(productsList, mProductsList)
        productsList = mProductsList
        DiffUtil.calculateDiff(diffUtilCallback).dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        return ProductsViewHolder(
            (ProductItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false))
                .root)
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        holder.bind(productsList[position])
    }

    override fun getItemCount(): Int {
        return productsList.size
    }

    inner class ProductsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(productDomain: ProductDomain) {
            ProductItemBinding.bind(itemView).apply {
                productItemTitleTextView.text = productDomain.name
                productItemDescriptionTextView.text = productDomain.description
                productItemPriceButton.text = itemView.context.getString(
                    R.string.product_item_price,
                    productDomain.price)
                productItemPhotoImageView.load(productDomain.imageUrl)
            }
        }
    }
}