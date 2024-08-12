package org.creationalPattern.prototype.impl.question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ChoiceQuestion extends AbstractQuestion {

    private Map<String, String> options;

    public ChoiceQuestion(final String name, final Map<String, String> options, final String answer) {
      super(name, answer);
      this.options = options;
    }

    public Map<String, String> getOptions() {
        return options;
    }

    public void setOptions(final Map<String, String> options) {
        this.options = options;
    }

    public void shuffleOptions() {
        final Set<String> keySet = options.keySet();
        ArrayList<String> keyList = new ArrayList<>(options.keySet());
        Collections.shuffle(keyList);
        int idx = 0;
        HashMap<String, String> optionsNew = new HashMap<String, String>();
        for (String key : keySet) {
            String randomKey = keyList.get(idx++);
            if (getAnswer().equals(key)) {
                setAnswer(randomKey);
            }
            optionsNew.put(randomKey, getOptions().get(key));
        }
        setOptions(optionsNew);
    }

    @Override
    public String toString() {
        return "ChoiceQuestion{" + "options=" + options + ", name='" + name + '\'' + ", answer='" + answer + '\'' + '}';
    }
}
