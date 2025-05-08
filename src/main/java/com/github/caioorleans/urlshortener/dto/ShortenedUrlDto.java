package com.github.caioorleans.urlshortener.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Getter
@Service
@NoArgsConstructor
@AllArgsConstructor
public class ShortenedUrlDto {
    private String id;
    private String shortUrl;
    private String originalUrl;
}
