/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.mixrad;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigAgent {
    
    public static void premain(String configFile) {
        try {
            if (configFile != null) {
                Properties properties = new Properties();
                properties.load(new FileInputStream(configFile));
                for (final String propertyName : properties.stringPropertyNames()) {
                    if (System.getProperty(propertyName) != null) {
                        continue;
                    }
                    System.setProperty(propertyName, properties.getProperty(propertyName));
                }
            }
        } catch (Exception ignored) {
        }
    }
    
}
