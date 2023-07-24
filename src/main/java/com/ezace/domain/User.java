package com.ezace.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Builder
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_user_info")
@Entity
public class User {

    @Id
    @Column(name = "idx", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "thumbnail", nullable = false)
    private String thumbnail;
}