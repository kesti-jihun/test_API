package com.kesti.test.test_API.repository;

import com.kesti.test.test_API.entity.*;
import com.kesti.test.test_API.entity.custom.DevInfoProjection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface DevInfoRepository extends JpaRepository<DevInfo, String> {

    Page<DevInfo> findAllByOrderByCretDtDesc(Pageable pageable);

    @Query("select " +
            "d.devId as devId, " +
            "d.devName as devName, " +
            "d.devPassword as devPassword, " +
            "d.latitVal as latitVal, " +
            "d.lngitVal as lngitVal, " +
            "d.protocolRule as protocolRule, " +
            "d.connStatus as connStatus, " +
            "d.liveStatus as liveStatus, " +
            "d.cretrId as cretrId, " +
            "m.userNm as userNm, " +
            "cd.dtlCdDesc as protocolRuleName " +
            "from DevInfo d, ComMbr m, CdDtl cd   " +
            "where d.cretrId = m.mbrId and cd.cdDtlKey.cdGroupId LIKE '%PROTR' and cd.cdDtlKey.dtlCd = d.protocolRule order by d.cretDt desc")
    Page<DevInfoProjection> selectAllByOrderByCretDtDesc(Pageable pageable);
}
