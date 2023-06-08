package org.example.ApiClientsServices.BookStore;

import org.example.Models.AddBook;
import org.example.Models.Book;
import org.example.Models.Isbn;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface BookStoreService {
    //Get List of books
    @GET("/BookStore/v1/Books")
    Call<List<Book>> getBooks();

    //Get book by ISBN
    @GET("/BookStore/v1/Books")
    Call<Book> getBookByIsbn(@Query("isbn") String isbn);

    //Post books to the user in context
    @POST("/BookStore/v1/Books")
    Call<List<Isbn>> addListOfBooks(@Header("Authorization") String token, @Body AddBook addBook);
}
