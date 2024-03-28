package com.didenko.starcruises.mapper;

import com.didenko.starcruises.dto.ClientDocumentDto;
import com.didenko.starcruises.entity.ClientDocument;
import com.didenko.starcruises.entity.ClientDocumentState;
import org.springframework.stereotype.Component;

@Component
public class  ClientDocumentReadDtoMapper implements Mapper<ClientDocument, ClientDocumentDto> {
    @Override
    public ClientDocumentDto mapFrom(ClientDocument object) {
        return ClientDocumentDto.builder()
                .id(object.getId())
                .documentName(object.getName())
                .state(object.getState())
                .build();
    }
}
