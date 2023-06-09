package org.example.network.ApiClients;

import okhttp3.ResponseBody;
import org.example.apiclientsservices.Account.AccountService;
import org.example.models.Token;
import org.example.models.User;
import org.example.models.UserBody;
import org.example.network.RetrofitClient;
import org.example.resources.TestDataBuild;
import retrofit2.Retrofit;

import java.io.IOException;

public class AccountApiClient {

    private AccountService accountService;
    private TestDataBuild data= new TestDataBuild();
    private UserBody userBody=data.newUserPayload();

// Preparing the account API client
    public AccountApiClient(){
        Retrofit retrofit= RetrofitClient.getRetrofitInstance();
        accountService=retrofit.create(AccountService.class);
    }

//Implementing account APIs methods
    //Create User API
    public User createNewUser() throws IOException {
        return accountService.createUser(userBody).execute().body();

    }

    //Generate User Token API
    public Token generateUserToken() throws IOException {
        return accountService.generateToken(userBody).execute().body();
    }

    //Getting a user by ID API
    public ResponseBody getUserById(String userID){
        return (ResponseBody) accountService.getUser(userID);
    }

    //Get user body to retrieve actual data to be used with assertions
    public UserBody getUserBody() {
        return userBody;
    }
}
