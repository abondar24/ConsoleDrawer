package org.abondar.experimental.drawer.util;

/**
 * Messages thrown in exceptions
 *
 * @author a.bondar
 */
public class MessageUtil {

    public static final String EMPTY_CANVAS = "Empty canvas. Nothing to draw";

    public static final String UNSUPPORTED_LINE_TYPE = "Line is not vertical or horizontal";

    public static final String POINT_IS_NOT_ON_CANVAS = "Point is not on canvas";
    public static final String WRONG_POINT = "Incorrect point";
    public static final String INVALID_INPIT = "Wrong or missing command params ";
    public static final String CANVAS_NOT_CREATED = "Can't execute command. Please create canvas first";
    public static final String UNKNOWN_COMMAND = "Command not recognized %s\n";

    private MessageUtil(){}
}
