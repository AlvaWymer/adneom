package com.adneom.controller;

import com.adneom.service.ISplitArrayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Yang Naihua <br>
 * Description:  SplitController<br>
 * @since 2020/02/05<br>
 */
@Slf4j
@RestController
@RequestMapping(value = "/api/splitArrays")
public class SplitController {
    @Autowired
    private ISplitArrayService splitArrayService;

    @PostMapping(value = {"/{volume}"})
    public List<List<Integer>> notifyDeparture(@RequestBody @Valid List<Integer> data, @PathVariable("volume") Integer volume) {
        return splitArrayService.partition(data, volume);
    }
}

