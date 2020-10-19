package ir.heydari.restapitest.repository

import androidx.lifecycle.LiveData
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.plusAssign
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers
import ir.heydari.restapitest.server.ApiUtils
import ir.heydari.restapitest.server.RestApi

class Repository(private val api: RestApi /*,private val booksDao: BooksDao*/) {
    fun getBooksList() = api.getBooksList("current" , "hardcover-fiction" ,ApiUtils.apiKey)


//    fun lists() : LiveData<List<ir.heydari.restapitest.models.List>> {
//        return booksDao.getList()
//    }
//
//    fun insert(list: ir.heydari.restapitest.models.List) {
//        booksDao.insertList(list = list)
//    }
}