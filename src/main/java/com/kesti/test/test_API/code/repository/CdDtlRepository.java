package com.kesti.test.test_API.code.repository;

import com.kesti.test.test_API.code.model.entity.CdDtl;
import com.kesti.test.test_API.code.model.entity.key.CdDtlKey;
import com.kesti.test.test_API.code.model.entity.projection.CdDtlProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface CdDtlRepository extends JpaRepository<CdDtl, CdDtlKey> {

    Optional<CdDtl> findByCdDtlKey(CdDtlKey cdDtlKey);

    List<CdDtl> findAllByCdDtlKeyCdGroupIdAndUseYnAndDelYnOrderByDtlCdNm(String cdGroupId, String useYn, String delYn);
    List<CdDtl> findAllByCdDtlKeyCdGroupIdOrderByDtlCdNm(String cdGroupId);

    @Query( "SELECT d.cdDtlKey.dtlCd   AS key" +
            "     , d.dtlCdNm          AS txt" +
            "     , FALSE              AS actYn" +
            "  FROM CdDtl d" +
            " WHERE d.cdDtlKey.cdGroupId = ?1" +
            "   AND d.cdDtlKey.langCd    = 'KOR'" +
            "   AND d.useYn              = 'Y'" +
            "   AND d.delYn              = 'N'" +
            " ORDER BY d.indcOdrg ASC" +
            "        , d.cdDtlKey.dtlCd ASC")
    List<CdDtlProjection> selectComCdList(String cdGroupId);

    @Transactional
    @Modifying
    @Query("update CdDtl c set c.cdDtlKey.cdGroupId  = ?2 where c.cdDtlKey.cdGroupId = ?1")
    Integer updateCdGroupId(String cdGroupId, String newCdGroupId);


    /*
    INSERT INTO test_schema1.cd_dtl (
cd_group_id, dtl_cd, lang_cd, dtl_cd_nm, dtl_cd_desc, indc_odrg, use_yn, cretr_id, cret_dt, del_yn, amdr_id, amd_dt
) VALUES (
'INTVAL',
'INV0005',
'KOR',
'86400',
'하루',
86400,
'Y',
'sujakup',
now(),
'N',
'',
now()
)
ON CONFLICT (cd_group_id, dtl_cd, lang_cd)
do UPDATE
SET
	dtl_cd_nm = '86400',
	dtl_cd_desc = '하루',
	indc_odrg = 86400,
	use_yn = 'Y',
	cretr_id = 'sujakup',
	cret_dt = now(),
	del_yn = 'N',
	amdr_id = '',
	amd_dt = NOW();*/

    @Transactional
    @Modifying
    @Query("")
    Integer upsertCdGroupId(String cdGroupId, String newCdGroupId);
}
