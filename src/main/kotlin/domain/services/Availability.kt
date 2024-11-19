package org.example.domain.services

import org.example.domain.entities.Book

class Availability {
    fun getStock(book: Book): Int = book.stock
}
