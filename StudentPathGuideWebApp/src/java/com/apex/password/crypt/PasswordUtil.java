/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apex.password.crypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author JREscert
 */

public class PasswordUtil {
   
    public static String hashPassword(String plainPassword) throws NoSuchAlgorithmException{

           MessageDigest md = MessageDigest.getInstance("SHA-256");
           byte[] hashedBytes = md.digest(plainPassword.getBytes());
           
           //converts bytes to hex string
           StringBuilder sb = new StringBuilder();
           
           for(byte b : hashedBytes){
               sb.append(String.format("%02x",b));
               
           }
           return sb.toString();
      
    }
   
    
}
