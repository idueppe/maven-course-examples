/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.crowdcode.maven;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author idueppe
 */
public class SayHello {
    
    public void say(String name, int times) {
        for (int i = 0; i < times; i++)
            System.out.println("Hello "+name);
        List<String> string = new ArrayList<>();
    }
    
}
