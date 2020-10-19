package ir.heydari.restapitest.server

import androidx.lifecycle.LiveData
import io.reactivex.rxjava3.core.Single
import ir.heydari.restapitest.models.BookListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RestApi {
//    GET https://api.nytimes.com/svc/books/v3/lists/current/hardcover-fiction.json?api-key=uSLXuP9Wq5TZ9UiGxTdcD4tU8hcldGDt
    @GET("svc/books/v3/lists/{date}/{name}.json")
    fun getBooksList(@Path("date") date: String
                          ,@Path("name") name : String
                          ,@Query("api-key") apiKey : String) : Single<BookListResponse>
}