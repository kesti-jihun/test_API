package com.kesti.test.test_API.code.model.request;

import com.kesti.test.test_API.code.model.entity.CdDtl;
import com.kesti.test.test_API.code.model.entity.key.CdDtlKey;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReqeustCdDtl {

    /* 그룹 코드 */
    @NotBlank
    private String cdGroupId;

    /* 상세 코드 */
    @NotBlank
    private String dtlCd;

    /* 언어 */
    @NotBlank
    private String langCd;

    /* 상세 코드명 */
    private String dtlCdNm;

    /* 코드 설명 */
    private String dtlCdDesc;

    /* 정렬 순서 */
    private Integer indcOdrg;

    /* 사용 여부 */
    @NotBlank
    private String useYn;

    /* 생성자 아이디 */
    private String cretrId;

    /* 삭제 여부 */
    private String delYn;

    @JsonIgnore
    public CdDtlKey getCdDtlKey() {
        // 공통 코드 PK
        return CdDtlKey.builder().cdGroupId(cdGroupId).dtlCd(dtlCd).langCd(langCd).build();
    }

    /* Request Data -> Entity */
    public CdDtl toCodeGroupInfo() {
        return CdDtl.builder()
                .cdDtlKey(getCdDtlKey())
                .dtlCdNm(dtlCdNm)
                .dtlCdDesc(dtlCdDesc)
                .indcOdrg(indcOdrg)
                .useYn(useYn)
                .cretrId(cretrId)
                .delYn(delYn)
                .build();
    }

}
