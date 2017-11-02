package com.teamtreehouse.control;

import com.teamtreehouse.core.BaseEntity;
import com.teamtreehouse.device.Device;
import com.teamtreehouse.room.Room;
import com.teamtreehouse.user.User;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Rumy on 10/10/2017.
 */
@Entity
public class Control extends BaseEntity{

    @Version
    private Long version;

    @NotNull
    @Size(min=1,max = 30)
    private String name;

    private Integer value;

    @ManyToOne
    private Device device;


    @OneToOne
    private User lastModifiedBy;



    protected Control(){
        super();
    }

    public Control(String name) {
        this();
        this.name = name;
    }


    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }


    public User getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(User lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }
}
