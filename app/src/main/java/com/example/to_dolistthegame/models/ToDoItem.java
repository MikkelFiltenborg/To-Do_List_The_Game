package com.example.to_dolistthegame.models;

import android.location.Location;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

enum Priority
{
    HIGH,
    NORMAL,
    LOW
}

public class ToDoItem
{
//    public enum TypeTask
//    {
//        CLEANING,
//        COOKING,
//        YARDWORK,
//        TELEVISION,
//        PLANNING,
//        COALMINING
//    }

//    public static String[] typeTaskArray = {
//            "CLEANING",
//            "COOKING",
//            "YARDWORK",
//            "TELEVISION",
//            "PLANNING",
//            "COALMINING"
//    };

    int id;
    public String name;
    String imageBeforeFile;
    String imageAfterFile;
    String description;
    LocalDateTime plannedStartTime;
    LocalDateTime plannedEndTime;
    LocalDateTime startTime;
    LocalDateTime endTime;
    int timeSpent;
    TypeTask typeTask;
//    int typeTask;
    Location location;
    List<ToDoItem> toDoItemsBlockersList;
    Boolean isComplete = false;
    Boolean isRepeatable;
    int xp;

//    public static String[] getNames(class>?)

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageBeforeFile() {
        return imageBeforeFile;
    }

    public void setImageBeforeFile(String imageBeforeFile) {
        this.imageBeforeFile = imageBeforeFile;
    }

    public String getImageAfterFile() {
        return imageAfterFile;
    }

    public void setImageAfterFile(String imageAfterFile) {
        this.imageAfterFile = imageAfterFile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getPlannedStartTime() {
        return plannedStartTime;
    }

    public void setPlannedStartTime(LocalDateTime plannedStartTime) {
        this.plannedStartTime = plannedStartTime;
    }

    public LocalDateTime getPlannedEndTime() {
        return plannedEndTime;
    }

    public void setPlannedEndTime(LocalDateTime plannedEndTime) {
        this.plannedEndTime = plannedEndTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public int getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(int timeSpent) {
        this.timeSpent = timeSpent;
    }

    public TypeTask getTypeTask() {
        return typeTask;
    }

    public void setTypeTask(TypeTask typeTask) {
        this.typeTask = typeTask;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<ToDoItem> getToDoItemsBlockersList() {
        return toDoItemsBlockersList;
    }

    public void setToDoItemsBlockersList(List<ToDoItem> toDoItemsBlockersList) {
        this.toDoItemsBlockersList = toDoItemsBlockersList;
    }

    public Boolean getComplete() {
        return isComplete;
    }

    public void setComplete(Boolean complete) {
        isComplete = complete;
    }

    public Boolean getRepeatable() {
        return isRepeatable;
    }

    public void setRepeatable(Boolean repeatable) {
        isRepeatable = repeatable;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }
}
