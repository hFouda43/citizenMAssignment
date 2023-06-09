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
    ReturnedBooks returnedBooks;
    List<String> isbns = new ArrayList<>();
    List<Book> booksList= new ArrayList<Book>();
    List<Isbn> isbnList= new ArrayList<>();

    @Test
    public void createUser() {
        try {
            user = accountApiClient.createNewUser();
            System.out.println("Successful Request");
            System.out.println(user.getUserID());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //  System.out.println(user.body().getUserName());
//        System.out.println(user.getBooks());

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
        returnedBooks = bookStoreApiClient.getBooks();
        for (int i = 0; i < returnedBooks.getBooks().size(); i++) {
            System.out.println(returnedBooks.getBooks().get(i).getAuthor());
            System.out.println(returnedBooks.getBooks().get(i).getIsbn());
        }
    }

    @Test
    public void getFilteredBooks() throws IOException {
        returnedBooks = bookStoreApiClient.getBooks();

        for (int i = 0; i < returnedBooks.getBooks().size(); i++) {
            if (returnedBooks.getBooks().get(i).getIsbn().contains("978144")) {
                isbns.add(returnedBooks.getBooks().get(i).getIsbn());
            }
        }

        for (int i = 0; i < isbns.size(); i++) {
            System.out.println(isbns.get(i));

            booksList.add(bookStoreApiClient.getBooksByIsbn(isbns.get(i)));

        }



    }

    @Test
    public void addBooksToUser() throws IOException {

        user = accountApiClient.createNewUser();
        token = accountApiClient.generateUserToken();
//String token2="Bearer "+token.getToken();
        returnedBooks = bookStoreApiClient.getBooks();

        for (int i = 0; i < returnedBooks.getBooks().size(); i++) {
            if (returnedBooks.getBooks().get(i).getIsbn().contains("978144")) {
                isbns.add(returnedBooks.getBooks().get(i).getIsbn());
            }
        }
        
        

        AddBook addBook=new AddBook();
        List<CollectionOfIsbns> collectionOfIsbns = new ArrayList<>();
        for (int i = 0; i < isbns.size(); i++) {
            CollectionOfIsbns collectionOfIsbns1=new CollectionOfIsbns();
            collectionOfIsbns1.setIsbn(isbns.get(i));
            collectionOfIsbns.add(collectionOfIsbns1);
        }
        addBook.setUserId(user.getUserID());
        addBook.setCollectionOfIsbns(collectionOfIsbns);
        isbnList=bookStoreApiClient.addListOfBooks(token.getToken(),addBook);

        System.out.println("SUCCESSSSS");
        for (int i = 0; i < isbnList.size(); i++) {
            System.out.println(isbnList.get(i).getIsbn());
        }
    }


}
