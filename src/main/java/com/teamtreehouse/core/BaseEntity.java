package com.teamtreehouse.core;

import javax.persistence.*;

/**
 * Created by Rumy on 10/10/2017.
 */

@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Long id;

    protected BaseEntity(){
        id=null;
    }
}
