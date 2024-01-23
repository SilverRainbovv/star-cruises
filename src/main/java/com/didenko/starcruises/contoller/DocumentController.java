package com.didenko.starcruises.contoller;

import com.didenko.starcruises.entity.ClientDocument;
import com.didenko.starcruises.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@RequiredArgsConstructor
@RequestMapping("/document")
@Controller
public class DocumentController {

    private final ImageService imageService;

    @GetMapping("/delete/{documentId}")
    public String deleteImage(@PathVariable("documentId") Long documentId){

        Optional<ClientDocument> clientDocument = imageService.findClientDocumentById(documentId);
        clientDocument.ifPresent(imageService::deleteClientDocument);

        return "redirect:/cruises";
    }

}
