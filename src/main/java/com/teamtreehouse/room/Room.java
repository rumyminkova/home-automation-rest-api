package com.teamtreehouse.room;

import com.teamtreehouse.core.BaseEntity;
import com.teamtreehouse.device.Device;
import com.teamtreehouse.user.User;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rumy on 10/9/2017.
 */

@Entity
public class Room extends BaseEntity{
    @NotNull
    @Size(min=1,max = 30)
    private String name;



    @Max(value = 1000,message="The room area must be less than or equal to 1000")
    private Integer area;

    @OneToMany(mappedBy = "room",cascade = CascadeType.ALL)
    private List<Device> devices;


    @ManyToMany
    private List<User> administrators;



    protected Room(){
       super();
       devices=new ArrayList<>();
       administrators=new ArrayList<>();
    }

    public Room(String name) {
        this();
        this.name = name;
    }


    public List<Device> getDevices() {
        return devices;
    }

    public void addDevice(Device device){
        device.setRoom(this);
        devices.add(device);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
         this.name = name;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public List<User> getAdministrators() {
        return administrators;
    }

    public void setAdministrators(List<User> administrators) {
        this.administrators = administrators;
    }

    public void addAdministrator(User user){
        administrators.add(user);
    }

}
