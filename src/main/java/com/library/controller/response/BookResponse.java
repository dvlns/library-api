package com.library.controller.response;

import lombok.Builder;

@Builder
public record BookResponse(Long id,
                           String title,
                           String author,
                           String ISBN) {
}
