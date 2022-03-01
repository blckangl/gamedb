package com.example.gamedb.services;

import com.example.gamedb.models.Platform;
import com.example.gamedb.repositories.GameRepository;
import com.example.gamedb.repositories.PlatformRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PlatfromServiceImpl implements PlatformService {

    @Autowired
    PlatformRepository platformRepository;


    @Override
    public ArrayList<Platform> getPlatforms() {
        return new ArrayList<>(platformRepository.findAll());
    }

    @Override
    public Platform getById(long id) {
        return platformRepository.findById(id).orElse(null);

    }

    @Override
    public Platform createPlatform(Platform platform) {
        return platformRepository.save(platform);
    }

    @Override
    public void deletePlatform(long id) {
        platformRepository.deleteById(id);

        return;
    }

    @Override
    public Platform updatePlatform(long id, Platform platform) {
        Platform platformtoUpdate = platformRepository.findById(id).orElse(null);

        if (platformtoUpdate != null) {
            if (platform.getImage() != null)
                platformtoUpdate.setImage(platform.getImage());
            if (platform.getTitle() != null)
                platformtoUpdate.setTitle(platform.getTitle());

            return platformRepository.save(platformtoUpdate);
        } else {
            return null;

        }
    }
}
