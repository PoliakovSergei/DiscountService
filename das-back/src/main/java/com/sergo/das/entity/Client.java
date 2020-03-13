package com.sergo.das.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "clients")
@AllArgsConstructor
@NoArgsConstructor
public class Client implements Serializable {

    private static final long serialVersionUID = -4415449104007962305L;

    @Id
    private Long cardNumber;

    @Column
    private Integer points;

    @Column
    private LocalDateTime date;
}
