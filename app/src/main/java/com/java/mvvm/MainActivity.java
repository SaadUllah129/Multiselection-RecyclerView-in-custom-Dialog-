package com.java.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.Toast;

import com.java.mvvm.database.model.Company;
import com.java.mvvm.database.reAdapter;
import com.java.mvvm.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    boolean[] selectedLanguage;
    ArrayList<Integer> langList = new ArrayList<>();
    reAdapter adapter;
    ArrayList<Company> langArray = new ArrayList<>();
    public Dialog dialog;
    Boolean[] buySellList = new Boolean[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        buySellList[0] = true;
        buySellList[1] = false;
        setContentView(view);
        dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.rec_view);
        langArray.add(new Company("Ferrous Metals"));
        langArray.add(new Company("Stainless Steel"));
        langArray.add(new Company("Tyres"));
        langArray.add(new Company("Textiles"));
        langArray.add(new Company("Plastic"));
        langArray.add(new Company("E-Scrap"));
        langArray.add(new Company("Red Metals"));
        langArray.add(new Company("Aluminum"));
        langArray.add(new Company("Zinc"));
        langArray.add(new Company("Magnesium"));
        langArray.add(new Company("Lead"));
        langArray.add(new Company("Nickel/Stainless/Hi Temp"));
        langArray.add(new Company("Mixed Metals"));
        langArray.add(new Company("Electric Furnace Casting and Foundry"));
        langArray.add(new Company("Specially Processed Grades"));
        langArray.add(new Company("Cast Iron Grades"));
        langArray.add(new Company("Special Boring Grades"));
        langArray.add(new Company("Copper"));
        langArray.add(new Company("Finance"));
        langArray.add(new Company("Insurance"));
        langArray.add(new Company("Shipping"));
        langArray.add(new Company("Equipments"));
        langArray.add(new Company("Others"));
        adapter = new reAdapter(MainActivity.this);
        selectedLanguage = new boolean[langArray.size()];
        RecyclerView list = dialog.findViewById(R.id.rcView);
        list.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        list.setAdapter(adapter);
        Button button = dialog.findViewById(R.id.btnList);
        //InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        //imm.hideSoftInputFromWindow(binding.etComodity.getWindowToken(),0);
        binding.etComodity.setInputType(InputType.TYPE_NULL);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (adapter.getSelected().size() > 0){
                    ArrayList<Company> selectedList = new ArrayList<>();
                    selectedList.addAll(adapter.getSelected());
                    String sb = "";
                    for (int i = 0; i < selectedList.size();i++){
                        sb += (selectedList.get(i).getCompanyName()+", ");
                    }
                    sb = sb.substring(0,(sb.length()-2));
                    binding.etComodity.setText(sb);
                } else {
                    binding.etComodity.setText("");
                }
                dialog.cancel();
            }
        });

        binding.etComodity.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                adapter.setCompanyList(langArray);
                dialog.show();
                return false;
            }
        });
    }
}