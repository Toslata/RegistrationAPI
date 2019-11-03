package com.registrationapi.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MemberType
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long memberTypeId;

    private String memberTypeName;

    private int minimumSalary;

    private int maximumSalary;

    public MemberType()
    {

    }

    public long getId()
    {
        return memberTypeId;
    }

    public void setId(long id)
    {
        this.memberTypeId = id;
    }

    public String getMemberTypeName()
    {
        return memberTypeName;
    }

    public void setMemberTypeName(String memberTypeName)
    {
        this.memberTypeName = memberTypeName;
    }

    public long getMemberTypeId()
    {
        return memberTypeId;
    }

    public void setMemberTypeId(long memberTypeId)
    {
        this.memberTypeId = memberTypeId;
    }

    public int getMinimumSalary()
    {
        return minimumSalary;
    }

    public void setMinimumSalary(int minimumSalary)
    {
        this.minimumSalary = minimumSalary;
    }

    public int getMaximumSalary()
    {
        return maximumSalary;
    }

    public void setMaximumSalary(int maximumSalary)
    {
        this.maximumSalary = maximumSalary;
    }
}
