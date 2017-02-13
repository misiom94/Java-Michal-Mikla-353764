package pl.lodz.uni.math.exception;

import org.apache.log4j.Logger;

public class RollException extends Exception {
	Logger logger = Logger.getRootLogger();

	public RollException() {
		logger.error(this + " Roll score is impossible.");
	}

}
