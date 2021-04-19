package com.kaf22.codezilla.controllers;

import com.pi4j.io.gpio.*;
import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @SneakyThrows
    @GetMapping("/open")
    public void openDoor() {
        GpioController gpio = GpioFactory.getInstance();
        GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_29);
        pin.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);

        pin.high();
        Thread.sleep(3000);
        pin.low();

        gpio.shutdown();
        gpio.unprovisionPin(pin);
    }
}
