package com.adneom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Application {
    // set volume
    private static final Integer SPLIT_SIZE = 3;

    public static void main(String[] args) {
        System.setProperty("spring.profiles.default", "dev");
        SpringApplication.run(Application.class, args);
//
//        // init data
//        List<Integer> data = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
//        System.out.println(data);
//        // result
//        List<List<Integer>> subAry = partition(data, SPLIT_SIZE);
//        System.out.println(subAry);
    }


    /**
     * 比如 { "a", "b", "c", "d", "e" }
     * 分隔成
     * a, b
     * c, d
     * e¬
     */
    private static List<List<Integer>> partition(List<Integer> data, Integer subSize) {

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
