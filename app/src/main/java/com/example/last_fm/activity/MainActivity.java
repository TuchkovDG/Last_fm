package com.example.last_fm.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.example.last_fm.R;
import com.example.last_fm.adapter.RecyclerItemClickListener;
import com.example.last_fm.adapter.RecyclerViewAdapterForMain;
import com.example.last_fm.model.by_country.ArtistByCountry;
import com.example.last_fm.model.by_country.DataByCountry;
import com.example.last_fm.model.by_country.TopArtistsByCountry;
import com.example.last_fm.retrofit.ApiService;
import com.example.last_fm.retrofit.RestManager;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar_for_main)
    protected Toolbar toolbar_for_main;
    @BindView(R.id.spinner_for_toolbar)
    protected Spinner spinner_for_toolbar;
    @BindView(R.id.recycler_view_for_artists)
    protected RecyclerView recycler_view_for_artists;

    private ApiService apiService;

    private List<ArtistByCountry> for_click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initHelpingClasses();
        initToolbar();
    }

    private void initHelpingClasses() {
        apiService = RestManager.getRetrofit(getApplicationContext());
    }

    private void initToolbar() {
        setSupportActionBar(toolbar_for_main);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        SpinnerAdapter spinnerAdapter = ArrayAdapter.createFromResource(getApplicationContext(),
                R.array.for_spinner, android.R.layout.simple_spinner_dropdown_item);
        spinner_for_toolbar.setAdapter(spinnerAdapter);

        spinner_for_toolbar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int item = spinner_for_toolbar.getSelectedItemPosition();
                String[] list = getResources().getStringArray(R.array.for_spinner);
                initRecyclerView(list[item]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void initRecyclerView(String selectedCountry) {
        apiService.getDataByCountry(selectedCountry).enqueue(new Callback<DataByCountry>() {
            @Override
            public void onResponse(Call<DataByCountry> call, Response<DataByCountry> response) {
                DataByCountry dataByCountry = response.body();
                TopArtistsByCountry topArtistsByCountry = dataByCountry.getTopArtistsByCountry();
                List<ArtistByCountry> list_artistByCountries = topArtistsByCountry.getArtistByCountry();

                Collections.sort(list_artistByCountries, new ArtistByCountry.SortComparator());

                for_click = list_artistByCountries;

                LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());

                recycler_view_for_artists.setLayoutManager(layoutManager);
                recycler_view_for_artists.setAdapter(new RecyclerViewAdapterForMain(list_artistByCountries,
                        R.layout.element_list_main, getApplicationContext()));

                DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recycler_view_for_artists.getContext(),
                        layoutManager.getOrientation());
                recycler_view_for_artists.addItemDecoration(dividerItemDecoration);
            }

            @Override
            public void onFailure(Call<DataByCountry> call, Throwable t) {

            }
        });

        recycler_view_for_artists.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(),
                recycler_view_for_artists, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(MainActivity.this, ArtistActivity.class);
                intent.putExtra("name", for_click.get(position).getName());
                startActivity(intent);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));
    }
}
