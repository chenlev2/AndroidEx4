package com.example.myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ListOfNotesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ListOfNotesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListOfNotesFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "user";
    private static final String ARG_PARAM2 = "pass";

    // TODO: Rename and change types of parameters
    private String userName;
    private String password;

    static Bundle arg;
    private String userAndPssword[];


    public ListOfNotesFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static ListOfNotesFragment newInstance(Bundle bun) {
        ListOfNotesFragment fragment = new ListOfNotesFragment();
        arg = bun;

        fragment.setArguments( arg );
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate( R.layout.fragment_list_of_notes, container, false );

        Log.i( "65vb getArguments()", "onCreateView: " +  getArguments() );

        if (getArguments() == null) {
            Log.i( "check args", "onCreateView: NULLL!!!" );
        }
        else{
            userName = getArguments().getString( "usname" );
            password = getArguments().getString( "password" );
            Log.i( "check args", "The user from login: " + userName + "password: "+ password);

        }


        TextView tv = (TextView) view.findViewById( R.id.userr );
        Log.i( "Line 78 userNamea", "onCreateView: The name:"+ userName);
        Log.i( "Line 79 userNamea", "onCreateView: The Password:"+ password);

        tv.setText( "UserName: " + userName );
        TextView textViewpass = (TextView) view.findViewById( R.id.passwordd );
        textViewpass.setText( "Password: "  +  password );

        return view;
    }



    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public interface ListOfNotesFragmentInterface {
        public void result(boolean bool);
    }
}
