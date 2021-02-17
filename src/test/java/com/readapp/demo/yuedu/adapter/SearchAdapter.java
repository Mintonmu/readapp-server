package com.readapp.demo.yuedu.adapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.readapp.demo.yuedu.ContentRule;

import java.io.IOException;

public class SearchAdapter extends TypeAdapter<ContentRule> {
    @Override
    public void write(JsonWriter out, ContentRule value) throws IOException {

    }

    @Override
    public ContentRule read(JsonReader in) throws IOException {
        ContentRule contentRule = new ContentRule();
        in.beginObject();
        String fieldName = "";
        while (in.hasNext()) {
            JsonToken token = in.peek();

            if (token.equals(JsonToken.NAME)) {
                fieldName = in.nextName();

            }
            if ("bookList".equals(fieldName)) {
                //move to next token
                token = in.peek();
                contentRule.setContent(in.nextString());
            }
            if ("name".equals(fieldName)) {
                //move to next token
                token = in.peek();
                contentRule.setNextContentUrl(in.nextString());
            }
            if ("author".equals(fieldName)) {
                //move to next token
                token = in.peek();
                contentRule.setWebJs(in.nextString());
            }
            if ("intro".equals(fieldName)) {
                //move to next token
                token = in.peek();
                contentRule.setSourceRegex(in.nextString());
            }
            if ("kind".equals(fieldName)) {
                //move to next token
                token = in.peek();
                contentRule.setReplaceRegex(in.nextString());
            }
            if ("lastChapter".equals(fieldName)) {
                //move to next token
                token = in.peek();
                contentRule.setImageStyle(in.nextString());
            }
            if ("updateTime".equals(fieldName)) {
                //move to next token
                token = in.peek();
                contentRule.setImageStyle(in.nextString());
            }
            if ("bookUrl".equals(fieldName)) {
                //move to next token
                token = in.peek();
                contentRule.setImageStyle(in.nextString());
            }
            if ("coverUrl".equals(fieldName)) {
                //move to next token
                token = in.peek();
                contentRule.setImageStyle(in.nextString());
            }
            if ("wordCount".equals(fieldName)) {
                //move to next token
                token = in.peek();
                contentRule.setImageStyle(in.nextString());
            }
        }
        in.endObject();
        return contentRule;
    }

}
