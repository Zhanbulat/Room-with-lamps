package app.model;

import app.entities.Room;

import java.util.*;
import java.util.stream.Collectors;

public class Model {
        public static Model instance = new Model();

        public List<Room> model;

        public static Model getInstance() {
            return instance;
        }

        public Model() {
            model = new ArrayList<>();
        }

        public void add(Room room) {
            model.add(room);
        }

        public List<String> list() {
            return model.stream()
                    .map(Room::getName)
                    .collect(Collectors.toList());
        }
    }

