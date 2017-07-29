package com.example.last_fm.retrofit;

import com.example.last_fm.model.by_artist.DataByArtist;
import com.example.last_fm.model.by_artist_and_album.DataByArtistAlbum;
import com.example.last_fm.model.by_country.DataByCountry;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("?method=geo.gettopartists&api_key=e81f61890b7ff8633ca024d0faa449e7&format=json")
    Call<DataByCountry> getDataByCountry(@Query("country") String country);

    @GET("?method=artist.gettopalbums&api_key=e81f61890b7ff8633ca024d0faa449e7&format=json")
    Call<DataByArtist> getDataByArtist(@Query("artist") String artist);

    @GET("?method=album.getinfo&api_key=e81f61890b7ff8633ca024d0faa449e7&format=json")
    Call<DataByArtistAlbum> getDataByArtistAlbum(@Query("artist") String artist,
                                                 @Query("album") String album);
}
