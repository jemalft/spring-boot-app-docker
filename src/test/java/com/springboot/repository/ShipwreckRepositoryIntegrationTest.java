package com.springboot.repository;

import com.springboot.Application;
import com.springboot.model.Shipwreck;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


//@RunWith(SpringJUnit4ClassRunner.class)
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ShipwreckRepositoryIntegrationTest {

    @Autowired
    private ShipwreckRepository shipwreckRepository;

    @Test
    public void testFindAll(){

        List<Shipwreck> wrecks = shipwreckRepository.findAll();
        assertThat(wrecks.size()).isGreaterThanOrEqualTo(0);

    }


}