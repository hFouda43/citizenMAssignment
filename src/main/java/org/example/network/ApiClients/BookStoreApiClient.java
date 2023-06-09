package org.example.network.ApiClients;

import org.example.apiclientsservices.BookStore.BookStoreService;
import org.example.models.*;
import org.example.network.RetrofitClient;
import org.example.resources.TestDataBuild;
import retrofit2.Retrofit;

import java.io.IOException;

public class BookStoreApiClient {

    private BookStoreService bookStoreService;
    private TestDataBuild data= new TestDataBuild();

    // Preparing the book store API client

    public BookStoreApiClient(){
        Retrofit retrofit= RetrofitClient.getRetrofitInstance();
        bookStoreService=retrofit.create(BookStoreService.class);
    }

    //Implementing Book APIs methods
// Get books API
    public ReturnedBooks getBooks() throws IOException {
        return bookStoreService.getBooks().execute().body();
    }

    //Get filtered books by ISBN
    public Book getBooksByIsbn(String isbn) throws IOException {
        return bookStoreService.getBookByIsbn(isbn).execute().body();
    }

    //Add books to a specific user
    public ReturnedBooks addListOfBooks(String token, AddBook addBook) throws IOException {
        return  bookStoreService.addListOfBooks(token,addBook).execute().body();
    }
}
