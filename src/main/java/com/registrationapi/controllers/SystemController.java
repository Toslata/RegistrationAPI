package com.registrationapi.controllers;

import com.registrationapi.config.security.Config;
import com.registrationapi.models.MemberType;
import com.registrationapi.models.User;
import com.registrationapi.requests.RegisterRequest;
import com.registrationapi.services.MemberTypeService;
import com.registrationapi.services.UserService;
import com.registrationapi.utils.RegistrationUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
public class SystemController
{
    private final UserService userService;

    private final MemberTypeService memberTypeService;

    private final Config config;
    public SystemController(UserService userService, MemberTypeService memberTypeService, Config config)
    {
        this.userService = userService;
        this.memberTypeService = memberTypeService;
        this.config = config;


    }
    @PostMapping("/register")
    public ResponseEntity<?> postUser(@Valid @RequestBody RegisterRequest request)
    {
        if(userService.checkExists(request.getUsername()))
        {
            throw new ResponseStatusException(HttpStatus.CONFLICT, request.getUsername() + " is already exists");
        }
        int salary = request.getSalary();
        MemberType memberType = memberTypeService.getMemberTypeBySalary(salary);
        if(memberType == null)
        {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, request.getSalary() + " is too low");
        }
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(config.getPasswordEncoder().encode(request.getPassword()));
        String referenceCode = RegistrationUtil.generateRefCode(request.getPhoneNumber());
        user.setReferenceCode(referenceCode);
        user.setMemberType(memberType);
        userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping("/users")
    public List<User> getCustomer()
    {
        return userService.getAllUsers();
    }

    @GetMapping("/memberTypes")
    public List<MemberType> getMemberTypes()
    {
        return memberTypeService.getAllMemberType();
    }


}




