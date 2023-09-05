package com.gopenux.myanimelist.data.provider;

import android.net.Uri;

import com.gopenux.myanimelist.data.model.AnimeModel;

import java.util.ArrayList;
import java.util.List;

public class AnimeListProvider implements IAnimeListProvider{

    private final List<AnimeModel> animeList = new ArrayList<>();

    public List<AnimeModel> getAnimeList() {
        animeList.add(0,
                new AnimeModel(
                        "Cowboy Bebop", "En este anime, el director Shinichiro " +
                        "Watanabe nos narra las aventuras de Spike, Faye, Jet Black, Ed y Ein... " +
                        "Un grupo muy peculiar de caza-recompensas que viaja a través del sistema " +
                        "solar en la nave Bebop. Balas, emoción y diversión se encuentran en cada " +
                        "una de sus sesiones autoconclusivas, las cuales los llevarán a enfrentar a " +
                        "un gran adversario y viejo amigo de Spike.",
                        Uri.parse("https://cdn.myanimelist.net/images/anime/4/19644.jpg")));
        animeList.add(1,
                new AnimeModel(
                        "Naruto",
                        "Pasados dos años y medio de entrenamiento con Jiraiya, Naruto " +
                                "Uzumaki regresa a la aldea oculta de la hoja, donde se reúne con sus " +
                                "viejos amigos y conforma de nuevo el Equipo 7. Debido a la ausencia " +
                                "de Sasuke, aparece un nuevo personaje llamado Sai el cual retoma su " +
                                "lugar. En esta secuela podremos notar como los compañeros de Naruto " +
                                "han madurado con respecto a su desempeño previo, mejorando la mayoría " +
                                "de estos en su nivel. Durante su entrenamiento con Jiraiya, Naruto " +
                                "aprendió a controlar un poco de la chacra del Kyubi. Lo contrario a " +
                                "la serie original, dónde sólo desempeñó un papel secundario, " +
                                "la organización Akatsuki asume el papel antagónico principal en " +
                                "Naruto Shippuden, buscando como objetivo principal el capturar a " +
                                "todos los poderosos monstruos Biju.",
                        Uri.parse("https://cdn.myanimelist.net/images/anime/13/17405.jpg")
                ));

        animeList.add(2,
                new AnimeModel(
                        "Monster",
                        "Kensou Tenma, un reconocido medico cirujano de origen japonés que vive " +
                                "en Alemania está apunto de experimentar una historia que le cambiará la " +
                                "vida : en el año 1986 en Dusseldorf mientras se preparaba para operar a una" +
                                " personalidad que llegaba en estado crítico, una pareja de niños también " +
                                "llegaba al hospital; la niña se encontraba en estado de shock y el niño " +
                                "estaba grave con una herida de bala en la cabeza. Debatiéndose entre lo más " +
                                "ético y en la moral, Tenma accede a operar al niño yendo en contra de sus " +
                                "superiores lo que le acarrearía problemas ya que con la muerte del paciente " +
                                "anterior, los directivos del hospital se encargaran de arruinar su reputacion...",
                        Uri.parse("https://cdn.myanimelist.net/images/anime/10/18793.jpg")
                ));

        animeList.add(3,
                new AnimeModel(
                        "One Piece",
                        "Una historia épica de piratas, donde narra la historia de \"Monkey D. Luffy\" " +
                                "quien cuado tenia 7 años, comió accidentalmente una \"Akuma no mi\"(Futa del diablo) " +
                                "la cual le dio poderes de goma. Por otra parte \"Gol D. Roger\" conocido como " +
                                "\"El rey de los Piratas\" quien fuera ejecutado por la Marine, habló antes " +
                                "de morir, acerca de su famoso tesoro \"One Piece\" escondido en la \"Gran line\". " +
                                "Esta noticia desato la gran era de la piratas lanzando a incontables piratas" +
                                " a ese lugar, en busca de \"One Piece\" el tesoro perdido. Diez años después, " +
                                "Luffy inspirado en \"Gol D. Roger\" y un pirata de nombre Akagami no Shanks " +
                                "(Shanks el pelirrojo) se convierte en pirata deseando ser el próximo \"Rey de los Piratas\"" +
                                " y zarpar para conocer amigos y tener aventuras con ellos, teniendo como meta " +
                                "encontrar el \"One Piece\".",
                        Uri.parse("https://img.youtube.com/vi/l_98K4_6UQ0/maxresdefault.jpg")
                ));

        animeList.add(4,
                new AnimeModel(
                        "Yu Yu Hakusho",
                        "Yusuke Urameshi, un chico de catorce años un poco gamberro es atropellado " +
                                "por un coche cuando intentaba salvar la vida de un niño pequeño. Al ser " +
                                "atropellado, no sobrevive y muere. Entonces es cuando Botan le dice que su " +
                                "muerte no estaba prevista asi que no va ni al cielo ni al infierno, por lo " +
                                "cual se queda en la tierra como fantasma. Botan le dice de hacer una prueba" +
                                " para volver a la vida, la consigue superar y entonces es cuando le encomiendan " +
                                "la tarea de ser detective espiritual, con lo cual tendrá que resolver varios " +
                                "casos utilizando poderes espirituales que le dan.",
                        Uri.parse("https://cdn.myanimelist.net/images/anime/8/25152l.jpg")
                ));

        animeList.add(5,
                new AnimeModel(
                        "Inuyasha",
                        "Los esbirros de Naraku trataran de rebelarse en contra de el ahora que" +
                                " ha perdido su corazón, pero Naraku tiene todo bajo control y no caerá tan " +
                                "fácilmente. Seshomaru busca dejar su ambición por las espadas de su padre en " +
                                "busca de su propia arma, al mismo tiempo el corazón de Inuyasha sigue en la " +
                                "cuerda floja entre Kagome y Kikyo, al mismo tiempo que intenta protegerlas " +
                                "a las dos, por su parte Kikyo intenta completar la perla para purificarla " +
                                "junto con Naraku, Miroku y Sango tomarán difíciles decisiones impulsadas por " +
                                "su amor.",
                        Uri.parse("https://cdn.myanimelist.net/images/anime/4/81393l.jpg")
                ));

        animeList.add(6,
                new AnimeModel(
                        "Shingeki no Kyojin",
                        "a historia nos traslada a un mundo en el que la humanidad estuvo a punto " +
                                "de ser exterminada cientos de años atrás por los gigantes. Los gigantes son " +
                                "enormes, parecen no ser inteligentes y devoran seres humanos. Lo peor es que " +
                                "parece que lo hacen por placer y no por alimentarse. Una pequeña parte de la " +
                                "humanidad ha conseguido sobrevivir protegiéndose en una ciudad con unos " +
                                "altísimos muros, más altos que el mayor de los gigantes. La ciudad vive su " +
                                "vida tranquila, y hace más de 100 años que ningún gigante aparece por allí. " +
                                "Eren y su hermana adoptiva Mikasa son todavía unos adolescentes cuando ven " +
                                "algo horroroso: un gigante mucho mayor que todos los que la humanidad había " +
                                "conocido hasta el momento está destruyendo los muros de la ciudad. No pasa " +
                                "mucho tiempo hasta que los gigantes entran por el hueco abierto",
                        Uri.parse("https://cdn.myanimelist.net/images/anime/10/47347l.jpg")
                ));

        animeList.add(7,
                new AnimeModel(
                        "Neon Genesis Evangelion",
                        "Según cuentan los libros de historia, el 13 de Septiembre del 2000, un " +
                                "enorme meteorito chocó contra la Antártida, causando el derretimiento del " +
                                "Polo Sur y la consecuente inundación y destrucción de todas las ciudades costeras." +
                                " A este evento crucial se lo denomino Segundo Impacto -El primero fue el que " +
                                "destruyó a los dinosaurios-. La Tierra atravesó luego de ello un estado de " +
                                "crisis y catástrofes naturales y más de mitad de la población humana murió. " +
                                "Han pasado 15 años desde el Segundo Impacto cuando Tokyo-3, es atacada por " +
                                "un misterioso ser orgánico gigante, sin embargo esto no parece ser una " +
                                "sorpresa para un selecto grupo de gente de una organización de la ONU llamada NERV. " +
                                "Ellos se refieren al enemigo como \"Tercer Ángel\" y han desarrollado unos " +
                                "enigmáticos robots gigantes llamados EVA con una particularidad, solo pueden " +
                                "ser piloteados por jóvenes de 14 años con caracteristicas no del todo claras.",
                        Uri.parse("https://cdn.myanimelist.net/images/anime/7/74975l.jpg")
                ));

        animeList.add(8,
                new AnimeModel(
                        "Kimetsu no Yaiba",
                        "Estamos en la era Taisho de Japón. Tanjiro, un joven que se gana la vida " +
                                "vendiendo carbón, descubre un día que su familia ha sido asesinada por un demonio. " +
                                "Para empeorar las cosas, su hermana menor Nezuko, la única superviviente de" +
                                " la masacre, ha sufrido una transformación en demonio. Destrozado por los " +
                                "acontecimientos Tanjiro decide convertirse en un cazador de demonios para " +
                                "poder devolver a su hermana a la normalidad y matar al demonio que masacró " +
                                "a su familia.",
                        Uri.parse("https://cdn.myanimelist.net/images/anime/1286/99889.jpg")
                ));

        animeList.add(9,
                new AnimeModel(
                        "Full Metal Alchemist Brotherhood",
                        "En el país de Ametris, Edward Elric y Alphonse viven en el pueblo rural " +
                                "de Resembool con su madre Trisha, mientras que tratan con la alquimia de " +
                                "autoaprendizaje a una edad temprana. Cuando los hermanos cometen el acto " +
                                "tabú de la Transmutación Humana, buscan resucitar a Trisha después de que " +
                                "muere de enfermedad, fracasa y sufren las consecuencias.",
                        Uri.parse("https://cdn.myanimelist.net/images/anime/7/74317.jpg")
                ));

        return animeList;
    }
}
