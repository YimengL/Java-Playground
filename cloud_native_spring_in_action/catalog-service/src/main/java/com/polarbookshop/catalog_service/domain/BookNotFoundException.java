package com.polarbookshop.catalog_service.domain;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(String isbn) {
        super("Book with ISBN " + isbn + " not found");
    }
}
