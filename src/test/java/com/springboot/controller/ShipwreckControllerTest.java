package com.springboot.controller;

import com.springboot.model.Shipwreck;
import com.springboot.repository.ShipwreckRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class ShipwreckControllerTest {
    @InjectMocks
    private ShipwreckController shipwreckController;

    @Mock
    private ShipwreckRepository shipwreckRepository;

    @BeforeMethod
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testShipwreckGet() {
        Shipwreck sw = new Shipwreck();
        sw.setId(1L);
        when(shipwreckRepository.getOne(1L)).thenReturn(sw);
        Shipwreck shipwreck = shipwreckController.get(1L);
        assertThat(1L).isEqualTo(shipwreck.getId().intValue());
    }
    @Test
    public void testShipwreckDelete() {
        Shipwreck sw = new Shipwreck();
        sw.setId(1L);
        when(shipwreckRepository.getOne(1L)).thenReturn(null);
        Shipwreck shipwreck = shipwreckController.delete(1L);
        //assertThat(shipwreck).isNull();
        assertThat(shipwreck).as("User attribute is deleted as expected").isNull();

    }

    @Test
    public void testShipwreckCreate() {
    }

    @Test
    public void testUpdate() {
    }

    @Test
    public void testDelete() {
    }
}