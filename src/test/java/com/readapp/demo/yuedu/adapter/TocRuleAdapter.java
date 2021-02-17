package com.readapp.demo.yuedu.adapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.readapp.demo.yuedu.ExploreRule;
import com.readapp.demo.yuedu.TocRule;

import java.io.IOException;

public class TocRuleAdapter extends TypeAdapter<TocRule> {
    @Override
    public void write(JsonWriter out, TocRule value) throws IOException {

    }

    @Override
    public TocRule read(JsonReader reader) throws IOException {
        TocRule tocRule = new TocRule();
        reader.beginObject();
        String fieldname = null;
        while (reader.hasNext()) {
            JsonToken token = reader.peek();
            if (token.equals(JsonToken.NAME)) {
                //get the current token
                fieldname = reader.nextName();
            }
            if ("chapterList".equals(fieldname)) {
                //move to next token
                token = reader.peek();
                tocRule.setChapterList(reader.nextString());
            }
            if("chapterName".equals(fieldname)) {
                //move to next token
                token = reader.peek();
                tocRule.setChapterName(reader.nextString());
            }
            if("chapterUrl".equals(fieldname)) {
                //move to next token
                token = reader.peek();
                tocRule.setChapterUrl(reader.nextString());
            }
            if("isVip".equals(fieldname)) {
                //move to next token
                token = reader.peek();
                tocRule.setIsVip(reader.nextString());
            }
            if("updateTime".equals(fieldname)) {
                //move to next token
                token = reader.peek();
                tocRule.setUpdateTime(reader.nextString());
            }
            if("nextTocUrl".equals(fieldname)) {
                //move to next token
                token = reader.peek();
                tocRule.setNextTocUrl(reader.nextString());
            }
        }
        reader.endObject();
        return tocRule;
    }

}
