package com.kesteli.filip.firebasequery;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class MainActivity extends AppCompatActivity {

    //Getting the firebase database
    private static FirebaseDatabase firebaseDatabase;
    //Firebase setup
    private DatabaseReference databaseReference;
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        getDatabase();
        setupFirebase();
//        initViews();
//        setupListeners();
        addToFirebase();

        //posebna metoda u slucaju da se stvari u kodu ponavljaju
        firebaseQuery(childDinosaurs.orderByChild("height"));

        firebaseQuery1();
        firebaseQuery2();
        firebaseQuery3();
        firebaseQuery4();
        firebaseQuery5();
        firebaseQuery6();
        firebaseQuery7();
    }

    private void setupFirebase() {
        databaseReference = FirebaseDatabase.getInstance().getReference();
    }

    DatabaseReference childDinosaurs;

    private void addToFirebase() {
        childDinosaurs = databaseReference.child("Dinosaurs");

        DatabaseReference childLambeosaurus = childDinosaurs.child("Lambeosaurus");
        DatabaseReference childStegosaurus = childDinosaurs.child("Stegosaurus");
        DatabaseReference childTiranosaurus = childDinosaurs.child("Tiranosaurus");

        childLambeosaurus.child("height").setValue(2.1);
        childLambeosaurus.child("length").setValue(12.5);
        childLambeosaurus.child("weight").setValue(5000);

        childStegosaurus.child("height").setValue(4);
        childStegosaurus.child("length").setValue(9);
        childStegosaurus.child("weight").setValue(2500);

        childTiranosaurus.child("height").setValue(3.6);
        childTiranosaurus.child("length").setValue(7.4);
        childTiranosaurus.child("weight").setValue(3000);
    }

    private void firebaseQuery(Query queryRef) {
        queryRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    /**
     * Poredaj po height-u
     */
    private void firebaseQuery1() {
        Query queryRef1 = childDinosaurs.orderByChild("height");
        queryRef1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                DinosaurFacts facts = dataSnapshot.getValue(DinosaurFacts.class);
                Log.d("a1", dataSnapshot.getKey() + " was " + facts.getHeight() + " meters tall");
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    /**
     * Poredaj
     */
    private void firebaseQuery2() {
        Query queryRef2 = childDinosaurs;
        queryRef2.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                DinosaurFacts facts = dataSnapshot.getValue(DinosaurFacts.class);
                Log.d("a2", dataSnapshot.getKey() + " was " + facts.getHeight() + " meters tall");
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    /**
     * Poredaj po weight-u koji je jednak 5000
     */
    private void firebaseQuery3() {
        Query queryRef3 = childDinosaurs.orderByChild("weight").equalTo(5000);
        queryRef3.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                DinosaurFacts facts = dataSnapshot.getValue(DinosaurFacts.class);
                Log.d("a3", dataSnapshot.getKey() + " was " + facts.getHeight() + " meters tall");
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    /**
     * Poredaj po key-u (key-value)
     */
    private void firebaseQuery4() {
        Query queryRef4 = childDinosaurs.child("Dinosaurs").orderByKey().limitToFirst(10);
        queryRef4.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                DinosaurFacts facts = dataSnapshot.getValue(DinosaurFacts.class);
                Log.d("a4", dataSnapshot.getKey() + " was " + facts.getHeight() + " meters tall");
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    /**
     * Poredaj po height-u - ime krece na L i zavrsava na s
     */
    private void firebaseQuery5() {
        Query queryRef5 = childDinosaurs.child("Dinosaurs").orderByChild("height").startAt('L').endAt("s\uf8ff");

        queryRef5.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                DinosaurFacts facts = dataSnapshot.getValue(DinosaurFacts.class);
                Log.d("a5", dataSnapshot.getKey() + " was " + facts.getHeight() + " meters tall");
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    /**
     * Poredaj po weight-u - najveca tezina 3200
     */
    private void firebaseQuery6() {
        Query queryRef6 = childDinosaurs.child("Dinosaurs").orderByChild("weight").endAt(3200);

        queryRef6.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                DinosaurFacts facts = dataSnapshot.getValue(DinosaurFacts.class);
                Log.d("a6", dataSnapshot.getKey() + " was " + facts.getHeight() + " meters tall");
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    /**
     * Poredaj po height-u - najmanja tezina 2900
     */
    private void firebaseQuery7() {
        Query queryRef7 = childDinosaurs.child("Dinosaurs").orderByChild("weight");
        queryRef7.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                DinosaurFacts facts = dataSnapshot.getValue(DinosaurFacts.class);
                Log.d("a7", dataSnapshot.getKey() + " was " + facts.getHeight() + " meters tall");
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}







