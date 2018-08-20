/**
 * Copyright 2018 Tahoma Robotics - http://tahomarobotics.org - Bear Metal 2046 FRC Team
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
 * documentation files (the "Software"), to deal in the Software without restriction, including without 
 * limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the 
 * Software, and to permit persons to whom the Software is furnished to do so, subject to the following 
 * conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions 
 * of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED 
 * TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL 
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER 
 * DEALINGS IN THE SOFTWARE.
 * 
 */
package org.tahomarobotics.robot.path;

import java.util.ArrayList;
import java.util.List;

import org.tahomarobotics.robot.state.Pose2D;

import edu.wpi.first.wpilibj.command.CommandGroup;

public abstract class PathCommandGroup extends CommandGroup {

	private final List<Waypoint> waypoints = new ArrayList<>();
	
	public abstract Pose2D getStartingPose(); 
	
	protected void addPath(PathCommand path) {
		addSequential(path);
		waypoints.addAll(path.getWaypoints());
	}
	
	public double[] getPath() {
		
		double[] path = new double[waypoints.size() * 2];
		int i = 0;
		for (Waypoint pt : waypoints) {
			path[i++] = pt.x;
			path[i++] = pt.y;
		}
		return path;
	}


}