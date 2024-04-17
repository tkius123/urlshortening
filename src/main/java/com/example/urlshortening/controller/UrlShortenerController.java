package com.example.urlshortening.controller;

import com.example.urlshortening.service.UrlServiceShortenerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlShortenerController {
    private UrlServiceShortenerService urlServiceShortenerService;

    public UrlShortenerController(UrlServiceShortenerService urlServiceShortenerService) {
        this.urlServiceShortenerService = urlServiceShortenerService;
    }

    @PostMapping("/encode")
    public String encode(@RequestParam String url) {
        return urlServiceShortenerService.encode(url);
    }

    @GetMapping("/decode")
    public String decode(@RequestParam String shortUrl) {
        return urlServiceShortenerService.decode(shortUrl);
    }
}
