package io.gridgo.core;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

import io.gridgo.connector.ConnectorFactory;
import io.gridgo.core.support.subscription.GatewaySubscription;
import io.gridgo.framework.ComponentLifecycle;

public interface GridgoContext extends ComponentLifecycle {

	public GatewaySubscription openGateway(String name);

	public Optional<Gateway> closeGateway(String name);

	public Optional<Gateway> findGateway(String name);

	public Collection<Gateway> getGateways();

	public Map<String, Gateway> getGatewaysWithNames();

	public ConnectorFactory getConnectorFactory();

	public Consumer<Throwable> getExceptionHandler();
}
