package com.mnt.actimize.bfits.fcd.wire.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mnt.actimize.bfits.fcd.wire.api.entity.ErrorLogEntity;

public interface ErrorLogRepository extends JpaRepository<ErrorLogEntity, Long> {
}
