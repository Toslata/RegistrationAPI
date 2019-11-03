package com.registrationapi.requests;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

public class LoginRequest
{
    @NotEmpty
    @Length(min = 5, max = 100)
    private String username;

    @NotEmpty
    @Length(min = 4, max = 100)
    private String password;

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
