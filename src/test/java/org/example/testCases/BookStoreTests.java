package org.example.testCases;

import okhttp3.ResponseBody;
import org.example.Models.*;
import org.example.Network.ApiClients.AccountApiClient;
import org.example.Network.ApiClients.BookStoreApiClient;
import org.testng.annotations.Test;
import retrofit2.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookStoreTests {
    AccountApiClient accountApiClient = new AccountApiClient();
    BookStoreApiClient bookStoreApiClient = new BookStoreApiClient();
    User user;
    Token token;
    List<Book> books;
    List<String> isbns;
    List<Book> booksList;
    List<Isbn> isbnList;

    @Test
    public void createUser() throws IOException {
        user = accountApiClient.createNewUser();
        System.out.println("Successful Request");

    }

    @Test
    public void generateAuthToken() throws IOException {
        token = accountApiClient.generateUserToken();
        System.out.println("Successful Request");
        System.out.println(token.getToken());
        System.out.println(token.getExpires());
        System.out.println(token.getResult());
        System.out.println(token.getStatus());
    }

    @Test
    public void getListOfBooks() throws IOException {
        books = bookStoreApiClient.getBooks();
        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i).getAuthor());
            System.out.println(books.get(i).getIsbn());
        }
    }

    @Test
    public void getFilteredBooks() throws IOException {

        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getIsbn().contains("978144")) {
                isbns.add(books.get(i).getIsbn());
            }
        }

        for (int i = 0; i < isbns.size(); i++) {
            booksList.add(bookStoreApiClient.getBooksByIsbn(isbns.get(i)));
        }

    }

    @Test
    public void addBooksToUser(){
        AddBook addBook=new AddBook();
        List<CollectionOfIsbns> collectionOfIsbns = new ArrayList<CollectionOfIsbns>();
        for (int i = 0; i < isbns.size(); i++) {
            collectionOfIsbns.add(se);
        }
        addBook.setUserId(user.getUserID());
        addBook.setCollectionOfIsbns(collectionOfIsbns);
isbnList=bookStoreApiClient.addListOfBooks(token,addBook);
    }


}
