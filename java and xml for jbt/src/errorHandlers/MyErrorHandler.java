package errorHandlers;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class MyErrorHandler implements ErrorHandler {
	
	private String getParseExceptionInfo(SAXParseException spe) {
		String systemId = spe.getSystemId();

		if (systemId == null) {
			systemId = "null";
		}

		String info = "URI=" + systemId + " Line=" + spe.getLineNumber()
				+ " Column=" + spe.getColumnNumber() + ": " + spe.getMessage();
		return info;
	}

	@Override
	public void warning(SAXParseException exception) throws SAXException {
		System.err.println("warning: " + getParseExceptionInfo(exception));

	}

	@Override
	public void error(SAXParseException exception) throws SAXException {
		String message = "Error: " + getParseExceptionInfo(exception);
		throw new SAXException(message);
	}

	@Override
	public void fatalError(SAXParseException exception) throws SAXException {
		String message = "Fatal Error: " + getParseExceptionInfo(exception);
		throw new SAXException(message);

	}
}
