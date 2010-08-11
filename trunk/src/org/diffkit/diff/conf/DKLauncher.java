/**
 * Copyright 2010 Joseph Panico
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.diffkit.diff.conf;

import com.jdotsoft.jarloader.JarClassLoader;

public class DKLauncher {
   private static final String TOOL_CLASS_NAME = "org.diffkit.diff.conf.DKTool";
   private static final String LOGBACK_CONFIGURATION_FILE_PROPERTY_KEY = "logback.configurationFile";
   private static final String DEFAULT_LOGBACK_CONFIGURATION_FILE_PATH = "conf/logback.xml";

   public static void main(String[] args_) {
      if (System.getProperty(LOGBACK_CONFIGURATION_FILE_PROPERTY_KEY) == null)
         System.setProperty(LOGBACK_CONFIGURATION_FILE_PROPERTY_KEY,
            DEFAULT_LOGBACK_CONFIGURATION_FILE_PATH);
      JarClassLoader jcl = new JarClassLoader();
      try {
         jcl.invokeMain(TOOL_CLASS_NAME, args_);
      }
      catch (Throwable e) {
         e.printStackTrace();
      }
   }

}
