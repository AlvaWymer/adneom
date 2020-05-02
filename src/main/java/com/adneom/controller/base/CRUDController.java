package com.adneom.controller.base;

import com.adneom.exception.BusinessException;
import com.adneom.exception.Result;
import com.adneom.repository.BaseJpaRepository;
import com.adneom.utils.ValidListUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

import static com.adneom.exception.ErrorCode.UPDATE_ERROR;

/**
 * @param <T>  Domain class type
 * @param <ID> Id class type
 * @ClassName: CRUDController
 * @Description: Base repository contain CURD REST API, subclass have to provide base URL and inject repository.<br/>
 * The method in there can be inherited, but do not rewrite @GetMapping(value = "/something")
 * @Author: Yang Naihua
 * @Create: 2018-07-04 23:08
 */
public abstract class CRUDController<T, ID> extends RController<T, ID> {
    protected BaseJpaRepository<T, ID> repository;

    protected CRUDController(BaseJpaRepository<T, ID> repository) {
        super(repository);
        this.repository = repository;
    }

    /**
     * Create a new article
     *
     * @param entity the created entity
     * @return the corresponding created article
     */
    @PostMapping
    public Result create(@Validated @RequestBody T entity) {
        return result(repository.save(entity));
    }

    @PostMapping(value = "array")
    public Result<List<T>> create(@RequestBody @Valid ValidListUtils<T> entities) {
        return result((T) repository.saveAll(entities));
    }

    /**
     * Update an article object
     *
     * @param sourceEntity
     * @return the updated article.
     */
    @PutMapping(value = "/{id}")
    public Result update(@Validated @RequestBody T sourceEntity, @PathVariable("id") ID id) {
        if (!repository.existsById(id)) {
            throw new BusinessException(UPDATE_ERROR);
        }
        return result(repository.save(sourceEntity));
    }

    /**
     * Delete the given article.
     *
     * @param id
     * @throws IOException
     */
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") ID id) {
        repository.deleteById(id);
    }
}
