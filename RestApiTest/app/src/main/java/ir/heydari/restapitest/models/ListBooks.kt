import androidx.room.Embedded
import androidx.room.Relation
import ir.heydari.restapitest.models.Book

data class ListBooks(
    @Embedded val list: ir.heydari.restapitest.models.List,
    @Relation(
        parentColumn = "id",
        entityColumn = "listId"
    )
    val books: List<Book>
)
