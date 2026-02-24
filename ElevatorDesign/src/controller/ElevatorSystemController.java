package controller;

import entity.ElevatorSystem;

public class ElevatorSystemController{

    ElevatorSystem systemInstance;

    public ElevatorSystem getInstance(){
        if(systemInstance==null){
            systemInstance =  new ElevatorSystem();
            return systemInstance;
        }else{
            return null;
        }
    }
}
