package com.tenniscope.tenniscope.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "court")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Court extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "court_type", length = 50)
    @Enumerated(value = EnumType.STRING)
    private CourtType courtType;

    @JoinColumn(name = "assigne_company_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Company company;

    /**
        optional = false    : bir court tanimlanirken company bilgisi verilmesi zorunlu
        fetch               : court tablosuna select atilirken, Company tablosuna join yapilsin mi?
                                FetchType.EAGER : Company tablosu her zaman select yapilarak getirilir.
                                FetchType.LAZY  : Company tablosunun getter 'i cagirildiginda sadece getirilir. yani ihtiyac halinde getirilir.
     **/

}
