// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class NetworkTablesSubsystem extends SubsystemBase {
  /** Creates a new NetworkTablesSubsystem. */
  NetworkTableInstance inst = NetworkTableInstance.getDefault();
  NetworkTable table;
  NetworkTable subTable;

  final String tableName = "photonvision";
  final String subTableName = "mmal_service_16.1";
  final String existKey = "hasTarget";
  public NetworkTablesSubsystem() {

      //Get the table within that instance that contains the data. There can
      //be as many tables as you like and exist to make it easier to organize
      //your data. In this case, it's a table called datatable.
    table = inst.getTable(tableName);
    subTable = table.getSubTable(subTableName);
    
  }

  public boolean isVisible(){
    return subTable.getEntry(existKey).getBoolean(false);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
