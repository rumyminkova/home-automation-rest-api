package com.teamtreehouse.device;

import com.teamtreehouse.control.Control;
import com.teamtreehouse.core.BaseEntity;
import com.teamtreehouse.room.Room;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rumy on 10/10/2017.
 */

@Entity
public class Device extends BaseEntity{

    @NotNull
    @Size(min=1,max = 30)
    private String name;

    @ManyToOne
    private Room room;

    @OneToMany(mappedBy = "device",cascade = CascadeType.ALL)
    private List<Control> controls;

    protected Device(){
        super();
        controls=new ArrayList<>();
    }


    public Device(String name) {
        this();
        this.name = name;
    }

    public List<Control> getControls() {
        return controls;
    }

    public void addControl(Control control){
        control.setDevice(this);
        controls.add(control);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
