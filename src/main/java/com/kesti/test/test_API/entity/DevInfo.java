package com.kesti.test.test_API.entity;

import lombok.*;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema="test_schema1", name="dev_info")
public class DevInfo extends BaseAuditor {
    @Id
    @Column(nullable = false)
    private String devId;               //디바이스 아이디

    @Column(nullable = false)
    private String devName;             //디바이스 이름

    private String devPassword;         //디바이스 패스워드

    private String manufacturerId;      //제조사 아이디

    private String manufacturerName;    //제조사 기업명

    private String protocolType;        // 프로토콜 구분

    private String protocolRule;        // 프로토콜 유형

    private String devImgPath;          //디바이스 이미지경로

    private String userDefName;         //사용자 정의 모델명

    private Float latitVal;             //위도

    private Float lngitVal;             //경도

    private String connStatus;          //연결상태

    private String liveStatus;          //활성화여부

    @ColumnDefault("GatewayTEST_ID")
    private String gatewayConnId;       //게이트웨이 연결ID

    private Integer mbrSeq;             //회원 기본 일련번호

    private String cretrId;             //성성자 아이디

    private String amdrId;              //수정자 아이디

    private Boolean testDevYn;          //테스트디바이스 여부

    private String prdtType;            //장비유형

    private Integer devSeq;				// IotMakers device sequence

    private Integer intval;				// 측정주기

    @ColumnDefault("")
    private String address;				// 주소

    @Transient
    private String protocolRuleName;

    public Boolean getHasImage() {
        return StringUtils.isNotBlank(devImgPath);
    }
}