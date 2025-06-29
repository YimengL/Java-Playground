package com.polarbookshop.catalog_service.domain;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

// The domain model is implemented as a record, an immutable object.
public record Book(
        @NotBlank(message = "The book ISBN must be defined")
        @Pattern(
                regexp = "^([0-9]{10}|[0-9]{13})$",
                message = "The ISBN format must be valid."
        )
        String isbn, // Unique identifier for the book

        @NotBlank(message = "The book title must be defined.")
        String title,

        @NotBlank(message = "The book author must be defined.")
        String author,

        @NotNull(message = "The book price must be defined.")
        @Positive(message = "The book price must be greater than zero.")
        Double price
) {}
