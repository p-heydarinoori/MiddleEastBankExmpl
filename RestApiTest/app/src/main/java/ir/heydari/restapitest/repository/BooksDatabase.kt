package ir.heydari.restapitest.repository

import BooksISBNs
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import ir.heydari.restapitest.models.Book
import ir.heydari.restapitest.models.BuyLink
import ir.heydari.restapitest.models.ISBN
import ir.heydari.restapitest.models.List

// Annotates class to be a Room Database with a table (entity) of the Word class
@Database(entities = arrayOf(List::class,Book::class,BuyLink::class,ISBN::class), version = 1, exportSchema = false)
public abstract class BooksDatabase : RoomDatabase() {

    abstract fun booksDao(): BooksDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: BooksDatabase? = null

        fun getDatabase(context: Context): BooksDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BooksDatabase::class.java,
                    "books_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}