package io.gridgo.core.support.subscription;

import java.util.Optional;

import org.joo.libra.Predicate;

import io.gridgo.core.Processor;
import io.gridgo.framework.execution.ExecutionStrategy;
import io.gridgo.framework.execution.ExecutionStrategyInstrumenter;

public interface RoutingPolicy {

    public Optional<Predicate> getCondition();

    public Optional<ExecutionStrategy> getStrategy();

    public Optional<Predicate> getInstrumenterCondition();

    public Optional<ExecutionStrategyInstrumenter> getInstrumenter();

    public Processor getProcessor();

    public RoutingPolicy setCondition(Predicate condition);

    public RoutingPolicy setStrategy(ExecutionStrategy strategy);

    public RoutingPolicy setProcessor(Processor processor);

    public RoutingPolicy setInstrumenterCondition(Predicate condition);

    public RoutingPolicy setInstrumenter(ExecutionStrategyInstrumenter instrumenter);
}
