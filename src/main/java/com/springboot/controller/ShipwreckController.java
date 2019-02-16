package com.springboot.controller;

import com.springboot.model.Shipwreck;
import com.springboot.repository.ShipwreckRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class ShipwreckController {

    @Autowired
    private ShipwreckRepository shipwreckRepository;


    @RequestMapping(value = "shipwrecks",method = RequestMethod.GET)
    public List<Shipwreck> list(){
        //return ShipwreckStub.list();
        return shipwreckRepository.findAll();
    }

    @RequestMapping(value = "shipwrecks",method = RequestMethod.POST)
    public Shipwreck create(@RequestBody Shipwreck shipwreck){
        //return ShipwreckStub.create(shipwreck);
        return shipwreckRepository.saveAndFlush(shipwreck);
    }

    @RequestMapping(value = "shipwrecks/{id}",method = RequestMethod.GET)
    public Shipwreck get(@PathVariable long id){
        //return ShipwreckStub.get(id);
        return shipwreckRepository.getOne(id);
    }

    @RequestMapping(value = "shipwrecks/{id}",method = RequestMethod.PUT)
    public Shipwreck update(@PathVariable long id, @RequestBody Shipwreck shipwreck){
        //return ShipwreckStub.update(id , shipwreck);
        Shipwreck existingShipwreck = shipwreckRepository.getOne(id);
        BeanUtils.copyProperties(shipwreck,existingShipwreck);
        return shipwreckRepository.saveAndFlush(existingShipwreck);
    }

    @RequestMapping(value = "shipwrecks/{id}",method = RequestMethod.DELETE)
    public Shipwreck delete(@PathVariable long id){
        //return ShipwreckStub.get(id);
        Shipwreck existingShipwreck = shipwreckRepository.getOne(id);
        shipwreckRepository.delete(existingShipwreck);
        return existingShipwreck;
    }
}
