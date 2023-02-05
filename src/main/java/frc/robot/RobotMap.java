package frc.robot;

import edu.wpi.first.wpilibj.PneumaticsModuleType;

public class RobotMap {
    public static final String SWERVE_CANBUS_TYPE = "rio";
    public static final PneumaticsModuleType PNEUMATICS_MODULE_TYPE = PneumaticsModuleType.REVPH;

    public static final int SWERVE_LEFTFRONT_DRIVEMOTOR = 1;
    public static final int SWERVE_LEFTFRONT_ANGLEMOTOR = 2;
    public static final int SWERVE_LEFTFRONT_CANCODER = 1;

    public static final int SWERVE_LEFTREAR_DRIVEMOTOR = 3;
    public static final int SWERVE_LEFTREAR_ANGLEMOTOR = 4;
    public static final int SWERVE_LEFTREAR_CANCODER = 2;

    public static final int SWERVE_RIGHTFRONT_DRIVEMOTOR = 7;
    public static final int SWERVE_RIGHTFRONT_ANGLEMOTOR = 8;
    public static final int SWERVE_RIGHTFRONT_CANCODER = 4;

    public static final int SWERVE_RIGHTREAR_DRIVEMOTOR = 5;
    public static final int SWERVE_RIGHTREAR_ANGLEMOTOR = 6;
    public static final int SWERVE_RIGHTREAR_CANCODER = 3;

    public static final int INTAKE_RIGHT_MOTOR = 13;
    public static final int INTAKE_LEFT_MOTOR = 14;
    public static final int INTAKE_SOLENOID = 1;

    public static final int TRANSFER_FRONT_MOTOR = 9;
    public static final int RIGHTING_MOTOR = 10;
    public static final int RIGHTING_ENCODER = 0;
    public static final int TRANSFER_REAR_MOTOR = 11;

    public static final int ELEVATOR_SOLENOID = 0;


}
