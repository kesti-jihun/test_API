package com.kesti.test.test_API.code.model.request;

import com.kesti.test.test_API.code.model.entity.CdGroupBas;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestCdGroupBas {

    /* 그룹 코드 */
    @NotBlank
    private String cdGroupId;

    /* 그룹 코드 명 */
    @NotBlank
    private String cdGroupNm;

    /* 그룹 코드 표준명 */
    private String cdGroupStdNm;

    /* 그룹 코드 설명 */
    private String cdGroupDesc;

    /* 그룹 코드 길이 */
    private Integer cdLen;

    /* 그룹 코드 사용 여부 */
    @NotBlank
    private String useYn;

    /* 상위 그룹 코드 아이디 */
    private String upCdGroupId;

    /* 생성자 아이디 */
    private String cretrId;

    /* 삭제 여부 */
    private String delYn;

    /* Request Data -> Entity */
    public CdGroupBas toCodeGroup() {
        return CdGroupBas.builder()
                .cdGroupId(cdGroupId)
                .cdGroupNm(cdGroupNm)
                .cdGroupStdNm(cdGroupStdNm)
                .cdGroupDesc(cdGroupDesc)
                .cdLen(cdLen)
                .useYn(useYn)
                .upCdGroupId(upCdGroupId)
                .delYn(delYn)
                .build();
    }

}
