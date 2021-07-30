package com.user.mangment.entities;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "roles",schema = "public")
public class Role extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(unique = true)
    private String roleName;

}
