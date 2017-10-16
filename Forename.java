package com.michaelGV;

public class Forename {
    private static String[] forenames = {"Wilbert", "Monroe", "Dylan", "Bruno", "Tony", "Ronald", "Gordon", "Buster", "Federico", "Doyle", "Jackson", "Marlon", "Mauro", "Samuel", "Stuart", "Sidney", "Gayle", "Roy", "Elmer", "Dominick", "Normand", "Kristopher", "Jamar", "Leandro", "Myron", "Asa", "Alejandro", "Jan", "Sonny", "Barney", "Jimmie", "Jarrod", "Bryan", "Cortez", "Mason", "Taylor", "Tyler", "Clark", "Branden", "Carmine", "Garrett", "Clint", "Bradly", "Lupe", "Sydney", "Curtis", "Arturo", "Winfred", "Joel",
            "Mary", "Ed", "Clay", "Larae", "Janet", "Wynell", "Chrissy", "Lizzette", "Dorthey", "Scarlet", "Julienne", "Cassy", "Queenie", "Charline", "Doretha", "Lan", "Mirtha", "Marya", "Juliane", "Juliann", "Benita", "Meri", "Maybelle", "Dianne", "Yadira", "Pilar", "Isela", "Marybelle", "Stephane", "Roseann", "Cornelia", "Lucie", "Katelin", "Kandra", "Janeen", "Danette", "Starla", "Ashlyn", "Gayla", "Dina", "Codi", "Neomi", "Kara", "Lizbeth", "Filomena", "Bess",
            "Aaron", "Richie", "Willie", "Wes", "Vito", "Parker", "Louis", "Wayne", "Stacey", "Omar", "Jessie", "Jamey", "Felipe", "Nelson", "Burt", "Lenard", "Ward", "Stanton", "Ivory", "Fritz", "Josiah", "John", "Patricia", "Byron", "Willis", "Marvin", "Jed", "Jefferson", "Emmett", "Kerry", "Angel", "Isaiah", "Dan", "Chadwick", "Roman", "Johnson", "Victor", "Gregory", "Rufus", "Kelly", "Errol", "Leroy", "Clifton", "Bill", "Bennie", "Ivan", "Theron", "Kenton", "Xavier", "Jerome",
            "Alease", "Stephenie", "Hannelore", "Apolonia", "Shana", "Leatha", "Monica", "Angelo", "Hank", "Isidro", "Elmer", "Foster", "Wilmer", "Kenton", "Darren", "Darnell", "Jacinto", "Thomas", "Blake", "Carmelo", "Damon", "Drew", "Mckinley", "Santos", "Clement", "Oren", "Kennith", "Renato", "Jewell", "Donn", "Jay", "Vance", "Abram", "Walker", "Vince", "Cory", "Colin", "Brain", "Isaiah", "Parker", "Lane", "Federico", "Michael", "Augustine", "Mariano", "Cordell", "Dudley",
            "Mckinley", "Freeman", "Russell", "Antonia", "Nickolas", "Carmine", "Darius", "Reynaldo", "Dorsey", "Weldon", "Emmitt", "Bruce", "Ignacio", "Del", "Milo", "Reid", "Deangelo", "Man", "Lemuel", "Justin", "Guadalupe", "Phillip", "Ollie", "Denny", "Maurice", "Kelly", "Tory", "Gerardo", "Harlan", "Max", "Angel", "Van", "Scot", "Warner", "Joel", "Long", "Marcelino", "Franklin", "Everett", "Shad", "Judson", "Elbert", "Wilbur", "Jc", "Samuel", "Kenton", "Elvis", "Irwin", "Toney",
            "Kristofer", "Alfonso", "Gaston", "Josh", "Luther", "Brad", "Edison", "Tyree", "Rob", "Donn", "Gil", "Kanisha", "Corliss", "Nada", "Marjory", "Sebrina", "Bettye", "Palma", "Soila", "Verena", "Marchelle", "Gabrielle", "Dori", "Jolanda", "Georgetta", "Clarisa", "Bernice", "Santa", "Cortney", "Laureen", "Dinah", "Joleen", "Loreen", "Desirae", "Natasha", "Fern", "Bridgett", "Ernestina", "Cecile", "Kirstin", "Marylou", "Herminia", "Glenna", "Cristal", "Shiloh", "Marceline",
            "Lue", "Ophelia", "Dalia", "Rosamaria", "Tanya", "Fallon", "Leonila", "Devorah", "Ailene", "Yan", "Georgine", "Tobie", "Calandra", "Tiffaney", "Hedwig", "Lorenza", "Ute", "Lavonia", "Mikaela", "Jacquelyn", "Tisa", "Rafaela", "Estella", "Renea", "Ping", "Keturah", "Lasonya", "Angelika", "Marianna", "Elodia", "Marx", "Kaylene", "Bong", "Liliana", "Larae", "Lurlene", "Reagan", "Monica", "Terra", "Annis", "Tracie", "Annalisa", "Cecila", "Chaya", "Oralee", "Elmira", "Pok",
            "Yolanda", "Jeri", "Vallie", "Karmen", "Emogene", "Georgianne", "Marti", "Nova", "Mittie", "Julienne", "Lauran", "Eleanor", "Luisa", "Miesha", "Anjelica", "Yee", "Kassandra", "Stormy", "Luna", "Cami", "Loreen", "Fay", "Jaye", "Hermila", "Jovita", "Honey", "Venice", "Goldie", "Deja", "Blanch", "Arie", "Vergie", "Tosha", "Teisha", "Meredith", "Ladonna", "Mee", "Precious", "Minnie", "Niesha", "Nicki", "Susanne", "Nidia", "Jerrica", "Verena", "Lenna", "Tonita", "Mimi",
            "Danna", "Ilona", "Ka", "Margherita", "Taneka", "Agustina", "Kellie", "Raquel", "Lorene", "Tracie", "Melodi", "Inge", "Margrett", "Jesusa", "Sommer", "Arminda", "Velvet", "Elsie", "Lala"};

    public static String getRandomForename() {
        int ran0 = (int) (Math.random() * (forenames.length));
        return forenames[ran0];
    }

    public static void main(String[] args) {
        System.out.println(getRandomForename());
    }
}