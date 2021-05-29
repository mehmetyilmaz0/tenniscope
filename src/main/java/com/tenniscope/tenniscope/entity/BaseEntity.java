package com.tenniscope.tenniscope.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Data // getter setter
@MappedSuperclass // diger entity classlarda ortak kullanilmasini yani extend edilmesini sagliyor
public abstract class BaseEntity implements Serializable {

    @Column(name="created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name="created_by", length = 100)
    private String createdBy;

    @Column(name="updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Column(name="updated_by", length = 100)
    private String updatedBy;

    @Column(name="status")
    private Boolean status;
}
