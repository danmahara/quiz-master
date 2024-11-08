package com.example.quizmaster;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView categoryListView;
    private List<Category> categoryList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        categoryListView = findViewById(R.id.categoryListView);

        // Initialize the list to hold categories
        categoryList = new ArrayList<>();

        // Create categories
        Category geography = new Category("Geography");
        Category science = new Category("Science");
        Category literature = new Category("Literature");
        Category history = new Category("History");
        Category nepalHistory = new Category("Nepal History");
        Category slogan = new Category("Slogan");
        Category carSlogan = new Category("Car Slogan");


        // Create questions for Geography
        geography.addQuestion(new Question("What is the capital of France?", shuffleOptions(new String[]{"Berlin", "Madrid", "Paris", "Rome"}), "Paris"));
        geography.addQuestion(new Question("Which is the largest country by land area?", shuffleOptions(new String[]{"Russia", "Canada", "USA", "China"}), "Russia"));

        // Example of Nepal Geography Quiz Questions
        geography.addQuestion(new Question("What is the capital city of Nepal?", shuffleOptions(new String[] {"Kathmandu", " Pokhara ", "Lalitpur", "Biratnagar"}), "Kathmandu"));
        geography.addQuestion(new Question("Which river is the longest in Nepal?", shuffleOptions(new String[] {"Koshi", "Ganga", "Brahmaputra", "Gandak"}), "Koshi"));
        geography.addQuestion(new Question("Which is the highest peak in Nepal?", shuffleOptions(new String[] {"Mount Everest", "Kanchenjunga", "Makalu", "Lhotse"}), "Mount Everest"));
        geography.addQuestion(new Question("Which national park in Nepal is known for its Bengal tiger population?", shuffleOptions(new String[] {"Chitwan National Park", "Sagarmatha National Park", "Bardia National Park", "Langtang National Park"}), "Chitwan National Park"));
        geography.addQuestion(new Question("In which part of Nepal is the Annapurna range located?", shuffleOptions(new String[] {"Central Nepal", "Eastern Nepal", "Western Nepal", "Northern Nepal"}), "Western Nepal"));
        geography.addQuestion(new Question("Which is the longest highway in Nepal?", shuffleOptions(new String[] {"Prithvi Highway", "Araniko Highway", "Mahendra Highway", "Mid-Hill Highway"}), "Mahendra Highway"));
        geography.addQuestion(new Question("Which is the smallest district in Nepal by area?", shuffleOptions(new String[] {"Bhaktapur", "Kathmandu", "Manang", "Pokhara"}), "Bhaktapur"));
        geography.addQuestion(new Question("What is the main source of water for Nepal’s rivers?", shuffleOptions(new String[] {"Monsoon rains", "Melting glaciers", "Underground springs", "Snowfall"}), "Melting glaciers"));
        geography.addQuestion(new Question("Which mountain range divides Nepal into two parts?", shuffleOptions(new String[] {"Himalayas", "Shivalik Hills", "Tibetan Plateau", "Aravalli Range"}), "Himalayas"));
        geography.addQuestion(new Question("Which is the largest lake in Nepal?", shuffleOptions(new String[] {"Rara Lake", "Phewa Lake", "Begnas Lake", "Shey Phoksundo Lake"}), "Rara Lake"));

        // Science Questions
        science.addQuestion(new Question("What is the chemical symbol for water?", shuffleOptions(new String[]{"O2", "H2O", "CO2", "O3"}), "H2O"));
        science.addQuestion(new Question("What is the speed of light?", shuffleOptions(new String[]{"3x10^8 m/s", "3x10^5 m/s", "3x10^7 m/s", "3x10^9 m/s"}), "3x10^8 m/s"));

        // Literature Questions
        literature.addQuestion(new Question("Who wrote Pride and Prejudice?", shuffleOptions(new String[] {"Emily Brontë", "Charles Dickens", "Jane Austen", "George Eliot"}), "Jane Austen"));
        literature.addQuestion(new Question("In Moby-Dick, what is the name of Captain Ahab's ship?", shuffleOptions(new String[] {"The Pequod", "The Beagle", "The Nautilus", "The Hispaniola"}), "The Pequod"));
        literature.addQuestion(new Question("Who is the author of the play Hamlet?", shuffleOptions(new String[] {"William Shakespeare", "Christopher Marlowe", "John Milton", "Geoffrey Chaucer"}), "William Shakespeare"));
        literature.addQuestion(new Question("In George Orwell's 1984, what is the name of the totalitarian party?", shuffleOptions(new String[] {"Big Brother", "The Brotherhood", "The Party", "The Ministry"}), "The Party"));
        literature.addQuestion(new Question("What is the title of J.R.R. Tolkien's prelude to The Lord of the Rings?", shuffleOptions(new String[] {"The Two Towers", "The Hobbit", "The Return of the King", "The Silmarillion"}), "The Hobbit"));
        literature.addQuestion(new Question("Which novel begins with the line, 'Call me Ishmael'?", shuffleOptions(new String[] {"The Great Gatsby", "Moby-Dick", "Pride and Prejudice", "The Odyssey"}), "Moby-Dick"));
        literature.addQuestion(new Question("Who wrote the dystopian novel Brave New World?", shuffleOptions(new String[] {"Aldous Huxley", "George Orwell", "Ray Bradbury", "Margaret Atwood"}), "Aldous Huxley"));
        literature.addQuestion(new Question("In To Kill a Mockingbird, who is the father of Scout Finch?", shuffleOptions(new String[] {"Atticus Finch", "Tom Robinson", "Boo Radley", "Dill Harris"}), "Atticus Finch"));
        literature.addQuestion(new Question("Who wrote the epic poem The Iliad?", shuffleOptions(new String[] {"Homer", "Virgil", "Sophocles", "Ovid"}), "Homer"));
        literature.addQuestion(new Question("What is the name of Sherlock Holmes's loyal friend and assistant?", shuffleOptions(new String[] {"Dr. John Watson", "Inspector Lestrade", "Professor Moriarty", "Mycroft Holmes"}), "Dr. John Watson"));

        // Slogan Quiz Questions
        slogan.addQuestion(new Question("Which company uses the slogan 'Just Do It'?", shuffleOptions(new String[] {"Nike", "Adidas", "Puma", "Reebok"}), "Nike"));
        slogan.addQuestion(new Question("Which brand is known for the slogan 'Think Different'?", shuffleOptions(new String[] {"Apple", "Microsoft", "Samsung", "Sony"}), "Apple"));
        slogan.addQuestion(new Question("Which car company uses the slogan 'The Ultimate Driving Machine'?", shuffleOptions(new String[] {"BMW", "Audi", "Mercedes-Benz", "Lexus"}), "BMW"));
        slogan.addQuestion(new Question("Which fast food chain uses the slogan 'I'm Lovin' It'?", shuffleOptions(new String[] {"McDonald's", "Burger King", "KFC", "Wendy's"}), "McDonald's"));
        slogan.addQuestion(new Question("Which company uses the slogan 'Red Bull Gives You Wings'?", shuffleOptions(new String[] {"Red Bull", "Monster", "Rockstar", "Pepsi"}), "Red Bull"));

        // Car Slogan Quiz Questions
        carSlogan.addQuestion(new Question("Which car brand uses the slogan 'The Ultimate Driving Machine'?", shuffleOptions(new String[] {"BMW", "Audi", "Mercedes-Benz", "Lexus"}), "BMW"));
        carSlogan.addQuestion(new Question("Which car brand uses the slogan 'Find New Roads'?", shuffleOptions(new String[] {"Chevrolet", "Ford", "Toyota", "Honda"}), "Chevrolet"));
        carSlogan.addQuestion(new Question("Which car brand uses the slogan 'Vorsprung Durch Technik'?", shuffleOptions(new String[] {"Audi", "BMW", "Mercedes-Benz", "Porsche"}), "Audi"));
        carSlogan.addQuestion(new Question("Which car brand uses the slogan 'Let's Go Places'?", shuffleOptions(new String[] {"Toyota", "Honda", "Nissan", "Ford"}), "Toyota"));
        carSlogan.addQuestion(new Question("Which car brand uses the slogan 'Go Further'?", shuffleOptions(new String[] {"Ford", "Chevrolet", "Dodge", "Jeep"}), "Ford"));
        carSlogan.addQuestion(new Question("Which car brand uses the slogan 'Because Driving Matters'?", shuffleOptions(new String[] {"Mazda", "Toyota", "Honda", "Ford"}), "Mazda"));
        carSlogan.addQuestion(new Question("Which car brand uses the slogan 'The Power of Dreams'?", shuffleOptions(new String[] {"Honda", "Toyota", "Nissan", "Kia"}), "Honda"));
        carSlogan.addQuestion(new Question("Which car brand uses the slogan 'Innovation That Excites'?", shuffleOptions(new String[] {"Nissan", "Ford", "Toyota", "Hyundai"}), "Nissan"));
        carSlogan.addQuestion(new Question("Which car brand uses the slogan 'Go Like a Pro'?", shuffleOptions(new String[] {"Chevrolet", "Ford", "Honda", "Toyota"}), "Chevrolet"));
        carSlogan.addQuestion(new Question("Which car brand uses the slogan 'Built Ford Tough'?", shuffleOptions(new String[] {"Ford", "Chevrolet", "Ram", "Toyota"}), "Ford"));

        // Nepal History Quiz Questions
        nepalHistory.addQuestion(new Question("Who was the first King of unified Nepal?", shuffleOptions(new String[] {"Prithvi Narayan Shah", "Tribhuvan", "Birendra", "Rana Bahadur Shah"}), "Prithvi Narayan Shah"));
        nepalHistory.addQuestion(new Question("In which year did Nepal become a republic?", shuffleOptions(new String[] {"2008", "1990", "1951", "2001"}), "2008"));
        nepalHistory.addQuestion(new Question("Which treaty was signed between Nepal and the British East India Company in 1815?", shuffleOptions(new String[] {"Sugauli Treaty", "Tibet Treaty", "Treaty of Peace", "Nepal-Britain Treaty"}), "Sugauli Treaty"));
        nepalHistory.addQuestion(new Question("Who was the first female Prime Minister of Nepal?", shuffleOptions(new String[] {"Sahana Pradhan", "Binda Pandey", "Chandrika Bhandari", "Khadga Prasad Sharma Oli"}), "Sahana Pradhan"));
        nepalHistory.addQuestion(new Question("In which year did Nepal become a monarchy?", shuffleOptions(new String[] {"1768", "1799", "1816", "1846"}), "1768"));
        nepalHistory.addQuestion(new Question("Who was the founder of the Shah dynasty in Nepal?", shuffleOptions(new String[] {"Prithvi Narayan Shah", "Rana Bahadur Shah", "Junga Bahadur", "Bishweshwar Prasad Koirala"}), "Prithvi Narayan Shah"));
        nepalHistory.addQuestion(new Question("Which movement led to the end of the Rana regime in Nepal?", shuffleOptions(new String[] {"1951 Revolution", "1990 People's Movement", "2006 Jana Andolan", "2008 Revolution"}), "1951 Revolution"));
        nepalHistory.addQuestion(new Question("When did the Rana regime officially end?", shuffleOptions(new String[] {"1951", "1990", "1959", "2001"}), "1951"));
        nepalHistory.addQuestion(new Question("Who was the first King of Nepal after the Shah dynasty?", shuffleOptions(new String[] {"Prithvi Narayan Shah", "King Tribhuvan", "King Birendra", "King Gyanendra"}), "King Tribhuvan"));
        nepalHistory.addQuestion(new Question("What year did the first democratic election take place in Nepal?", shuffleOptions(new String[] {"1959", "1990", "2001", "1951"}), "1959"));


        // Add categories to the list
        categoryList.add(geography);
        categoryList.add(science);
        categoryList.add(literature);
        categoryList.add(history);
        categoryList.add(slogan);
        categoryList.add(carSlogan);
        categoryList.add(nepalHistory);


        // Set the adapter to the ListView
        CategoryAdapter adapter = new CategoryAdapter(this, categoryList);
        categoryListView.setAdapter(adapter);


        categoryListView.setOnItemClickListener((parent, view, position, id) -> {
            Category selectedCategory = categoryList.get(position);

            // Use an Intent to pass the selected category to QuestionListActivity
            Intent intent = new Intent(this, QuestionListActivity.class);
            intent.putExtra("CATEGORY", selectedCategory);

            // Start the QuestionListActivity
            startActivity(intent);
        });

    }
    private String[] shuffleOptions(String[] options) {
        List<String> optionList = Arrays.asList(options);
        Collections.shuffle(optionList);
        return optionList.toArray(new String[0]);
    }


}




