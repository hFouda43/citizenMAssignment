package org.example.testCases.apistests;

import org.example.models.*;
import org.example.network.ApiClients.AccountApiClient;
import org.example.network.ApiClients.BookStoreApiClient;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookStoreTests {
    AccountApiClient accountApiClient = new AccountApiClient();
    BookStoreApiClient bookStoreApiClient = new BookStoreApiClient();

    User user;
    Token token;
    ReturnedBooks returnedBooks;
    List<String> isbns = new ArrayList<>();
    List<Book> booksList = new ArrayList<Book>();
    List<Isbn> isbnList = new ArrayList<>();

    //Testing create user Api
    @Test
    public void createUser() {
        try {
            user = accountApiClient.createNewUser();
            Assert.assertEquals(accountApiClient.getUserBody().getUserName(), user.getUsername());
            Assert.assertEquals(user.getBooks().size(), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Testig generate Token Api
    @Test
    public void generateAuthToken() {
        try {
            token = accountApiClient.generateUserToken();
            Assert.assertEquals( token.getResult(),"User authorized successfully.");
            Assert.assertEquals( token.getStatus(),"Success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Testing get books list API
    @Test
    public void getListOfBooks() {
        try {
            returnedBooks = bookStoreApiClient.getBooks();
            Assert.assertNotEquals(returnedBooks.getBooks().size(),0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //Testing get filtered books using ISBN .. in swagger neither publisher not author is working
    @Test
    public void getFilteredBooks() {
        try {
            returnedBooks = bookStoreApiClient.getBooks();
            for (int i = 0; i < returnedBooks.getBooks().size(); i++) {
                if (returnedBooks.getBooks().get(i).getIsbn().contains("978144")) {
                    isbns.add(returnedBooks.getBooks().get(i).getIsbn());
                }
            }

            for (int i = 0; i < isbns.size(); i++) {

                booksList.add(bookStoreApiClient.getBooksByIsbn(isbns.get(i)));

            }
            Assert.assertNotEquals(booksList.size(),0);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    //Testing add books to user API
    @Test
    public void addBooksToUser() {

        try {
            user = accountApiClient.createNewUser();
            token = accountApiClient.generateUserToken();
            String authToken = "Bearer " + token.getToken();
            returnedBooks = bookStoreApiClient.getBooks();

            for (int i = 0; i < returnedBooks.getBooks().size(); i++) {
                if (returnedBooks.getBooks().get(i).getIsbn().contains("978144")) {
                    isbns.add(returnedBooks.getBooks().get(i).getIsbn());
                }
            }

            AddBook addBook = new AddBook();
            List<CollectionOfIsbns> collectionOfIsbns = new ArrayList<>();
            for (int i = 0; i < isbns.size(); i++) {
                CollectionOfIsbns collectionOfIsbns1 = new CollectionOfIsbns();
                collectionOfIsbns1.setIsbn(isbns.get(i));
                collectionOfIsbns.add(collectionOfIsbns1);
            }
            addBook.setUserId(user.getUserID());
            addBook.setCollectionOfIsbns(collectionOfIsbns);
            returnedBooks = bookStoreApiClient.addListOfBooks(authToken, addBook);

            Assert.assertEquals(returnedBooks.getBooks().size(),4);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
