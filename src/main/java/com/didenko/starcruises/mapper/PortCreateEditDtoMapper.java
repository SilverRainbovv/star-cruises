package com.didenko.starcruises.mapper;

import com.didenko.starcruises.dto.PortCreateEditDto;
import com.didenko.starcruises.entity.Port;
import org.springframework.stereotype.Component;

@Component
public class PortCreateEditDtoMapper implements Mapper<PortCreateEditDto, Port> {
    @Override
    public Port mapFrom(PortCreateEditDto object) {
        return Port.builder()
                .name(object.getName())
                .visitDate(object.getVisitDate())
                .build();
    }
}
