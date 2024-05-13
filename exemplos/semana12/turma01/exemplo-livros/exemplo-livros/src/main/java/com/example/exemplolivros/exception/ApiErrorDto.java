package com.example.exemplolivros.exception;

import java.time.Instant;

public record ApiErrorDto(
        String name,
        String description,
        Instant date
) {
}
