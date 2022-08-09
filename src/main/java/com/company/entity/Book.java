package com.company.entity;

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
    private Integer year_publishing;

    private Language language;

    public enum Language {
        ENGLISH, RUSSIAN, SPANISH, FRENCH, DEUTSCH, ARABIC, CHINESE, JAPANESE
    }

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

    public Integer getYear_publishing() {
        return year_publishing;
    }

    public void setYear_publishing(Integer year_publishing) {
        this.year_publishing = year_publishing;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) && Objects.equals(book_name, book.book_name) && Objects.equals(author, book.author) && Objects.equals(isbn, book.isbn) && Objects.equals(price, book.price) && Objects.equals(pages, book.pages) && Objects.equals(binding, book.binding) && Objects.equals(year_publishing, book.year_publishing) && language == book.language;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, book_name, author, isbn, price, pages, binding, year_publishing, language);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", book_name='" + book_name + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", price=" + price +
                ", pages=" + pages +
                ", binding='" + binding + '\'' +
                ", year_publishing=" + year_publishing +
                ", language=" + language +
                '}';
    }
}
