package frc.robot;

public class AutoConstants {
    
    public static double LIMELIGHT_HEIGHT = 1;//measure please
    
    public static int BARREL_FIRST_DISTANCE =1;
    public static int NINETY_DEGREES = 1;
    public static int BARREL_SQUARE_DISTANCE = 1;
    public static int BARREL_FIRST_TURN = 1;
    public static int BARREL_SECOND_DISTANCE = 1;
    public static int BARREL_SECOND_TURN = 1;
    public static int BARREL_THIRD_DISTANCE = 1;
    public static int BARREL_FOURTH_TURN = 1;
    public static int BARREL_FOURTH_DISTANCE = 1;


    public static int BOUNCE_FIRST_DISTANCE = 1;
    public static int BOUNCE_FIRST_TURN = 1; //turn right
    public static int BOUNCE_SECOND_DISTANCE = 1;
    public static int BOUNCE_SECOND_TURN = 1; //turn left
    public static int BOUNCE_THIRD_DISTANCE = 1;
    public static int BOUNCE_THIRD_TURN = 1; //turn left
    public static int BOUNCE_FOURTH_DISTANCE = 1;
    public static int BOUNCE_FOURTH_TURN = 1; //turn right
    public static int BOUNCE_FIFTH_DISTANCE = 1;
    public static int BOUNCE_FIFTH_TURN = 1; //turn left
    public static int BOUNCE_SIXTH_DISTANCE = 1;
    public static int BOUNCE_SIXTH_TURN = 1; //turn left
    public static int BOUNCE_SEVENTH_DISTANCE = 1;
    public static int BOUNCE_SEVENTH_TURN = 1; //turn right
    public static int BOUNCE_EIGHTH_DISTANCE = 1;

    
    public static int SLALOM_FIRST_DISTANCE = 1;
    public static int SLALOM_STOP = 1;
    public static int SLALOM_FIRST_ROTATION = 1; //turn upwards roughly 45 degrees
    public static int SLALOM_DRIVE_STRAIGHT = 1;
    public static int SLALOM_SECOND_ROTATION = 1;//turn southwards
    public static int SLALOM_THIRD_ROTATION = 1;
    public static int SLALOM_FOURTH_ROTATION = 1;
    public static int SLALOM_DRIVE_CIRCLE_ONE = 1;
    public static int SLALOM_FIFTH_ROTATION = 1;
    public static int SLALOM_DRIVE_CIRCLE_TWO = 1;
    public static int SLALOM_SIXTH_ROTATION = 1;
    public static int SLALOM_DRIVE_CIRCLE_THREE = 1;
    public static int SLALOM_SEVENTH_ROTATION = 1;
    public static int SLALOM_DRIVE_CIRCLE_FOUR = 1;
    public static int SLALOM_EIGTH_ROTATION = 1;
    public static int SLALOM_NINTH_ROTATION = 1;
    public static int SLALOM_DRIVE_TO_END = 1;

    public static DataTable DATA = new DataTable("START", "D1", "T1", "D2", "T2", "D3", "T3", "D4");

    //possibly obsolete, might do manual entry
    public static int[][] GS_DISTANCES ={   //s,d1,t1,d2,t2,d3,t3,d4
                                             {1, 1, 1, 2, 2, 3, 3, 4},//path 1
                                             {1, 1, 1, 2, 2, 3, 3, 4},//path 2
                                             {1, 1, 1, 2, 2, 3, 3, 4},//path 3
                                             {1, 1, 1, 2, 2, 3, 3, 4},//path 4
                                        };
    
    
    public static double VISION_ERROR = 0.3;

    public static void setActivePath(String path){
        DATA.changeRowName(path, "ACTIVE");
    }

    public static void fillTable(){
        DATA.addRows("PATH1","PATH2","PATH3","PATH4");
    }


}
