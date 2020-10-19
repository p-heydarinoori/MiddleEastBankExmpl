package ir.heydari.restapitest.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ir.heydari.restapitest.R
import ir.heydari.restapitest.models.Book
import kotlinx.android.synthetic.main.recycler_layout_book_list.view.*

class BooksListsAdapter(private val booksData: List<Book>) :
    RecyclerView.Adapter<BooksListsAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_layout_book_list, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = booksData.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.apply {
            Glide.with(holder.image.context).load(booksData[position].bookImage)
            title.text = booksData[position].title
            publisher.text = booksData[position].publisher
            author.text = booksData[position].author
            description.text = booksData[position].description
        }
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.image
        val title: TextView = itemView.title
        val publisher: TextView = itemView.publisher
        val author: TextView = itemView.author
        val description: TextView = itemView.description
    }
}