package com.registrationapi.services;

import com.registrationapi.models.MemberType;
import com.registrationapi.repositories.MemberTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberTypeService
{
    private final MemberTypeRepository memberTypeRepository;

    public MemberTypeService(MemberTypeRepository memberTypeRepository)
    {
        this.memberTypeRepository = memberTypeRepository;
    }


    public MemberType getMemberTypeBySalary(int salary)
    {
        return memberTypeRepository.findByMinimumSalaryLessThanEqualAndMaximumSalaryGreaterThanEqual(salary, salary);
    }

    public List<MemberType> getAllMemberType()
    {
        return memberTypeRepository.findAll();
    }

}
