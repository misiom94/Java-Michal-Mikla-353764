package pl.lodz.uni.math.gamebowling;

import org.apache.log4j.Logger;

public class FrameException extends Exception {
	Logger logger = Logger.getRootLogger();

	public FrameException() {
		logger.error(this + " Roll score is impossible.");
	}

}
