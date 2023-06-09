package org.example.Network.ApiClients;

import okhttp3.ResponseBody;
import org.example.ApiClientsServices.Account.AccountService;
import org.example.Models.Token;
import org.example.Models.User;
import org.example.Models.UserBody;
import org.example.Network.RetrofitClient;
import org.example.resources.TestDataBuild;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

public class AccountApiClient {

    private AccountService accountService;
    private TestDataBuild data= new TestDataBuild();
    private UserBody userBody=data.newUserPayload();


    public AccountApiClient(){
        Retrofit retrofit= RetrofitClient.getRetrofitInstance();
        accountService=retrofit.create(AccountService.class);
    }

    public User createNewUser() throws IOException {
            User usr = accountService.createUser(userBody).execute().body();
            return usr;
    }

    public Token generateUserToken() throws IOException {
        return accountService.generateToken(userBody).execute().body();
    }

    public ResponseBody getUserById(String userID){
        return (ResponseBody) accountService.getUser(userID);
    }
}
