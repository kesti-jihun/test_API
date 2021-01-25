package com.kesti.test.test_API.code.model.entity;

import com.kesti.test.test_API.code.model.entity.key.CdDtlKey;
import com.kesti.test.test_API.libs.model.BaseAuditor;
import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema="test_schema1", name="cd_dtl", uniqueConstraints = @UniqueConstraint(columnNames = { "cdGroupId", "dtlCd" ,"langCd"}))
public class CdDtl extends BaseAuditor {

	@EmbeddedId
	private CdDtlKey cdDtlKey;

	private String dtlCdNm;

	private String dtlCdDesc;

	private Integer indcOdrg;

	@Column(nullable = false)
	private String useYn;

	private String cretrId;

	private String delYn;

	public String getDtlCd() {
		return cdDtlKey.getDtlCd();
	}
}
	