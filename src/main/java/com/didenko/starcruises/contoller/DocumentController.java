package com.didenko.starcruises.contoller;

import com.didenko.starcruises.entity.ClientDocument;
import com.didenko.starcruises.service.ImageService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

        return "redirect:/client";
    }

    @SneakyThrows
    @RequestMapping(value = "/{documentId}", method = RequestMethod.GET)
    @ResponseBody
    public void findImage(@PathVariable("documentId") Long documentId, HttpServletResponse response){

        response.setContentType("image/jpeg");
        response.getOutputStream().write(imageService.getClientDocumentById(documentId).get());
    }

}