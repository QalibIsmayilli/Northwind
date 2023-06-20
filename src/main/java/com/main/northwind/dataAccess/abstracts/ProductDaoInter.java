package com.main.northwind.dataAccess.abstracts;

import com.main.northwind.entities.concretes.Category;
import com.main.northwind.entities.concretes.Product;
import com.main.northwind.entities.dtos.ProductWithCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDaoInter extends JpaRepository<Product,Integer> {

    Product getByProductName(String productName);

    Product getByProductNameAndCategory_Id(String productName, Integer categoryId);


    List<Product> getAllByProductNameOrCategory_Id(String productName, Integer categoryId);


    @Query(value = "select p from Product p where p.category.id=:id")
    List<Product> getByCategoryId(Integer id);

    @Query(value = "select new com.main.northwind.entities.dtos.ProductWithCategory(p.id,p.productName,p.category.name) from Product p")
    List<ProductWithCategory> getAllWithCategory();
}
