package com.example.gamedb.repositories;

import com.example.gamedb.models.Platform;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatformRepository extends JpaRepository<Long, Platform> {
}
