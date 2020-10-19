package ir.heydari.restapitest.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "isbns")
data class ISBN(
    @PrimaryKey val isbn10: String,
    val isbn13: String,
    val bookId: String
)