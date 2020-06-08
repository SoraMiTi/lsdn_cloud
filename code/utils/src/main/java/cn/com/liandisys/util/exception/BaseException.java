package cn.com.liandisys.util.exception;

import java.util.ArrayList;
import java.util.List;

/**
 * The base class of the exception.
 */
public abstract class BaseException extends RuntimeException {

    private static final long serialVersionUID = -2033758305426780486L;

    /** message list */
    private List<String> messageList;

    /**
     * Constructs a new exception with <code>null</code> as its detail message. The cause is not initialized, and
     * may subsequently be initialized by a call to {@link #initCause}.
     */
    public BaseException() {
        super();
        messageList = new ArrayList<String>();
        messageList.add(this.getMessage());
    }

    /**
     * Constructs a new exception with the specified detail message. The cause is not initialized, and may
     * subsequently be initialized by a call to {@link #initCause}.
     * 
     * @param message the detail message. The detail message is saved for later retrieval by the
     *            {@link #getMessage()} method.
     */
    public BaseException(String message) {
        super(message);
        messageList = new ArrayList<String>();
        messageList.add(this.getMessage());
    }

    /**
     * Constructs a new exception with the detail message list. The cause is not initialized, and may subsequently
     * be initialized by a call to {@link #initCause}.
     * 
     * @param messageList the detail message list. The message list is saved for later retrieval by the
     *            {@link #getMessageList()} method.
     */
    public BaseException(List<String> messageList) {
        super();
        this.messageList = messageList;
    }

    /**
     * Constructs a new exception with the specified detail message and cause.
     * <p>
     * Note that the detail message associated with <code>cause</code> is <i>not</i> automatically incorporated in
     * this exception's detail message.
     * 
     * @param message the detail message (which is saved for later retrieval by the {@link #getMessage()} method).
     * @param cause the cause (which is saved for later retrieval by the {@link #getCause()} method). (A
     *            <tt>null</tt> value is permitted, and indicates that the cause is nonexistent or unknown.)
     * @since 1.4
     */
    public BaseException(String message, Throwable cause) {
        super(message, cause);
        messageList = new ArrayList<String>();
        messageList.add(this.getMessage());
    }

    /**
     * Constructs a new exception with the specified cause and a detail message of
     * <tt>(cause==null ? null : cause.toString())</tt> (which typically contains the class and detail message of
     * <tt>cause</tt>). This constructor is useful for exceptions that are little more than wrappers for other
     * throwables (for example, {@link java.security.PrivilegedActionException}).
     * 
     * @param cause the cause (which is saved for later retrieval by the {@link #getCause()} method). (A
     *            <tt>null</tt> value is permitted, and indicates that the cause is nonexistent or unknown.)
     * @since 1.4
     */
    public BaseException(Throwable cause) {
        super(cause);
        messageList = new ArrayList<String>();
        messageList.add(this.getMessage());
    }

    /**
     * <p>
     * get the messageList.
     * </p>
     * 
     * @return messageList
     */
    public List<String> getMessageList() {

        return this.messageList;
    }

    /**
     * <p>
     * set the messageList.
     * </p>
     * 
     * @param messageList messageList
     */
    public void setMessageList(List<String> messageList) {

        this.messageList = messageList;
    }
}
