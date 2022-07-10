package com.levins.Matrix_Gilad_Levinson.view
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.levins.Matrix_Gilad_Levinson.MainActivity
import com.levins.Matrix_Gilad_Levinson.R
import com.levins.Matrix_Gilad_Levinson.model.DataObjectX

import kotlinx.android.synthetic.main.recyclerview_item_max.view.*
import kotlinx.android.synthetic.main.recyclerview_item_max.view.textViewCat


class RecyclerAdapter(context: Context, private var result: List<DataObjectX>):// LocationItem>):
    RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {
    private val context: Context =context
    class MyViewHolder(val v: View, val context: Context) : RecyclerView.ViewHolder(v) {
        val textViewTitle : TextView
        val textViewStitle : TextView
        val imageView : ImageView
        val textViewImageUrl : TextView
        val textViewCategoryId : TextView
        val textViewId : TextView
        init {
            // Define click listener for the ViewHolder's View.
            textViewTitle =v.titleTextView
            textViewStitle =v.sTitleTextView
            imageView = v.imageView
            textViewImageUrl =v.imageUrlTextview
            textViewCategoryId =v.textViewCat
            textViewId = v.objectIdtextview
        }
    }
    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): RecyclerAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_item_max , parent, false)
        return MyViewHolder(view,parent.context)//,myDatasetIds
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textViewTitle.text = result!![position].Title +" - "+ result!![position].STitle
//        holder.textViewStitle.text = result!![position].STitle
        holder.textViewImageUrl.text = result!![position].Imag
        holder.textViewCategoryId.text = result!![position].CatId.toString()
        holder.textViewId.text = result!![position].Id.toString()
                Glide.with(context)
                        .load(result!![position].Imag)
                        .placeholder(R.mipmap.ic_hamatgad_background)
                        .into(holder.imageView)
        holder.itemView.setOnClickListener(View.OnClickListener {//textView2.

                onClickDate(it)//todo return it
            })
    }

    //    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = result!!.size //size()

    fun onClickDate(v: View) {
        val category:  String = v.textViewCat.getText().toString() //two text views defined on top of the viewHolder
        val id: String = v.objectIdtextview.getText().toString()
        val imgUrl: String = v.imageUrlTextview.getText().toString()
        val intent = Intent(context, MainActivity::class.java).apply {
            putExtra("category", category)
            putExtra("id",id)
            putExtra("imgUrl",imgUrl)
        }
        context.startActivity(intent)
    }
}





