package com.programmerstavern.zipper.examples;

import static org.awaitility.Awaitility.await;

import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.test.ShellAssertions;
import org.springframework.shell.test.ShellTestClient;
import org.springframework.shell.test.ShellTestClient.NonInteractiveShellSession;
import org.springframework.shell.test.autoconfigure.ShellTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;


@ShellTest
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
class ProgrammaticCommandTest {

  @Autowired
  ShellTestClient client;

//  @Test
  public void shouldPrintToConsole() {
    // when
    NonInteractiveShellSession session = client.nonInterative("programmatic").run();

    // then
    await().atMost(2, TimeUnit.SECONDS).untilAsserted(() -> {
      ShellAssertions.assertThat(session.screen()).containsText("Hi");
    });
  }

}