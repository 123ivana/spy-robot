package org.talentwunder.spyrobot.service;

import org.talentwunder.spyrobot.exception.InvalidInputException;
import org.talentwunder.spyrobot.model.Command;
import org.talentwunder.spyrobot.model.Heading;
import org.talentwunder.spyrobot.model.Robot;
import org.talentwunder.spyrobot.model.Room;

public class MovingService {

    public void move(Command command, Robot robot, Room room) {
        switch (command) {
            case L -> robot.setHeading(robot.getHeading().getLeft());
            case R -> robot.setHeading(robot.getHeading().getRight());
            case F -> moveForward(robot, room);
            default -> throw new InvalidInputException("Invalid input command");
        }
    }

    private void moveForward(Robot robot, Room room) {
        switch (robot.getHeading()) {
            case N, S -> {
                int newCoordinate = robot.getHeading().equals(Heading.N) ? robot.getCoordinateY() + 1 : robot.getCoordinateY() - 1;
                if (isValidCoordinate(newCoordinate, room.getCoordinateY())) {
                    robot.setCoordinateY(newCoordinate);
                }
            }
            case W, E -> {
                int newCoordinate = robot.getHeading().equals(Heading.W) ? robot.getCoordinateX() - 1 : robot.getCoordinateX() + 1;
                if (isValidCoordinate(newCoordinate, room.getCoordinateX())) {
                    robot.setCoordinateX(newCoordinate);
                }
            }
            default -> throw new InvalidInputException("Robot is in invalid heading state");
        }
    }

    private Boolean isValidCoordinate(int coordinate, int maxSize) {
        if (coordinate < 0 || coordinate > maxSize) {
            throw new InvalidInputException("Robot has reached end of the room");
        }
        return Boolean.TRUE;
    }

}
