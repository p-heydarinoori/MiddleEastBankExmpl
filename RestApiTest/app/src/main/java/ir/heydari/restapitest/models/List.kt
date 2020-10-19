package ir.heydari.restapitest.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "lists")
data class List(
    @PrimaryKey @SerializedName("list_name") val listName: String,
    @SerializedName("list_name_encoded") val list_name_encoded: String,
    @SerializedName("bestsellers_date") val bestsellers_date: String,
    @SerializedName("published_date") val published_date: String,
    @SerializedName("published_date_description") val published_date_description: String,
    @SerializedName("next_published_date") val next_published_date: String,
    @SerializedName("previous_published_date") val previous_published_date: String,
    @SerializedName("display_name") val display_name: String,
    @SerializedName("normal_list_ends_at") val normal_list_ends_at: Int,
    @SerializedName("updated") val updated: String,
    @Ignore @SerializedName("books") val books: ArrayList<Book>
//    @SerializedName("corrections") val corrections : ArrayList<Book>
)