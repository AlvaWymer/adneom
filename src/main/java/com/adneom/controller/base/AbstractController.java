package com.adneom.controller.base;


import com.adneom.repository.BaseJpaRepository;

/**
 * @param <T>  Domain class type
 * @param <ID> Id class type
 * @ClassName: AbstractController
 * @Description: Base repository contain CURD REST API, subclass have to provide base URL and inject repository.<br/>
 * The method in there can be inherited, but do not rewrite @GetMapping(value = "/something")
 * @Author: Yang Naihua
 * @Create: 2018-07-04 23:08
 */

public abstract class AbstractController<T, ID> {
    protected BaseJpaRepository<T, ID> repository;

    AbstractController(BaseJpaRepository<T, ID> repository) {
        this.repository = repository;
    }
}
