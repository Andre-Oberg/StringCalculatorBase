/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ax.ha.it.calculator;

/**
 *
 * @author André
 */
public class LoggerStub implements Logger{

    @Override
    public void log(Integer number) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("StringCalculator.Add() was called with: "+number);
    }
    
}
