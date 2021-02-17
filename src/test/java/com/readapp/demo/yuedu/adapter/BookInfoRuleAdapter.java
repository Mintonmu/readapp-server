package com.readapp.demo.yuedu.adapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.readapp.demo.yuedu.BookInfoRule;

import java.io.IOException;

public class BookInfoRuleAdapter extends TypeAdapter<BookInfoRule> {
    @Override
    public void write(JsonWriter out, BookInfoRule value) throws IOException {

    }

    @Override
    public BookInfoRule read(JsonReader reader) throws IOException {
        BookInfoRule bookInfoRule = new BookInfoRule();
        reader.beginObject();
        String fieldname = null;
        while (reader.hasNext()) {
            JsonToken token = reader.peek();
            if (token.equals(JsonToken.NAME)) {
                //get the current token
                fieldname = reader.nextName();
            }
            if ("init".equals(fieldname)) {
                //move to next token
                token = reader.peek();
                bookInfoRule.setInit(reader.nextString());
            }
            if("name".equals(fieldname)) {
                //move to next token
                token = reader.peek();
                bookInfoRule.setName(reader.nextString());
            }
            if("author".equals(fieldname)) {
                //move to next token
                token = reader.peek();
                bookInfoRule.setAuthor(reader.nextString());
            }
            if("intro".equals(fieldname)) {
                //move to next token
                token = reader.peek();
                bookInfoRule.setIntro(reader.nextString());
            }
            if("kind".equals(fieldname)) {
                //move to next token
                token = reader.peek();
                bookInfoRule.setKind(reader.nextString());
            }
            if("lastChapter".equals(fieldname)) {
                //move to next token
                token = reader.peek();
                bookInfoRule.setLastChapter(reader.nextString());
            }
            if("updateTime".equals(fieldname)) {
                //move to next token
                token = reader.peek();
                bookInfoRule.setUpdateTime(reader.nextString());
            }
            if("coverUrl".equals(fieldname)) {
                //move to next token
                token = reader.peek();
                bookInfoRule.setCoverUrl(reader.nextString());
            }
            if("tocUrl".equals(fieldname)) {
                //move to next token
                token = reader.peek();
                bookInfoRule.setTocUrl(reader.nextString());
            }

            if("wordCount".equals(fieldname)) {
                //move to next token
                token = reader.peek();
                bookInfoRule.setWordCount(reader.nextString());
            }

            if("canReName".equals(fieldname)) {
                //move to next token
                token = reader.peek();
                bookInfoRule.setCanReName(reader.nextString());
            }
        }
        reader.endObject();
        return bookInfoRule;
    }

}
