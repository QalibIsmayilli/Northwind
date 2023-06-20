package com.main.northwind.api.controllers;


import com.main.northwind.business.abstarcts.UserService;
import com.main.northwind.core.entities.User;
import com.main.northwind.core.utilities.results.DataErrorResult;
import com.main.northwind.core.utilities.results.DataResult;
import com.main.northwind.core.utilities.results.Result;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getByEmail")
    public DataResult getByEmail(@RequestParam String email) {
        return this.userService.findByEmail(email);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody User user) {
        return ResponseEntity.ok(this.userService.add(user));
    }

    @PostMapping("/update")
    public Result update(@RequestBody User user) {
        return this.userService.update(user);
    }

    @PostMapping("/remove")
    public Result remove(@RequestBody User user) {
        return this.userService.remove(user);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public DataErrorResult<Object> handleValidationExceptions(MethodArgumentNotValidException exception) {
        Map<String,String> validationExceptions = new HashMap<>();
        for (FieldError fieldError: exception.getBindingResult().getFieldErrors()){
            validationExceptions.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        return new DataErrorResult(validationExceptions, "Dogrulama hatalari");
    }

}
