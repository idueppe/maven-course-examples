package de.crowdcode.maven.plugins.uppercase;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

/**
 * @goal message
 * 
 * @author idueppe
 *
 */
public class MessageMojo extends AbstractMojo {

	/**
	 * @parameter expression="${nachricht}" default-value="Hello World!"
	 */
	private String message;
	
	public void execute() throws MojoExecutionException, MojoFailureException {
		getLog().info(message);
	}

}
