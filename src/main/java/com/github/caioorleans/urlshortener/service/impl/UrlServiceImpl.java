package com.github.caioorleans.urlshortener.service.impl;

import com.github.caioorleans.urlshortener.exception.InternalServerErrorException;
import com.github.caioorleans.urlshortener.exception.NotFoundException;
import com.github.caioorleans.urlshortener.model.ShortenedUrl;
import com.github.caioorleans.urlshortener.repository.UrlRepository;
import com.github.caioorleans.urlshortener.service.UrlService;
import com.github.caioorleans.urlshortener.util.Base62Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UrlServiceImpl implements UrlService {

    @Autowired
    public UrlServiceImpl(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    private final UrlRepository urlRepository;

    @Override
    public ShortenedUrl saveUrl(String url) {
        var shortUrl = Base62Encoder.generate(6);
        try {
            var createdUrl = urlRepository.save(new ShortenedUrl(url, shortUrl));
            createdUrl.setShortenedUrl("localhost:8080/url/"+createdUrl.getShortenedUrl());
            return createdUrl;
        } catch (Exception e) {
            throw new InternalServerErrorException("Ocorreu um erro ao tentar salvar a URL.");
        }
    }

    @Override
    public String findUrlByShortUrl(String shortUrl) {
        var shortenedUrl = urlRepository.findByShortenedUrl(shortUrl);
        if (shortenedUrl.isEmpty()) {
            throw new NotFoundException("URL não encontrada");
        }
        return shortenedUrl.get().getOriginalUrl();
    }

    @Override
    public List<ShortenedUrl> listUrls() {
        try {
            var urls = urlRepository.findAll();
            urls.forEach(
                            (url)-> url.setShortenedUrl("localhost:8080/url/" + url.getShortenedUrl()));
            return urls;
        } catch (Exception e) {
            throw new NotFoundException("Ocorreu um erro ao tentar listar URLs.");
        }
    }

    @Override
    public void deleteUrl(Long id) {
        try {
            urlRepository.deleteById(id);
        } catch (Exception e) {
            throw new NotFoundException("Ocorreu um erro ao tentar deletar URL.");
        }
    }
}
