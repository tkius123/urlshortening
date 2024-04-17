package com.example.urlshortening.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class UrlServiceShortenerService {
    private ConcurrentHashMap<String, String> urlMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, String> orgUrlMap = new ConcurrentHashMap<>();
    private int id = 0;

    public String encode(String originalUrl) {
        if(orgUrlMap.contains(originalUrl)) return orgUrlMap.get(originalUrl);
        String shortUrl = "http://short.est/" + Integer.toHexString(id++);
        urlMap.put(shortUrl, originalUrl);
        orgUrlMap.put(originalUrl, shortUrl);
        return shortUrl;
    }

    public String decode(String shortUrl) {
        return urlMap.getOrDefault(shortUrl, "URL not found");
    }
}
