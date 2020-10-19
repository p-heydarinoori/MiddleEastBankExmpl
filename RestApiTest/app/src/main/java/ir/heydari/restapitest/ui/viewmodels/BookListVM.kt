package ir.heydari.restapitest.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.plusAssign
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers
import ir.heydari.restapitest.repository.Repository

class BookListVM(private val repository: Repository) : ViewModel() {
    // Create a LiveData with a String
//    val lists: MutableLiveData<List<ir.heydari.restapitest.models.List>> by lazy {
//        MutableLiveData()
//    }
//    val error: MutableLiveData<String> by lazy {
//        MutableLiveData()
//    }

    fun getBooks() = repository.getBooksList()
//    private val compositeDisposable = CompositeDisposable()
    // Rest of the ViewModel...

//    fun lists() : LiveData<List<ir.heydari.restapitest.models.List>> {
//        compositeDisposable += repository.getBooksList()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribeBy(
//                onSuccess = { response ->
//                    repository.insert(response.results)
//                    lists.postValue(repository.lists().value)
//                },
//                onError = { e -> error.postValue(e.message!!) }
//            )
//        return lists
//    }


}