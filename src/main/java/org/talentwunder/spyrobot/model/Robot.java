package org.talentwunder.spyrobot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Robot {

    int coordinateX;
    int coordinateY;
    Heading heading;

}
