package com.colourcardonline.backend.model;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String playername;
    private String password;
    private String gender;
    private Integer age;
    private Integer wins;
    private Long trophies;
}
