package com.company.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Book {
    private Long id;
    private String book_name;
    private String author;
    private String isbn;
    private BigDecimal price;
    private Integer pages;
    private String binding;
    private Integer year_publising;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getBinding() {
        return binding;
    }

    public void setBinding(String binding) {
        this.binding = binding;
    }

    public Integer getYear_publising() {
        return year_publising;
    }

    public void setYear_publising(Integer year_publising) {
        this.year_publising = year_publising;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book books = (Book) o;
        return Objects.equals(id, books.id) && Objects.equals(book_name, books.book_name) && Objects.equals(author, books.author) && Objects.equals(isbn, books.isbn) && Objects.equals(price, books.price) && Objects.equals(pages, books.pages) && Objects.equals(binding, books.binding) && Objects.equals(year_publising, books.year_publising);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, book_name, author, isbn, price, pages, binding, year_publising);
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", book_name='" + book_name + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", price=" + price +
                ", pages=" + pages +
                ", binding='" + binding + '\'' +
                ", year_publising=" + year_publising +
                '}';
    }
}
