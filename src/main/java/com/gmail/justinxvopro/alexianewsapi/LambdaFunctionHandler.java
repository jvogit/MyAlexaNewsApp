package com.gmail.justinxvopro.alexianewsapi;

import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.gmail.justinxvopro.alexianewsapi.util.NewsAPI;

public class LambdaFunctionHandler implements RequestHandler<Object, List<NewsArticle>> {

    @Override
    public List<NewsArticle> handleRequest(Object input, Context context) {
	context.getLogger().log("Input: " + input);
	NewsAPI api = new NewsAPI("key here");

	return api.gatherArticles("google-news", 5);
    }

}
