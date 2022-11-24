package com.example.virtuallibrary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.ItemClickListener {
    private RecyclerViewAdapter adapter;
    private ArrayList<Book> books;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setBooks();

        RecyclerView recyclerView = findViewById(R.id.bookList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerViewAdapter(this, books);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.about){
            startActivity(new Intent(MainActivity.this, AboutActivity.class));
        }
        else if (item.getItemId() == R.id.contact){
            startActivity(new Intent(MainActivity.this, ContactActivity.class));
        }

        return true;
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, adapter.getItem(position).getName() +
                " by " + adapter.getItem(position).getAuthor(), Toast.LENGTH_SHORT).show();
    }

    private void setBooks(){
        books = new ArrayList<>();

        books.add(new Book("Sapiens: A Brief History of Humankind", "Yuval Noah Harari"));
        books.add(new Book("Homo Deus: A Brief History of Tomorrow", "Yuval Noah Harari"));
        books.add(new Book("21 Lessons for the 21st Century", "Yuval Noah Harari"));
        books.add(new Book("Crazy Rich Asians", "Kevin Kwan"));
        books.add(new Book("The Martian", "Andy Weir"));
        books.add(new Book("Surrender", "Bono"));
        books.add(new Book("Harry Potter and the Philosopher's Stone", "J. K. Rowling"));
        books.add(new Book("Team of Rivals", "Doris Kearns Goodwin"));
        books.add(new Book("Stranger in a Strange Land", "by Robert Heinlein"));
        books.add(new Book("The Inner Game of Tennis", "by Robert Gallwey"));
        books.add(new Book("Essays", "Michel de Montaigne"));
        books.add(new Book("Me Before You", "Jojo Moyes"));
        books.add(new Book("Mendeleyev’s Dream", "Paul Strathern"));
        books.add(new Book("A Game of Thrones", "George R. R. Martin"));
        books.add(new Book("Project Hail Mary", "Andy Weir"));
        books.add(new Book("And Then There Were None", "Agatha Christie"));
        books.add(new Book("Me Before You", "Jojo Moyes"));
        books.add(new Book("The Diary of a Young Girl", "Anne Frank"));
        books.add(new Book("The Interpretation of Dreams", "Sigmund Freud"));
        books.add(new Book("Born a Crime: Stories from a South African Childhood", "Trevor Noah"));
    }
}