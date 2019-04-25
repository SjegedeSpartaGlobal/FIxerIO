package com.spartaglobal.fixerio;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        FixerServices services = new FixerServices();
        System.out.println(services.getRates().getSuccess());
    }
}
