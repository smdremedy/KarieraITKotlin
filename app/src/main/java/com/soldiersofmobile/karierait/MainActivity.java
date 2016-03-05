package com.soldiersofmobile.karierait;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;
import java.util.Map;

class LoginManager {

    private String username;
    private String password;

    private Map<String, String> users = new HashMap<>();

    public LoginManager() {
        users.put("test", "test");
        users.put("user1", "user2");
    }


    public void login(String username, String password) {
        this.username = username;
        this.password = password;

        Log.d("LoginManager", "Trying to login username:" + username + " password:" + password);

        for (Map.Entry<String, String> entry : users.entrySet()) {
            if (username.equals(entry.getKey()) && password.equals(entry.getValue())) {
                Log.d("LoginManager", "Logged:" + toString());
            }
        }

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginManager{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

public class MainActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button signUpButton;

    private LoginManager loginManager = new LoginManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameEditText = (EditText) findViewById(R.id.usernameEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        signUpButton = (Button) findViewById(R.id.signInButton);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loginManager.login(usernameEditText.getText().toString(), passwordEditText.getText().toString());
            }
        });

    }
}
