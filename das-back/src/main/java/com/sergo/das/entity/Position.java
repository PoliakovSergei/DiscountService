package com.sergo.das.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "positions")
public class Position implements Serializable {

    private static final long serialVersionUID = 7176913147099015318L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long chequeId;

    @Column
    private Double sum;

    @Column
    private Date date;
}
