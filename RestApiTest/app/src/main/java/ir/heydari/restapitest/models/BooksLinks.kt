import androidx.room.Embedded
import androidx.room.Relation
import ir.heydari.restapitest.models.Book
import ir.heydari.restapitest.models.BuyLink
import ir.heydari.restapitest.models.ISBN

data class BooksLinks(
    @Embedded val book: Book,
    @Relation(
        parentColumn = "id",
        entityColumn = "bookId"
    )
    val buyLinks: List<BuyLink>
)
