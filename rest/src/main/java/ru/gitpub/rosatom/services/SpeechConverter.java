package ru.gitpub.rosatom.services;

import java.io.IOException;
import java.io.InputStream;

import edu.cmu.sphinx.api.AbstractSpeechRecognizer;
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.SpeechResult;
import org.springframework.stereotype.Service;

@Service
public class SpeechConverter {

    private final MyRecognizer recognizer;

    private boolean initialized;

    public SpeechConverter() throws IOException {
        Configuration configuration = new Configuration();
        configuration.setAcousticModelPath("resource:/sphinx/zero_ru.cd_cont_4000");
        configuration.setDictionaryPath("resource:/sphinx/ru.dic");
        configuration.setLanguageModelPath("resource:/sphinx/ru.lm");
        recognizer = new MyRecognizer(configuration);
    }

    public String convert(InputStream speech) {
        if (!initialized) {
            recognizer.init();
            initialized = true;
        }

        recognizer.startRecognition(speech);
        SpeechResult result;
        StringBuilder text = new StringBuilder();
        while ((result = recognizer.getResult()) != null) {
            text.append(result.getHypothesis()).append(" ");
        }
        return text.toString();
    }

    private static class MyRecognizer extends AbstractSpeechRecognizer {

        public MyRecognizer(Configuration configuration) throws IOException {
            super(configuration);
        }

        public void init() {
            recognizer.allocate();
        }

        public void startRecognition(InputStream stream) {
            context.setSpeechSource(stream);
        }

        public void stopRecognition() {
            recognizer.deallocate();
        }
    }
}
