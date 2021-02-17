package com.readapp.demo.yuedu.adapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.readapp.demo.yuedu.BookInfoRule;
import com.readapp.demo.yuedu.ContentRule;

import java.io.IOException;

public class ContentRuleAdapter extends TypeAdapter<ContentRule> {
    @Override
    public void write(JsonWriter out, ContentRule value) throws IOException {

    }

    @Override
    public ContentRule read(JsonReader reader) throws IOException {
        ContentRule contentRule = new ContentRule();
        reader.beginObject();
        String fieldname = null;
        while (reader.hasNext()) {
            JsonToken token = reader.peek();
            if (token.equals(JsonToken.NAME)) {
                //get the current token
                fieldname = reader.nextName();
            }
            if ("content".equals(fieldname)) {
                //move to next token
                token = reader.peek();
                contentRule.setContent(reader.nextString());
            }
            if("nextContentUrl".equals(fieldname)) {
                //move to next token
                token = reader.peek();
                contentRule.setNextContentUrl(reader.nextString());
            }
            if("webJs".equals(fieldname)) {
                //move to next token
                token = reader.peek();
                contentRule.setWebJs(reader.nextString());
            }
            if("sourceRegex".equals(fieldname)) {
                //move to next token
                token = reader.peek();
                contentRule.setSourceRegex(reader.nextString());
            }
            if("replaceRegex".equals(fieldname)) {
                //move to next token
                token = reader.peek();
                contentRule.setReplaceRegex(reader.nextString());
            }
            if("imageStyle".equals(fieldname)) {
                //move to next token
                token = reader.peek();
                contentRule.setImageStyle(reader.nextString());
            }
        }
        reader.endObject();
        return contentRule;
    }

}
