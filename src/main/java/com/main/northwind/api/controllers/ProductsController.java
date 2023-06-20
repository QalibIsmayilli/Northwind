package com.main.northwind.api.controllers;


import com.main.northwind.business.abstarcts.ProductService;
import com.main.northwind.core.utilities.results.DataResult;
import com.main.northwind.core.utilities.results.Result;
import com.main.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/getall")
    public DataResult getAll() {
        return this.productService.getAll();
    }

    @GetMapping("/getall2")
    public DataResult getAll(int pageNo, int pageSize) {
        return this.productService.getAll(pageNo, pageSize);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Product product) {
        return this.productService.add(product);
    }

    @GetMapping("/getByProductName")
    public DataResult getByCategory(@RequestParam String productName) {
        return this.productService.getByProductName(productName);
    }

    @GetMapping("/getByProductNameAndCategoryId")
    public DataResult getByProductNameAndCategory(@RequestParam String productName, @RequestParam Integer categoryId) {
        return this.productService.getByProductNameAndCategoryId(productName, categoryId);
    }

    @GetMapping("/getAllByProductNameOrCategory")
    public DataResult getAllByProductNameOrCategory(@RequestParam String productName, @RequestParam Integer categoryId) {
        return this.productService.getAllByProductNameOrCategoryId(productName, categoryId);
    }

    @GetMapping("/getByCategoryId")
    public DataResult getByCategoryId(Integer categoryId) {
        return this.productService.getByCategoryId(categoryId);
    }


    @GetMapping("/getAllWithCategory")
    public DataResult getAllWithCategory(){
        return this.productService.getAllWithCategory();
    }


}
