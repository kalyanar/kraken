package com.kraken.runtime.context.environment;

import com.google.common.collect.ImmutableMap;
import com.kraken.analysis.client.properties.AnalysisClientProperties;
import com.kraken.runtime.entity.environment.ExecutionEnvironment;
import com.kraken.runtime.entity.task.TaskType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.Map;

import static com.kraken.tools.environment.KrakenEnvironmentKeys.KRAKEN_ANALYSIS_URL;

@Component
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
class AnalysisUrlPublisher implements EnvironmentPublisher {

  @NonNull AnalysisClientProperties properties;

  @Override
  public boolean test(final TaskType taskType) {
    return TaskType.DEBUG == taskType || TaskType.RECORD == taskType;
  }

  @Override
  public Map<String, String> apply(final ExecutionEnvironment context) {
    return ImmutableMap.of(KRAKEN_ANALYSIS_URL, properties.getAnalysisUrl());
  }
}