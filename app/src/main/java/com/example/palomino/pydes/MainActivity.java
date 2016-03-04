package com.example.palomino.pydes;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.palomino.pydes.Fragments.InicioFragment;
import com.example.palomino.pydes.Fragments.PerfilFragment;
import com.example.palomino.pydes.Fragments.StarredFragment;
import com.example.palomino.pydes.Fragments.LoginFragment;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Aqui mi nueva accion", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        setFragment(0);
    }

    @Override
    public void onBackPressed() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_camera:
                //llamar a un Fragment enviar Posicion
                item.setChecked(true);
                setFragment(0);
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            case R.id.nav_perfil:
                item.setChecked(true);
                setFragment(1);
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            case R.id.nav_slideshow:
                item.setChecked(true);
                setFragment(2);
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            case R.id.nav_manage:
                item.setChecked(true);
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            case R.id.nav_share:
                //llamar a un Activity
                item.setChecked(true);
                Toast.makeText(MainActivity.this, "Launching " + item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawer(GravityCompat.START);
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
                return true;
            case R.id.nav_send:
                item.setChecked(true);
                Toast.makeText(MainActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
        }



        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    public void setFragment(int position) {

        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        switch (position) {
            case 0:

                InicioFragment inicioFragment = new InicioFragment();
                fragmentTransaction.replace(R.id.frag_contenedor, inicioFragment);
                fragmentTransaction.addToBackStack("inicioFragment");
                fragmentTransaction.commit();
                break;
            case 1:

                PerfilFragment nuevo_Fragment = new PerfilFragment();
                fragmentTransaction.replace(R.id.frag_contenedor, nuevo_Fragment);
                fragmentTransaction.addToBackStack("nuevo_Fragment");
                fragmentTransaction.commit();
                break;
            case 2:

                LoginFragment loginFragment = new LoginFragment();
                fragmentTransaction.replace(R.id.frag_contenedor, loginFragment);
                fragmentTransaction.addToBackStack("loginFragment");
                fragmentTransaction.commit();
                break;
        }
    }
}
