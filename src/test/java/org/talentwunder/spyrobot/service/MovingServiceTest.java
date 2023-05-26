package org.talentwunder.spyrobot.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.talentwunder.spyrobot.model.Command;
import org.talentwunder.spyrobot.model.Heading;
import org.talentwunder.spyrobot.model.Robot;
import org.talentwunder.spyrobot.model.Room;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MovingServiceTest {

    MovingService movingService;

    @BeforeAll
    void setUp() {
        movingService = new MovingService();
    }

    @ParameterizedTest
    @DisplayName("Test valid input Command left")
    @CsvSource({
            "5,5,1,2,N,LFLFLFLFF,1 3 N",
            "5,5,3,3,E,FFRFFRFRRF,5 1 E"
    })
    void testMultiply(Integer roomCoordinateX, Integer roomCoordinateY,
                      Integer robotCoordinateX, Integer robotCoordinateY,
                      String robotHeading, String command, String result) {
        //given
        var room = new Room(roomCoordinateX, roomCoordinateY);
        var robot = new Robot(robotCoordinateX, robotCoordinateY, Heading.valueOf(robotHeading));

        //when
        for (char c : command.toCharArray()) {
            movingService.move(Command.valueOf(String.valueOf(c)), robot, room);
        }

        //then
        assertEquals(result, robot.getCoordinateX() + " " + robot.getCoordinateY() + " " + robot.getHeading());

    }

}
