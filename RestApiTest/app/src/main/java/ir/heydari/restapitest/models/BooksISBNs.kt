import androidx.room.Embedded
import androidx.room.Relation
import ir.heydari.restapitest.models.Book
import ir.heydari.restapitest.models.ISBN

data class BooksISBNs(
    @Embedded val book: Book,
    @Relation(
        parentColumn = "id",
        entityColumn = "bookId"
    )
    val isbns: List<ISBN>
)
