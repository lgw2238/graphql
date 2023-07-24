package com.ezace.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_contents_info")
@Entity
public class Contents {

    @Id
    @Column(name = "idx", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "contents", nullable = false)
    private String contents;

    @Column(name = "category", nullable = false)
    public String category;
    
    @Column(name = "useyn", nullable = false)
    public String useyn;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_idx", referencedColumnName = "idx")
    private User user;
}