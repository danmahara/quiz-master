package com.example.quizmaster;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.widget.ExpandableListView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//
//public class MainActivity extends AppCompatActivity {
//
//    private ListView categoryListView;
//    private List<Category> categoryList;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        categoryListView = findViewById(R.id.categoryListView);
//
//        // Initialize the list to hold categories
//        categoryList = new ArrayList<>();
//
//        // Create categories
//        Category geography = new Category("Geography");
//        Category science = new Category("Science");
//        Category literature = new Category("Literature");
//        Category history = new Category("History");
//        Category nepalHistory = new Category("Nepal History");
//        Category slogan = new Category("Slogan");
//        Category carSlogan = new Category("Car Slogan");
//
//
//        // Create questions for Geography
//        geography.addQuestion(new Question("What is the capital of France?", shuffleOptions(new String[]{"Berlin", "Madrid", "Paris", "Rome"}), "Paris"));
//        geography.addQuestion(new Question("Which is the largest country by land area?", shuffleOptions(new String[]{"Russia", "Canada", "USA", "China"}), "Russia"));
//
//        // Example of Nepal Geography Quiz Questions
//        geography.addQuestion(new Question("What is the capital city of Nepal?", shuffleOptions(new String[]{"Kathmandu", " Pokhara ", "Lalitpur", "Biratnagar"}), "Kathmandu"));
//        geography.addQuestion(new Question("Which river is the longest in Nepal?", shuffleOptions(new String[]{"Koshi", "Ganga", "Brahmaputra", "Gandak"}), "Koshi"));
//        geography.addQuestion(new Question("Which is the highest peak in Nepal?", shuffleOptions(new String[]{"Mount Everest", "Kanchenjunga", "Makalu", "Lhotse"}), "Mount Everest"));
//        geography.addQuestion(new Question("Which national park in Nepal is known for its Bengal tiger population?", shuffleOptions(new String[]{"Chitwan National Park", "Sagarmatha National Park", "Bardia National Park", "Langtang National Park"}), "Chitwan National Park"));
//        geography.addQuestion(new Question("In which part of Nepal is the Annapurna range located?", shuffleOptions(new String[]{"Central Nepal", "Eastern Nepal", "Western Nepal", "Northern Nepal"}), "Western Nepal"));
//        geography.addQuestion(new Question("Which is the longest highway in Nepal?", shuffleOptions(new String[]{"Prithvi Highway", "Araniko Highway", "Mahendra Highway", "Mid-Hill Highway"}), "Mahendra Highway"));
//        geography.addQuestion(new Question("Which is the smallest district in Nepal by area?", shuffleOptions(new String[]{"Bhaktapur", "Kathmandu", "Manang", "Pokhara"}), "Bhaktapur"));
//        geography.addQuestion(new Question("What is the main source of water for Nepal’s rivers?", shuffleOptions(new String[]{"Monsoon rains", "Melting glaciers", "Underground springs", "Snowfall"}), "Melting glaciers"));
//        geography.addQuestion(new Question("Which mountain range divides Nepal into two parts?", shuffleOptions(new String[]{"Himalayas", "Shivalik Hills", "Tibetan Plateau", "Aravalli Range"}), "Himalayas"));
//        geography.addQuestion(new Question("Which is the largest lake in Nepal?", shuffleOptions(new String[]{"Rara Lake", "Phewa Lake", "Begnas Lake", "Shey Phoksundo Lake"}), "Rara Lake"));
//
//        // Science Questions
//        science.addQuestion(new Question("What is the chemical symbol for water?", shuffleOptions(new String[]{"O2", "H2O", "CO2", "O3"}), "H2O"));
//        science.addQuestion(new Question("What is the speed of light?", shuffleOptions(new String[]{"3x10^8 m/s", "3x10^5 m/s", "3x10^7 m/s", "3x10^9 m/s"}), "3x10^8 m/s"));
//
//        // Literature Questions
//        literature.addQuestion(new Question("Who wrote Pride and Prejudice?", shuffleOptions(new String[]{"Emily Brontë", "Charles Dickens", "Jane Austen", "George Eliot"}), "Jane Austen"));
//        literature.addQuestion(new Question("In Moby-Dick, what is the name of Captain Ahab's ship?", shuffleOptions(new String[]{"The Pequod", "The Beagle", "The Nautilus", "The Hispaniola"}), "The Pequod"));
//        literature.addQuestion(new Question("Who is the author of the play Hamlet?", shuffleOptions(new String[]{"William Shakespeare", "Christopher Marlowe", "John Milton", "Geoffrey Chaucer"}), "William Shakespeare"));
//        literature.addQuestion(new Question("In George Orwell's 1984, what is the name of the totalitarian party?", shuffleOptions(new String[]{"Big Brother", "The Brotherhood", "The Party", "The Ministry"}), "The Party"));
//        literature.addQuestion(new Question("What is the title of J.R.R. Tolkien's prelude to The Lord of the Rings?", shuffleOptions(new String[]{"The Two Towers", "The Hobbit", "The Return of the King", "The Silmarillion"}), "The Hobbit"));
//        literature.addQuestion(new Question("Which novel begins with the line, 'Call me Ishmael'?", shuffleOptions(new String[]{"The Great Gatsby", "Moby-Dick", "Pride and Prejudice", "The Odyssey"}), "Moby-Dick"));
//        literature.addQuestion(new Question("Who wrote the dystopian novel Brave New World?", shuffleOptions(new String[]{"Aldous Huxley", "George Orwell", "Ray Bradbury", "Margaret Atwood"}), "Aldous Huxley"));
//        literature.addQuestion(new Question("In To Kill a Mockingbird, who is the father of Scout Finch?", shuffleOptions(new String[]{"Atticus Finch", "Tom Robinson", "Boo Radley", "Dill Harris"}), "Atticus Finch"));
//        literature.addQuestion(new Question("Who wrote the epic poem The Iliad?", shuffleOptions(new String[]{"Homer", "Virgil", "Sophocles", "Ovid"}), "Homer"));
//        literature.addQuestion(new Question("What is the name of Sherlock Holmes's loyal friend and assistant?", shuffleOptions(new String[]{"Dr. John Watson", "Inspector Lestrade", "Professor Moriarty", "Mycroft Holmes"}), "Dr. John Watson"));
//
//        // Slogan Quiz Questions
//        slogan.addQuestion(new Question("Which company uses the slogan 'Just Do It'?", shuffleOptions(new String[]{"Nike", "Adidas", "Puma", "Reebok"}), "Nike"));
//        slogan.addQuestion(new Question("Which brand is known for the slogan 'Think Different'?", shuffleOptions(new String[]{"Apple", "Microsoft", "Samsung", "Sony"}), "Apple"));
//        slogan.addQuestion(new Question("Which car company uses the slogan 'The Ultimate Driving Machine'?", shuffleOptions(new String[]{"BMW", "Audi", "Mercedes-Benz", "Lexus"}), "BMW"));
//        slogan.addQuestion(new Question("Which fast food chain uses the slogan 'I'm Lovin' It'?", shuffleOptions(new String[]{"McDonald's", "Burger King", "KFC", "Wendy's"}), "McDonald's"));
//        slogan.addQuestion(new Question("Which company uses the slogan 'Red Bull Gives You Wings'?", shuffleOptions(new String[]{"Red Bull", "Monster", "Rockstar", "Pepsi"}), "Red Bull"));
//
//        // Car Slogan Quiz Questions
//        carSlogan.addQuestion(new Question("Which car brand uses the slogan 'The Ultimate Driving Machine'?", shuffleOptions(new String[]{"BMW", "Audi", "Mercedes-Benz", "Lexus"}), "BMW"));
//        carSlogan.addQuestion(new Question("Which car brand uses the slogan 'Find New Roads'?", shuffleOptions(new String[]{"Chevrolet", "Ford", "Toyota", "Honda"}), "Chevrolet"));
//        carSlogan.addQuestion(new Question("Which car brand uses the slogan 'Vorsprung Durch Technik'?", shuffleOptions(new String[]{"Audi", "BMW", "Mercedes-Benz", "Porsche"}), "Audi"));
//        carSlogan.addQuestion(new Question("Which car brand uses the slogan 'Let's Go Places'?", shuffleOptions(new String[]{"Toyota", "Honda", "Nissan", "Ford"}), "Toyota"));
//        carSlogan.addQuestion(new Question("Which car brand uses the slogan 'Go Further'?", shuffleOptions(new String[]{"Ford", "Chevrolet", "Dodge", "Jeep"}), "Ford"));
//        carSlogan.addQuestion(new Question("Which car brand uses the slogan 'Because Driving Matters'?", shuffleOptions(new String[]{"Mazda", "Toyota", "Honda", "Ford"}), "Mazda"));
//        carSlogan.addQuestion(new Question("Which car brand uses the slogan 'The Power of Dreams'?", shuffleOptions(new String[]{"Honda", "Toyota", "Nissan", "Kia"}), "Honda"));
//        carSlogan.addQuestion(new Question("Which car brand uses the slogan 'Innovation That Excites'?", shuffleOptions(new String[]{"Nissan", "Ford", "Toyota", "Hyundai"}), "Nissan"));
//        carSlogan.addQuestion(new Question("Which car brand uses the slogan 'Go Like a Pro'?", shuffleOptions(new String[]{"Chevrolet", "Ford", "Honda", "Toyota"}), "Chevrolet"));
//        carSlogan.addQuestion(new Question("Which car brand uses the slogan 'Built Ford Tough'?", shuffleOptions(new String[]{"Ford", "Chevrolet", "Ram", "Toyota"}), "Ford"));
//
//        // Nepal History Quiz Questions
//        nepalHistory.addQuestion(new Question("Who was the first King of unified Nepal?", shuffleOptions(new String[]{"Prithvi Narayan Shah", "Tribhuvan", "Birendra", "Rana Bahadur Shah"}), "Prithvi Narayan Shah"));
//        nepalHistory.addQuestion(new Question("In which year did Nepal become a republic?", shuffleOptions(new String[]{"2008", "1990", "1951", "2001"}), "2008"));
//        nepalHistory.addQuestion(new Question("Which treaty was signed between Nepal and the British East India Company in 1815?", shuffleOptions(new String[]{"Sugauli Treaty", "Tibet Treaty", "Treaty of Peace", "Nepal-Britain Treaty"}), "Sugauli Treaty"));
//        nepalHistory.addQuestion(new Question("Who was the first female Prime Minister of Nepal?", shuffleOptions(new String[]{"Sahana Pradhan", "Binda Pandey", "Chandrika Bhandari", "Khadga Prasad Sharma Oli"}), "Sahana Pradhan"));
//        nepalHistory.addQuestion(new Question("In which year did Nepal become a monarchy?", shuffleOptions(new String[]{"1768", "1799", "1816", "1846"}), "1768"));
//        nepalHistory.addQuestion(new Question("Who was the founder of the Shah dynasty in Nepal?", shuffleOptions(new String[]{"Prithvi Narayan Shah", "Rana Bahadur Shah", "Junga Bahadur", "Bishweshwar Prasad Koirala"}), "Prithvi Narayan Shah"));
//        nepalHistory.addQuestion(new Question("Which movement led to the end of the Rana regime in Nepal?", shuffleOptions(new String[]{"1951 Revolution", "1990 People's Movement", "2006 Jana Andolan", "2008 Revolution"}), "1951 Revolution"));
//        nepalHistory.addQuestion(new Question("When did the Rana regime officially end?", shuffleOptions(new String[]{"1951", "1990", "1959", "2001"}), "1951"));
//        nepalHistory.addQuestion(new Question("Who was the first King of Nepal after the Shah dynasty?", shuffleOptions(new String[]{"Prithvi Narayan Shah", "King Tribhuvan", "King Birendra", "King Gyanendra"}), "King Tribhuvan"));
//        nepalHistory.addQuestion(new Question("What year did the first democratic election take place in Nepal?", shuffleOptions(new String[]{"1959", "1990", "2001", "1951"}), "1959"));
//
//
//        // Add categories to the list
//        categoryList.add(geography);
//        categoryList.add(science);
//        categoryList.add(literature);
//        categoryList.add(history);
//        categoryList.add(slogan);
//        categoryList.add(carSlogan);
//        categoryList.add(nepalHistory);
//
//
//        // Set the adapter to the ListView
//        CategoryAdapter adapter = new CategoryAdapter(this, categoryList);
//        categoryListView.setAdapter(adapter);
//
//
//        categoryListView.setOnItemClickListener((parent, view, position, id) -> {
//            Category selectedCategory = categoryList.get(position);
//
//            // Use an Intent to pass the selected category to QuestionListActivity
//            Intent intent = new Intent(this, QuestionListActivity.class);
//            intent.putExtra("CATEGORY", selectedCategory);
//
//            // Start the QuestionListActivity
//            startActivity(intent);
//        });
//
//    }
//

//
//}
public class MainActivity extends AppCompatActivity {

    private ExpandableListView expandableListView;
    private CustomExpandableListAdapter expandableListAdapter;
    private List<Category> categoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandableListView = findViewById(R.id.categoryExpandableListView);

        // Initialize categories and subcategories
        categoryList = new ArrayList<>();

        Category geography = new Category("Geography");
        Category science = new Category("Science");
        Category history = new Category("History");
        Category technology=new Category("Technology");

        categoryList.add(geography);
        categoryList.add(science);
        categoryList.add(history);
        categoryList.add(technology);


        SubCategory countries = new SubCategory("Countries Related");
        SubCategory physics = new SubCategory("Physics");
        SubCategory chemistry = new SubCategory("Chemistry");
        SubCategory nepal = new SubCategory("Nepal");
        SubCategory technologyAll=new SubCategory("All");


        geography.addSubcategory(countries);
        science.addSubcategory(physics);
        science.addSubcategory(chemistry);
        history.addSubcategory(nepal);
        technology.addSubcategory(technologyAll);


        countries.addQuestion(new Question("What is the capital of France?", shuffleOptions(new String[]{"Paris", "London", "Berlin", "Madrid"}), "Paris"));
        countries.addQuestion(new Question("Which is the largest country in the world?", shuffleOptions(new String[]{"Russia", "Canada", "China", "Usa"}), "Russia"));

        countries.addQuestion(new Question("What is the capital of Japan?",
                shuffleOptions(new String[]{"Tokyo", "Osaka", "Kyoto", "Hiroshima"}), "Tokyo"));

        countries.addQuestion(new Question("Which country has the largest population in the world?",
                shuffleOptions(new String[]{"China", "India", "USA", "Indonesia"}), "China"));

        countries.addQuestion(new Question("Which is the largest country in the world by land area?",
                shuffleOptions(new String[]{"Russia", "Canada", "USA", "China"}), "Russia"));

        countries.addQuestion(new Question("What is the capital of Australia?",
                shuffleOptions(new String[]{"Sydney", "Melbourne", "Canberra", "Brisbane"}), "Canberra"));

        countries.addQuestion(new Question("Which country is known as the Land of the Rising Sun?",
                shuffleOptions(new String[]{"Japan", "China", "Thailand", "Vietnam"}), "Japan"));

        countries.addQuestion(new Question("Which country is the Eiffel Tower located in?",
                shuffleOptions(new String[]{"France", "Germany", "Italy", "Spain"}), "France"));

        countries.addQuestion(new Question("What is the official language of Brazil?",
                shuffleOptions(new String[]{"Portuguese", "Spanish", "English", "French"}), "Portuguese"));

        countries.addQuestion(new Question("Which country has the longest river in the world, the Nile?",
                shuffleOptions(new String[]{"Egypt", "Sudan", "Kenya", "Ethiopia"}), "Egypt"));

        countries.addQuestion(new Question("Which country is home to the Great Barrier Reef?",
                shuffleOptions(new String[]{"Australia", "USA", "Mexico", "Philippines"}), "Australia"));
        countries.addQuestion(new Question("What is the capital of Canada?",
                shuffleOptions(new String[]{"Ottawa", "Toronto", "Vancouver", "Montreal"}), "Ottawa"));

        countries.addQuestion(new Question("Which country is known for the Pyramids of Giza?",
                shuffleOptions(new String[]{"Egypt", "Jordan", "Greece", "Turkey"}), "Egypt"));

        countries.addQuestion(new Question("Which country is famous for the ancient city of Machu Picchu?",
                shuffleOptions(new String[]{"Peru", "Brazil", "Mexico", "Argentina"}), "Peru"));

        countries.addQuestion(new Question("Which country is the birthplace of the Olympic Games?",
                shuffleOptions(new String[]{"Greece", "Italy", "France", "Germany"}), "Greece"));




        // Science category with "Physics"
        physics.addQuestion(new Question("What is Newton's First Law?", shuffleOptions(new String[]{"Inertia", "Momentum", "Force", "Velocity"}), "Inertia"));
        physics.addQuestion(new Question("What is the SI unit of force?", shuffleOptions(new String[]{"Newton", "Joule", "Watt", "Tesla"}), "Newton"));
        physics.addQuestion(new Question("What is the speed of light in vacuum?", shuffleOptions(new String[]{"3 x 10^8 m/s", "3 x 10^6 m/s", "2.9 x 10^8 m/s", "2 x 10^8 m/s"}), "3 x 10^8 m/s"));
        physics.addQuestion(new Question("Which law explains the relationship between pressure and volume?", shuffleOptions(new String[]{"Boyle's Law", "Newton's Law", "Archimedes' Principle", "Hooke's Law"}), "Boyle's Law"));
        physics.addQuestion(new Question("Who developed the theory of General Relativity?", shuffleOptions(new String[]{"Albert Einstein", "Isaac Newton", "Galileo Galilei", "Nikola Tesla"}), "Albert Einstein"));
        physics.addQuestion(new Question("What is the unit of electric current?", shuffleOptions(new String[]{"Ampere", "Volt", "Ohm", "Coulomb"}), "Ampere"));
        physics.addQuestion(new Question("What is the formula for kinetic energy?", shuffleOptions(new String[]{"1/2 mv^2", "mv^2", "mgh", "m/v^2"}), "1/2 mv^2"));
        physics.addQuestion(new Question("What is the law of conservation of energy?", shuffleOptions(new String[]{"Energy cannot be created or destroyed", "Energy is always increasing", "Energy is always decreasing", "Energy can be created but not destroyed"}), "Energy cannot be created or destroyed"));
        physics.addQuestion(new Question("What does the Pythagorean Theorem calculate?", shuffleOptions(new String[]{"The relationship between the sides of a right triangle", "The speed of light", "The force of gravity", "The energy of a system"}), "The relationship between the sides of a right triangle"));
        physics.addQuestion(new Question("What is the principle of conservation of momentum?", shuffleOptions(new String[]{"The total momentum before and after a collision remains constant", "Momentum is always increasing", "Momentum is lost in every collision", "Momentum can be created or destroyed"}), "The total momentum before and after a collision remains constant"));
        physics.addQuestion(new Question("What is the unit of power?", shuffleOptions(new String[]{"Watt", "Joule", "Newton", "Ampere"}), "Watt"));
        physics.addQuestion(new Question("What is the formula for gravitational potential energy?", shuffleOptions(new String[]{"mgh", "1/2 mv^2", "F = ma", "qV"}), "mgh"));
        physics.addQuestion(new Question("What is the unit of frequency?", shuffleOptions(new String[]{"Hertz", "Watts", "Coulombs", "Volts"}), "Hertz"));
        physics.addQuestion(new Question("Who proposed the theory of electromagnetism?", shuffleOptions(new String[]{"James Clerk Maxwell", "Thomas Edison", "Nikola Tesla", "Michael Faraday"}), "James Clerk Maxwell"));
        physics.addQuestion(new Question("What is the maximum speed of a car?", shuffleOptions(new String[]{"Depends on the car", "50 km/h", "200 km/h", "300 km/h"}), "Depends on the car"));

//        chemestry questions
        chemistry.addQuestion(new Question("What is the atomic number of Hydrogen?", shuffleOptions(new String[]{"1", "2", "3", "4"}), "1"));
        chemistry.addQuestion(new Question("What is the formula for water?", shuffleOptions(new String[]{"H2O", "CO2", "NaCl", "O2"}), "H2O"));
        chemistry.addQuestion(new Question("What is the chemical symbol for Sodium?", shuffleOptions(new String[]{"Na", "N", "So", "S"}), "Na"));
        chemistry.addQuestion(new Question("What is the pH value of pure water?", shuffleOptions(new String[]{"7", "0", "14", "10"}), "7"));
        chemistry.addQuestion(new Question("Which element is known as the King of the elements?", shuffleOptions(new String[]{"Gold", "Silver", "Copper", "Iron"}), "Gold"));
        chemistry.addQuestion(new Question("Which gas is used in balloons to make them float?", shuffleOptions(new String[]{"Helium", "Hydrogen", "Oxygen", "Nitrogen"}), "Helium"));
        chemistry.addQuestion(new Question("What is the atomic number of Oxygen?", shuffleOptions(new String[]{"8", "6", "16", "12"}), "8"));
        chemistry.addQuestion(new Question("Which element is a liquid at room temperature?", shuffleOptions(new String[]{"Mercury", "Lead", "Copper", "Gold"}), "Mercury"));
        chemistry.addQuestion(new Question("What is the symbol for Chlorine?", shuffleOptions(new String[]{"Cl", "C", "O", "H"}), "Cl"));
        chemistry.addQuestion(new Question("What is the chemical formula for methane?", shuffleOptions(new String[]{"CH4", "C2H6", "CO2", "H2O"}), "CH4"));
        chemistry.addQuestion(new Question("Which element is present in all acids?", shuffleOptions(new String[]{"Hydrogen", "Oxygen", "Carbon", "Nitrogen"}), "Hydrogen"));
        chemistry.addQuestion(new Question("What is the molar mass of carbon dioxide (CO2)?", shuffleOptions(new String[]{"44 g/mol", "32 g/mol", "28 g/mol", "16 g/mol"}), "44 g/mol"));
        chemistry.addQuestion(new Question("Which acid is found in lemons?", shuffleOptions(new String[]{"Citric acid", "Sulfuric acid", "Acetic acid", "Hydrochloric acid"}), "Citric acid"));
        chemistry.addQuestion(new Question("What is the chemical formula for sulfuric acid?", shuffleOptions(new String[]{"H2SO4", "H2O", "SO3", "CO2"}), "H2SO4"));
        chemistry.addQuestion(new Question("What is the most abundant gas in the Earth's atmosphere?", shuffleOptions(new String[]{"Nitrogen", "Oxygen", "Carbon dioxide", "Helium"}), "Nitrogen"));
        chemistry.addQuestion(new Question("What is the process of heating a liquid to create vapors and then condensing them back into liquid?", shuffleOptions(new String[]{"Distillation", "Evaporation", "Sublimation", "Filtration"}), "Distillation"));
        chemistry.addQuestion(new Question("What is the chemical symbol for Gold?", shuffleOptions(new String[]{"Au", "Ag", "Pb", "Cu"}), "Au"));


// Add history-related questions
        nepal.addQuestion(new Question("Who was the first King of unified Nepal?",
                shuffleOptions(new String[]{"Prithvi Narayan Shah", "Tribhuvan", "Birendra", "Rana Bahadur Shah"}), "Prithvi Narayan Shah"));

        nepal.addQuestion(new Question("In which year did Nepal become a republic?", shuffleOptions(new String[]{"2008", "1990", "2001", "1951"}), "2008"));

        nepal.addQuestion(new Question("What is the capital of Nepal?", shuffleOptions(new String[]{"Kathmandu", "Pokhara", "Lalitpur", "Biratnagar"}), "Kathmandu"));

        nepal.addQuestion(new Question("Which was the first democratic movement in Nepal?", shuffleOptions(new String[]{"1951 Revolution", "1990 People's Movement", "2006 Democracy Movement", "1980 Referendum"}), "1951 Revolution"));

        nepal.addQuestion(new Question("Who was the first female Prime Minister of Nepal?", shuffleOptions(new String[]{"Bhimsen Thapa", "Sushil Koirala", "Madhav Kumar Nepal", "Bidhya Devi Bhandari"}), "Bidhya Devi Bhandari"));

        nepal.addQuestion(new Question("What is the name of the famous battle where Prithvi Narayan Shah defeated the Malla kings?",
                shuffleOptions(new String[]{"Battle of Nalapani", "Battle of Kirtipur", "Battle of Jitpur", "Battle of Banepa"}), "Battle of Kirtipur"));

        nepal.addQuestion(new Question("In which year did Nepal sign the Sugauli Treaty with the British East India Company?",
                shuffleOptions(new String[]{"1815", "1857", "1860", "1950"}), "1815"));

        nepal.addQuestion(new Question("Who is regarded as the Father of Nepalese Democracy?",
                shuffleOptions(new String[]{"King Tribhuvan", "Bishweshwar Prasad Koirala", "Jang Bahadur Rana", "Puskar Shah"}), "Bishweshwar Prasad Koirala"));

        nepal.addQuestion(new Question("Which revolution led to the end of the Rana rule in Nepal?",
                shuffleOptions(new String[]{"1951 Revolution", "1990 People's Movement", "2006 Democracy Movement", "1996 Maoist Insurgency"}), "1951 Revolution"));

        nepal.addQuestion(new Question("Which year was the new Constitution of Nepal promulgated?",
                shuffleOptions(new String[]{"2015", "2008", "1990", "1972"}), "2015"));

        nepal.addQuestion(new Question("Who was the first King of unified Nepal?",
                shuffleOptions(new String[]{"Prithvi Narayan Shah", "Tribhuvan", "Birendra", "Rana Bahadur Shah"}), "Prithvi Narayan Shah"));

        nepal.addQuestion(new Question("When did Nepal become a Federal Democratic Republic?",
                shuffleOptions(new String[]{"2008", "1990", "2015", "1951"}), "2008"));

        nepal.addQuestion(new Question("Which year did the Rana rule in Nepal end?",
                shuffleOptions(new String[]{"1951", "1947", "1961", "1935"}), "1951"));

        nepal.addQuestion(new Question("What is the name of the palace where the Shah Kings used to reside in Kathmandu?",
                shuffleOptions(new String[]{"Narayanhiti Palace", "Shital Niwas", "Hanuman Dhoka Palace", "Maitidevi Palace"}), "Narayanhiti Palace"));

        nepal.addQuestion(new Question("In which year did King Tribhuvan return to Nepal from India after the end of the Rana rule?",
                shuffleOptions(new String[]{"1951", "1948", "1960", "1989"}), "1951"));

        nepal.addQuestion(new Question("Which movement led to the end of the Rana regime in Nepal?",
                shuffleOptions(new String[]{"1951 Revolution", "1990 People's Movement", "2006 Democracy Movement", "Madhesh Movement"}), "1951 Revolution"));

        nepal.addQuestion(new Question("Which year did the first democratic election in Nepal take place?",
                shuffleOptions(new String[]{"1959", "1991", "1990", "2008"}), "1959"));

        nepal.addQuestion(new Question("Who was the first democratically elected Prime Minister of Nepal?",
                shuffleOptions(new String[]{"Bishweshwar Prasad Koirala", "Tanka Prasad Acharya", "Chandrashekhar Upadhyaya", "Ganesh Man Singh"}), "Bishweshwar Prasad Koirala"));

        nepal.addQuestion(new Question("When did Nepal become a member of the United Nations?",
                shuffleOptions(new String[]{"1992", "1991", "1985", "1975"}), "1992"));


//        technology questions
        technologyAll.addQuestion(new Question("Which technology is used to make phone calls over the internet?",
                shuffleOptions(new String[]{"VoIP", "Bluetooth", "Wi-Fi", "NFC"}), "VoIP"));

        technologyAll.addQuestion(new Question("What does AI stand for?",
                shuffleOptions(new String[]{"Artificial Intelligence", "Automated Interface", "Augmented Input", "Advanced Integration"}), "Artificial Intelligence"));

        technologyAll.addQuestion(new Question("Which programming language is primarily used for web development?",
                shuffleOptions(new String[]{"Java", "Python", "JavaScript", "C++"}), "JavaScript"));

        technologyAll.addQuestion(new Question("What is the most common operating system for smartphones?",
                shuffleOptions(new String[]{"iOS", "Android", "Windows", "Linux"}), "Android"));

        technologyAll.addQuestion(new Question("Which company developed the first computer mouse?",
                shuffleOptions(new String[]{"IBM", "Apple", "Microsoft", "Xerox"}), "Xerox"));

        technologyAll.addQuestion(new Question("What does the acronym 'HTTP' stand for?",
                shuffleOptions(new String[]{"HyperText Transfer Protocol", "High Transfer Text Protocol", "HyperText Transmitter Protocol", "HyperText Transmission Protocol"}), "HyperText Transfer Protocol"));

        technologyAll.addQuestion(new Question("Which of these is a type of renewable energy?",
                shuffleOptions(new String[]{"Solar", "Nuclear", "Natural Gas", "Coal"}), "Solar"));

        technologyAll.addQuestion(new Question("What is the process of converting a design into a physical object using a 3D printer?",
                shuffleOptions(new String[]{"3D Printing", "Sublimation", "Injection Molding", "Casting"}), "3D Printing"));

        technologyAll.addQuestion(new Question("Which company is known for creating the iPhone?",
                shuffleOptions(new String[]{"Samsung", "Apple", "Google", "Huawei"}), "Apple"));

        technologyAll.addQuestion(new Question("What does IoT stand for?",
                shuffleOptions(new String[]{"Internet of Things", "Internet of Transactions", "Interoperability of Tools", "Internal Operations Technology"}), "Internet of Things"));

        technologyAll.addQuestion(new Question("Which technology is used for secure online payments?",
                shuffleOptions(new String[]{"Blockchain", "FTP", "Bluetooth", "Wi-Fi"}), "Blockchain"));

        technologyAll.addQuestion(new Question("What is the purpose of an Operating System?",
                shuffleOptions(new String[]{"Manage hardware and software resources", "Provide internet access", "Handle graphic rendering", "Play multimedia content"}), "Manage hardware and software resources"));

        technologyAll.addQuestion(new Question("Which programming language is known for its use in Artificial Intelligence?",
                shuffleOptions(new String[]{"Python", "Java", "C", "Ruby"}), "Python"));

        technologyAll.addQuestion(new Question("Which device converts digital data into analog signals for transmission over a phone line?",
                shuffleOptions(new String[]{"Modem", "Router", "Hub", "Switch"}), "Modem"));

        technologyAll.addQuestion(new Question("Which technology allows self-driving cars to navigate safely?",
                shuffleOptions(new String[]{"Lidar", "Bluetooth", "Wi-Fi", "NFC"}), "Lidar"));

        technologyAll.addQuestion(new Question("What is the name of the first successful personal computer developed by IBM?",
                shuffleOptions(new String[]{"IBM PC", "Apple II", "Commodore 64", "Altair 8800"}), "IBM PC"));

        technologyAll.addQuestion(new Question("Which company is known for developing the Windows operating system?",
                shuffleOptions(new String[]{"Microsoft", "Apple", "Google", "IBM"}), "Microsoft"));

        technologyAll.addQuestion(new Question("What is the primary function of a router in a network?",
                shuffleOptions(new String[]{"To direct data packets between networks", "To store data files", "To send emails", "To monitor network traffic"}), "To direct data packets between networks"));

        technologyAll.addQuestion(new Question("Which of the following is a wireless communication technology?",
                shuffleOptions(new String[]{"Wi-Fi", "Ethernet", "HDMI", "VGA"}), "Wi-Fi"));

        technologyAll.addQuestion(new Question("Which of these is a popular programming language used for web development?",
                shuffleOptions(new String[]{"JavaScript", "Swift", "Ruby", "Objective-C"}), "JavaScript"));


        // Set up the adapter with category data
        expandableListAdapter = new CustomExpandableListAdapter(this, categoryList);
        expandableListView.setAdapter(expandableListAdapter);

        // Set up the child click listener
        expandableListView.setOnChildClickListener((parent, v, groupPosition, childPosition, id) -> {
            Category selectedCategory = categoryList.get(groupPosition);
            SubCategory selectedSubCategory = selectedCategory.getSubcategories().get(childPosition);

            // Ensure SubCategory is not null before passing it
            if (selectedSubCategory != null) {
                Intent intent = new Intent(MainActivity.this, QuestionListActivity.class);
                intent.putExtra("SUBCATEGORY", selectedSubCategory);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Error: SubCategory not found.", Toast.LENGTH_SHORT).show();
            }
            return true;
        });

    }

    private String[] shuffleOptions(String[] options) {
        List<String> optionList = Arrays.asList(options);
        Collections.shuffle(optionList);
        return optionList.toArray(new String[0]);
    }
}
