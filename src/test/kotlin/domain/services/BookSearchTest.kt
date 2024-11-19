package domain.services

import org.example.domain.services.Availability
import org.example.domain.services.BookSearch
import org.junit.jupiter.api.Test

class BookSearchTest {
    private val bookSearch = BookSearch(Availability())

    @Test
    fun shouldReturnBookGivenASearchTitle() {
        val books = bookSearch.findBooksByTitle("The Hobbit")
        assert(books.size == 1)
        assert(books[0].title == "The Hobbit")
    }

    @Test
    fun shouldReturnEmptyLisIfNoBooksMatchTheSearchTitle() {
        val books = bookSearch.findBooksByTitle("Unknown Title")
        assert(books.isEmpty())
    }

    @Test
    fun shouldNotReturnBooksWithoutStock() {
        val books = bookSearch.findBooksByTitle("The Silmarillion")
        assert(books.isEmpty())
    }
}
