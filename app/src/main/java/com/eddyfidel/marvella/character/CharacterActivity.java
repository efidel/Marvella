package com.eddyfidel.marvella.character;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.eddyfidel.marvella.R;
import com.eddyfidel.marvella.data.source.CharacterRepository;
import com.eddyfidel.marvella.data.source.remote.CharacterRemoteDataSource;
import com.eddyfidel.marvella.util.ActivityUtils;

public class CharacterActivity extends AppCompatActivity {

    private CharacterPresenter mCharacterPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.character_activity);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        CharacterFragment characterFragment = (CharacterFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);

        if (characterFragment == null) {
            characterFragment = CharacterFragment.newInstance();

            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), characterFragment, R.id.contentFrame);
        }

        CharacterRemoteDataSource remoteDataSource = new CharacterRemoteDataSource();

        CharacterRepository repository = new CharacterRepository(remoteDataSource);

        mCharacterPresenter = new CharacterPresenter(repository, characterFragment);
    }
}