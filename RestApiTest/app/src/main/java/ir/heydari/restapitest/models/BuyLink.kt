package ir.heydari.restapitest.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "buy_links")
class BuyLink(
    @ColumnInfo(name = "id") val id: Int,
    val name: String,
    val url: String,
    val bookId: String
)