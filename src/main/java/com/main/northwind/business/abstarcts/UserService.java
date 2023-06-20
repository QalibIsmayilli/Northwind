package com.main.northwind.business.abstarcts;

import com.main.northwind.core.entities.User;
import com.main.northwind.core.utilities.results.DataResult;
import com.main.northwind.core.utilities.results.Result;

public interface UserService {

    Result add(User user);

    Result update(User user);

    Result remove(User user);

    DataResult findByEmail(String email);

}
