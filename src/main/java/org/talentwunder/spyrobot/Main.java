package org.talentwunder.spyrobot;

import org.talentwunder.spyrobot.model.Command;
import org.talentwunder.spyrobot.model.Heading;
import org.talentwunder.spyrobot.model.Robot;
import org.talentwunder.spyrobot.model.Room;
import org.talentwunder.spyrobot.service.MovingService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter room size, robot position and commands:");

        MovingService movingService = new MovingService();

        var roomSizeArray = sc.nextLine().split("\\s+");
        var room = new Room(Integer.valueOf(roomSizeArray[0]), Integer.valueOf(roomSizeArray[1]));

        while (sc.hasNextLine()) {
            var initRobotPositionArray = sc.nextLine().split("\\s+");
            Robot robot = new Robot(Integer.valueOf(initRobotPositionArray[0]), Integer.valueOf(initRobotPositionArray[1]),
                    Heading.valueOf(initRobotPositionArray[2]));
            for (char c : sc.nextLine().toCharArray()) {
                movingService.move(Command.valueOf(String.valueOf(c)), robot, room);
            }
            System.out.println(robot.getCoordinateX() + " " + robot.getCoordinateY() + " " + robot.getHeading());
        }
    }
}