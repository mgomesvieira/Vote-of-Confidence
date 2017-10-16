package com.michaelGV;

public class Seat {
    private static String[] seats = {"Cruikshank", "Toley", "Dalkeith", "Griffin", "Abbotshade", "Fretherne", "Blakehall", "Woolreeds", "Walcott", "Cutler",
            "Bulwer Court", "Golden Ball", "Saladine", "Souberie", "Shellgrove", "Milton", "New Butt", "Godwin", "Longfellow", "Thong", "Fassetts", "Teviot",
            "Laffans", "Godington", "Sayer", "Ramsden", "Bowdell", "Forest End", "The Rocks", "Lamberton", "Clayfarm", "Perran", "Rickling", "Tuesley", "Lightermans",
            "Merstham", "Riffhams", "Burnhams", "Rushout", "Elmstead", "Bengeo", "Cole", "Sunnyside", "Mortimer", "Linsford", "Sangers", "Sheriff", "Cryers Hill",
            "High Hatch", "Lechford", "Benner", "Dodsley", "Byrne", "Harvest", "Dersingham", "Woodhatch", "Helden", "Ardingly", "Moorside", "East Thurrock", "Keightley",
            "Charlesford", "Kinnerton", "Bradbourne Vale", "Lorne", "Batford", "Tilebarn", "Shellbank", "Deep Mill", "Barclay", "Hookstone", "Tanza", "Ellice",
            "Kirkmans", "Rockdale", "Crimsworth", "Newport", "Herne", "Carholme", "Harlescott", "Allerton", "High Barn", "Hawkswood", "Steventon", "Burge End",
            "Blighton", "Tatlers", "Holtsmere End", "Pigeon", "Upper Union", "Wingrave", "Hawkins", "Greenside", "Abbottswell", "Denbeigh", "Emery Hill", "Cannons",
            "Chrisp", "Ediva", "Bonnetts", "Lower Elmstone", "Barclose", "Bread", "Praed", "Kimmeridge", "Ada", "Dryburgh", "Theodore", "Worting", "Fromer", "Parnel",
            "Sibella", "Towersey", "Gerard", "Dingwall", "Royston", "Ardgowan", "Nuttall", "Strathyre", "Upper Soldridge", "South Brook", "Norvic", "Alcester",
            "Runtley Wood", "Sumner South", "North Breach", "New Mile", "Treadgold", "Coombe Farm", "Furze Hill", "St. Audrey", "Woodger", "Lakes", "Colebrooke",
            "Lanfranc", "Eltham Church", "Rangoon", "Heatherdene", "Mays", "Hotspur", "Whomerley", "Opal", "Victoria Hill", "Cutlers", "Queenhythe", "Upper Hammer",
            "Chadwin", "Hudson", "Penyston", "Britton", "Tenor", "Limmer", "Passmore", "Kingsingfield", "Peregrine", "Willesden", "Uplees", "Kingsford", "Spiers",
            "Two Dells", "Bywater", "Upsdell", "Ver", "Waterdale", "Buck", "Blackwell", "Sandland", "Orpington", "Rosenthorpe", "Valliers Wood", "Fetcham", "Longmoore",
            "Stonenest", "Springhill", "Keinches", "Rondini", "Hendrick", "Flitwick", "Yalding", "Cathill", "Jemmett", "Great Elms", "Torver", "Perimeter", "Wheatsheaf",
            "Foden", "Stoney", "Padcroft", "Orchardleigh", "Robinwood", "Langhedge", "Jonathan", "Poynders", "Wildernesse", "Thompsons", "Walnuts", "Pegg",
            "South Birkbeck", "Penwood", "Turgis", "Bradstock", "Easterford", "Bag", "Black Pond", "Cackle", "Inglewood", "Babylon", "Langley Hall", "Frimley",
            "Woodbury Park", "Newells", "Tawney", "Flexmere", "Meadowhill", "Rutford", "Great New", "Admiralty", "Stainton", "Emu", "Convalescent", "Chopin",
            "Ticehurst", "Danson", "Melne", "Rockland", "Brett", "Crosslet", "Watcombe", "Riverpark", "Black Friars", "Marjorams", "White Cottage", "Weavers Rock",
            "Lagonda", "Furze Platt", "Bulborne", "Perrymans Farm", "Wedgewood", "Shirbutt", "Ridgmont", "Iveley", "Nesta", "Hatters", "Poltimore", "Fox", "Chapel Pond",
            "Guildford Park", "Belmont", "Crystal", "Austenwood", "Weystone", "Nottingham", "Harper", "Neatham Mill", "Spinnells", "Grapple", "Donkey", "Tate", "Dunkin",
            "Three Crowns", "Goscombs", "Thrift", "Whitfeld", "Ink Pen", "Keysham", "Hobury", "Old Redstone", "Stalisfield", "Greggs Wood", "Halt", "Chimney Pot",
            "Ashlyns", "Lambs Conduit", "Melthorne", "Dufferin", "Dunsham", "Stratfield", "Hospital High", "Thorpewood", "Choats", "Ballfield", "Fern Hill", "Sandell",
            "Rigby", "Glenville", "Albion", "Peak Hill", "Halse", "Loyalty", "Kirk", "Stubpond", "Velmead", "Springhouse", "Summerley", "Green East", "Baddow Hall",
            "Punch Bowl", "Brooklyn", "Grest South West", "Turkey", "Merle", "Davis", "Kilnwood", "Manton", "Bulwark", "Ismailia", "Glendale", "Berwyn", "Godley",
            "Hartington", "Brinsmead", "Broomgrove", "Monkswick", "Greencroft  Deans", "Morrish", "Barrie", "Tally", "Pescot", "Marcuse", "Fostall", "Bannacle Hill",
            "Keary", "Debden", "Vulcan", "Collards", "Thrift Farm", "Leaf", "Adderley", "Creasys", "Blandford", "Neale", "Goldwell", "Lorraine", "Wakehurst", "Fonthill",
            "Blakesley", "Dylan", "Keswick", "Keith Lucas", "Tawneys", "Tolworth Park", "Brain", "Remnant", "Birchington", "Luckmore", "Bartholomew", "Chattern",
            "Summerhill Burnham", "Edge Hill", "Bartram", "Calverton", "Ravel", "Gadby", "Harts", "Erskine", "Buslins", "Kelsey", "Wardwell", "Rathbone", "Sharsted",
            "Wisley", "Croston", "Charterhouse", "Laundry", "Lockington", "Telston", "Magdalene", "New Odiham", "Downs", "Cuckoo", "Gostling", "Rae", "Cottingham",
            "Turquand", "Stag Oak", "Meadway", "Swanley", "Clapham Manor", "Annardale", "Ingoldsby", "Halden", "Wedderburn", "New Writtle", "Rough", "Rosedale",
            "Pincents", "Broadford", "Mundesley", "Sheep", "Barnet", "New Waverley", "Bleakwood", "Midgley", "Clivedale", "Harecourt", "Malone", "Bowater", "Inhams",
            "St. Anns", "Lavers", "Spring Saw", "Underwood", "Leda", "Place Farm", "Moorbridge", "Hollycross", "St Clement", "Lockers Park", "Mascalls", "Winkworth",
            "Longbridge", "Ironmonger", "Somerleyton", "Hillcourt", "Bounces", "Teal", "King Coel", "High Wood", "Mayroyd", "Mill View", "St Ethelbert", "Cherrytree",
            "Bowley", "Minehurst", "Tayles Hill", "Charmfield", "Mercator", "Jansens", "Leppoc", "Buckstone", "Link", "Evershot", "Halls Hole", "Midhurst", "Silvester",
            "Elderberry", "Chauntry", "Wyld Green", "Estcots", "Manor Lea", "Coldrum", "Mount Pleasent", "Cockerell", "Aston Clinton", "Farleigh", "Swaledale",
            "Burrfield", "Telese", "Gatcombe", "Harwater", "Havengore", "South Access", "Bledlow Ridge", "Stories", "Renfrew", "Whyteleaf", "Eatington", "Harridge",
            "Stock", "Cold Norton", "Westlea", "Robert", "Doria", "Tallow", "Exton", "Penrose", "Cullesden", "Lodore", "Shernbroke", "Kendall", "Gadebridge",
            "Blackborough", "Braywick", "Corunna", "Greenfields", "Woodleigh", "Philpot", "Richard House", "Buckland", "Heysham", "North Orbital", "Wimblington",
            "Watts", "Longcrofte", "Temperance", "Dampier", "Shipley Hills", "Alders End", "Menon", "Russell Hill", "Law", "Cotleigh", "Kingsash", "Great Goodwin",
            "Fellowes", "Lower Bedfords", "Banstock", "Tylers", "Finchampstead", "Reinickendorf", "Valetta", "Bagleys", "Thackeray", "Metcalf", "Ruskin", "Knollys",
            "Stifford Clays", "Luddesdon", "Exbourne", "Binstead", "Cole Green", "Deaks", "Tylers Green", "Makepeace", "Ruth", "Dockett Eddy", "Old Kiln", "Setchell",
            "Fontaine", "Bubblestone", "Pincott", "Blawith", "Ivanhoe", "Marks", "Curtis Field", "Sandridgebury", "Beechcroft", "Milsted", "Vyner", "Hazen", "Steynton",
            "Haddon", "Snargate", "Adam", "Winfrith", "Brinkinfield", "Vange Park", "Brooks", "Nallhead", "St Jude", "Darrington", "Luckyn", "Milton Court", "Arcola",
            "Coldbridge", "Ensfield", "Caversham Park", "Hartmann", "Tintells", "Judd", "Archer", "Lesbourne", "Howes", "Gate", "Bignell", "East Duck Lees",
            "Norton Heath", "Soames", "Taranto", "Bentry", "Ox", "Danbrook", "Chaseley", "Great James", "Damien", "Dellows", "Tabard", "Pages", "Habgood", "Gataker",
            "Old Barn", "Elgin", "Bridewain", "Wincrofts", "Atkinson", "Penrhyn", "Bartlett", "Glasbrook", "Riseldine", "Allsmoor", "Waarem", "Rose Cottage", "Centenary"
    };

    public static String getSeat(int x) {
        return seats[x];
    }

    public static void main(String[] args) {
        System.out.println(getSeat(12));
    }
}
