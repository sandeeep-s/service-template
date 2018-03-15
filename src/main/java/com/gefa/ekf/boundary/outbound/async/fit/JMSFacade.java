package com.gefa.ekf.boundary.outbound.async.fit;

import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gefa.ekf.application.infrastructure.ActiveMQ;
import com.gefa.ekf.boundary.inbound.async.fit.domain.AbstractTransferObject;
import com.gefa.ekf.boundary.inbound.async.fit.domain.FITAsset;

@ApplicationScoped
public class JMSFacade {

	private static final Log LOG = LogFactory.getLog(JMSFacade.class);

	@Inject
	@ActiveMQ
	private ConnectionFactory connectionFactory;

	@Inject
	private Configuration configuration;

	@Produces
	@ActiveMQ
	public ConnectionFactory getConnectionFactory() {
		return new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
	}

	public void createAsset(FITAsset fitAsset) {
		try {
			sendMessage(fitAsset, "assetq.create", DeliveryMode.PERSISTENT, false);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	public void createAssetSync(FITAsset fitAsset) {
		long objectNumber = 0;
		try {
			TextMessage txtmsg = sendMessage(fitAsset, "assetq.create.sync", DeliveryMode.PERSISTENT, true);
			objectNumber = Long.parseLong(txtmsg.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	public void updateAsset(FITAsset fitAsset) {
	}

	public TextMessage sendMessage(AbstractTransferObject payload, String qName, int deliveryMode, boolean synchronous)
			throws JMSException {

		TextMessage txtmsg = null;

		Connection connection = null;
		Session session = null;
		try {

			connection = connectionFactory.createConnection();
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Queue jmsQueue = session.createQueue(qName);
			MessageProducer publisher = session.createProducer(jmsQueue);
			publisher.setDeliveryMode(deliveryMode);

			connection.start();

			TextMessage message = session.createTextMessage();
			message.setText(payload.toJson());

			if (synchronous) {
				Destination replyDestination = session.createTemporaryQueue();
				MessageConsumer replyConsumer = session.createConsumer(replyDestination);

				message.setJMSCorrelationID(UUID.randomUUID().toString());
				message.setJMSReplyTo(replyDestination);
				publisher.send(message);

				long timeout = configuration.getTimeout();
				Message replymsg = replyConsumer.receive(timeout);

				if (replymsg instanceof TextMessage) {
					txtmsg = (TextMessage) replymsg;
				} else {
					System.out.println("Not textmessage");
				}

			} else {
				publisher.send(message);
			}

		} finally {
			if (null != session) {
				try {
					session.close();
				} catch (JMSException e) {
					LOG.warn("Error closing Session.", e);
				}
			}
			if (null != connection) {
				try {
					connection.close();
				} catch (JMSException e) {
					LOG.warn("Error closing Connection");
				}
			}
		}

		return txtmsg;
	}

}
