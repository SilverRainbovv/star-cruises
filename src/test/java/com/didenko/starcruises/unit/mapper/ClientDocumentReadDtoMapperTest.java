package com.didenko.starcruises.unit.mapper;

import com.didenko.starcruises.dto.ClientDocumentDto;
import com.didenko.starcruises.entity.ClientDocument;
import com.didenko.starcruises.entity.ClientDocumentState;
import com.didenko.starcruises.mapper.ClientDocumentReadDtoMapper;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class ClientDocumentReadDtoMapperTest {

    private static final MockMultipartFile MOCK_MULTIPART_FILE;
    static {
        try {
            MOCK_MULTIPART_FILE = new MockMultipartFile("doc", "doc", null, InputStream.nullInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static final ClientDocument CLIENT_DOCUMENT = ClientDocument.builder()
            .name("doc")
            .state(ClientDocumentState.APPROVED)
            .build();
    private static final ClientDocumentDto CLIENT_DOCUMENT_DTO = ClientDocumentDto.builder()
            .documentName("doc")
            .state(ClientDocumentState.APPROVED)
            .build();

    private final ClientDocumentReadDtoMapper mapper = new ClientDocumentReadDtoMapper();

    @Test
    void testMapFromClientDocument() {
        assertEquals(CLIENT_DOCUMENT_DTO, mapper.mapFrom(CLIENT_DOCUMENT));
    }
}