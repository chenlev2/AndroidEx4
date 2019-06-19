package com.example.myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static android.widget.Toast.LENGTH_SHORT;


public class LoginFragment extends Fragment implements ListOfNotesFragment.ListOfNotesFragmentInterface{

    private String user;
    private String password;
    private Button btnLogin;
    EditText userName;
    EditText passWord;

    // Required empty public constructor
    public LoginFragment() {}

    // TODO: Rename and change types and number of parameters
    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        fragment.setArguments( args );
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
    }

    // call RegisterFragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View  view = inflater.inflate( R.layout.fragment_login, container, false );

        // from Text view, make a clickListener for registering
        TextView tv = view.findViewById( R.id.register );
        tv.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr= getFragmentManager().beginTransaction();
                fr.replace( R.id.login,  new RegisterFragment() );
                fr.addToBackStack( null ); // come back on last fragment
                fr.commit();
            }
        });


        btnLogin = view.findViewById( R.id.loginbutt );
        btnLogin.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText chekEmptyName = (EditText)view.findViewById(R.id.username);
                EditText chekEmptyPassword = (EditText)view.findViewById(R.id.getpassword);

                user = ((EditText)view.findViewById(R.id.username)).getText().toString();
                password = ((EditText)view.findViewById(R.id.getpassword)).getText().toString();

                if ( TextUtils.isEmpty( user )  ) {
                    chekEmptyName.setError( "The item Username cannot be empty" );
                    return;
                }
                if( ( TextUtils.isEmpty( password )) ){
                    chekEmptyPassword.setError( "The item Password cannot be empty" );
                    return;
                }

                Log.i( " userNameDescription", "onClick: " + user );
                Log.i( " PasswordDescription", "onClick: " + password );

                Bundle bundleuserAndPass = new Bundle();
                bundleuserAndPass.putString( "usname", user );
                bundleuserAndPass.putString( "password", password );

                FragmentTransaction fr= getFragmentManager().beginTransaction();
                fr.replace( R.id.login, ListOfNotesFragment.newInstance( bundleuserAndPass ) );
                fr.addToBackStack( null ); // come back on last fragment
                fr.commit();
            }
        });


        return view;
    }

    public void backFragment(View view, FragmentTransaction fr){
      //  view.findViewById(  )
    }




    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {

    }


    @Override
    public void result(boolean bool) {

    }
}
