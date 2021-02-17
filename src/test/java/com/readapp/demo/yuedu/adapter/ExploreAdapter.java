package com.readapp.demo.yuedu.adapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.readapp.demo.yuedu.ContentRule;
import com.readapp.demo.yuedu.ExploreRule;

import java.io.IOException;

public class ExploreAdapter extends TypeAdapter<ExploreRule> {
    @Override
    public void write(JsonWriter out, ExploreRule value) throws IOException {

    }

    @Override
    public ExploreRule read(JsonReader reader) throws IOException {
        ExploreRule exploreRule = new ExploreRule();
        reader.beginObject();
        String fieldname = null;
        while (reader.hasNext()) {
            JsonToken token = reader.peek();
            if (token.equals(JsonToken.NAME)) {
                //get the current token
                fieldname = reader.nextName();
            }
            if ("bookList".equals(fieldname)) {
                //move to next token
                token = reader.peek();
                exploreRule.setBookList(reader.nextString());
            }
            if("name".equals(fieldname)) {
                //move to next token
                token = reader.peek();
                exploreRule.setName(reader.nextString());
            }
            if("author".equals(fieldname)) {
                //move to next token
                token = reader.peek();
                exploreRule.setAuthor(reader.nextString());
            }
            if("intro".equals(fieldname)) {
                //move to next token
                token = reader.peek();
                exploreRule.setIntro(reader.nextString());
            }
            if("kind".equals(fieldname)) {
                //move to next token
                token = reader.peek();
                exploreRule.setKind(reader.nextString());
            }
            if("lastChapter".equals(fieldname)) {
                //move to next token
                token = reader.peek();
                exploreRule.setLastChapter(reader.nextString());
            }
            if("updateTime".equals(fieldname)) {
                //move to next token
                token = reader.peek();
                exploreRule.setUpdateTime(reader.nextString());
            }
            if("bookUrl".equals(fieldname)) {
                //move to next token
                token = reader.peek();
                exploreRule.setBookUrl(reader.nextString());
            }
            if("coverUrl".equals(fieldname)) {
                //move to next token
                token = reader.peek();
                exploreRule.setCoverUrl(reader.nextString());
            }
            if("wordCount".equals(fieldname)) {
                //move to next token
                token = reader.peek();
                exploreRule.setWordCount(reader.nextString());
            }
        }
        reader.endObject();
        return exploreRule;
    }

}
