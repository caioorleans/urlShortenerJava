package com.github.caioorleans.urlshortener.repository;

import com.github.caioorleans.urlshortener.model.ShortenedUrl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UrlRepository extends JpaRepository<ShortenedUrl, Long> {
    public Optional<ShortenedUrl> findByShortenedUrl(String shortenedUrl);
}
