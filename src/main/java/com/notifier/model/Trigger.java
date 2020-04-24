package com.notifier.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "triggers")
public class Trigger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String researcher;
    private String college;
    private String bucket;
    private String nname;

    public Trigger() {
    }


    public Trigger(Long id, String nname, String bucket, String researcher, String college) {

        this.id = id;
        this.nname = nname;
        this.bucket = bucket;
        this.researcher = researcher;
        this.college = college;
    }

    public String getNname() {
        return nname;
    }

    public void setNname(String nname) {
        this.nname = nname;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public Long getId() {
        return id;
    }

    public String getResearcher() {
        return researcher;
    }

    public void setResearcher(String researcher) {
        this.researcher = researcher;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

}