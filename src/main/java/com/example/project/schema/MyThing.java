package com.example.project.schema;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by tomxon on 30.08.17.
 */

@Entity
@Table(name = "mythings")
public class MyThing {
    @Id
    @Column(name = "thing_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "thing_generator")
    @GenericGenerator(
            name = "thing_generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "thing_generator"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
