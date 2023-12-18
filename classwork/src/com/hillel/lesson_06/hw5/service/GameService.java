package com.hillel.lesson_06.hw5.service;


import com.hillel.lesson_06.hw5.copet.Competitor;
import com.hillel.lesson_06.hw5.odstacle.Obstacle;
import com.hillel.lesson_06.hw5.odstacle.Road;
import com.hillel.lesson_06.hw5.odstacle.Wall;

public class GameService {

    public void run(int userNumber, int odstNumber) {
        Generator gen = new Generator();

        Competitor[] competitors = gen.generateCompetitor(userNumber);
        Obstacle[] odst = gen.generateObstacle(odstNumber);

        for (Competitor c : competitors) {
            System.out.println(c);
            for (Obstacle o : odst) {
                System.out.println(">>>>> " + o);
                if (o instanceof Wall) {
                    int jump = c.getJump();
                    if (((Wall) o).overcome(jump)) {
                        System.out.println("Fail");
                        break;
                    } else {
                        System.out.println("next ..");
                    }
                } else if (o instanceof Road) {
                    int run = c.getRun();
                    if (run < ((Road) o).getLength()) {
                        System.out.println("Fail");
                        break;
                    } else {
                        System.out.println("next ..");
                    }
                }
            }
        }
    }

}
