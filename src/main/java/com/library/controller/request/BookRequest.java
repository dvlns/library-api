package com.library.controller.request;

import lombok.Builder;

@Builder
public record BookRequest(String title, String author, String ISBN) {
}
