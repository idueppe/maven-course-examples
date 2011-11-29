package de.crowdcode.maven.plugins.uppercase;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
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

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Goal which touches a timestamp file.
 * 
 * @goal uppercase
 * 
 * @phase process-resources
 */
public class UpperCaseMojo extends AbstractMojo {
	/**
	 * Location of the file.
	 * 
	 * @parameter expression="${project.build.directory}/upperCases"
	 * @required
	 */
	private File outputDirectory;
	
    /**
     * Directory containing resources files.
     *
     * @parameter default-value="${basedir}/src/main/resources"
     */
    private File sourceDirectory;

	public void execute() throws MojoExecutionException {
		if (!sourceDirectory.exists()) {
			throw new MojoExecutionException("Error no sourceDirectory defined!");
		}

		if (!outputDirectory.exists()) {
			outputDirectory.mkdir();
		}
		
		
		File[] sourceFiles = sourceDirectory.listFiles();
		processFiles(sourceFiles, outputDirectory);
	}
	
	public void processFiles(final File[] sourceFiles, final File directory) throws MojoExecutionException {
		for (File file : sourceFiles) {
			getLog().info("Found file "+file.getName());
			File upperFile = new File(directory,file.getName().toUpperCase());
			if (file.isDirectory()) {
				upperFile.mkdir();
				processFiles(file.listFiles(), upperFile);
			} else {
				FileWriter writer = null;
				try {
					writer = new FileWriter(upperFile);
					writer.write(upperFile.getName());
				} catch (IOException e) {
					throw new MojoExecutionException("Error creating file " + upperFile, e);
				} finally {
					if (writer != null) {
						try {
							writer.close();
						} catch (IOException e) {
							// ignore
						}
					}
				}
			}
		}
		
	}
	
}
