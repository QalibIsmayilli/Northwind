package com.main.northwind.core.utilities.results;

import lombok.Getter;

public class DataErrorResult<T> extends DataResult {

    public DataErrorResult(Object data) {
        super(data, false);
    }

    public DataErrorResult(T data, String message) {
        super(data, false, message);
    }
}
