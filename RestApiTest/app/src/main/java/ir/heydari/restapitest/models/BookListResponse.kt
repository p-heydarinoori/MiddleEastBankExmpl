package ir.heydari.restapitest.models

import com.google.gson.annotations.SerializedName

data class BookListResponse (
    val status : String,
    val copyright : String,
    @SerializedName("num_results") val numResults : Int,
    @SerializedName("last_modified") val last_modified : String,
    val results : List
)
