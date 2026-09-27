package mx.edu.utez.proyecto1C.controller;


import mx.edu.utez.proyecto1C.controller.dto.RequesBodyDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin({"*"}) //Todos los origenes
@RequestMapping("/my-services")
public class Mycontroller {

    @GetMapping("/servicio1/{n}")
    public String servicio1(@PathVariable int n){
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
        return "Luis Gerardo Barron Flores 4c";
    }

    @GetMapping("/servicio2/{n}")
    public String servicio2(@PathVariable int n){
        int anterior = 0, actual = 1;
        System.out.print(anterior + " " + actual);
        for (int i = 2; i <= n-1; i++) {
            int siguiente = anterior + actual;
            anterior = actual;
            actual = siguiente;
            System.out.print( " " +actual);
        }
        return "Luis Gerardo Barron Flores 4c";
    }



}


