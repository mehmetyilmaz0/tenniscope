package com.tenniscope.tenniscope.util;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

public class TPage<T>  {

    private int number;         // suan kacinci sayfada
    private int size;           // kayitlar kacarli gosterilsin
    private Sort sort;          // kolona tiklayip o kolonu siralayacak
    private int totalPages;     // toplam kac sayfa var
    private Long totalElements; // totalde kac tane kayit var
    private List<T> content;    // datalarin listesi

    public void setStat(Page page, List<T> list) {
        this.number = page.getNumber();
        this.size = page.getSize();
        this.sort = page.getSort();
        this.totalPages = page.getTotalPages();
        this.totalElements = page.getTotalElements();
        this.content = list;
    }

}
