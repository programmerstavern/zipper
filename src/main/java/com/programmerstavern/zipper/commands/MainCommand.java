package com.programmerstavern.zipper.commands;

import com.programmerstavern.zipper.utils.CompressionService;
import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.command.annotation.Option;
import org.springframework.shell.context.InteractionMode;

@Command(group = "Compression")
public class MainCommand {

  private final CompressionService compressionService;

  public MainCommand(CompressionService compressionService) {
    this.compressionService = compressionService;
  }

  @Command(command = "compress", description = "compresses file or folder", interactionMode = InteractionMode.NONINTERACTIVE)
  public String compress(
      @Option(longNames = "input", description = "file or folder to be compressed") String inputPath,
      @Option(longNames = "output", description = "compressed file name") String outputPath
  ) {
    compressionService.zipTarget(inputPath, outputPath);
    return String.format("Input %s successfully compressed to %s" + System.lineSeparator(),
        inputPath,
        outputPath);
  }

  @Command(command = "decompress", description = "decompresses file or folder", interactionMode = InteractionMode.NONINTERACTIVE)
  public void decompress(
      @Option(longNames = "input", description = "file or folder to be decompressed") String inputPath,
      @Option(longNames = "output", description = "folder where the decompressed files will be put in") String outputPath
  ) {
    compressionService.unzipFile(inputPath, outputPath);
    System.out.printf("Input %s successfully decompressed to %s" + System.lineSeparator(),
        inputPath,
        outputPath);
  }
}
