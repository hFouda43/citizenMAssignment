package org.example.Network.ApiClients;

import okhttp3.ResponseBody;
import org.example.ApiClientsServices.Account.AccountService;
import org.example.ApiClientsServices.BookStore.BookStoreService;
import org.example.Models.AddBook;
import org.example.Models.Book;
import org.example.Models.Token;
import org.example.Network.RetrofitClient;
import org.example.resources.TestDataBuild;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.List;

public class BookStoreApiClient {

    private BookStoreService bookStoreService;
    private TestDataBuild data= new TestDataBuild();

    public BookStoreApiClient(){
        Retrofit retrofit= RetrofitClient.getRetrofitInstance();
        bookStoreService=retrofit.create(BookStoreService.class);
    }

    public List<Book> getBooks() throws IOException {
        return bookStoreService.getBooks().execute().body();
    }

    public Book getBooksByIsbn(String isbn) throws IOException {
        return bookStoreService.getBookByIsbn(isbn).execute().body();
    }

    public ResponseBody addListOfBooks(String token,AddBook addBook){
        return (ResponseBody) bookStoreService.addListOfBooks(token,addBook);
    }
}