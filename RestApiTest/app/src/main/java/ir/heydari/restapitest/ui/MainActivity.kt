package ir.heydari.restapitest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.plusAssign
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers
import ir.heydari.restapitest.R
import ir.heydari.restapitest.models.Book
import ir.heydari.restapitest.repository.BooksDao
import ir.heydari.restapitest.repository.BooksDatabase
import ir.heydari.restapitest.repository.Repository
import ir.heydari.restapitest.server.ApiClient
import ir.heydari.restapitest.ui.adapters.BooksListsAdapter
import ir.heydari.restapitest.ui.viewmodels.BookListVM
import ir.heydari.restapitest.ui.viewmodels.BooksVMFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val compositeDisposable = CompositeDisposable()
    private lateinit var viewModel: BookListVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        onlyShowProgressBar()

//        val booksDao = BooksDatabase.getDatabase(application).booksDao()
        val repo = Repository(ApiClient().getClient )
        val vmFactory = BooksVMFactory(repo)
        viewModel = ViewModelProviders.of(this, vmFactory).get(BookListVM::class.java)

//        viewModel.error.observe(this, Observer { error ->
//            // Update the cached copy of the words in the adapter.
//            onlyShowErrorMsg(error)
//        })
//
//        viewModel.lists.observe(this, Observer { list ->
//            // Update the cached copy of the words in the adapter.
//            initRecyclerView(list.get(0).books)
//            onlyShowRecyclerView()
//        })
    }

    override fun onStart() {
        super.onStart()

        compositeDisposable += viewModel.getBooks()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = { userDataList ->
                    initRecyclerView(userDataList.results.books)
                    onlyShowRecyclerView()
                },
                onError = { e -> onlyShowErrorMsg(e.message!!) }
            )
    }

    override fun onStop() {
        super.onStop()
        compositeDisposable.dispose()
    }

    private fun onlyShowProgressBar() {
        progressBar.visibility = View.VISIBLE
        recyclerView.visibility = View.INVISIBLE
        errorMsg.visibility = View.INVISIBLE
    }

    private fun onlyShowRecyclerView() {
        progressBar.visibility = View.INVISIBLE
        recyclerView.visibility = View.VISIBLE
        errorMsg.visibility = View.INVISIBLE
    }


    private fun onlyShowErrorMsg(msg: String) {
        progressBar.visibility = View.INVISIBLE
        recyclerView.visibility = View.INVISIBLE
        errorMsg.visibility = View.VISIBLE
        errorMsg.text = "Network Error: $msg"
    }

    private fun initRecyclerView(userDataList: List<Book>) {
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = BooksListsAdapter(userDataList)
        }
    }
}