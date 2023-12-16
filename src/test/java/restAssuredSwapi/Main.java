package restAssuredSwapi;
import DTO.Films;
import DTO.Planets;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import java.util.Arrays;
import java.util.Scanner;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class Main{
    static String[] People  = {"Luke Skywalker", "C-3PO", "R2-D2", "Darth Vader", "Leia Organa"};
    static String[] peopleRu = {"1"+"."+"Люк Скайуокер","Luke Skywalker \n","2"+"."+"C-3PO \n", "3"+"."+"R2-D2 \n", "4"+"."+"Дарт Вейдер", "Darth Vader \n",
            "5"+"."+"Лейла Органа", "Leia Organa \n"};

    static String[] planetRu = {"1" + "." + "Татуин"," Tatooine \n", "2" + "." + "Альдераан", " Alderaan \n", "3" + "." + "Явин IV", " Yavin IV \n"
            , "4" + "." + "Хот", " Hoth", "5"+"."+"Дагоба", " Dagobah \n"};
    static String[] filmRu = {"1"+"."+"Новая надежда", "A New Hope \n", "2"+"."+"Империя наносит ответный удар", "The Empire Strikes Back \n",
            "3"+"."+"Возвращение Джедая", "Return of the Jedi \n", "4"+"."+"Скрытая угроза", "The Phantom Menace \n",
            "5"+"."+"Атака клонов", "Attack of the Clones \n", "6"+"."+"Месть ситхов", "Revenge of the Sit \n"};
    static String[] filmCheck = {"1","Новая надежда", "A New Hope ", "2","Империя наносит ответный удар", "The Empire Strikes Back",
            "3","Возвращение Джедая", "Return of the Jedi ", "4","Скрытая угроза", "The Phantom Menace ",
            "5","Атака клонов", "Attack of the Clones", "6","Месть ситхов", "Revenge of the Sit"};
    static String[] planetCheck = {"1", "Татуин"," Tatooine ", "2","Альдераан", " Alderaan", "3","Явин IV", "Yavin IV ",
            "4", "Хот", "Hoth", "5", "Дагоба", "Dagobah "};
    static String[] peopleCheck = {"1","Люк Скайуокер","Luke Skywalker","2", "C-3PO ", "3", "R2-D2", "4","Дарт Вейдер", "Darth Vader",
            "5"+"."+"Лейла Органа", "Leia Organa \n"};
    static String[] checkchoose = {"1", "characters", "Characters","CHARACTERS", "3", "films", "Films","FILMS", "2", "planets", "Planets","PLANETS", "4", "exit", "Exit","EXIT"};
    static String[] restartcheck = {"1", "2", "продолжить","Продолжить", "закончить", "Закончить"};
    static int k;
    public static void Start() {
        System.out.println("""
                Что вас интересует:
                1.Персонажи(characters)
                2.Планеты(planets)
                3.фильмы(films)
                4.выход(exit)""");
        step1();
    }

    public static void step1() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        boolean isValid = false;
        for (String data : checkchoose) {
            if (data.equalsIgnoreCase(input)) {
                isValid = true;
                break;
            }
        }
        while (!isValid) {
            System.out.println("Введенные данные некорректны. Пожалуйста, введите данные снова:");
            input = scanner.nextLine();

            for (String data : checkchoose) {
                if (data.equalsIgnoreCase(input)) {
                    isValid = true;
                    break;
                }
            }
        }
        try {
            int chose = Integer.parseInt(input);
            switch (chose) {
                case 1:
                    Character();
                    break;
                case 2:
                    planet();
                    break;
                case 3:
                    Film();
                    break;
                case 4:
                    break;
            }
        } catch (NumberFormatException e) {
            switch (input) {

                case "Персонажи":
                case "characters":
                case "Characters":
                case "CHARACTERS":
                    Character();
                    break;
                case "Планеты":
                case "planets":
                case "Planets":
                case "PLANETS":
                    planet();
                    break;
                case "Фильмы":
                case "films":
                case "Films":
                case "FILMS":
                    Film();
                    break;
                case "Выход":
                case "exit":
                case "Exit":
                case "EXIT":
                    break;

            }
        }
    }

    public static void Character() {
        System.out.print("Выберете персонажа: \n" + Arrays.toString(peopleRu) + "\n" + " 6.Выход" + "\n");
        Scanner scan = new Scanner(System.in);
        String character = scan.nextLine();

        boolean isValid = false;
        for (String data : peopleCheck) {
            if (data.equalsIgnoreCase(character)) {
                isValid = true;
                break;
            }
        }
        while (!isValid) {
            System.out.println("Введенные данные некорректны. Пожалуйста, введите данные снова:");
            character = scan.nextLine();

            for (String data : peopleCheck) {
                if (data.equalsIgnoreCase(character)) {
                    isValid = true;
                    break;
                }
            }
        }
        System.out.println("Данные загружаются");
        try {
            int number = Integer.parseInt(character);
            switch (number) {
                case 1:
                    k = 0;
                    findcharacter();
                    restart();
                    break;
                case 2:
                    k = 1;
                    findcharacter();
                    restart();
                    break;
                case 3:
                    k = 2;
                    findcharacter();
                    restart();
                    break;
                case 4:
                    k = 3;
                    findcharacter();
                    restart();
                    break;
                case 5:
                    k = 4;
                    findcharacter();
                    restart();
                    break;
                case 6:
                    break;
            }
        } catch (NumberFormatException e) {
            switch (character) {
                case "Luke Skywalker":
                case "Люк Скайуокер":
                    k = 0;
                    findcharacter();
                    restart();
                    break;
                case "C-3PO":
                    k = 1;
                    findcharacter();
                    restart();
                    break;
                case "R2-D2":
                    k = 2;
                    findcharacter();
                    restart();
                    break;
                case "Darth Vader":
                case "Дарт Вейдер":
                    k = 3;
                    findcharacter();
                    restart();
                    break;
                case "Leia Organa":
                case "Лейла Органа":
                    k = 4;
                    findcharacter();
                    restart();
                    break;
                case "Выход":
                    break;
            }
        }
    }
    public static void planet() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Выберете планету: \n" + Arrays.toString(planetRu) +"\n" + " 6.Выход" + "\n");
        String planet = scan.nextLine();

        boolean isValid = false;
        for (String data : planetCheck) {
            if (data.equalsIgnoreCase(planet)) {
                isValid = true;
                break;
            }
        }
        while (!isValid) {
            System.out.println("Введенные данные некорректны. Пожалуйста, введите данные снова:");
            planet = scan.nextLine();

            for (String data : planetCheck) {
                if (data.equalsIgnoreCase(planet)) {
                    isValid = true;
                    break;
                }
            }
        }
        System.out.println("Данные загружаются");
        try {
            int number = Integer.parseInt(planet);
            switch (number) {
                case 1:
                    k = 0;
                    findPlanet();
                    restart();
                    break;
                case 2:
                    k = 1;
                    findPlanet();
                    restart();
                    break;
                case 3:
                    k = 2;
                    findPlanet();
                    restart();
                    break;
                case 4:
                    k = 3;
                    findPlanet();
                    restart();
                    break;
                case 5:
                    k = 4;
                    findPlanet();
                    restart();
                    break;
                case 6:
                    break;


            }
        } catch (NumberFormatException e) {
            switch (planet) {
                case "Татуин":
                case "Tatooine":
                    k = 0;
                    findPlanet();
                    restart();
                    break;
                case "Альдераан":
                case "Alderaan":
                    k = 1;
                    findPlanet();
                    restart();
                    break;
                case "Явин IV":
                case "Yavin IV":
                    k = 2;
                    findPlanet();
                    restart();
                    break;
                case "Хот":
                case "Hoth":
                    k = 3;
                    findPlanet();
                    restart();
                    break;
                case "дагоба":
                case "Dagobah":
                    k = 4;
                    findPlanet();
                    restart();
                    break;
                case "Выход":
                    break;
            }
        }
    }
    public static void Film() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Выберете фильм: \n" + Arrays.toString(filmRu) +"\n" + " 7.Выход" + "\n");
        String film = scan.nextLine();
        boolean isValid = false;
        for (String data : filmCheck) {
            if (data.equalsIgnoreCase(film)) {
                isValid = true;
                break;
            }
        }
        while (!isValid) {
            System.out.println("Введенные данные некорректны. Пожалуйста, введите данные снова:");
            film = scan.nextLine();

            for (String data : filmCheck) {
                if (data.equalsIgnoreCase(film)) {
                    isValid = true;
                    break;
                }
            }
        }
        System.out.println("Данные загружаются");

        try {
            int number = Integer.parseInt(film);
            switch (number) {
                case 1:
                    k = 0;
                    findFilm();
                    restart();
                    break;
                case 2:
                    k = 1;
                    findFilm();
                    restart();
                    break;
                case 3:
                    k = 2;
                    findFilm();
                    restart();
                    break;
                case 4:
                    k = 3;
                    findFilm();
                    restart();
                    break;
                case 5:
                    k = 4;
                    findFilm();
                    restart();
                    break;
                case 6:
                    k=5;
                    findFilm();
                    restart();
                    break;
                case 7:
                    break;


            }
        } catch (NumberFormatException e) {
            switch (film) {
                case "Новая надежда":
                case "A New Hope":
                    k = 0;
                    findFilm();
                    restart();
                    break;
                case "Империя наносит ответный удар":
                case "The Empire Strikes Back":
                    k = 1;
                    findFilm();
                    restart();
                    break;
                case "Возвращение Джедая":
                case "Return of the Jedi":
                    k = 2;
                    findFilm();
                    restart();
                    break;
                case "Скрытая угроза":
                case "The Phantom Menace":
                    k = 3;
                    findFilm();
                    restart();
                    break;
                case "Атака клонов":
                case "Attack of the Clones":
                    k = 4;
                    findFilm();
                    restart();
                    break;
                case "Месть ситхов":
                case "Revenge of the Sit":
                    k = 5;
                    findFilm();
                    restart();
                    break;
                case "Выход":
                    break;
            }
        }
    }
    public static void findPlanet() {
        RestAssured.baseURI = "https://swapi.dev/api/planets/";

        Planets response = given().expect().defaultParser(Parser.JSON).
                when().
                get(baseURI).as(Planets.class);

        String planetName = response.getResults().get(k).getName();
        String climate = response.getResults().get(k).getClimate();
        String terrain = response.getResults().get(k).getTerrain();
        String population = response.getResults().get(k).getPopulation();
        System.out.println("'" + planetName + "' Climate: " + climate + ". Terrain: " + terrain + ". Population: " + population + " habitats");

    }

    public static void findcharacter()
    {
        RestAssured.baseURI = "https://swapi.dev/api/people";

        String validatableResponse = given().
                when().get(baseURI).
                then().
                assertThat().statusCode(200).
                body("results["+k+"].name", equalTo(People[k]))
                .extract().response().asPrettyString();
        JsonPath js = restAssuredSwapi.ReusableMethod.rawToJson((validatableResponse));
        String getInfo = js.getString("results["+k+"]");
        String getUrl = js.getString("results["+k+"].url");
        String getId = getUrl.substring(29, 30);

        int countFilms = js.getInt("results["+k+"].films.size()");
        int countVehicles = js.getInt("results["+k+"].vehicles.size()");
        int countStarships = js.getInt("results["+k+"].starships.size()");

        System.out.println("Summary: " + People[k] + "participate in " + countFilms +  " films, have " + countVehicles + " vehicles, " + countStarships + " starships");
        System.out.println(People[k] + " Id: " + getId);
        System.out.println(People[k] + "complete information:");
        System.out.println(getInfo);

    }
    public static void findFilm(){
        RestAssured.baseURI = "https://swapi.dev/api/films";
        Films response = given().expect().defaultParser(Parser.JSON).
                when().
                get(baseURI).as(Films.class);

        String movieTitle = response.getResults().get(k).getTitle();
        String directorName = response.getResults().get(k).getDirector();
        String producerName = response.getResults().get(k).getProducer();
        String releaseDate = response.getResults().get(k).getRelease_date();
        System.out.println("'"+movieTitle+"' directed by: "+directorName+" produced by: "+producerName+" released:"+releaseDate);


    }
    public static void restart(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("""
                1.Продолжить
                2.Закончить
                """);

        String input = scanner.nextLine();
        boolean isValid = false;
        for (String data : restartcheck) {
            if (data.equalsIgnoreCase(input)) {
                isValid = true;
                break;
            }
        }

        while (!isValid) {
            System.out.println("Введенные данные некорректны. Пожалуйста, введите данные снова:");
            input = scanner.nextLine();

            for (String data : restartcheck) {
                if (data.equalsIgnoreCase(input)) {
                    isValid = true;
                    break;
                }
            }
        }

        try {
            int number = Integer.parseInt(input);
            switch (number) {
                case 1:
                    Start();
                    break;
                case 2:

                    break;

            }
        } catch (NumberFormatException e) {
            switch (input) {
                case "Продолжить":
                    Start();
                    break;
                case "Закончить":
                    break;

            }
        }

    }
    public static void main(String[] args) {
        Start();
    }

}
