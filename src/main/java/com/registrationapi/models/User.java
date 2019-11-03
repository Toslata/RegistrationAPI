package com.registrationapi.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "user")
public class User implements UserDetails
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long userId;

    private String username;
    private String password;
    private String address;
    private String phoneNumber;
    private String email;

    @ManyToOne
    @JoinColumn(name = "memberTypeId")
    private MemberType memberType;

    private String referenceCode;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    public User()
    {
        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.credentialsNonExpired = true;
        this.enabled = true;
    }


    public long getUserId()
    {
        return userId;
    }

    public void setUserId(long userId)
    {
        this.userId = userId;
    }

    public String getUsername()
    {
        return username;
    }

    @Override
    public boolean isAccountNonExpired()
    {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked()
    {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired()
    {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled()
    {
        return enabled;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        return null;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getReferenceCode()
    {
        return referenceCode;
    }

    public void setReferenceCode(String referenceCode)
    {
        this.referenceCode = referenceCode;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public MemberType getMemberType()
    {
        return memberType;
    }

    public void setMemberType(MemberType memberType)
    {
        this.memberType = memberType;
    }

    public void setAccountNonExpired(boolean accountNonExpired)
    {
        this.accountNonExpired = accountNonExpired;
    }

    public void setAccountNonLocked(boolean accountNonLocked)
    {
        this.accountNonLocked = accountNonLocked;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired)
    {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public void setEnabled(boolean enabled)
    {
        this.enabled = enabled;
    }
}
