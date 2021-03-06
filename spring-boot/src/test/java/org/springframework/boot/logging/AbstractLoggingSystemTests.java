/*
 * Copyright 2012-2014 the original author or authors.
 *
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

package org.springframework.boot.logging;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.springframework.util.StringUtils;

/**
 * Base for {@link LoggingSystem} tests.
 *
 * @author Phillip Webb
 */
public abstract class AbstractLoggingSystemTests {

	@Before
	public void deleteTempLog() {
		new File(tmpDir() + "/spring.log").delete();
	}

	@After
	public void clear() {
		System.clearProperty("LOG_FILE");
		System.clearProperty("PID");
	}

	protected final String tmpDir() {
		String path = StringUtils.cleanPath(System.getProperty("java.io.tmpdir"));
		if (path.endsWith("/")) {
			path = path.substring(0, path.length() - 1);
		}
		return path;
	}

}
