package com.adneom.service.impl;

import com.adneom.service.ISplitArrayService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @className: SplitArrayServiceImpl
 * @description:
 * @author: Yang Naihua
 * @create: 2020-05-02 13:41
 **/
@Service
public class SplitArrayServiceImpl implements ISplitArrayService {
    @Override
    public List<List<Integer>> partition(List<Integer> data, Integer subSize) {
        int count = data.size() % subSize == 0 ? data.size() / subSize
                : data.size() / subSize + 1;

        List<List<Integer>> subAryList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int index = i * subSize;
            List<Integer> list = new ArrayList<>();
            int j = 0;
            while (j < subSize && index < data.size()) {
                list.add(data.get(index++));
                j++;
            }
            subAryList.add(list);
        }
        return subAryList;
    }
}