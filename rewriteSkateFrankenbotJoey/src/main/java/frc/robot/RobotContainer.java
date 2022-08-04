// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.MoveRobotCommand;
import frc.robot.subsystems.PneumaticsSubsystem;
import frc.robot.subsystems.SkateBotSubsystem;
import frc.robot.subsystems.SlayDashboardSubsystem;



public class RobotContainer {

  public static Joystick driveStick;
  public static Joystick turnStick;
  public static SkateBotSubsystem skateBotSubsystem = new SkateBotSubsystem();
  public static PneumaticsSubsystem pneumaticsSubsystem = new PneumaticsSubsystem();
  public static SlayDashboardSubsystem slayDashboardSubsystem = new SlayDashboardSubsystem(); 


  public RobotContainer() {
    Constants.RobotProperties.configureRobotSettings();
    configureDriverInterface();
    configureButtonBindings();
    skateBotSubsystem.setDefaultCommand(new MoveRobotCommand());
  }

  private void configureDriverInterface(){
    switch (Constants.RobotProperties.driveInterface){
      case ONESTICK:
        driveStick = new Joystick(0);
        break;
      case TWOSTICK:
        driveStick = new Joystick(1);
        turnStick = new Joystick(0);
      break;
    }
  }
  
  private void configureButtonBindings(){

    new JoystickButton(driveStick, 1)
      .whenPressed(new InstantCommand(() -> pneumaticsSubsystem.slayenoidTheHouseUpAndDown()));

    //new JoystickButton (driveStick, 9).whenPressed(SkateBotSubsystem::setToZero);

  }



}

