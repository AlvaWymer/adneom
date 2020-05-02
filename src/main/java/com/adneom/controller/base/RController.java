package com.adneom.controller.base;

import com.adneom.exception.Result;
import com.adneom.repository.BaseJpaRepository;
import com.adneom.specification.RSQLSpecification;
import com.adneom.utils.CommonUtils;
import com.adneom.utils.ResultUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @param <T>  Domain class type
 * @param <ID> Id class type
 * @ClassName: RController
 * @Description: Base repository contain R REST API, subclass have to provide base URL and inject repository.<br/>
 * The method in there can be inherited, but do not rewrite @GetMapping(value = "/something")
 * @Author: Yang Naihua
 * @Create: 2018-07-04 23:08
 */

public abstract class RController<T, ID> extends AbstractController<T, ID> {
    public static Result result = ResultUtil.success();

    protected BaseJpaRepository<T, ID> repository;

    protected RController(BaseJpaRepository<T, ID> repository) {
        super(repository);
        this.repository = repository;
    }

    /**
     * Get all articles in database
     *
     * @return a iterable list of articles.
     */
    @GetMapping(value = "array")
    public Result<List<T>> find(RSQLSpecification<T> predicate) {
        return result((T) repository.findAll(predicate));
    }

    /**
     * List all articles by page
     *
     * @param pageable
     * @param predicate
     * @return
     */
    @GetMapping
    public Result<Page<T>> find(
            @PageableDefault Pageable pageable,
            RSQLSpecification<T> predicate) {
        return result((T) repository.findAll(predicate, pageable));
    }

    /**
     * Get a corresponding article by its hscode.
     *
     * @param id
     * @return the corresponding article.
     */
    @GetMapping(value = "/{id}")
    public Result get(@PathVariable("id") ID id) {
        return result(repository.findById(id).orElse(null));
    }

    public Result result(T t) {
        if (t != null) {
            return result = ResultUtil.success(t);
        }
        return result;
    }

    public Result result(List<T> t) {
        if (!CommonUtils.isEmpty(t)) {
            return result = ResultUtil.success(t);
        }
        return result;
    }
}
