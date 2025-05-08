package com.github.caioorleans.urlshortener.controller;

import com.github.caioorleans.urlshortener.dto.NewUrlDto;
import com.github.caioorleans.urlshortener.model.ShortenedUrl;
import com.github.caioorleans.urlshortener.service.UrlService;
import com.github.caioorleans.urlshortener.service.impl.UrlServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/url")
public class UrlController {

    @Autowired
    public UrlController(UrlServiceImpl urlService) {
        this.urlService = urlService;
    }

    private final UrlService urlService;

    @PostMapping()
    public ShortenedUrl shorten(@RequestBody NewUrlDto urlDto) {
        return urlService.saveUrl(urlDto.getUrl());
    }

    @GetMapping()
    public List<ShortenedUrl> getShortenedUrls() {
        return urlService.listUrls();
    }

    @GetMapping("/{url}")
    public String getShortenedUrl(@PathVariable("url") String url) {
        return urlService.findUrlByShortUrl(url);
    }
}
