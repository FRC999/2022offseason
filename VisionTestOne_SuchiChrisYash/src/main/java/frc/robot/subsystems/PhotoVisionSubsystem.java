// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.List;

import org.photonvision.PhotonCamera;
import org.photonvision.targeting.PhotonPipelineResult;
import org.photonvision.targeting.PhotonTrackedTarget;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PhotoVisionSubsystem extends SubsystemBase {
  /** Creates a new PhotoVisionSubsystem. */

  PhotonCamera camera = new PhotonCamera("mmal_service_16.1");
  boolean hasTargets;
    List<PhotonTrackedTarget> targets;
  
  public PhotoVisionSubsystem() {
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    
  }

  public void getTargets() {
  }

  public String getYawPitch() {

    var result = camera.getLatestResult();
    hasTargets = result.hasTargets();
    targets = result.getTargets();

    if (targets ==  null) { return "-2,-2"; }
    if (result ==  null) { return "-1,-1"; }

    PhotonTrackedTarget target = result.getBestTarget();

    double yaw = target.getYaw();
    double pitch = target.getPitch();
    return ""+yaw+","+pitch;
  }


}
