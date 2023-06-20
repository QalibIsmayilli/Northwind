package com.main.northwind.business.concretes;

import com.main.northwind.business.abstarcts.UserService;
import com.main.northwind.core.dataAccess.UserDaoInter;
import com.main.northwind.core.entities.User;
import com.main.northwind.core.utilities.results.DataResult;
import com.main.northwind.core.utilities.results.DataSuccessResult;
import com.main.northwind.core.utilities.results.Result;
import com.main.northwind.core.utilities.results.SuccessResult;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {
    private UserDaoInter userDao;

    @Autowired
    public UserManager(UserDaoInter userDao){
        this.userDao = userDao;
    }

    @Override
    public Result add(User user){
        this.userDao.save(user);
        return new SuccessResult("kullanici eklendi");
    }

    @Override
    public Result update(User user) {
        this.userDao.save(user);
        return new SuccessResult("kullanici guncellendi");
    }

    @Override
    public Result remove(User user){
        this.userDao.delete(user);
        return new SuccessResult("kullanici silindi");
    }

    @Override
    public DataResult findByEmail(String email) {
        return new DataSuccessResult(this.userDao.findByEmail(email),"kullanici bashariyla getirildi");
    }
}
