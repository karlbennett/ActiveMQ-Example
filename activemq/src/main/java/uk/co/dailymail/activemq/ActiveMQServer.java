package uk.co.dailymail.activemq;

import org.apache.activemq.broker.BrokerService;

/**
 * User: Karl Bennett
 * Date: 30-Jan-2011
 */
public class ActiveMQServer {

    public static void main(String[] args) throws Exception {
        BrokerService broker = new BrokerService();

        // configure the broker
        broker.addConnector("tcp://localhost:61616");

        broker.start();

//        broker.stop();
    }
}
