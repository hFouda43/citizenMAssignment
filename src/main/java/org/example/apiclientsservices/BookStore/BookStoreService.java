package org.example.apiclientsservices.BookStore;

import org.example.models.AddBook;
import org.example.models.Book;
import org.example.models.ReturnedBooks;
import retrofit2.Call;
import retrofit2.http.*;

public interface BookStoreService {
    //Get List of books
    @GET("/BookStore/v1/Books")
    Call<ReturnedBooks> getBooks();

    //Get book by ISBN
    @GET("/BookStore/v1/Book")
    Call<Book> getBookByIsbn(@Query("ISBN") String isbn);

    //Post books to the user in context
    @POST("/BookStore/v1/Books")
    Call<ReturnedBooks> addListOfBooks(@Header("Authorization") String token, @Body AddBook addBook);
}
