package domain.services

import org.example.domain.services.Availability
import org.example.domain.services.BookSearch
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class BookSearchTest {
    private lateinit var availability: Availability
    private lateinit var bookSearch: BookSearch

    @BeforeEach
    fun setUp() {
        availability = mock()
        bookSearch = BookSearch(availability)
    }

    @Test
    fun shouldReturnBookGivenASearchTitle() {
        whenever(availability.getStock(any())).thenReturn(10)
        val books = bookSearch.findBooksByTitle("The Hobbit")
        assert(books.size == 1)
        assert(books[0].title == "The Hobbit")
    }

    @Test
    fun shouldReturnEmptyLisIfNoBooksMatchTheSearchTitle() {
        whenever(availability.getStock(any())).thenReturn(10)
        val books = bookSearch.findBooksByTitle("Unknown Title")
        assert(books.isEmpty())
    }

    @Test
    fun shouldNotReturnBooksWithoutStock() {
        whenever(availability.getStock(any())).thenReturn(0)
        val books = bookSearch.findBooksByTitle("The Silmarillion")
        assert(books.isEmpty())
    }
}
