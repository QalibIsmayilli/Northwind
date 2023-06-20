package com.main.northwind.business.concretes;

import com.main.northwind.business.abstarcts.ProductService;
import com.main.northwind.core.utilities.results.DataResult;
import com.main.northwind.core.utilities.results.DataSuccessResult;
import com.main.northwind.core.utilities.results.Result;
import com.main.northwind.core.utilities.results.SuccessResult;
import com.main.northwind.entities.concretes.Product;
import com.main.northwind.dataAccess.abstracts.ProductDaoInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductManager implements ProductService {

    private ProductDaoInter productDao;

    @Autowired
    public ProductManager(ProductDaoInter productDao) {
        this.productDao = productDao;
    }

    @Override
    public DataResult getAll() {
        return new DataSuccessResult<>(this.productDao.findAll(), "bilgiler getirildi .");
    }

    @Override
    public DataResult getAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return new DataSuccessResult(this.productDao.findAll(pageable));
    }

    @Override
    public Result add(Product product) {
        this.productDao.save(product);
        return new SuccessResult("Product nesnesi bashariyla eklendi");
    }


    @Override
    public DataResult getByProductName(String productName) {
        return new DataSuccessResult(this.productDao.getByProductName(productName));
    }

    @Override
    public DataResult getByProductNameAndCategoryId(String productName, Integer categoryId) {
        return new DataSuccessResult(this.productDao.getByProductNameAndCategory_Id(productName, categoryId), "urun getirildi");
    }

    @Override
    public DataResult getAllByProductNameOrCategoryId(String productName, Integer categoryId) {
        return new DataSuccessResult(this.productDao.getAllByProductNameOrCategory_Id(productName, categoryId), "urun getirildi");
    }

    @Override
    public DataResult getByCategoryId(Integer id) {
        return new DataSuccessResult(this.productDao.getByCategoryId(id), "urun getirildi");
    }

    @Override
    public DataResult getAllWithCategory(){
        return new DataSuccessResult(this.productDao.getAllWithCategory(),"nesneler getirildi");
    }
}
