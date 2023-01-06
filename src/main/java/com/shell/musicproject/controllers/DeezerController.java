package com.shell.musicproject.controllers;

import com.shell.musicproject.services.DeezerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DeezerController {
    @Autowired
    private DeezerService deezerService;
    @GetMapping("/getArtist")
    @ResponseBody
    public ModelAndView getArtistFromDeezer(@RequestParam(defaultValue = "test") String name, Model model) {
        model.addAttribute("name", name);
        deezerService.getArtists(name);
        return new ModelAndView("name.html");
    }
}
