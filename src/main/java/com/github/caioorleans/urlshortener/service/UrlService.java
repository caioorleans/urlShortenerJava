package com.github.caioorleans.urlshortener.service;

import com.github.caioorleans.urlshortener.model.ShortenedUrl;

import java.util.List;

public interface UrlService {
    public ShortenedUrl saveUrl(String url);
    public String findUrlByShortUrl(String shortUrl);
    public List<ShortenedUrl> listUrls();
    public void deleteUrl(Long id);
}
