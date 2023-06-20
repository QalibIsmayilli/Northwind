package com.main.northwind.business.abstarcts;

import com.main.northwind.core.utilities.results.DataResult;
import com.main.northwind.core.utilities.results.Result;
import com.main.northwind.entities.concretes.Category;
import com.main.northwind.entities.concretes.Product;


public interface ProductService {
    DataResult getAll();

    DataResult getAll(int pageNo, int pageSize);

    Result add(Product product);


    DataResult getByProductName(String productName);

    DataResult getByProductNameAndCategoryId(String productName, Integer categoryId);


    DataResult getAllByProductNameOrCategoryId(String productName, Integer categoryId);

    DataResult getByCategoryId(Integer id);

    DataResult getAllWithCategory();
}
