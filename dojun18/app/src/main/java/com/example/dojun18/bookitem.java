package com.example.dojun18;

public class bookitem {
    String bookname;
    String author;
    String description;
    int booknum;
    public bookitem(String bookname,String author,String description,int booknum){
        this.bookname=bookname;
        this.author=author;
        this.description=description;
        this.booknum=booknum;
    }
    public bookitem(String bookname,String author,int booknum){
        this.description="";
        this.bookname=bookname;
        this.author=author;
        this.booknum=booknum;
    }

    public int getBooknum() {
        return booknum;
    }

    public String getAuthor() {
        return author;
    }

    public String getBookname() {
        return bookname;
    }

    public String getDescription() {
        return description;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public void setBooknum(int booknum) {
        this.booknum = booknum;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
