package com.registrationapi.repositories;

import com.registrationapi.models.MemberType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberTypeRepository extends JpaRepository<MemberType, Long>
{
    Optional<MemberType> findByMemberTypeName(String memberTypename);

    MemberType findByMinimumSalaryLessThanEqualAndMaximumSalaryGreaterThanEqual(int salary1, int salary2);
}
