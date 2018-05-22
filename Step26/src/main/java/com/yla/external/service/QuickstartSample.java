package com.yla.external.service;
import java.io.FileInputStream;

import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
// Imports the Google Cloud client library
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.Translate.TranslateOption;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

import io.grpc.Context.Storage;

public class QuickstartSample {
  public static void main(String... args) throws Exception {
	  
	 // Credentials credentials = GoogleCredentials
	//		  .fromStream(new FileInputStream("path/to/file"));
	//		Storage storage = StorageOptions.newBuilder().setCredentials(credentials)
	//		  .setProjectId("baeldung-cloud-tutorial").build().getService();
	  
    // Instantiates a client
    Translate translate = TranslateOptions.getDefaultInstance().getService();

    // The text to translate
    String text = "Hello, world!";

    // Translates some text into Russian
    Translation translation =
        translate.translate(
            text,
            TranslateOption.sourceLanguage("en"),
            TranslateOption.targetLanguage("ru"));


    System.out.printf("Text: %s%n", text);
    System.out.printf("Translation: %s%n", translation.getTranslatedText());
  }
}