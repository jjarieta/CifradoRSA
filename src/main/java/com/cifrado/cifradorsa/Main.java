/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.cifrado.cifradorsa;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.InvalidKeySpecException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author JJARRIETA
 */
public class Main {



    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        try {
            // TODO code application logic here
            //Definimos un texto a cifrar
            String str = "0310402234Jose2011111";
            
            System.out.println("\nTexto a cifrar:");
            System.out.println(str);
            
            //Instanciamos la clase
            RSA rsa = new RSA();
            
            try {
                //Generamos un par de claves
                //Admite claves de 512, 1024, 2048 y 4096 bits
                rsa.genKeyPair(4096);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchPaddingException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidKeyException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            String file_private = "/tmp/rsa.pri";
            String file_public = "/tmp/rsa.pub";
            
            //Las guardamos asi podemos usarlas despues
            //a lo largo del tiempo
            rsa.saveToDiskPrivateKey("c:/llaves/rsa.pri");
            rsa.saveToDiskPublicKey("c:/llaves/rsa.pub");
            
            //Ciframos y e imprimimos, el texto cifrado
            //es devuelto en la variable secure
         
             
            try {
                try {
             
            
                    String secure = rsa.Encrypt(str);        
                    System.out.println("\nCifrado:");
                    System.out.println(secure);
                    
                 
                    RSA rsa2 = new RSA();

                    //A diferencia de la anterior aca no creamos
                    //un nuevo par de claves, sino que cargamos
                    //el juego de claves que habiamos guadado
                    rsa2.openFromDiskPrivateKey("c:/llaves/rsa.pri");    
                    rsa2.openFromDiskPublicKey("c:/llaves/rsa.pub");

                    //Le pasamos el texto cifrado (secure) y nos 
                    //es devuelto el texto ya descifrado (unsecure) 
                    String unsecure = rsa2.Decrypt(secure);

                    //Imprimimos
                    System.out.println("\nDescifrado:");
                    System.out.println(unsecure);  
                    
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchPaddingException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidKeyException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidKeySpecException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchProviderException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            
           
            
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        
    }
    
    
}
