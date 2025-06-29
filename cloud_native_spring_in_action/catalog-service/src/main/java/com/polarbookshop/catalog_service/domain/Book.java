package com.polarbookshop.catalog_service.domain;


// The domain model is implemented as a record, an immutable object.
public record Book(
        String isbn, // Unique identifier for the book
        String title,
        String author,
        Double price
) {}
