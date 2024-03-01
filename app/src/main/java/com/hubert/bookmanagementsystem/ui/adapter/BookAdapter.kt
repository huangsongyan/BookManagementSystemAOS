package com.hubert.bookmanagementsystem.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hubert.bookmanagementsystem.databinding.ItemBookBinding
import com.hubert.bookmanagementsystem.model.bean.Book
import com.hubert.bookmanagementsystem.ui.BookDetailActivity

class BookAdapter : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    private var mData: List<Book> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        return BookViewHolder(
            ItemBookBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    fun setData(data: List<Book>) {
        mData = data
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bindData(mData[position])
        holder.binding.root.setOnClickListener {
            val intent = Intent(it.context, BookDetailActivity::class.java)
            intent.putExtra("data",mData[position])
            it.context.startActivity(intent)
        }
    }


    class BookViewHolder(val binding: ItemBookBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(book: Book) {
            binding.tvName.text = book.bookTitle
            binding.tvAuthor.text = book.author
            binding.tvYear.text = book.publicationYear.toString()
            Glide
                .with(binding.bookImg.context)
                .load(book.cover)
                .into(binding.bookImg)
        }
    }
}