package com.example.gamedb.services;

import com.example.gamedb.models.Category;
import com.example.gamedb.models.Platform;

import java.util.ArrayList;

public interface PlatformService {

    ArrayList<Platform> getPlatforms();
    Platform getById(long id);

    Platform createPlatform(Platform platform);

    void deletePlatform(long id);

    Platform updatePlatform(long id, Platform platform);
}
