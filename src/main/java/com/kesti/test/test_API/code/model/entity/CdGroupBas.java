package com.kesti.test.test_API.code.model.entity;

import com.kesti.test.test_API.libs.model.BaseAuditor;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema="test_schema1", name="cd_group_bas")
public class CdGroupBas extends BaseAuditor {

    @Id
    @Column(nullable = false)
    private String cdGroupId;

    @Column(nullable = false)
    private String cdGroupNm;

    private String cdGroupStdNm;

    private String cdGroupDesc;

    private Integer cdLen;

    @Column(nullable = false)
    private String useYn;

    private String upCdGroupId;

    private String cretrId;

    private String delYn;
}
