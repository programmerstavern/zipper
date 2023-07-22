package com.programmerstavern.zipper;

import static org.awaitility.Awaitility.await;

import com.deriklima.thecompressor.utils.CompressionService;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.shell.test.ShellAssertions;
import org.springframework.shell.test.ShellTestClient;
import org.springframework.shell.test.ShellTestClient.NonInteractiveShellSession;
import org.springframework.shell.test.autoconfigure.ShellTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@ShellTest
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
class MainCommandTest {

  @Autowired
  ShellTestClient client;

  @MockBean
  CompressionService compressionService;

//  @Test
  public void test() {
    NonInteractiveShellSession session = client.nonInterative("compress", "--input", "file.txt",
        "--output", "compressed.zip");

    await().atMost(2, TimeUnit.SECONDS).untilAsserted(() -> {
      ShellAssertions.assertThat(session.screen()).containsText("successfully compressed to");
    });
  }

}