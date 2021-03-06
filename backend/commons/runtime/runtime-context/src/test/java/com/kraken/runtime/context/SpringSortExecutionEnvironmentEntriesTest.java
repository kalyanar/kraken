package com.kraken.runtime.context;

import com.google.common.collect.ImmutableList;
import com.kraken.runtime.entity.environment.ExecutionEnvironmentEntry;
import org.junit.Before;
import org.junit.Test;

import static com.kraken.runtime.entity.environment.ExecutionEnvironmentEntrySource.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SpringSortExecutionEnvironmentEntriesTest {

  private SpringSortExecutionEnvironmentEntries sort;

  @Before
  public void before() {
    this.sort = new SpringSortExecutionEnvironmentEntries();
  }

  @Test
  public void shouldFilter() {
    final var result = this.sort.apply(ImmutableList.of(
        ExecutionEnvironmentEntry.builder()
            .scope("hostId")
            .from(USER)
            .key("foo")
            .value("bar")
            .build(),
        ExecutionEnvironmentEntry.builder()
            .scope("")
            .from(BACKEND)
            .key("foo")
            .value("bar")
            .build(),
        ExecutionEnvironmentEntry.builder()
            .scope("hostId")
            .from(FRONTEND)
            .key("foo")
            .value("bar")
            .build(),
        ExecutionEnvironmentEntry.builder()
            .scope("")
            .from(USER)
            .key("foo")
            .value("bar")
            .build(),
        ExecutionEnvironmentEntry.builder()
            .scope("hostId")
            .from(TASK_CONFIGURATION)
            .key("foo")
            .value("bar")
            .build()
        )
    );
    assertThat(result).isEqualTo(ImmutableList.of(
        ExecutionEnvironmentEntry.builder()
            .scope("")
            .from(BACKEND)
            .key("foo")
            .value("bar")
            .build(),
        ExecutionEnvironmentEntry.builder()
            .scope("hostId")
            .from(TASK_CONFIGURATION)
            .key("foo")
            .value("bar")
            .build(),
        ExecutionEnvironmentEntry.builder()
            .scope("hostId")
            .from(FRONTEND)
            .key("foo")
            .value("bar")
            .build(),
        ExecutionEnvironmentEntry.builder()
            .scope("")
            .from(USER)
            .key("foo")
            .value("bar")
            .build(),
        ExecutionEnvironmentEntry.builder()
            .scope("hostId")
            .from(USER)
            .key("foo")
            .value("bar")
            .build()
    ));
  }

}
