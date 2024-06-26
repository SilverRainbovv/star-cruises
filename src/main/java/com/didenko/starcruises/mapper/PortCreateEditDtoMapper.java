package com.didenko.starcruises.mapper;

import com.didenko.starcruises.dto.PortCreateEditDto;
import com.didenko.starcruises.entity.Port;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class PortCreateEditDtoMapper implements Mapper<PortCreateEditDto, Port> {
    @Override
    public Port mapFrom(PortCreateEditDto object) {
        return Port.builder()
                .id(object.getId())
                .name(object.getName())
                .visitDate(LocalDate.parse(object.getVisitDate()))
                .build();
    }

    public PortCreateEditDto mapFrom(Port object) {

        return PortCreateEditDto.builder()
                .id(object.getId())
                .name(object.getName())
                .visitDate(object.getVisitDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .build();
    }
}
