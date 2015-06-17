package de.crowdcode.maven;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        new SayHello().say(args[0], 3);
    }
}
