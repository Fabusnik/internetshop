package ru.fab.model;

/**
 * Created by r22fab21051979 on 29.01.2018.
 */
public abstract class AbstractEntity {

    public static final Integer LOGGED_USER_ID = 1;

    private Integer id;

    public AbstractEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isNew(){
        return this.getId() == null;
    }
}
