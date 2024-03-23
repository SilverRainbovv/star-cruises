package com.didenko.starcruises.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;
import lombok.Value;
import org.springframework.data.domain.Page;

import java.util.List;

@AllArgsConstructor
@Data
public class PageResponse <T>{

    @Setter
    List<T> content;
    Metadata metadata;

    public static <T> PageResponse<T> of(Page<T> page){
        var metadata = new Metadata(page.getNumber(), page.getSize(), page.getTotalElements());
        return new PageResponse<>(page.getContent(), metadata);
    }

    @Value
    public static class Metadata {
        int page;
        int size;
        long totalElements;
    }

}
