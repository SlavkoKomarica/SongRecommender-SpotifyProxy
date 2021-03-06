package rs.fon.inteligentni.rest.exception.mapper;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import rs.fon.inteligentni.rest.exception.SpotifyProxyRuntimeException;

@ControllerAdvice
public class ExceptionMapper {

	Logger logger = Logger.getLogger(ExceptionMapper.class);

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(SpotifyProxyRuntimeException.class)
	@ResponseBody
	ErrorMessage handleIvalidArguments(HttpServletRequest req, Exception ex) {
		logger.error("RuntimeException: ", ex);
		return new ErrorMessage(ex.getMessage());
	}	

	class ErrorMessage {

		private String error;

		public ErrorMessage() {

		}

		public ErrorMessage(String errorMessage) {
			this.error = errorMessage;
		}

		public String getError() {
			return error;
		}

		public void setError(String error) {
			this.error = error;
		}

	}

}