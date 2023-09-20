package com.ashokbaniya.connection;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import java.util.ArrayList;
import java.util.List;

public class SellingCropsView extends AppCompatActivity {
    private DatabaseReference databaseReference;
    GridView gridView;
    List<SellingCropsItems> items ;
    ArrayList<User> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selling_crops_view);
        list=new ArrayList<>();
        gridView = findViewById(R.id.gridView1);
        items = new ArrayList<>();
        FirebaseApp.initializeApp(this);
        FirebaseApp.initializeApp(this);
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReference();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("sellCrops"); // Replace with your node's path
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Iterate through the data
                for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
                    String key = childSnapshot.getKey();
                    String name = childSnapshot.child("name").getValue(String.class);
                    String quantity =  String.valueOf(childSnapshot.child("total_crops").getValue());
                    String price =  String.valueOf(childSnapshot.child("price").getValue());
                    StorageReference imageRef = storageRef.child("images/"+key);
                    imageRef.getDownloadUrl().addOnSuccessListener(uri -> {
                        String imageUrl = uri.toString();
                        items.add(new SellingCropsItems(imageUrl,name,quantity, price ));
                        SellingCropsGridAdapter adapter = new SellingCropsGridAdapter(getApplicationContext(), items);
                        gridView.setAdapter(adapter);
                        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // Retrieve the value of the clicked item
                                TextView textView = view.findViewById(R.id.textView);
                                TextView pr = view.findViewById(R.id.textView9);
                                TextView qt = view.findViewById(R.id.txtV);
                                // Get the text value of the TextView
                                String name = textView.getText().toString();
                                String p = pr.getText().toString();
                                String q = qt.getText().toString();
                            }
                        });
                    }).addOnFailureListener(exception -> {
                    });
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle errors here
            }
        });
    }
}