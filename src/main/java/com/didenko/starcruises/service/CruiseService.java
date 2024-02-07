package com.didenko.starcruises.service;

import com.didenko.starcruises.dto.CruiseCreateEditDto;
import com.didenko.starcruises.dto.CruiseReadDto;
import com.didenko.starcruises.entity.Cruise;
import com.didenko.starcruises.entity.Port;
import com.didenko.starcruises.mapper.CruiseCreateEditDtoMapper;
import com.didenko.starcruises.mapper.CruiseReadDtoMapper;
import com.didenko.starcruises.repository.CruiseRepository;
import com.didenko.starcruises.repository.PortRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class CruiseService {

    private final CruiseRepository cruiseRepository;
    private final PortRepository portRepository;
    private final CruiseReadDtoMapper mapper;
    private final CruiseCreateEditDtoMapper cruiseCreateEditDtoMapper;
    private final ImageService imageService;

    public List<CruiseReadDto> allCruises() {
        return cruiseRepository.findAll().stream().map(mapper::mapFrom).toList();
    }

    @Transactional(readOnly = false)
    public void save(CruiseCreateEditDto cruiseDto) {

        Cruise cruise = cruiseDto.getId() == null
                ? new Cruise()
                : cruiseRepository.findById(cruiseDto.getId()).orElse(new Cruise());
        Cruise updatedCruise = cruiseCreateEditDtoMapper.mapFrom(cruiseDto);

        cruise.setShip(updatedCruise.getShip());
        cruise.setDescription(updatedCruise.getDescription());
        cruise.setImage(updatedCruise.getImage());
        comparePorts(cruise.getPorts(), updatedCruise.getPorts(), cruise);

        uploadImage(cruiseDto.getImage());

        cruiseRepository.save(cruise);
    }

    public Optional<byte[]> findCruiseImage(Long id){
        return cruiseRepository.findById(id)
                .map(Cruise::getImage)
                .filter(StringUtils::hasText)
                .flatMap(imageService::getCruiseImage);
    }

    @SneakyThrows
    private void uploadImage(MultipartFile image) {
        if (image != null && !image.isEmpty())
            imageService.uploadCrusieImage(image.getOriginalFilename(), image.getInputStream());
    }

    public Optional<CruiseCreateEditDto> findEditDtoById(Long cruiseId) {
        return cruiseRepository.findById(cruiseId).map(cruiseCreateEditDtoMapper::mapFrom);
    }

    public Optional<CruiseReadDto> findReadDtoById(Long cruiseId){
        Optional<Cruise> cruise = cruiseRepository.findById(cruiseId);
        return cruise.map(mapper::mapFrom);

    }

    public void comparePorts(List<Port> oldPorts, List<Port> newPorts, Cruise cruise) {
        List<Port> toBeRemoved = oldPorts.stream().filter(port -> !newPorts.contains(port)).toList();
        List<Port> toBeInserted = newPorts.stream().filter(port -> !oldPorts.contains(port)).toList();

        portRepository.deleteAll(toBeRemoved);
        cruise.removePorts(toBeRemoved);
        toBeInserted.forEach(port -> port.setCruise(cruise));
    }

    public Optional<Cruise> findCruiseEntityById(Long cruiseId) {
        return cruiseRepository.findById(cruiseId);
    }
}
