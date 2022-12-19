package com.example.juliasite.controllers;




import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

//    @Autowired
//    private

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("title", "Главная страница");
        model.addAttribute("date_of_Birth", "");
        model.addAttribute("numbers", "");
        model.addAttribute("fate", "");
        model.addAttribute("temperament", "");
        model.addAttribute("Character", "");
        model.addAttribute("Health", "");
        model.addAttribute("Luck", "");
        model.addAttribute("Target", "");
        model.addAttribute("Energy", "");
        model.addAttribute("Logics", "");
        model.addAttribute("Duty", "");
        model.addAttribute("Family", "");
        model.addAttribute("Interest", "");
        model.addAttribute("Work", "");
        model.addAttribute("Memory", "");
        model.addAttribute("habits", "");
        model.addAttribute("Life", "");
        return "home";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String homeSubmit(@RequestParam String data_of_b, Model model) {
        String data = (data_of_b.replace(".", "")).replace("0", "");
        int sum = 0;
        for (int i = 0; i < data.length(); i++) {
            sum += Character.getNumericValue(data.charAt(i));
        }

        int fate = 0;
        if (sum >= 10) {
            fate = (int) (sum / 10) + sum % 10;
        } else {
            fate = sum;
        }

        int num_3 = 0;
        num_3 = sum - Character.getNumericValue(data.charAt(0)) * 2;

        int num_4 = 0;
        if (num_3 >= 13) {     //if (sum >= 10) {
            num_4 = (int) (num_3 / 10) + num_3 % 10;
        } else {
            num_4 = sum;
        }


        String numbers = "" + sum + ", " + fate + ", " + num_3 + ", " + num_4;

        if (fate == 10 || fate >11){
            fate = (int) (fate / 10) + fate % 10;
        }


        String all_numb = data + sum + fate + num_3 + num_4;
        String characters = "", health = "", luck = "", energy = "", logics = "", duty = "", interest = "", work = "", memory = "";
        for (int i = 0; i < all_numb.length(); i++) {
            if (Character.getNumericValue(all_numb.charAt(i)) == 1) {
                characters += "1";
            } else if (Character.getNumericValue(all_numb.charAt(i)) == 2) {
                energy += "2";
            } else if (Character.getNumericValue(all_numb.charAt(i)) == 3) {
                interest += "3";
            } else if (Character.getNumericValue(all_numb.charAt(i)) == 4) {
                health += "4";
            } else if (Character.getNumericValue(all_numb.charAt(i)) == 5) {
                logics += "5";
            } else if (Character.getNumericValue(all_numb.charAt(i)) == 6) {
                work += "6";
            } else if (Character.getNumericValue(all_numb.charAt(i)) == 7) {
                luck += "7";
            } else if (Character.getNumericValue(all_numb.charAt(i)) == 8) {
                duty += "8";
            } else if (Character.getNumericValue(all_numb.charAt(i)) == 9) {
                memory += "9";
            }
        }
        int temperament = (interest + logics + luck).length();
        int target = (characters + health + luck).length();
        int family = (energy + logics + duty).length();
        int habits = (interest + work + memory).length();
        int life = (health + logics + work).length();

        if (characters == "") {
            characters = "Пусто";
        }
        if (energy == "") {
            energy = "Пусто";
        }
        if (interest == "") {
            interest = "Пусто";
        }
        if (health == "") {
            health = "Пусто";
        }
        if (logics == "") {
            logics = "Пусто";
        }
        if (work == "") {
            work = "Пусто";
        }
        if (luck == "") {
            luck = "Пусто";
        }
        if (duty == "") {
            duty = "Пусто";
        }
        if (memory == "") {
            memory = "Пусто";
        }


        model.addAttribute("title", "Главная страница");
        model.addAttribute("date_of_Birth", data_of_b);
        model.addAttribute("numbers", numbers);
        model.addAttribute("fate", fate);
        model.addAttribute("temperament", temperament);
        model.addAttribute("characters", characters);
        model.addAttribute("health", health);
        model.addAttribute("luck", luck);
        model.addAttribute("target", target);
        model.addAttribute("energy", energy);
        model.addAttribute("logics", logics);
        model.addAttribute("duty", duty);
        model.addAttribute("family", family);
        model.addAttribute("interest", interest);
        model.addAttribute("work", work);
        model.addAttribute("memory", memory);
        model.addAttribute("habits", habits);
        model.addAttribute("life", life);
        return "home";
    }

//    @GetMapping("/1")
//    public String home() {
//        return "index";
//    }

//    @GetMapping("/calc")
//    public String calc(Model model)
//        model.addAttribute("title", "Главная страница");
//        model.addAttribute("Date_of_Birth", "asdfg");
//        return "home";
//    }

}