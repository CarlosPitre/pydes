package com.example.palomino.pydes.Fragments;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.palomino.pydes.R;


public class LoginFragment extends BaseFragment {


    private static final int REQUEST_READ_CONTACTS = 0;


    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "foo@example.com:hello", "bar@example.com:world"
    };

    private UserLoginTask mAuthTask = null;

    private Button Btnlogin;
    private Button BtnRegistrar;
    private EditText TxtEmail;
    private EditText TxtPwd;
    private View mProgressView;
    private View mLoginFormView;

    //El Fragment va a cargar su layout, el cual debemos especificar


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

          final View view = inflater.inflate(R.layout.fragment_login, container, false);
          return view;
    }


    //La vista de layout ha sido creada y ya está disponible
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TxtEmail = (EditText) view.findViewById(R.id.TxtEmail);
        TxtPwd =   (EditText) view.findViewById(R.id.TxtPwd);

        Btnlogin = (Button)  view.findViewById(R.id.Btnlogin);
        BtnRegistrar = (Button)  view.findViewById(R.id.BtnRegistrar);

        mLoginFormView = view.findViewById(R.id.login_form);
        mProgressView = view.findViewById(R.id.login_progress);

        // click en el boton Login
        Btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();

            }
        });


        // click en el boton Registrar
        BtnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                android.support.v4.app.FragmentManager fragmentManager;
                FragmentTransaction fragmentTransaction;
                fragmentManager = getFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();

                RegisterFragment nuevoFragment = new RegisterFragment();
                fragmentTransaction.replace(R.id.frag_contenedor, nuevoFragment);
                fragmentTransaction.addToBackStack("nuevoFragment");
                fragmentTransaction.commit();
            }
        });


    }

    private void attemptLogin() {
        if (mAuthTask != null) {
            return;
        }

        // Reset errors.
        TxtEmail.setError(null);
        TxtPwd.setError(null);

        // Store values at the time of the login attempt.
        String email = TxtEmail.getText().toString();
        String password = TxtPwd.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (TextUtils.isEmpty(password) || !isPasswordValid(password)) {
            TxtPwd.setError(getString(R.string.error_invalid_password));
            focusView = TxtPwd;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            TxtEmail.setError(getString(R.string.error_field_required));
            focusView = TxtEmail;
            cancel = true;
        } else if (!isEmailValid(email)) {
            TxtEmail.setError(getString(R.string.error_invalid_email));
            focusView = TxtEmail;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
             showProgress(true);
           // mAuthTask = new UserLoginTask(email, password);
           // mAuthTask.execute((Void) null);

            // consumo el servicio y obtengo respuesta
             String rsta= "Ok";

            switch (rsta) {

                case "Ok":
                    //open new fragment
                    android.support.v4.app.FragmentManager fragmentManager;
                    FragmentTransaction fragmentTransaction;
                    fragmentManager = getFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();

                    InicioFragment nuevoFragment = new  InicioFragment();
                    fragmentTransaction.replace(R.id.frag_contenedor, nuevoFragment);
                    fragmentTransaction.addToBackStack("nuevoFragment");
                    fragmentTransaction.commit();


                    //_DatosUser.SetUser (result.Dato);
                    break;

                default:

                   // Toast.MakeText(this, rsta, ToastLength.Long).Show ();

                    break;
            }



        }
    }
    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }


    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mLoginFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }

    private interface ProfileQuery {
        String[] PROJECTION = {
                ContactsContract.CommonDataKinds.Email.ADDRESS,
                ContactsContract.CommonDataKinds.Email.IS_PRIMARY,
        };

        int ADDRESS = 0;
        int IS_PRIMARY = 1;
    }



    public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {

        private final String mEmail;
        private final String mPassword;

        UserLoginTask(String email, String password) {
            mEmail = email;
            mPassword = password;
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            // TODO: attempt authentication against a network service.

            try {
                // Simulate network access.
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                return false;
            }

            for (String credential : DUMMY_CREDENTIALS) {
                String[] pieces = credential.split(":");
                if (pieces[0].equals(mEmail)) {
                    // Account exists, return true if the password matches.
                    return pieces[1].equals(mPassword);
                }
            }

            // TODO: register the new account here.
            return true;
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            mAuthTask = null;
            showProgress(false);

            if (success) {
               // finish();
            } else {
                TxtPwd.setError(getString(R.string.error_incorrect_password));
                TxtPwd.requestFocus();
            }
        }

        @Override
        protected void onCancelled() {
            mAuthTask = null;
            showProgress(false);
        }
    }






}

