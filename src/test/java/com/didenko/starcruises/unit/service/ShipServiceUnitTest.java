package com.didenko.starcruises.unit.service;

import com.didenko.starcruises.integration.BaseIntegrationTest;
import com.didenko.starcruises.mapper.ShipCreateEditDtoMapper;
import com.didenko.starcruises.mapper.ShipReadDtoMapper;
import com.didenko.starcruises.repository.ShipRepository;
import com.didenko.starcruises.service.ImageService;
import com.didenko.starcruises.service.ShipService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;

@Disabled
@ImportAutoConfiguration(classes = {
        CacheAutoConfiguration.class,
        RedisAutoConfiguration.class
})
@EnableCaching
@ExtendWith(value = {
        MockitoExtension.class,
        SpringExtension.class
})
public class ShipServiceUnitTest extends BaseIntegrationTest {

    @Mock
    private ShipCreateEditDtoMapper createEditDoMapper;
    @Mock
    private ShipReadDtoMapper readDtoMapper;
    @Mock
    private ShipRepository shipRepository;
    @Mock
    private ImageService imageService;
    @InjectMocks
    private ShipService shipService;

    @Test
    public void findAllShipsCachingTest(){
        Mockito.doReturn(new ArrayList<>()).when(shipRepository).findAll();

        shipService.findAll();
        shipService.findAll();

        Mockito.verify(shipRepository, Mockito.times(1)).findAll();
    }

}