package com.springboot.controller;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HomeControllerTest {

    private HomeController homeController;

    @BeforeMethod
    public void setUp() {
        homeController = new HomeController();
    }

    @Test
    public void testHome() {
        String result = homeController.home();
        assertThat(result).isEqualTo("Das Boot, reporting for duty");
    }
}