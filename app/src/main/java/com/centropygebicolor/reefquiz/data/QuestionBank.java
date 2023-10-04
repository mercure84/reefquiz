package com.centropygebicolor.reefquiz.data;

import java.util.Arrays;
import java.util.List;

public class QuestionBank {

    public List<Question> getQuestions() {

        return Arrays.asList(
                new Question("Quelle est la salinité optimale d'un aquarium récifal ?", Arrays.asList("15ppt", "35ppt", "1024ppt", "1023.5ppt"), 1),
                new Question("Quel est le nom scientifique du célèbre poisson clown Némo ?", Arrays.asList("Amphiprion frenatus", "Paracanthurus hepatus", "Premnas biaculeatus", "Amphiprion ocellaris"), 3),
                new Question("A quelle famille de poissons appartient le Zebrasoma flavescesens ?", Arrays.asList("Les poissons anges", "Les poissons coffre", "Les poissons papillons", "Les poissons chirurgiens"), 3),
                new Question("Parmi ces produits, lequel peut être utilisé pour réduire les phosphates dans l'eau de mer ?", Arrays.asList("Résine ferrique", "Buffer KH", "Sel sans sel", "Bétadine"), 0),
                new Question("Comment se reproduisent les poissons clowns ?", Arrays.asList("Ils pondent en pleine eau", "Ils pondent dans le sable", "Ils pondent sur une roche", "Ils se reproduisent par bouturage"), 2),
                new Question("Qui apprécie de vivre au contact d'une anémone ?", Arrays.asList("Les poissons clowns", "Les poissons lapins", "Les poissons faucons", "Les murènes"), 0),
                new Question("Quelle espèce d'anémone possède souvent des tentacules en forme de tétine ?", Arrays.asList("Heteractis magnifica", "Entacmea quadricolor", "Stychodactyla gigantea", "Xenia pumping"), 1),
                new Question("Quelles sont les 2 principales couleurs du Centropyge bicolor ?", Arrays.asList("Jauge et Blanc", "Rouge et Noir", "Jaune et Bleu", "Blanc et Orange"), 2),
                new Question("Quel nuisible peut être éliminé par la crevette Hymenocera picta ?", Arrays.asList("Les anémones aiptasia", "les étoiles asterinas", "les algues vallonias", "les anémones majanos"), 1),
                new Question("Quelle espèce d'escargot est la plus couramment utilisée pour nettoyer la couche de sable ?", Arrays.asList("Nassarius", "Trochus", "Tectus", "Neritina"), 0),
                new Question("Comment peut on mesurer l'intensité lumineuse ?", Arrays.asList("avec un ph-mètre", "avec une sonde redox", "avec un par-mètre", "avec un thermomètre"), 2),
                new Question("Quelle espèce nécessite la détention d'un certificat de capacité pour être maintenu en aquarium en France ?", Arrays.asList("Lactoria cornuta", "Pterois volitans", "Neocirrithes armatus", "Pomacanthus asfur"), 1),
                new Question("Parmin ces espèces, laquelle peut manger les anémones de verre Aiptasias ?", Arrays.asList("Acreichthys tomentosus", "Labroides dimidiatus", "Chrysiptera talboti", "Pseudocheilinus hexataenia"), 0),
                new Question("Quel corail n'est pas un LPS ?", Arrays.asList("Caulastrea", "Catalaphyllia", "Acanthastrea", "Xenia"), 3),
                new Question("A quoi servent les biopellets dans un aquariums récifal ?", Arrays.asList("A chauffer l'eau", "A réduire nitrates et phosphates", "A soigner la maladie des points blancs", "A éliminer les majanos"), 1),
                new Question("Quelle espèce de poisson est la plus grande à l'âge adulte ?", Arrays.asList("Synchiropus picturatus", "Centropyge flavissima", "Pomacanthus paru", "Pseudochromis flavivertex"), 2),
                new Question("Qu'appelle-t-on couremment le turn over d'un bac ?", Arrays.asList("Le nombre de poissons morts qu'il faut remplacer chaque mois", "Le volume d'eau qu'il faut changer chaque semaine", "Le débit quotidien d'une pompe doseuse", "Le nombre de fois par heure où le volume du bac passe par la filtration"), 3),
                new Question("Quel corail contient une toxine particulière dangereuse ?", Arrays.asList("Xenia pumping", "Euphyllia glabrescens dragonsoul", "Zoanthus", "Acropora pikachu"), 2),
                new Question("Quel outil permet couramment de mesure la salinité de l'eau ?", Arrays.asList("Un thermomètre", "Une épuisette à mailles fines", "Un densimètre", "Un PAR-mètre"), 2),
                new Question("Quelle est la conductivité idéale de l'eau osmosée ? ", Arrays.asList("0µs/cm", "500µs/cm", "50ms/cm", "Aucune réponse ne convient"), 0),
                new Question("Quel animal est couramment utilisé pour manger les algues bulles vallonias ?", Arrays.asList("Chelmon rostratus", "Mithrax sculptus", "Cypraea moneta", "Lysmata amboinensis"), 1),
                new Question("Quelle crevette aime déparasiter les pensionnaires de l'aquarium récifal ?", Arrays.asList("Lysmata amboinensis", "Hymenocera picta", "Stenopus hispidus", "Odontodactylus scyllarus"), 0),
                new Question("Quelle est la particularité des vers de feu ?", Arrays.asList("Ils ont une morsure brûlante", "Ils chauffent l'eau de l'aquarium", "Leurs poils sont urticants", "Ils peuvent vivre en eau douce"), 2),
                new Question("Quel appareil est particulièrement efficace pour retirer les sédiments en suspension dans l'eau ?", Arrays.asList("Un écumeur", "Un filtre à papier", "Un osmolateur", "Un réacteur à calcium"), 1),
                new Question("Qu'est ce qu'un SPS ?", Arrays.asList("Un corail mou", "Un corail dur à longs polypes", "Un corail dur à petits polypes", "Un détritivore"), 2),
                new Question("Quelle est la signification du S dans LPS ?", Arrays.asList("Skeleton", "Stars", "Stony", "Situation"), 2),
                new Question("Parmi ces coraux, lequel est un SPS ?", Arrays.asList("Zoanthus", "Heliofungia", "Pavona", "Sarcophyton"), 2),
                new Question("Comment reconnaît-on la femelle dans un couple de poissons clowns ?", Arrays.asList("Elle est plus grande que le mâle", "Elle est plus petite que le mâle", "Elle est de couleur rose", "Elle a des nageoires transparentes"), 0),
                new Question("Quelle est la taille adulte de Paracanthurs hepatus (alias Dory dans le film Nemo) ?", Arrays.asList("4cm", "12cm", "25cm", "70cm"), 2),
                new Question("Quel est le rôle d'un écumeur dans un aquarium récifal ?", Arrays.asList("Filtrer l'eau pour éliminer les algues", "Contrôler la température de l'eau", "Enrichir l'eau en nutriments", "Éliminer les substances organiques dissoutes"), 3)

        );

    }

    private static QuestionBank instance;
    public static QuestionBank getInstance(){
        if(instance == null){
            instance = new QuestionBank();
        }
        return instance;
    }

}
