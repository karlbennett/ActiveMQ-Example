package uk.co.dailymail.lastname;

import uk.co.dailymail.messaging.Messenger;

/**
 * User: Karl Bennett
 * Date: 08/02/11
 */
public class LastName extends Messenger<String, String> {
    /**
     * Constructs a new messenger class that connects to the JMS server at the provided uri and the input and output queues at the provided
     * queue names.
     *
     * @param uri    - the address of the JSM server.
     * @param iQueue - the name of the input queue.
     * @param oQueue - the name of the output queue.
     */
    public LastName(String uri, String iQueue, String oQueue) {
        super(uri, iQueue, oQueue);
    }

    @Override
    public String process(String input) {
        System.out.println(input);

        return null;
    }
}
