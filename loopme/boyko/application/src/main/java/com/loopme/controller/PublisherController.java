package com.loopme.controller;

import com.loopme.model.Application;
import com.loopme.service.IPublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/publisher")
public class PublisherController {

    @Autowired
    private IPublisherService publisherService;

    @PostMapping("/createApplication")
    @ResponseBody
    public Application createApplication(@RequestBody Application application) {
        return publisherService.createApplication(application);
    }

    @PostMapping("/updateApplication")
    @ResponseBody
    public Application updateApplication(@RequestBody Application application) {
        return publisherService.updateApplication(application);
    }

    @DeleteMapping("/deleteApplication")
    public void deleteApplication(@RequestParam String businessKey) {
        publisherService.deleteApplication(businessKey);
    }

    @GetMapping("/getApplicationsByPublisherName")
    @ResponseBody
    public List<Application> getApplicationsByPublisherName(@RequestParam String publisherName) {
        return publisherService.getApplicationsByPublisherName(publisherName);
    }
}
