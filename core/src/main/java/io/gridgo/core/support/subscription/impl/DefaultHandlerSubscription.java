package io.gridgo.core.support.subscription.impl;

import org.joo.libra.Predicate;
import org.joo.libra.sql.SqlPredicate;

import io.gridgo.core.Gateway;
import io.gridgo.core.Processor;
import io.gridgo.core.support.subscription.GatewaySubscription;
import io.gridgo.core.support.subscription.HandlerSubscription;
import io.gridgo.core.support.subscription.RoutingPolicy;
import io.gridgo.framework.execution.ExecutionStrategy;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class DefaultHandlerSubscription implements HandlerSubscription {

    private Gateway gateway;

    private RoutingPolicy policy;

    public DefaultHandlerSubscription(Gateway gateway, Processor processor) {
        this.gateway = gateway;
        this.policy = new DefaultRoutingPolicy(processor);
    }

    public DefaultHandlerSubscription(Gateway gateway, RoutingPolicy policy) {
        this.gateway = gateway;
        this.policy = policy;
    }

    @Override
    public HandlerSubscription when(String condition) {
        return when(new SqlPredicate(condition));
    }

    @Override
    public HandlerSubscription when(Predicate condition) {
        this.policy.setCondition(condition);
        return this;
    }

    @Override
    public HandlerSubscription using(ExecutionStrategy strategy) {
        this.policy.setStrategy(strategy);
        return this;
    }

    @Override
    public GatewaySubscription withPolicy(final @NonNull RoutingPolicy policy) {
        this.policy.setCondition(policy.getCondition().orElse(null));
        this.policy.setStrategy(policy.getStrategy().orElse(null));
        return gateway;
    }

    @Override
    public GatewaySubscription finishSubscribing() {
        return gateway;
    }
}
