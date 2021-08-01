package ru.lanit.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.lanit.dto.response.StatisticDTO;
import ru.lanit.service.ApplicationService;

@RestController
public class ServiceController {

    private final ApplicationService service;

    public ServiceController(ApplicationService service) {
        this.service = service;
    }

    @GetMapping("/clear")
    public void clearData() {
        service.clearAll();
    }

    @GetMapping("/statistics")
    public StatisticDTO getStatistic(){
       return service.getStatistic();
    }
}
