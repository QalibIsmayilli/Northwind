package com.main.northwind.core.utilities.results;

import lombok.Getter;

@Getter
public class DataSuccessResult<T> extends DataResult{
    public DataSuccessResult(T data) {
        super(data, true);
    }

    public DataSuccessResult(T data, String message) {
        super(data,true,message);
    }
}
