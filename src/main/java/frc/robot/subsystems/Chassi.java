/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Chassi extends SubsystemBase {
  private CANSparkMax rightMaster, rightSlave, leftMaster, leftSlave;
  private CANEncoder rightEncoder, leftEncoder;

  /**
   * Creates a new Chassi.
   */
  public Chassi(){
    rightMaster = new CANSparkMax(Constants.rightMasterPort, MotorType.kBrushless);
    rightSlave = new CANSparkMax(Constants.rightSlavePort, MotorType.kBrushless);
    leftMaster = new CANSparkMax(Constants.leftMasterPort, MotorType.kBrushless);
    leftSlave = new CANSparkMax(Constants.leftSlavePort, MotorType.kBrushless);

    rightSlave.follow(rightMaster);
    leftSlave.follow(leftMaster);

    rightEncoder = rightMaster.getAlternateEncoder();
    leftEncoder = leftMaster.getAlternateEncoder();

    
  }

  public void setSpeeds(double left, double right){
    rightMaster.set(right);
    leftMaster.set(left);
  }

  public double getRightEncoder(){
    return rightEncoder.getPosition();
  }
  
  public double getLeftEncoder() {
    return leftEncoder.getPosition();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
