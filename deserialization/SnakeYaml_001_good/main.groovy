import org.yaml.snakeyaml.Yaml
import org.yaml.snakeyaml.constructor.Constructor
import org.yaml.snakeyaml.constructor.SafeConstructor

import java.io.InputStream
import java.net.Socket

class SafeSnakeYamlDeserialize {

    void deserializeSnakeYaml3(String input) throws IOException {
        Yaml yaml = new Yaml(new SafeConstructor())
        Object o = yaml.load(input) // NOT VULNERABLE TO Deserialization HERE // Yaml Instance constructed with SafeConstructor
    }

    void deserializeSnakeYaml4(String input) throws IOException {
        Yaml yaml = new Yaml(new Constructor(SafeSnakeYamlDeserialize.class))
        Object o = yaml.load(input) // NOT VULNERABLE TO Deserialization HERE // Constructor with whitelist - Safe Setting
    }
}
