package com.didenko.starcruises.dto;

import com.didenko.starcruises.entity.ClientDocumentState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientDocumentDto {

    private Long id;

    private String name;

    private String documentNumber;

    private ClientDocumentState state;

    private MultipartFile multipartFile;

}
