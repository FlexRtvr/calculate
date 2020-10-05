package com.mytest.calculate;

import javax.persistence.*;

@Entity
@Table(name = "numbers")
public class NumberEntity {

    private Integer id;
    private Integer value;

    public NumberEntity() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    @Column(name="value_")
    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public NumberEntity (Integer value)
    {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format( "Number[id=%d, value=%d]",id,value);
    }
}
