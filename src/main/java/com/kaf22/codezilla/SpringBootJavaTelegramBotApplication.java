package com.kaf22.codezilla;

import com.pi4j.io.gpio.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootJavaTelegramBotApplication {

    public static void main(String[] args) {

        GpioController gpio = GpioFactory.getInstance();
        GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_29);
        pin.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);

        pin.low();

        gpio.shutdown();
        gpio.unprovisionPin(pin);

        SpringApplication.run(SpringBootJavaTelegramBotApplication.class, args);
    }

}
