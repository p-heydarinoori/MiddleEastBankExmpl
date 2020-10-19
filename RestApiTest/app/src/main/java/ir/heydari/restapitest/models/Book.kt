package ir.heydari.restapitest.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "books")
data class Book(
    @SerializedName("rank") val rank: Int,
    @SerializedName("rank_last_week") val rankLastWeek: Int,
    @SerializedName("weeks_on_list") val weeksOnList: Int,
    @SerializedName("asterisk") val asterisk: Int,
    @SerializedName("dagger") val dagger: Int,
    @PrimaryKey @SerializedName("primary_isbn10") val primaryIsbn10: String,
    @SerializedName("primary_isbn13") val primaryIsbn13: String,
    @SerializedName("publisher") val publisher: String,
    @SerializedName("description") val description: String,
    @SerializedName("price") val price: Int,
    @SerializedName("title") val title: String,
    @SerializedName("author") val author: String,
    @SerializedName("contributor") val contributor: String,
    @SerializedName("contributor_note") val contributorNote: String,
    @SerializedName("book_image") val bookImage: String,
    @SerializedName("book_image_width") val bookImageWidth: Int,
    @SerializedName("book_image_height") val bookImageHeight: Int,
    @SerializedName("amazon_product_url") val amazonProductUrl: String,
    @SerializedName("age_group") val ageGroup: String,
    @SerializedName("book_review_link") val bookReviewLink: String,
    @SerializedName("first_chapter_link") val firstChapterLink: String,
    @SerializedName("sunday_review_link") val sundayReviewLink: String,
    @SerializedName("article_chapter_link") val articleChapterLink: String,
    @Ignore @SerializedName("isbns") val isbns: ArrayList<ISBN>,
    @Ignore @SerializedName("buy_links") val buyLinks: ArrayList<BuyLink>,
    @SerializedName("book_uri") val bookUri: String,
    val listId : Int
)