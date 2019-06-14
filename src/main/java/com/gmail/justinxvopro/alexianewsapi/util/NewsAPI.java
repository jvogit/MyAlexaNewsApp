package com.gmail.justinxvopro.alexianewsapi.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import com.gmail.justinxvopro.alexianewsapi.NewsArticle;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@RequiredArgsConstructor
public class NewsAPI {
    @NonNull
    private String key;
    private static final String BASE_URL = "https://newsapi.org/v2/top-headlines?";
    private static final HttpClient HTTP_CLIENT = HttpClientBuilder.create().build();

    @SneakyThrows
    public List<NewsArticle> gatherArticles(String source, int limit) {
	List<NewsArticle> toReturn = new ArrayList<>();

	HttpGet get = new HttpGet(BASE_URL + "apiKey=" + key + "&sources=" + source);
	HttpResponse response = HTTP_CLIENT.execute(get);
	if (response.getStatusLine().getStatusCode() != 200) {
	    return toReturn;
	}
	JSONObject root = new JSONObject(EntityUtils.toString(response.getEntity()));
	JSONArray articles = root.getJSONArray("articles");

	articles.forEach(o -> {
	    JSONObject obj = (JSONObject) o;

	    toReturn.add(NewsArticle.parse(obj));
	});

	return toReturn;
    }
}
