package com.oleh.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "ua")
public class UaEntity {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "cv")
    private String cv;
    @Column(name = "info")
    private String info;
    @Column(name = "contact")
    private String contact;
    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCv() {
        return cv;
    }
    public void setCv(String cv) {
        this.cv = cv;
    }
    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UaEntity uaEntity = (UaEntity) o;
        if (id != uaEntity.id) return false;
        if (cv != null ? !cv.equals(uaEntity.cv) : uaEntity.cv != null) return false;
        if (info != null ? !info.equals(uaEntity.info) : uaEntity.info != null) return false;
        return true;
    }
    @Override
    public String toString() {
        return  cv ;
    }
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (cv != null ? cv.hashCode() : 0);
        result = 31 * result + (info != null ? info.hashCode() : 0);
        return result;
    }
}
