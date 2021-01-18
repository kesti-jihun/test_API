package com.kesti.test.test_API.service;

import com.kesti.test.test_API.entity.*;
import com.kesti.test.test_API.repository.DevInfoRepository;
import com.kesti.test.test_API.entity.custom.DevInfoProjection;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@RequiredArgsConstructor
@Service
public class DevInfoService {

    private final DevInfoRepository devInfoRepository;

    public Page<DevInfo> getDevInfos(Pageable pageable) {
        return devInfoRepository.findAllByOrderByCretDtDesc(pageable);
    }

    public Page<DevInfoProjection> getDevInfoProjections(Pageable pageable) {
        return devInfoRepository.selectAllByOrderByCretDtDesc(pageable);
    }
}