package com.didenko.starcruises.contoller;

import com.didenko.starcruises.entity.ClientDocument;
import com.didenko.starcruises.entity.ClientDocumentState;
import com.didenko.starcruises.service.ClientDocumentService;
import com.didenko.starcruises.service.ClientService;
import com.didenko.starcruises.service.ImageService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RequiredArgsConstructor
@RequestMapping("/document")
@Controller
public class DocumentController {

    private final ImageService imageService;
    private final ClientDocumentService clientDocumentService;

    @GetMapping("/delete/{documentId}")
    public String deleteImage(@PathVariable("documentId") Long documentId){

        Optional<ClientDocument> clientDocument = imageService.findClientDocumentById(documentId);
        clientDocument.ifPresent(imageService::deleteClientDocument);

        return "redirect:/client";
    }

    @GetMapping("/{action}/{documentId}")
    public String doActionToImage(@PathVariable("action") String action, @PathVariable("documentId") Long documentId){

        clientDocumentService.changeDocumentState(action, documentId);

        return "redirect:/document";
    }

    @SneakyThrows
    @RequestMapping(value = "/{documentId}", method = RequestMethod.GET)
    @ResponseBody
    public void findImage(@PathVariable("documentId") Long documentId, HttpServletResponse response){

        response.setContentType("image/jpeg");
        response.getOutputStream().write(imageService.getClientDocumentById(documentId).get());
    }

    @GetMapping
    public String documentsPage(Model model){

        model.addAttribute("documents",
                clientDocumentService.findAllDocumentsByState(ClientDocumentState.PENDING));

        return "/documents";
    }

}