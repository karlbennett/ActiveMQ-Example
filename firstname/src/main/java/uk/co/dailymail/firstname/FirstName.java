package uk.co.dailymail.firstname;

import uk.co.dailymail.messaging.Messenger;

import java.io.Serializable;

/**
 * User: Karl Bennett
 * Date: 27-Jan-2011
 */
public class FirstName extends Messenger<String, String> {

    /**
     * Constructs a new messenger class that connects to the JMS server at the provided uri and the input and output queues at the provided
     * queue names.
     *
     * @param uri    - the address of the JSM server.
     * @param iQueue - the name of the input queue.
     * @param oQueue - the name of the output queue.
     */
    public FirstName(String uri, String iQueue, String oQueue) {
        super(uri, iQueue, oQueue);
    }

    @Override
    public String process(String input) {
        return "First Name.";
    }


}
