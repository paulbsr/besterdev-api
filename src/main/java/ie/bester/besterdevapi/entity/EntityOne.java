package ie.bester.besterdevapi.entity;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import java.time.LocalDate;


@Transactional
@Entity
@Table (name = "dbtable", schema="besterdev")

public class EntityOne {

    @Id
    @GeneratedValue
    private int id;
    private String colone;
    private String coltwo;
    private String colthree;
    private String colfour;
    private LocalDate coldate;

    public EntityOne () {}

    
    
    
    public EntityOne(int id, String colone, String coltwo, String colthree, String colfour, LocalDate coldate) {
        this.id = id;
        this.colone = colone;
        this.coltwo = coltwo;
        this.colthree = colthree;
        this.colfour = colfour;
        this.coldate = coldate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getcolone() {
        return colone;
    }

    public void setcolone(String colone) {
        this.colone = colone;
    }

    public String getcoltwo() {
        return coltwo;
    }

    public void setcoltwo(String coltwo) {
        this.coltwo = coltwo;
    }

    public String getcolthree() {
        return colthree;
    }

    public void setcolthree(String colthree) {
        this.colthree = colthree;
    }

    public String getcolfour() {
        return colfour;
    }

    public void setcolfour(String colfour) {
        this.colfour = colfour;
    }

    public LocalDate getcoldate() {
        return coldate;
    }

    public void setcoldate(LocalDate coldate) {
        this.coldate = coldate;
    }
}
