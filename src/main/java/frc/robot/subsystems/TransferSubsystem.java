// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.*;
import static frc.robot.RobotMap.*;


public class TransferSubsystem extends SubsystemBase
{
    private final CANSparkMax rightNEO = new CANSparkMax(INTAKE_RIGHT_MOTOR, CANSparkMaxLowLevel.MotorType.kBrushless);
    private final CANSparkMax leftNEO = new CANSparkMax(INTAKE_LEFT_MOTOR, CANSparkMaxLowLevel.MotorType.kBrushless);
    private final Solenoid solenoid = new Solenoid(PNEUMATICS_MODULE_TYPE, INTAKE_SOLENOID);
    private final CANSparkMax frontNEO = new CANSparkMax(TRANSFER_FRONT_MOTOR, CANSparkMaxLowLevel.MotorType.kBrushless);
    private final CANSparkMax REARNEO = new CANSparkMax(TRANSFER_REAR_MOTOR, CANSparkMaxLowLevel.MotorType.kBrushless);
    private final CANSparkMax rightingNEO = new CANSparkMax(RIGHTING_MOTOR, CANSparkMaxLowLevel.MotorType.kBrushless);
    private final DutyCycleEncoder rightingEncoder = new DutyCycleEncoder(RIGHTING_ENCODER);


    public TransferSubsystem() {
        configIntakeMotor();
        configTransferMotor();

        rightingNEO.restoreFactoryDefaults();
        rightingNEO.setSmartCurrentLimit(RIGHTING_MOTOR_CURRENTLIMIT);
        rightingNEO.setInverted(RIGHTING_MOTOR_INVERTED);
        rightingNEO.enableVoltageCompensation(RIGHTING_MOTOR_VOLTAGE_COMPENSATION);
        rightingNEO.getPIDController().setP(RIGHTING_MOTOR_KP);
        rightingNEO.getPIDController().setI(RIGHTING_MOTOR_KI);
        rightingNEO.getPIDController().setD(RIGHTING_MOTOR_KD);
        rightingNEO.getPIDController().setFF(RIGHTING_MOTOR_KF);
        rightingNEO.getEncoder().setPositionConversionFactor(1/100);
    }
    
    @Override
    public void periodic()
    {
        // This method will be called once per scheduler run
    }

    public void intakeDown(boolean down){
        if(down){
            solenoid.set(true);
            leftNEO.getPIDController().setReference(INTAKE_MOTOR_RPM, CANSparkMax.ControlType.kVelocity);
        }else{
            solenoid.set(false);
            leftNEO.stopMotor();
        }
    }
    public void configIntakeMotor(){
        rightNEO.restoreFactoryDefaults();
        rightNEO.setSmartCurrentLimit(INTAKE_MOTOR_CURRENTLIMIT);
        rightNEO.setInverted(INTAKE_RIGHT_MOTOR_INVERTED);
        rightNEO.enableVoltageCompensation(INTAKE_VOLTAGE_COMPENSATION);
        rightNEO.getPIDController().setP(INTAKE_MOTOR_KP);
        rightNEO.getPIDController().setI(INTAKE_MOTOR_KI);
        rightNEO.getPIDController().setD(INTAKE_MOTOR_KD);
        rightNEO.getPIDController().setFF(INTAKE_MOTOR_KF);
        rightNEO.getEncoder().setVelocityConversionFactor(1/15);

        leftNEO.restoreFactoryDefaults();
        leftNEO.setSmartCurrentLimit(INTAKE_MOTOR_CURRENTLIMIT);
        leftNEO.setInverted(INTAKE_LEFT_MOTOR_INVERTED);
        leftNEO.enableVoltageCompensation(INTAKE_VOLTAGE_COMPENSATION);
        leftNEO.getPIDController().setP(INTAKE_MOTOR_KP);
        leftNEO.getPIDController().setI(INTAKE_MOTOR_KI);
        leftNEO.getPIDController().setD(INTAKE_MOTOR_KD);
        leftNEO.getPIDController().setFF(INTAKE_MOTOR_KF);
        leftNEO.getEncoder().setVelocityConversionFactor(1/15);

        rightNEO.follow(leftNEO, true);
    }
    public void configTransferMotor(){
        frontNEO.restoreFactoryDefaults();
        frontNEO.setSmartCurrentLimit(TRANSFER_FRONT_MOTOR_CURRENTLIMIT);
        frontNEO.setInverted(TRANSFER_FRONT_MOTOR_INVERTED);
        frontNEO.enableVoltageCompensation(TRANSFER_FRONT_MOTOR_VOLTAGE_COMPENSATION);
        frontNEO.getPIDController().setP(TRANSFER_FRONT_MOTOR_KP);
        frontNEO.getPIDController().setI(TRANSFER_FRONT_MOTOR_KI);
        frontNEO.getPIDController().setD(TRANSFER_FRONT_MOTOR_KD);
        frontNEO.getPIDController().setFF(TRANSFER_FRONT_MOTOR_KF);
        frontNEO.getEncoder().setVelocityConversionFactor(1/15);

        REARNEO.restoreFactoryDefaults();
        REARNEO.setSmartCurrentLimit(TRANSFER_REAR_MOTOR_CURRENTLIMIT);
        REARNEO.setInverted(TRANSFER_REAR_MOTOR_INVERTED);
        REARNEO.enableVoltageCompensation(TRANSFER_REAR_MOTOR_VOLTAGE_COMPENSATION);
        REARNEO.getPIDController().setP(TRANSFER_REAR_MOTOR_KP);
        REARNEO.getPIDController().setI(TRANSFER_REAR_MOTOR_KI);
        REARNEO.getPIDController().setD(TRANSFER_REAR_MOTOR_KD);
        REARNEO.getPIDController().setFF(TRANSFER_REAR_MOTOR_KF);
        REARNEO.getEncoder().setVelocityConversionFactor(1/15);
    }
}
