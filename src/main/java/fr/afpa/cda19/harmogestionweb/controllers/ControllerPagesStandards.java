package fr.afpa.cda19.harmogestionweb.controllers;

import fr.afpa.cda19.harmogestionweb.models.Membre;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Classe de controller liée aux pages standards (index, accessibilité, mentions légales).
 */
@Controller
public class ControllerPagesStandards {
    /**
     * Titre de la page.
     */
    public static final String TITRE_PAGE_PARAM = "titrePage";

    /**
     * Méthode d'accès à la page d'index'.
     * @param model Modèle de la page.
     * @return URI de la page.
     */
    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute(TITRE_PAGE_PARAM, "Accueil");
        return "index";
    }

    /**
     * Méthode d'accès à la page relative à l'accessibilité.
     * @param model Modèle de la page.
     * @return URI de la page.
     */
    @GetMapping("/accessibilite")
    public String accessibilite(Model model) {
        model.addAttribute(TITRE_PAGE_PARAM, "Accessibilité");
        return "accessibilite";
    }

    /**
     * Méthode d'accès à la page des mentions légales.
     * @param model Modèle de la page.
     * @return URI de la page.
     */
    @GetMapping("/mentionsLegales")
    public String mentionsLegales(Model model) {
        model.addAttribute(TITRE_PAGE_PARAM, "Mentions légales");
        return "mentionsLegales";
    }
}
