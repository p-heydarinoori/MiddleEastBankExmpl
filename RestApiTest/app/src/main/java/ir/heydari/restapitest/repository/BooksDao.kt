package ir.heydari.restapitest.repository

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface BooksDao {
    @Query("SELECT * from lists")
    fun getList(): LiveData<List<ir.heydari.restapitest.models.List>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertList(list: ir.heydari.restapitest.models.List)

    @Query("DELETE FROM lists")
    suspend fun deleteAll()
}