package com.didenko.starcruises.service;

import com.didenko.starcruises.dto.CruiseCreateEditDto;
import com.didenko.starcruises.dto.CruiseReadDto;
import com.didenko.starcruises.entity.*;
import com.didenko.starcruises.mapper.CruiseCreateEditDtoMapper;
import com.didenko.starcruises.mapper.CruiseReadDtoMapper;
import com.didenko.starcruises.querydsl.QPredicates;
import com.didenko.starcruises.repository.CruiseRepository;
import com.didenko.starcruises.repository.PortRepository;
import com.didenko.starcruises.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.domain.Page;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.data.querydsl.QSort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static com.didenko.starcruises.entity.QCruise.cruise;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class CruiseService {

    private final CruiseRepository cruiseRepository;
    private final PortRepository portRepository;
    private final CruiseReadDtoMapper mapper;
    private final CruiseCreateEditDtoMapper cruiseCreateEditDtoMapper;
    private final ImageService imageService;


    public Page<CruiseReadDto> findCruisesByFilter(CruiseFilter cruiseFilter) {

        var predicates = QPredicates.builder()
                .add(cruiseFilter.getDepartureAfter(), cruise.firstPort.visitDate::after)
                .add(cruiseFilter.getNights(), dur -> cruise.duration.between(dur.minNights, dur.maxNights));

        if (!cruiseFilter.getShipName().isBlank())
            predicates.add(cruiseFilter.getShipName(), cruise.ship.name::containsIgnoreCase);

        if (!cruiseFilter.getDeparturePort().isBlank())
            predicates.add(cruiseFilter.getDeparturePort(), cruise.firstPort.name::containsIgnoreCase);

        var builtPredicates = predicates.build();

        QPageRequest qPageRequest = QPageRequest.of(cruiseFilter.getPageNumber(),
                cruiseFilter.getPageSize().getSize(),
                sort(cruiseFilter.getSortOption()));

        return cruiseRepository.findAll(builtPredicates, qPageRequest)
                .map(mapper::mapFrom);
    }

    private QSort sort(CruiseSortOptions sortOption) {
        return switch (sortOption) {
            case DEPARTURE_EARLIEST -> QSort.by(cruise.firstPort.visitDate.asc());
            case DEPARTURE_LATEST -> QSort.by(cruise.firstPort.visitDate.desc());
            case DURATION_ASCENDING -> QSort.by(cruise.duration.asc());
            case DURATION_DESCENDING -> QSort.by(cruise.duration.desc());
            default -> QSort.unsorted();
        };
    }

    public List<CruiseReadDto> findAllCruises() {
        return cruiseRepository.findAll().stream()
                .sorted(Comparator.comparing(c -> c.getState().getPriority()))
                .map(mapper::mapFrom)
                .toList();
    }

    @Transactional(readOnly = false)
    public Long save(CruiseCreateEditDto cruiseDto) {

        Cruise cruise = cruiseDto.getId() == null
                ? new Cruise()
                : cruiseRepository.findById(cruiseDto.getId()).orElse(new Cruise());
        Cruise updatedCruise = cruiseCreateEditDtoMapper.mapFrom(cruiseDto);

        cruise.setShip(updatedCruise.getShip());
        cruise.setDescription(updatedCruise.getDescription());
        comparePorts(cruise.getPorts(), updatedCruise.getPorts(), cruise);
        cruise.setFirstPort(updatedCruise.getFirstPort());
        cruise.setLastPort(updatedCruise.getLastPort());
        cruise.setDuration(updatedCruise.getDuration());
        cruise.setImage(updatedCruise.getImage() == null ? cruise.getImage() : updatedCruise.getImage());

        cruise.getFirstPort().setCruise(cruise);
        cruise.getLastPort().setCruise(cruise);

        uploadImage(cruiseDto.getImage());

        return cruiseRepository.save(cruise).getId();
    }

    public Optional<byte[]> findCruiseImage(Long id) {
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

    public Optional<CruiseReadDto> findReadDtoById(Long cruiseId) {
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

    @Transactional(readOnly = false)
    public void changeCruiseStateByCruiseId(Long cruiseId, CrusieState crusieState) {

        cruiseRepository.setStateByCruiseId(cruiseId, crusieState);
    }
}
