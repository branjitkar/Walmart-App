package com.example.walmart.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.walmart.ElectronicDetailActivity
import com.example.walmart.R
import com.example.walmart.model.Product

class CategoryAdapter(val context: Context, val products: MutableList<Product>) :
    RecyclerView.Adapter<BaseViewHolder?>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): BaseViewHolder {
        val itemEvents: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.product_list_item, viewGroup, false)
        return AssignedTasksViewHolder(itemEvents)
    }

    override fun onBindViewHolder(baseViewHolder: BaseViewHolder, i: Int) {
        baseViewHolder.onBind(i)
    }

    override fun getItemCount(): Int = products.size

    inner class AssignedTasksViewHolder(view: View?) : BaseViewHolder(view) {
        private var tvTitle: TextView? = view?.findViewById(R.id.tvTitle)
        private var imgProduct: ImageView? = view?.findViewById(R.id.imgProduct)
        private var tvPrice: TextView? = view?.findViewById(R.id.tvPrice)
        private var tvDesc: TextView? = view?.findViewById(R.id.tvDesc)
        private var itemContainer: LinearLayout? = view?.findViewById(R.id.productListContainer)

        override fun onBind(position: Int) {
            super.onBind(position)
            val product = products[position]

            imgProduct?.setBackgroundResource(product.image)
            tvTitle?.text = product.productName
            tvPrice?.text = product.cost
            tvDesc?.text = product.desc

            itemContainer?.setOnClickListener {
                val intent = Intent(context, ElectronicDetailActivity::class.java)
                var res = products[position]
                intent.putExtra("product",res)
                context.startActivity(intent)
            }
        }
    }
}