package ir.heydari.restapitest.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ir.heydari.restapitest.repository.Repository
import ir.heydari.restapitest.ui.adapters.BooksListsAdapter

class BooksVMFactory(private val repository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return BookListVM(repository) as T
    }
}