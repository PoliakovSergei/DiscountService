package com.sergo.das.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "clients")
public class Client implements Serializable {

    private static final long serialVersionUID = -4415449104007962305L;

    @Id
    private Long cardNumber;

    @Column
    private Integer points;

    @Column
    private Date date;
}
