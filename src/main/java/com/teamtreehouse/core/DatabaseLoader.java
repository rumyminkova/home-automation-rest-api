package com.teamtreehouse.core;

import com.teamtreehouse.control.Control;
import com.teamtreehouse.device.Device;
import com.teamtreehouse.room.Room;
import com.teamtreehouse.room.RoomRepository;
import com.teamtreehouse.user.User;
import com.teamtreehouse.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


/**
 * Created by Rumy on 10/10/2017.
 */
@Component
public class DatabaseLoader implements ApplicationRunner {
    private final RoomRepository rooms;
    private final UserRepository users;

    @Autowired
    public DatabaseLoader(RoomRepository rooms, UserRepository users) {
        this.rooms = rooms;
        this.users = users;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        String[] roomNames={
                "Master Bedroom",
                "Guest Bedroom",
                "Kids Bedroom",
                "Living Room",
                "Kitchen",
                "Office",
                "Media Room"
        };

        String[] deviceNames={
                "SoundSpeaker",
                "A/C",
                "Lights",
                "TV"
        };


        List<User> allUsers = Arrays.asList(
                new User("user1", "password", new String[] {"ROLE_USER"}),
                new User("user2", "password", new String[] {"ROLE_USER"}),
                new User("user3", "password", new String[] {"ROLE_USER"}),
                new User("Tom","1234",new String[] {"ROLE_USER","ROLE_ADMIN"}),
                new User("user4", "password", new String[] {"ROLE_USER"}),
                new User("user5", "password", new String[] {"ROLE_USER"}),
                new User("user6", "password", new String[] {"ROLE_USER"}),
                new User("user7", "password", new String[] {"ROLE_USER"}),
                new User("rumym","1234",new String[] {"ROLE_USER","ROLE_ADMIN"})
        );
        users.save(allUsers);

        List<Room> allRooms =new ArrayList<>();

        for (int r = 0; r<roomNames.length; r++) {
            Room roomCreated=new Room(roomNames[r]);
            roomCreated.setArea(110);
            roomCreated.setAdministrators(allUsers.subList(r,r+3));
            for (String d: deviceNames) {
                Device deviceCreated=new Device(d);
                for(int i = 1; i <4; i++){
                        Control controlCreated=new Control(d+"_ctrl_"+i);
                        controlCreated.setLastModifiedBy(allUsers.get(3-i));
                        deviceCreated.addControl(controlCreated);
                }
              roomCreated.addDevice(deviceCreated);
            }
           allRooms.add(roomCreated);
        }

        rooms.save(allRooms);

    }
}
