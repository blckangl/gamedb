package com.example.gamedb.controllers;


import com.example.gamedb.models.Game;
import com.example.gamedb.models.Platform;
import com.example.gamedb.services.GameService;
import com.example.gamedb.services.PlatformService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/platforms")
@CrossOrigin("*")
public class PlatformController {

    PlatformService platformService;

    public PlatformController(PlatformService platformService) {
        this.platformService = platformService;
    }

    @GetMapping()
    public ArrayList<Platform> Index() {
        return platformService.getPlatforms();
    }

    @DeleteMapping("{id}")
    public ArrayList<Platform> delete(@PathVariable long id) {
        platformService.deletePlatform(id);
        return platformService.getPlatforms();
    }

    @PostMapping
    public Platform create(@RequestBody Platform platform) {
        return platformService.createPlatform(platform);
    }

    @PutMapping("{id}")
    public Platform create(@RequestBody Platform platform, @PathVariable long id) {
        return platformService.updatePlatform(id, platform);
    }
}
