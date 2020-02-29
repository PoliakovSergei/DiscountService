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
@Table(name = "cheques")
public class Cheque implements Serializable {

    private static final long serialVersionUID = -8526814857650958216L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long cardNumber;

    @Column
    private Double sum;

    @Column
    private Date date;
}
