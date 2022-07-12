package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String showGuessForm() {
        return "roll-dice";
    }

    @PostMapping("/roll-dice")
    @ResponseBody
    public String showGuess(@RequestParam(name = "guess") int guess, Model model) {
        Random random = new Random();
        int dice = random.nextInt(7-1) + 1;
        model.addAttribute("guess", "You guessed " + guess + "!");
        if (guess == dice) {
            model.addAttribute("dice", "The dice rolled on " + dice + "!" + " You win!");
        } else {
            model.addAttribute("dice", "The dice rolled on " + dice + "!" + " Better luck next time!");
        }
        return "roll-dice";
    }

}
