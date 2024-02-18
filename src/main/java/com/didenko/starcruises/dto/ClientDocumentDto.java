package com.didenko.starcruises.dto;

import com.didenko.starcruises.entity.ClientDocumentState;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientDocumentDto {

    private Long id;

    @NotBlank
    private String documentName;

    private ClientDocumentState state;

    @NotNull
    private MultipartFile multipartFile;

}
