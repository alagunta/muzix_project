package com.cgi.fav_muzix.exception;

public class MuzixAlreadyExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MuzixAlreadyExistsException(String string) {
		System.out.println(string);

	}

	@Override
	public String getLocalizedMessage() {

		return super.getLocalizedMessage();
	}

	@Override
	public StackTraceElement[] getStackTrace() {

		return super.getStackTrace();
	}

	@Override
	public void setStackTrace(StackTraceElement[] arg0) {
		super.setStackTrace(arg0);
	}

	@Override
	public String toString() {

		return super.toString();
	}

}
