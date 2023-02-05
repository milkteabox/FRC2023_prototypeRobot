// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.RobotMap.*;


public class ElevatorSubsystem extends SubsystemBase
{
    public final Solenoid elevator_solenoid = new Solenoid(PNEUMATICS_MODULE_TYPE, ELEVATOR_SOLENOID);

    @Override
    public void periodic()
    {
    }
    public void elevator_UP(boolean up){
        if (up){
            elevator_solenoid.set(true);
        }else {
            elevator_solenoid.set(false);
        }
    }
}
