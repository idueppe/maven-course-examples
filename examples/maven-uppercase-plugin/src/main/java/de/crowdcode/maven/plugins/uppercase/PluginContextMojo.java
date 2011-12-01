package de.crowdcode.maven.plugins.uppercase;

import java.util.Map;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.project.MavenProject;

/**
 * @goal print-context
 * 
 * @author idueppe
 *
 */
public class PluginContextMojo extends AbstractMojo {

    /**
     * @parameter expression="${project}"
     * @readonly
     */
    protected MavenProject project;
    
	public void execute() throws MojoExecutionException, MojoFailureException {
		getLog().info("Name "+project.getArtifactId());
		getLog().info("---------------------------------");
		getLog().info("Context");
		
		for(Map.Entry<String,Object> entry : ((Map<String,Object>)getPluginContext()).entrySet()) {
			try {
			getLog().info("\t"+entry.getKey()+" - "+entry.getValue().getClass().getCanonicalName());
			} catch (Exception e) {
				getLog().info("\t"+entry.getKey());
			}
		}
		
		
	}

}
