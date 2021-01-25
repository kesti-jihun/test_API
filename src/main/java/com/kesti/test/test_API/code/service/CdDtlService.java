package com.kesti.test.test_API.code.service;

import com.kesti.test.test_API.code.model.entity.CdDtl;
import com.kesti.test.test_API.code.model.entity.key.CdDtlKey;
import com.kesti.test.test_API.code.model.entity.projection.CdDtlProjection;
import com.kesti.test.test_API.code.model.request.ReqeustCdDtl;
import com.kesti.test.test_API.code.repository.CdDtlRepository;
//import com.kesti.test.test_API.device.model.request.RequestSearchManufacturer;
//import com.kesti.test.test_API.error.ApplicationException;
import com.kesti.test.test_API.error.ResponseCode;
import com.kesti.test.test_API.libs.util.JsonUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class CdDtlService {

    private final CdDtlRepository cdDtlRepository;

    public List<CdDtl> getCodeGroupInfos() {
        return cdDtlRepository.findAll();
    }
/*
    public CdDtl getCodeGroupInfoOrThrow(CdDtlKey cdDtlKey) {
        return cdDtlRepository.findByCdDtlKey(cdDtlKey)
                .orElseThrow(() -> new ApplicationException(ResponseCode.RESOURCE_NOT_FOUND, "CodeGroupInfo not found: "+ JsonUtils.toString(cdDtlKey)));
    }
*/
    public CdDtl createCodeGroupInfo(ReqeustCdDtl requestCodeGroup) {
        CdDtl cdDtl = requestCodeGroup.toCodeGroupInfo();
        log.debug("{}", JsonUtils.toPrettyString(cdDtl));
        return cdDtlRepository.save(cdDtl);
    }

    public CdDtl updateCodeGroupInfo(ReqeustCdDtl reqeustCdDtl) {
        //getCodeGroupInfoOrThrow(reqeustCdDtl.getCdDtlKey());
        CdDtl cdDtl = reqeustCdDtl.toCodeGroupInfo();
        cdDtl.setCdDtlKey(reqeustCdDtl.getCdDtlKey());
        log.debug("{}", JsonUtils.toPrettyString(cdDtl));
        return cdDtlRepository.save(cdDtl);
    }

/*
    @Transactional
    public void delete(CdDtlKey cdDtlKey) {
        CdDtl cdDtl = getCodeGroupInfoOrThrow(cdDtlKey);
        cdDtlRepository.delete(cdDtl);
    }


    public List<CdDtl> getCodeGroupInfosByGroupId(String cdGroupId) {
        return cdDtlRepository.findAllByCdDtlKeyCdGroupIdAndUseYnAndDelYnOrderByDtlCdNm(cdGroupId, "Y", "N");
    }


    public Map<String, String> getCodeGroupInfosMapByGroupId(String cdGroupId) {
        if(cdGroupId.equals("PROTR") || cdGroupId.equals("NPROTR")){
            return getCodeGroupInfosByGroupId(cdGroupId).stream().collect(Collectors.toMap(CdDtl::getDtlCd, CdDtl::getDtlCdDesc));
        }
        return getCodeGroupInfosByGroupId(cdGroupId).stream().collect(Collectors.toMap(CdDtl::getDtlCd, CdDtl::getDtlCdNm));
    }

    public Map<String, String> getObsItemMap() {
        return getCodeGroupInfosMapByGroupId("OBS");
    }

    public Map<String, String> getObsTypeMap() {
        return getCodeGroupInfosMapByGroupId("OBSTYPE");
    }
    public Map<String, String> getObsItemUnitMap() {
        return getCodeGroupInfosMapByGroupId("OBSUNIT");
    }

    public Map<String, String> getProtocolRuleMap() {
        Map<String, String> protocalMap = getCodeGroupInfosMapByGroupId("PROTR");
        protocalMap.putAll(getCodeGroupInfosMapByGroupId("NPROTR"));
        return protocalMap;
    }
    public Map<String, String> get() {
        return getCodeGroupInfosMapByGroupId("PROTR");
    }

    public List<CdDtl> searchManufacturer(RequestSearchManufacturer request) {
        List<CdDtl> cdDtls = getCodeGroupInfosByGroupId("MANF");
        return cdDtls.stream().filter(cdDtl -> cdDtl.getDtlCdNm().contains(request.getKeyword())).collect(Collectors.toList());
    }

    public List<CdDtlProjection> selectComCdList(String cdGroupId) {
        return cdDtlRepository.selectComCdList(cdGroupId);
    }
    */

}
