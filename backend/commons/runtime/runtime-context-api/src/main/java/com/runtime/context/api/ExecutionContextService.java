package com.runtime.context.api;

import com.kraken.runtime.entity.environment.ExecutionEnvironment;
import com.runtime.context.entity.ExecutionContext;
import reactor.core.publisher.Mono;

public interface ExecutionContextService {

  Mono<ExecutionContext> newExecuteContext(String applicationId, ExecutionEnvironment environment);

  Mono<ExecutionContext> newCancelContext(String applicationId, String taskId, String taskType);

}