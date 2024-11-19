package org.example.domain.services

import org.example.domain.entities.Book

class BookSearch(
    private val availability: Availability,
) {
    private val existingBooks: List<Book> =
        listOf(
            Book("The Hobbit"),
            Book("The Lord of the Rings"),
            Book("The Silmarillion"),
        )

    fun findBooksByTitle(title: String): List<Book> {
        val matchingBooks = existingBooks.filter { it.title.contains(title) }
        return matchingBooks.filter { availability.isAvailable(it) }
    }
}
