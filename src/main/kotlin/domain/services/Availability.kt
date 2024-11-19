package org.example.domain.services

import org.example.domain.entities.Book

class Availability {
    fun isAvailable(book: Book): Boolean = book.stock > 0
}
