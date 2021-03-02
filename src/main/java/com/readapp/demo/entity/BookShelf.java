package com.readapp.demo.entity;

import lombok.Data;

import java.util.Objects;

@Data
public class BookShelf {
    private Integer id;
    private String bookshelfId;
    private String bookTitle;
    private Integer lastchapter_num;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        BookShelf bookShelf = (BookShelf) o;
        return Objects.equals(bookshelfId, bookShelf.bookshelfId) && Objects.equals(bookTitle, bookShelf.bookTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookshelfId, bookTitle);
    }
}
