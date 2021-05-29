package com.tenniscope.tenniscope.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "company")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Company extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "company_code", length = 50, unique = true)
    private String companyCode;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "address", length = 1000)
    private String address;

    @Column(name = "mobile_phone", length = 50)
    private String mobilePhone;

    @Column(name = "office_phone", length = 50)
    private String officePhone;

    @Column(name = "mail_address", length = 50)
    private String mailAddress;

    @Column(name = "city", length = 50)
    @Enumerated(EnumType.STRING)
    private City city;

    @Column(name = "district", length = 100)
    private String district;

    /**
     *  @Enumerated(EnumType.STRING) : Cities class'indaki direk metni kaydeder company tablosuna. (orn. ADANA)
     *  @Enumerated(EnumType.ORDINAL) : Cities class'indaki metinlerin indexini tutar. (orn. 1)
     */

}
