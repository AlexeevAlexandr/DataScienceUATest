package com.DataScienceUATest.controller;

import com.DataScienceUATest.dto.UserFullDto;
import com.DataScienceUATest.dto.UserShortDto;
import com.DataScienceUATest.model.User;
import com.DataScienceUATest.response.Response;
import com.DataScienceUATest.service.UserService;
import com.DataScienceUATest.validation.Validation;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final ModelMapper modelMapper;
    private final UserService userService;
    private final Validation validation;

    public UserController(ModelMapper modelMapper, UserService userService, Validation validation) {
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.validation = validation;
    }

    @GetMapping(value = "/user/{id}")
    public UserFullDto getUser(@PathVariable int id) {
        if (!userService.isPresent(id)) {
            throw new IllegalArgumentException("The user not found");
        }
        User user = userService.getUser(id);
        return modelMapper.map(user, UserFullDto.class);
    }

    @GetMapping(value = "/users")
    public List<UserShortDto> getUsers() {
        List<User> users = userService.getUsers();
        return users.stream().map(e -> modelMapper.map(e, UserShortDto.class)).collect(Collectors.toList());
    }

    @PostMapping(value = "/create")
    public UserFullDto createUser(@RequestBody UserFullDto userFullDto) {

        if (validation.isDateOutOfRange(userFullDto.getBirthdate())) {
            throw new IllegalArgumentException("The date ob birthday can not be more than 150 years");
        }

        User user = modelMapper.map(userFullDto, User.class);
        User newUser = userService.createUser(user);
        return modelMapper.map(newUser, UserFullDto.class);
    }

    @PutMapping(value = "/update")
    public UserFullDto updateUser(@RequestBody UserFullDto userFullDto) {
        if (!userService.isPresent(userFullDto.getId())) {
            throw new IllegalArgumentException("The user not exists");
        }

        if (validation.isNegativeNumber(userFullDto.getId())) {
            throw new IllegalArgumentException("The id can not be negative");
        }

        if (validation.isDateOutOfRange(userFullDto.getBirthdate())) {
            throw new IllegalArgumentException("The date ob birthday can not be more than 150 years");
        }

        User user = modelMapper.map(userFullDto, User.class);
        User newUser = userService.updateUser(user);
        return modelMapper.map(newUser, UserFullDto.class);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> handleException(Exception ex) {
        Response response = new Response(ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
