package org.example.ApiClientsServices.Account;

import okhttp3.ResponseBody;
import org.example.Models.Token;
import org.example.Models.User;
import org.example.Models.UserBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

// This interface defines the account API Endpoints
public interface AccountService {
    //Create new user request
    @POST("/Account/v1/User")
    Call<User> createUser(@Body UserBody user);

    //Generate a user token
    @POST("/Account/v1/GenerateToken")
    Call<Token> generateToken(@Body UserBody user);

    //Get user by ID request
    @GET("/Account/v1/User/{id}")
    Call<ResponseBody> getUser(@Path("id") String userID);
}
