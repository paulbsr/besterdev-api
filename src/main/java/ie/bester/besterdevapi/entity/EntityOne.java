package ie.bester.besterdevapi.entity;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;


@Transactional
@Entity
@Table (name = "TableOne", schema="besterdev")

public class EntityOne {

    @Id
    @GeneratedValue
    private int id;
    private String colOne;
    private String colTwo;
    private String colThree;

    public EntityOne () {}

    public EntityOne (int id, String colOne, String colTwo, String colThree) {
        this.id = id;
        this.colOne = colOne;
        this.colTwo = colTwo;
        this.colThree = colThree;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColOne() {
        return colOne;
    }

    public void setColOne(String colOne) {
        this.colOne = colOne;
    }

    public String getColTwo() {
        return colTwo;
    }

    public void setColTwo(String colTwo) {
        this.colTwo = colTwo;
    }

    public String getColThree() {
        return colThree;
    }

    public void setColThree(String colThree) {
        this.colThree = colThree;
    }
}
