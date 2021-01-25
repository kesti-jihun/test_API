package com.kesti.test.test_API.controller;

import com.kesti.test.test_API.entity.DevInfo;
import com.kesti.test.test_API.service.PageMaker;
import com.kesti.test.test_API.service.DevInfoService;
import com.kesti.test.test_API.entity.custom.DevInfoProjection;
import com.kesti.test.test_API.model.response.ApiResponse;
import com.kesti.test.test_API.model.Pagination;

import com.google.common.collect.ImmutableMap;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

import java.util.*;

import javax.annotation.Resource;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/TESTBED/v0.9/api")
public class DevInfoController {

    private final DevInfoService devInfoService;
    private final PageMaker pageMaker;

    //@Resource(name = "commonAPI")
    //private CommonAPI commonAPI;

    @ApiOperation(value = "디바이스 목록 조회")
    @GetMapping("/management/devices")
    public ApiResponse<?> getManagementDeviceList(@RequestParam(name = "page", required = false, defaultValue = "0") int page,
                                                  @RequestParam(name = "size", required = false, defaultValue = "8") int size) {
        Page<DevInfoProjection> pages = devInfoService.getDevInfoProjections(PageRequest.of(page, size));
        Pagination<?> pagination = pageMaker.toPagination(pages, 10);
        return ApiResponse.ok(pagination);
    }

    /*
    @ApiOperation(value = "디바이스 추가")
    @PostMapping("/management/addDevice")
    public String sndMsg(@RequestBody HashMap<String, String> requestData)
    {
        Page<DevInfoProjection> pages = devInfoService.getDevInfoProjections(PageRequest.of(String, String));
        Pagination<?> pagination = pageMaker.toPagination(pages, 10);
        return ApiResponse.ok(pagination);

    }
     */

/*
    @ApiOperation(value = "내 디바이스 목록 조회")
    @PostMapping("/management/devices")
    public ApiResponse<?> getMyManagementDeviceList(@RequestBody RequestDevInfo request) {
        log.info("management > devices: {}", request.getCretrId());
        Page<DevInfoProjection> pages = devInfoService.getDevInfoProjectionsByCretrId(request.getCretrId(), PageRequest.of(request.getPage(), request.getSize()));
        Pagination<?> pagination = pageMaker.toPagination(pages, 10);
        return ApiResponse.ok(pagination);
    }

    @ApiOperation(value = "디바이스 ID 중복확인")
    @GetMapping("/management/device/checkDevId")
    public ApiResponse<?> checkDevId(@RequestParam("devId") final String devId) {
        boolean exist = devInfoService.existDevInfo(devId);
        Map<String, Object> data = new HashMap<>();
        data.put("valid", exist);
        return ApiResponse.ok(data);
    }

    @ApiOperation(value = "디바이스 정보 조회")
    @GetMapping("/management/device/{id}")
    public ApiResponse<?> getDevInfo(@PathVariable(value = "id") String devId) {
        log.debug("request device id: " + devId);
        DevInfo res = devInfoService.getDevInfoOrThrow(devId);
        return ApiResponse.ok(res);
    }
*/

}