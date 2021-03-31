/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon.inicio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author crist
 */
public class ProgramaUno {

    public static void main(String[] args) {
        try {
            FileReader lector = new FileReader(System.getProperty("user.dir") + "/codigo.txt");
            BufferedReader buffer = new BufferedReader(lector);
            int estado = 1;
            int lineas = 0;
            for (int caracter = 0; caracter != -1; caracter = buffer.read()) {
                try {
                    for (caracter = buffer.read(); caracter != '\n'; caracter = buffer.read()) {
                        switch (estado) {
                            case 1:
                                if (caracter == 'a') {
                                    estado = 2;
                                } else if (caracter == 'b') {
                                    estado = 3;
                                } else {
                                    throw new Exception("caracter no soportado");
                                }
                                break;
                            case 2:
                                if (caracter == 'a') {
                                    estado = 2;
                                } else if (caracter == 'b') {
                                    estado = 4;
                                } else {
                                    throw new Exception("caracter no soportado");
                                }
                                break;
                            case 3:
                                if (caracter == 'a') {
                                    estado = 2;
                                } else if (caracter == 'b') {
                                    estado = 3;
                                } else {
                                    throw new Exception("caracter no soportado");
                                }
                                break;
                            case 4:
                                if (caracter == 'a') {
                                    estado = 3;
                                } else if (caracter == 'b') {
                                    estado = 5;
                                } else {
                                    throw new Exception("caracter no soportado");
                                }
                                break;
                            case 5:
                                if (caracter == 'a') {
                                    estado = 2;
                                } else if (caracter == 'b') {
                                    estado = 3;
                                } else {
                                    throw new Exception("caracter no soportado");
                                }
                                break;
                        }
                    }
                    if (estado == 5) {
                        System.out.println("variable valida linea:" + (lineas + 1));
                    } else {
                        System.out.println("variable no valida linea:" + (lineas + 1));
                    }
                } catch (Exception e) {
                    System.out.println("caracter invalido linea:" + (lineas + 1));
                }
                estado = 1;
                lineas++;
            }
            buffer.close();
            lector.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProgramaUno.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProgramaUno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
