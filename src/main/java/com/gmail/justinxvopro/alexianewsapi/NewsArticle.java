package com.gmail.justinxvopro.alexianewsapi;

import java.util.UUID;

import org.json.JSONObject;

import com.gmail.justinxvopro.alexianewsapi.util.JSONUtil;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class NewsArticle {

    @Getter
    @Setter
    @NonNull
    private String uid;

    @Getter
    @Setter
    @NonNull
    private String updateDate;

    @Getter
    @Setter
    @NonNull
    private String titleText;

    @Getter
    @Setter
    @NonNull
    private String author;

    @Getter
    @Setter
    @NonNull
    private String mainText;

    @Getter
    @Setter
    @NonNull
    private String redirectionUrl;

    public static NewsArticle parse(JSONObject obj) {
	String date = JSONUtil.getOrNull(obj, "publishedAt");
	String title = JSONUtil.getOrNull(obj, "title");
	String author = JSONUtil.getOrNull(obj, "author");
	String text = JSONUtil.getOrNull(obj, "description");
	String url = JSONUtil.getOrNull(obj, "url");

	return new NewsArticle(UUID.randomUUID().toString(), date, title, author, text, url);
    }

}
