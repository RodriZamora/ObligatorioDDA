/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author ASUS
 */
public class RestauranteException extends Exception {

    public RestauranteException(String message) {
        super(message);
    }

    public RestauranteException(String message, Throwable cause) {
        super(message, cause);
    }

    public RestauranteException(Throwable cause) {
        super(cause);
    }

}
